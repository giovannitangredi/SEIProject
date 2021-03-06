package it.polito.ezgas.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.GPSDataException;
import exception.InvalidCarSharingException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.service.GasStationService;
import it.polito.ezgas.service.UserService;

/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class GasStationServiceimpl implements GasStationService {
	//"connection" to the DB
	@Autowired
	GasStationRepository repository;
	
	@Autowired
	UserService userService;
	
	
	@Override
	public GasStationDto getGasStationById(Integer gasStationId) throws InvalidGasStationException {
		// id error handling
		if( gasStationId == null || gasStationId<0 ) {
			throw new InvalidGasStationException("Invalid Gas Station ID!");
		}
		
		// retrieve gas station
		GasStation gasStation = repository.findOne(gasStationId);
		if( gasStation == null ) {
			return null;
		} 
		
		// when the gas station has a price report
		if( gasStation.getUser() != null ) {
			//check if the user still exists in the DB
			UserDto userDto = null;
			
			try {
				userDto = userService.getUserById(gasStation.getUser().getUserId());
			} catch (InvalidUserException e1) {
				e1.printStackTrace();
			}
			
			if( userDto != null ) {
				// make the new calculus on the Price Report dependability
				try {
					
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
					Date reportTimestamp;
					reportTimestamp = sdf.parse(gasStation.getReportTimestamp());
					Calendar calReport = Calendar.getInstance();
					calReport.setTime(reportTimestamp);
					Calendar calNow = Calendar.getInstance();
					long obsolescence = 0;
					long remainingDays = ((long) (calNow.getTimeInMillis() - calReport.getTimeInMillis())) / (24 * 60 * 60 * 1000);
					if( remainingDays < 7 ) {
						obsolescence = 1 - (remainingDays/7);
					} 
					double dependability = 50 * (userDto.getReputation()+5)/10 + 50 * obsolescence;
					gasStation.setReportDependability(dependability);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return GasStationConverter.toGasStationDto(gasStation);
	}

	@Override
	public GasStationDto saveGasStation(GasStationDto gasStationDto) throws PriceException, GPSDataException {
		//price error has not to be handled
		// TODO check if to handle price exception
		
		
		//GPS error handling
		if(gasStationDto.getLat()>90 || gasStationDto.getLat()<-90) {
			throw new GPSDataException("Latitude out of boundaries!");
		}
		if(gasStationDto.getLon()>180 || gasStationDto.getLon()<-180) {
			throw new GPSDataException("Longitude out of boundaries!");
		}
		
		//inserting new gas station or updating an existing one
		GasStation gasStation = new GasStation();
		if(gasStationDto.getCarSharing()!=null && 
				gasStationDto.getCarSharing().toLowerCase().equals("null"))
			gasStationDto.setCarSharing(null);
		
		gasStation = repository.save(GasStationConverter.toGasStation(gasStationDto));

		return GasStationConverter.toGasStationDto(gasStation);
	}

	@Override
	public List<GasStationDto> getAllGasStations() {
		//retrieving all gas stations
		List<GasStation> gasStations = repository.findAll();
		if( gasStations == null ) {
			return new ArrayList<GasStationDto>();
		}
		
		gasStations.forEach( gasStation -> {
			// when the gas station has a price report
			if( gasStation.getUser() != null ) {
				//check if the user still exists in the DB
				UserDto userDto = null;
				
				try {
					userDto = userService.getUserById(gasStation.getUser().getUserId());
				} catch (InvalidUserException e1) {
					e1.printStackTrace();
				}
				
				if( userDto != null ) {
					// make the new calculus on the Price Report dependability
					try {
						
						SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
						Date reportTimestamp;
						reportTimestamp = sdf.parse(gasStation.getReportTimestamp());
						Calendar calReport = Calendar.getInstance();
						calReport.setTime(reportTimestamp);
						Calendar calNow = Calendar.getInstance();
						long obsolescence = 0;
						long remainingDays = ((long) (calNow.getTimeInMillis() - calReport.getTimeInMillis())) / (24 * 60 * 60 * 1000);
						if( remainingDays < 7 ) {
							obsolescence = 1 - (remainingDays/7);
						} 
						double dependability = 50 * (userDto.getReputation()+5)/10 + 50 * obsolescence;
						gasStation.setReportDependability(dependability);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		return gasStations.stream()
				.map( g -> GasStationConverter.toGasStationDto(g))	//converting each GasStation to GasStationDto
				.collect(Collectors.toList());
	}

	@Override
	public Boolean deleteGasStation(Integer gasStationId) throws InvalidGasStationException {
		//id error handling
		if( gasStationId<0 ) {
			throw new InvalidGasStationException("Invalid Gas Station ID!");
		}
		//if gas station doesn't exist return null
		if( repository.exists(gasStationId) == false ) {
			return false;
		} 
		
		
		//deleting gas station
		repository.delete(gasStationId);
		
		//second check after deleting
		if( repository.exists(gasStationId) == true) {
			return false;
		} 
		
		return true;
	}

	@Override
	public List<GasStationDto> getGasStationsByGasolineType(String gasolinetype) throws InvalidGasTypeException {
		String gasoline = gasolinetype.toLowerCase();
		//retrieving all gas stations
		List<GasStationDto> gasStations = getAllGasStations();
		if( gasStations == null ) {
			return new ArrayList<GasStationDto>();
		}
		
		Stream<GasStationDto> filteredGasStations;
		
		if( gasoline.compareTo("diesel") == 0 ) {
			filteredGasStations = gasStations.stream().filter(g -> g.getHasDiesel())
											.sorted(Comparator.comparingDouble(GasStationDto::getDieselPrice));
		} else if( gasoline.compareTo("super") == 0 ) {
			filteredGasStations = gasStations.stream().filter(g -> g.getHasSuper())
											.sorted(Comparator.comparingDouble(GasStationDto::getSuperPrice));
		} else if( gasoline.compareTo("superplus") == 0 ) {
			filteredGasStations = gasStations.stream().filter(g -> g.getHasSuperPlus())
											.sorted(Comparator.comparingDouble(GasStationDto::getSuperPlusPrice));
		} else if( gasoline.compareTo("gas") == 0 ) {
			filteredGasStations = gasStations.stream().filter(g -> g.getHasSuperPlus())
											.sorted(Comparator.comparingDouble(GasStationDto::getGasPrice));
		} else if( gasoline.compareTo("methane") == 0 ) {
			filteredGasStations = gasStations.stream().filter(g -> g.getHasMethane())
											.sorted(Comparator.comparingDouble(GasStationDto::getMethanePrice));
		} else if( gasoline.compareTo("premiumdiesel") == 0 ) {
			filteredGasStations = gasStations.stream().filter(g -> g.getHasPremiumDiesel())
					.sorted(Comparator.comparingDouble(GasStationDto::getPremiumDieselPrice));
		} else {
			//gasoline type error handling
			throw new InvalidGasTypeException(gasolinetype + "is an invalid gas type!");
		}
		
		return filteredGasStations
				.collect(Collectors.toList());		
	}

	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon, int radius) throws GPSDataException {
		
		//GPS error handling
		if( lat>90 || lat<-90 ) {
			throw new GPSDataException("Latitude out of boundaries!");
		}
		if( lon>180 || lon<-180 ) {
			throw new GPSDataException("Longitude out of boundaries!");
		}
		
		//retrieving all gas stations
		List<GasStationDto> gasStations = getAllGasStations();
		if( gasStations == null ) {
			return new ArrayList<GasStationDto>();
		}
		
		
		// 1Km RADIUS BOUNDARIES CALCULATION
		/*			1 degree
		 * 		lat			lon
		0°	110.574 km	111.320 km
		15°	110.649 km	107.550 km
		30°	110.852 km	96.486 km
		45°	111.132 km	78.847 km
		60°	111.412 km	55.800 km
		75°	111.618 km	28.902 km
		90°	111.694 km	0.000 km
		*/
		/*			1 km 
		 * 		lat					lon
		0°	0,00904371 degrees	0,00898311 degrees
		15°	0,00903759 degrees	0,00929800 degrees
		30°	0,00902104 degrees	0,01036420 degrees
		45°	0,00899831 degrees	0,01268279 degrees
		60°	0,00897570 degrees	0,01792115 degrees
		75°	0,00895913 degrees	0,03459968 degrees
		90°	0,00895303 degrees	0.000 
		*/
		
		double lat0 = 0.00904371; 
		double lat15 = 0.00903759;
		double lat30 = 0.00902104;
		double lat45 = 0.00899831;
		double lat60 = 0.00897570;
		double lat75 = 0.00895913;
		
		double lon0 = 0.00898311;
		double lon15 = 0.00929800;
		double lon30 = 0.01036420;
		double lon45 = 0.01268279;
		double lon60 = 0.01792115;
		double lon75 = 0.03459968;
		
		double latUnsigned = Math.abs(lat);
		double latUpper = 0;
		double latLower = 0;
		double lonRight = 0;
		double lonLeft = 0;
		final double[] GPSArea = new double[4];
		
		//check the latitude zone of the geopoint to set the boundaries to filter the gas station
		if( latUnsigned>=0 && latUnsigned<15 ) {
			latUpper = lat + lat0;
			latLower = lat - lat0;
			lonRight = lon + lon0;
			lonLeft = lon - lon0;
		}else if( latUnsigned>=15 && latUnsigned<30 ) {
			latUpper = lat + lat15;
			latLower = lat - lat15;
			lonRight = lon + lon15;
			lonLeft = lon - lon15;
		}else if( latUnsigned>=30 && latUnsigned<45 ) {
			latUpper = lat + lat30;
			latLower = lat - lat30;
			lonRight = lon + lon30;
			lonLeft = lon - lon30;
		}else if( latUnsigned>=45 && latUnsigned<60 ) {
			latUpper = lat + lat45;
			latLower = lat - lat45;
			lonRight = lon + lon45;
			lonLeft = lon - lon45;
		}else if( latUnsigned>=60 && latUnsigned<75 ) {
			latUpper = lat + lat60;
			latLower = lat - lat60;
			lonRight = lon + lon60;
			lonLeft = lon - lon60;
		}else if( latUnsigned>=75 && latUnsigned<90 ) {
			latUpper = lat + lat75;
			latLower = lat - lat75;
			lonRight = lon + lon75;
			lonLeft = lon - lon75;
		}
		
		// set the radius
		int kms = 1;
		if(radius > 0) {
			kms = radius;
		}
		
		GPSArea[0] = latUpper*kms;
		GPSArea[1] = latLower*kms;
		GPSArea[2] = lonRight*kms;
		GPSArea[3] = lonLeft*kms;

		//filter gas station for the coordinates inside the limits of 1km
		Stream<GasStationDto> filteredGasStations = gasStations.stream()
				.filter(g -> g.getLat()<GPSArea[0] && g.getLat()>GPSArea[1] &&
							 g.getLon()<GPSArea[2] && g.getLon()>GPSArea[3]);
		if( filteredGasStations == null ) {
			return new ArrayList<GasStationDto>();
		}
		
		return filteredGasStations
				.collect(Collectors.toList());
	}
	
	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon) throws GPSDataException {
		List<GasStationDto> result = getGasStationsByProximity(lat, lon, 1);
		return result;
	}

	@Override
	public List<GasStationDto> getGasStationsWithCoordinates(double lat, double lon, int radius, String gasolinetype,
			String carsharing) throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		// handle car sharing exception
		if( carsharing != null && carsharing.compareTo("null") != 0 
				&& carsharing.toLowerCase().compareTo("enjoy") != 0
				&& carsharing.toLowerCase().compareTo("car2go") != 0)
			throw new InvalidCarSharingException("Invalid car sharing!");
		
		//retrieving gas stations by proximity
		// other exceptions not handled because they should be launched by the called methods
		List<GasStationDto> gasStationsByProximity = getGasStationsByProximity(lat, lon, radius);
		List<GasStationDto> gasStationsByProximityAndFuelType = new ArrayList<GasStationDto>(); 
		List<GasStationDto> gasStationsByProximityAndFuelTypeAndCarSharing = new ArrayList<GasStationDto>();
		List<GasStationDto> gasStationsFiltered = new ArrayList<GasStationDto>();
		
		if( gasStationsByProximity == null ) {
			return new ArrayList<GasStationDto>(); 
		}
		
		gasStationsFiltered = gasStationsByProximity;
		if( gasolinetype != null && gasolinetype.compareTo("null") != 0 ) {
			//retrieving gas stations by fuel type and convert it into list of ids
			List<Integer> gasStationsByFuelType = getGasStationsByGasolineType(gasolinetype).stream()
															.map( g -> g.getGasStationId()).collect(Collectors.toList());
			if( gasStationsByFuelType.isEmpty() ) {
				return new ArrayList<GasStationDto>(); 
			}
			//intersection between gas stations by proximity and gas stations by fuel type
			gasStationsByProximityAndFuelType = 
					gasStationsFiltered.stream()
					.filter( g -> gasStationsByFuelType.contains(g.getGasStationId())).collect(Collectors.toList());
			gasStationsFiltered = gasStationsByProximityAndFuelType;
		}
		
		if( carsharing != null && carsharing.compareTo("null") != 0 ) {
			//retrieving gas stations by car sharing and convert it into list of ids
			List<Integer> gasStationsByCarSharing = getGasStationByCarSharing(carsharing).stream()
																.map( g -> g.getGasStationId()).collect(Collectors.toList());
			if( gasStationsByCarSharing.isEmpty() ) {
				return new ArrayList<GasStationDto>();
			}
			
			//intersection between gas stations by proximity and gas stations by fuel type and by car sharing
			gasStationsByProximityAndFuelTypeAndCarSharing = 
					gasStationsFiltered.stream()
					.filter( g -> gasStationsByCarSharing.contains(g.getGasStationId())).collect(Collectors.toList());
			gasStationsFiltered = gasStationsByProximityAndFuelTypeAndCarSharing;
		}

		return gasStationsFiltered;
	}

	@Override
	public List<GasStationDto> getGasStationsWithoutCoordinates(String gasolinetype, String carsharing)
			throws InvalidGasTypeException {
		//retrieving gas stations by proximity
		//exceptions not handled because they should be launched by the called methods
		List<GasStationDto> gasStations = getAllGasStations();
		List<GasStationDto> gasStationsByFuelType = new ArrayList<GasStationDto>(); 
		List<GasStationDto> gasStationsByFuelTypeAndCarSharing = new ArrayList<GasStationDto>();
		List<GasStationDto> gasStationsFiltered = new ArrayList<GasStationDto>();
		
		if( gasStations == null ) {
			return new ArrayList<GasStationDto>(); 
		}
		gasStationsFiltered = gasStations;
		
		if( gasolinetype != null && gasolinetype.compareTo("null") != 0 ) {
			//retrieving gas stations by fuel type and convert it into list of ids
			List<Integer>gasStationsByFuelTypeIds = getGasStationsByGasolineType(gasolinetype).stream()
															.map( g -> g.getGasStationId()).collect(Collectors.toList());
			if( gasStationsByFuelTypeIds.isEmpty() ) {
				return new ArrayList<GasStationDto>(); 
			}
			//intersection between gas stations by proximity and gas stations by fuel type
			gasStationsByFuelType = 
					gasStationsFiltered.stream()
					.filter( g -> gasStationsByFuelTypeIds.contains(g.getGasStationId())).collect(Collectors.toList());
			gasStationsFiltered = gasStationsByFuelType;
		}
		
		if( carsharing != null && carsharing.compareTo("null") != 0 ) {
			//retrieving gas stations by car sharing and convert it into list of ids
			List<Integer> gasStationsByCarSharingIds = getGasStationByCarSharing(carsharing).stream()
																.map( g -> g.getGasStationId()).collect(Collectors.toList());
			if( gasStationsByCarSharingIds.isEmpty() ) {
				return new ArrayList<GasStationDto>();
			}
			
			//intersection between gas stations by proximity and gas stations by fuel type and by car sharing
			gasStationsByFuelTypeAndCarSharing = 
					gasStationsFiltered.stream()
					.filter( g -> gasStationsByCarSharingIds.contains(g.getGasStationId())).collect(Collectors.toList());
			gasStationsFiltered = gasStationsByFuelTypeAndCarSharing;
		}
		
		return gasStationsFiltered;
	}

	@Override
	public void setReport(Integer gasStationId, Double dieselPrice, Double superPrice, Double superPlusPrice,
			Double gasPrice, Double methanePrice, Double premiumDieselPrice, Integer userId)
			throws InvalidGasStationException, PriceException, InvalidUserException {
		//gas station id error handling
		if( gasStationId<0 ) {
			throw new InvalidGasStationException("Invalid Gas Station ID!");
		}
		
		//user id error handling
		if( userId<0 ) {
			throw new InvalidUserException("Invalid User ID!");
		}
		
		//check if the user exists
		UserDto userDto = userService.getUserById(userId);
		if( userDto == null ) {
			return;
		}
		
		GasStationDto gasStationDto = getGasStationById(gasStationId);
		if( gasStationDto == null ) {
			return;
		}
		
		//price error handling 
		if( gasStationDto.getHasDiesel() == true && dieselPrice<0 ) {
			throw new PriceException("Invalide diesel price value!");
		}
		if( gasStationDto.getHasSuper() == true && superPrice<0 ) {
			throw new PriceException("Invalide super price value!");
		}
		if( gasStationDto.getHasSuperPlus() == true && superPlusPrice<0 ) {
			throw new PriceException("Invalide super plus price value!");
		}
		if( gasStationDto.getHasGas() == true && gasPrice<0 ) {
			throw new PriceException("Invalide gas price value!");
		}
		if( gasStationDto.getHasMethane() == true && methanePrice<0 ) {
			throw new PriceException("Invalide methane price value!");
		}
		if( gasStationDto.getHasPremiumDiesel() == true && premiumDieselPrice<0 ) {
			throw new PriceException("Invalide premium diesel price value!");
		}
		
		DateFormat format = new SimpleDateFormat("MM-dd-YYYY");
		Date today = new Date(System.currentTimeMillis());
		
		// CR4: overwriting a price report only if new user trust level >= previous user trust level
		// or if today - report timestamp > 4
		
		if( gasStationDto.getReportUser() != null && gasStationDto.getReportUser() !=-1 ) {
			UserDto previousUser = userService.getUserById(gasStationDto.getReportUser());
			if( userDto.getReputation() < previousUser.getReputation() ) {
				Date previousTimestamp = null;
				try {
					previousTimestamp = format.parse(gasStationDto.getReportTimestamp());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				int passedDays = ((int) (today.getTime() - previousTimestamp.getTime())) / (24 * 60 * 60 * 1000);
				if( passedDays <= 4 ) {
					return;
				}
			} 
		}
		
		gasStationDto.setDieselPrice(dieselPrice);
		gasStationDto.setSuperPrice(superPrice);
		gasStationDto.setSuperPlusPrice(superPlusPrice);
		gasStationDto.setGasPrice(gasPrice);
		gasStationDto.setMethanePrice(methanePrice);
		gasStationDto.setPremiumDieselPrice(premiumDieselPrice);
		gasStationDto.setReportUser(userId);
		gasStationDto.setReportTimestamp(format.format(today));
		double dependability = 50 * (userDto.getReputation() +5)/10 + 50; /*0 is because of obsolescence*/;
		gasStationDto.setReportDependability(dependability);
		gasStationDto.setUserDto(userDto);
		
		//updating an existing one
		repository.save(GasStationConverter.toGasStation(gasStationDto));
	}

	@Override
	public List<GasStationDto> getGasStationByCarSharing(String carSharing) {
		
		//retrieving all gas stations
		List<GasStationDto> gasStations = getAllGasStations();
		if( gasStations.size() == 0 ) {
			return new ArrayList<GasStationDto>();
		}
		//filtering gas stations by car sharing
		Stream<GasStationDto> filteredGasStations = 
				gasStations.stream()
				.filter( g -> g.getCarSharing().compareTo(carSharing) == 0);
		if( filteredGasStations == null ) {
			return new ArrayList<GasStationDto>();
		}
		
		return filteredGasStations
				.collect(Collectors.toList());
	}

	
	
}
