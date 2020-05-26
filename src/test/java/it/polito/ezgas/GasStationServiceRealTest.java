package it.polito.ezgas;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.service.impl.GasStationServiceimpl;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
public class GasStationServiceRealTest {
	@Autowired
	private GasStationServiceimpl gsService;
	
	@Autowired
	private GasStationRepository gsRepo;
	
	@Before
	public void setup() {
		gsRepo.deleteAll();
	}
	
	@Test
	public void getGasStationByIdTest() throws PriceException, GPSDataException, InvalidGasStationException {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		GasStationDto gasStationDto = gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation));
		assertNotNull(gsService.getGasStationById(gasStationDto.getGasStationId()));
	}
	 
	@Test
	public void getAllGasStationsTest() throws PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation2));
		List<GasStationDto> result = gsService.getAllGasStations();
		assertNotNull(result);
		assertEquals(2, result.size());
	}
	
	@Test
	public void saveGasStationTest() throws PriceException, GPSDataException, InvalidGasStationException {
		GasStation gs = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStationDto gasStation = gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		GasStationDto result = gsService.getGasStationById(gasStation.getGasStationId());
		assertEquals(gasStation.getGasStationName(), result.getGasStationName());
		assertEquals(gasStation.getGasStationAddress(), result.getGasStationAddress());
		assertEquals(gasStation.getHasDiesel(), result.getHasDiesel());
		assertEquals(gasStation.getHasGas(), result.getHasGas());
		assertEquals(gasStation.getHasMethane(), result.getHasMethane());
		assertEquals(gasStation.getHasSuper(), result.getHasSuper());
		assertEquals(gasStation.getHasSuperPlus(), result.getHasSuperPlus());
		assertEquals(gasStation.getCarSharing(), result.getCarSharing());
		assertEquals(gasStation.getLat(), result.getLat());
		assertEquals(gasStation.getLon(), result.getLon());
		assertEquals(gasStation.getMethanePrice(), result.getMethanePrice());
		assertEquals(gasStation.getGasPrice(), result.getGasPrice());
		assertEquals(gasStation.getDieselPrice(), result.getDieselPrice());
		assertEquals(gasStation.getSuperPrice(), result.getSuperPrice());
		assertEquals(gasStation.getSuperPlusPrice(), result.getSuperPlusPrice());
		assertEquals(gasStation.getReportUser(), result.getReportUser());
		assertEquals(gasStation.getReportTimestamp(), result.getReportTimestamp());
		assertEquals(gasStation.getReportDependability(), result.getReportDependability());
	}
	
	@Test
	public void deleteGasStationTest() throws PriceException, GPSDataException, InvalidGasStationException {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStationDto gasStationDto = gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation));
		gsService.deleteGasStation(gasStationDto.getGasStationId());
		assertNull(gsService.getGasStationById(gasStationDto.getGasStationId()));
	}
	
	@Test
	public void getGasStationsByGasolineTypeTest() throws PriceException, GPSDataException, InvalidGasTypeException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation2));
		List<GasStationDto> result = gsService.getGasStationsByGasolineType("diesel");
		assertNotNull(result);
		assertEquals(1, result.size());
	}
	
	@Test
	public void getGasStationsByProximityTest() throws PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 2, 3, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true,
												true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation2));
		List<GasStationDto> result = gsService.getGasStationsByProximity(2, 3);
		assertNotNull(result);
		assertEquals(1, result.size());
	}
	
	@Test
	public void getGasStationsWithCoordinatesTest() throws InvalidGasTypeException, PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 2, 3, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true,
												true, true, true, "ShareNow", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation2));
		List<GasStationDto> result = gsService.getGasStationsWithCoordinates(2, 3, "diesel", "Enjoy");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(gasStation1.getLon(), result.get(0).getLon());
	}
	
	@Test
	public void getGasStationsWithoutCoordinatesTest() throws InvalidGasTypeException, PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 2, 3, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true,
												true, true, true, "ShareNow", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation2));
		List<GasStationDto> result = gsService.getGasStationsWithoutCoordinates("super", "ShareNow");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(gasStation2.getHasDiesel(), result.get(0).getHasDiesel());
	}
	
	@Test
	public void getGasStationByCarSharingTest() throws PriceException, GPSDataException, InvalidGasTypeException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 2, 3, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true,
												true, true, true, "ShareNow", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation2));
		List<GasStationDto> result = gsService.getGasStationByCarSharing("ShareNow");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(gasStation2.getCarSharing(), result.get(0).getCarSharing());
	}
	
	@Test
	public void setReportTest() throws PriceException, GPSDataException, InvalidGasTypeException, InvalidGasStationException, InvalidUserException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, "Enjoy", 2, 3, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		GasStationDto gasStationDto = gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation1));
		gsService.setReport(gasStationDto.getGasStationId(), 1.4, 1.5, 1.6, 1.3, 1.2, 1);
		assertNotNull(gasStationDto);
		assertEquals(gasStation1.getDieselPrice(), gasStationDto.getDieselPrice());
		assertEquals(gasStation1.getSuperPrice(), gasStationDto.getSuperPrice());
		assertEquals(gasStation1.getSuperPrice(), gasStationDto.getSuperPrice());
		assertEquals(gasStation1.getGasPrice(), gasStationDto.getGasPrice());
		assertEquals(gasStation1.getMethanePrice(), gasStationDto.getMethanePrice());
		
	}
}
