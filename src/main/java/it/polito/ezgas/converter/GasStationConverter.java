package it.polito.ezgas.converter;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;

public class GasStationConverter {
	
	public static GasStationDto toGasStationDto(GasStation gasStation) {
		GasStationDto gasStationConverted = new GasStationDto();
		gasStationConverted.setGasStationId(gasStation.getGasStationId());
		gasStationConverted.setGasStationName(gasStation.getGasStationName());
		gasStationConverted.setGasStationAddress(gasStation.getGasStationAddress());
		gasStationConverted.setHasDiesel(gasStation.getHasDiesel());
		gasStationConverted.setHasSuper(gasStation.getHasSuper());
		gasStationConverted.setHasSuperPlus(gasStation.getHasSuperPlus());
		gasStationConverted.setHasMethane(gasStation.getHasMethane());
		gasStationConverted.setCarSharing(gasStation.getCarSharing());
		gasStationConverted.setLat(gasStation.getLat());
		gasStationConverted.setLon(gasStation.getLon());
		gasStationConverted.setDieselPrice(gasStation.getDieselPrice());
		gasStationConverted.setSuperPrice(gasStation.getSuperPrice());
		gasStationConverted.setSuperPlusPrice(gasStation.getSuperPlusPrice());
		gasStationConverted.setGasPrice(gasStation.getGasPrice());
		gasStationConverted.setMethanePrice(gasStation.getMethanePrice());
		gasStationConverted.setReportUser(gasStation.getReportUser());
		gasStationConverted.setUserDto(UserConverter.toUserDto(gasStation.getUser()));
		gasStationConverted.setReportTimestamp(gasStation.getReportTimestamp());
		gasStationConverted.setReportDependability(gasStation.getReportDependability());
		// TODO priceReportDtos check if it is really needed
		return gasStationConverted;
		
	}
	
	public static GasStation toGasStation(GasStationDto gasStationDto) {
		GasStation gasStationConverted = new GasStation();
		gasStationConverted.setGasStationId(gasStationDto.getGasStationId());
		gasStationConverted.setGasStationName(gasStationDto.getGasStationName());
		gasStationConverted.setGasStationAddress(gasStationDto.getGasStationAddress());
		gasStationConverted.setHasDiesel(gasStationDto.getHasDiesel());
		gasStationConverted.setHasSuper(gasStationDto.getHasSuper());
		gasStationConverted.setHasSuperPlus(gasStationDto.getHasSuperPlus());
		gasStationConverted.setHasMethane(gasStationDto.getHasMethane());
		gasStationConverted.setCarSharing(gasStationDto.getCarSharing());
		gasStationConverted.setLat(gasStationDto.getLat());
		gasStationConverted.setLon(gasStationDto.getLon());
		gasStationConverted.setDieselPrice(gasStationDto.getDieselPrice());
		gasStationConverted.setSuperPrice(gasStationDto.getSuperPrice());
		gasStationConverted.setSuperPlusPrice(gasStationDto.getSuperPlusPrice());
		gasStationConverted.setGasPrice(gasStationDto.getGasPrice());
		gasStationConverted.setMethanePrice(gasStationDto.getMethanePrice());
		gasStationConverted.setReportUser(gasStationDto.getReportUser());
		//gasStationConverted.setUser(UserConverter.toUser(gasStationDto.getUserDto()));
		gasStationConverted.setReportTimestamp(gasStationDto.getReportTimestamp());
		gasStationConverted.setReportDependability(gasStationDto.getReportDependability());
		return gasStationConverted;
		
	}
}
