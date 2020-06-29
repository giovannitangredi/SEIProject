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
import exception.InvalidCarSharingException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.impl.GasStationServiceimpl;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
	
	@Autowired
	private UserRepository uRepo;

	@Before
	public void setup() {
		gsRepo.deleteAll();
	}

	@Test
	public void getGasStationByIdTest() throws PriceException, GPSDataException, InvalidGasStationException {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 45, 45,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		GasStation gasStationDto = gsRepo.save(gasStation);
		assertNotNull(gsService.getGasStationById(gasStationDto.getGasStationId()));
	}

	@Test
	public void getAllGasStationsTest() throws PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 45,
				45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "2020-05-10T22:44:14.421", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 45,
				45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "2020-05-10T22:43:14.421", 1.0);
		User user1 = new User("user1", "pass1", "user1@user.com", 1);
		User user2 = new User("user2", "pass2", "user2@user.com", 2);
		gasStation1.setUser(user1);
		gasStation1.setUser(user2);
		uRepo.save(user1);
		uRepo.save(user2);
		
		gsRepo.save(gasStation1);
		gsRepo.save(gasStation2);
		List<GasStationDto> result = gsService.getAllGasStations();
		assertNotNull(result);
		assertEquals(2, result.size());
		// Scenario 9.1
		assertNotEquals(gasStation1.getReportDependability(), result.get(0).getReportDependability());
	}

	@Test
	public void saveGasStationTest() throws PriceException, GPSDataException, InvalidGasStationException {
		// scenario 4.1
		GasStation gs = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 45, 45, 1.0,
				1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation = gsRepo.save(gs);
		GasStationDto result = gsService.getGasStationById(gasStation.getGasStationId());
		assertEquals(gasStation.getGasStationName(), result.getGasStationName());
		assertEquals(gasStation.getGasStationAddress(), result.getGasStationAddress());
		assertEquals(gasStation.getHasDiesel(), result.getHasDiesel());
		assertEquals(gasStation.getHasGas(), result.getHasGas());
		assertEquals(gasStation.getHasMethane(), result.getHasMethane());
		assertEquals(gasStation.getHasSuper(), result.getHasSuper());
		assertEquals(gasStation.getHasSuperPlus(), result.getHasSuperPlus());
		assertEquals(gasStation.getHasPremiumDiesel(), result.getHasPremiumDiesel());
		assertEquals(gasStation.getCarSharing(), result.getCarSharing());
		assertEquals(gasStation.getLat(), result.getLat());
		assertEquals(gasStation.getLon(), result.getLon());
		assertEquals(gasStation.getMethanePrice(), result.getMethanePrice());
		assertEquals(gasStation.getGasPrice(), result.getGasPrice());
		assertEquals(gasStation.getDieselPrice(), result.getDieselPrice());
		assertEquals(gasStation.getSuperPrice(), result.getSuperPrice());
		assertEquals(gasStation.getSuperPlusPrice(), result.getSuperPlusPrice());
		assertEquals(gasStation.getPremiumDieselPrice(), result.getPremiumDieselPrice());
		assertEquals(gasStation.getReportUser(), result.getReportUser());
		assertEquals(gasStation.getReportTimestamp(), result.getReportTimestamp());
		assertEquals(gasStation.getReportDependability(), result.getReportDependability());

		// scenario 4.2
		gs.setLat(-91);
		gs.setLon(-181);
		assertThrows(GPSDataException.class, () -> {
			gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		});

		// scenario 5.1
		gasStation.setLat(45);
		gasStation.setLon(75);
		GasStationDto gsSc = gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation));
		assertEquals(45, gsSc.getLat());
		assertEquals(75, gsSc.getLon());

		// scenario 5.2
		gasStation.setLat(-91);
		gasStation.setLon(-181);
		assertThrows(GPSDataException.class, () -> {
			gsService.saveGasStation(GasStationConverter.toGasStationDto(gasStation));
		});
	}

	@Test
	public void deleteGasStationTest() throws PriceException, GPSDataException, InvalidGasStationException {
		// scenario 6.1
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 45, 45,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStationDto = gsRepo.save(gasStation);
		gsRepo.delete(gasStationDto.getGasStationId());
		assertNull(gsService.getGasStationById(gasStationDto.getGasStationId()));
	}

	@Test
	public void getGasStationsByGasolineTypeTest() throws PriceException, GPSDataException, InvalidGasTypeException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 45,
				45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true, "Enjoy", 45,
				45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		gsRepo.save(gasStation1);
		gsRepo.save(gasStation2);
		List<GasStationDto> result = gsService.getGasStationsByGasolineType("diesel");
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	public void getGasStationsByProximityTest() throws PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 2, 3,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true, "Enjoy", 45,
				45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		gsRepo.save(gasStation1);
		gsRepo.save(gasStation2);
		List<GasStationDto> result = gsService.getGasStationsByProximity(2, 3);
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	public void getGasStationsWithCoordinatesTest() throws InvalidGasTypeException, PriceException, GPSDataException, InvalidCarSharingException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 2, 3,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true, "ShareNow",
				45, 46, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		gsRepo.save(gasStation1);
		gsRepo.save(gasStation2);
		List<GasStationDto> result = gsService.getGasStationsWithCoordinates(2, 3, 1, "diesel", "Enjoy");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(gasStation1.getLon(), result.get(0).getLon());

		// Scenario 8.1
		GasStation gasStation3 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true, "Enjoy", 45,
				46, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		gsRepo.save(gasStation3);
		List<GasStationDto> result2 = gsService.getGasStationsWithCoordinates(45, 46, 1, "super", "Enjoy");
		
		assertNotNull(result2);
		assertEquals(1, result2.size());
		
		assertThrows(InvalidCarSharingException.class, () -> {
			gsService.getGasStationsWithCoordinates(45, 46, 1, "super", "ShareNow");
		});
	}

	@Test
	public void getGasStationsWithoutCoordinatesTest()
			throws InvalidGasTypeException, PriceException, GPSDataException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 2, 3,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true, "ShareNow",
				45, 45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		gsRepo.save(gasStation1);
		gsRepo.save(gasStation2);
		List<GasStationDto> result = gsService.getGasStationsWithoutCoordinates("super", "ShareNow");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(gasStation2.getHasDiesel(), result.get(0).getHasDiesel());

		// Scenario 8.2
		GasStation gasStation3 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true,"AVIS", 45,
				46, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		gsRepo.save(gasStation3);
		List<GasStationDto> result2 = gsService.getGasStationsWithoutCoordinates("super", "AVIS");
		assertNotNull(result2);
		assertEquals(1, result2.size());
	}

	@Test
	public void getGasStationByCarSharingTest() throws PriceException, GPSDataException, InvalidGasTypeException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 2, 3,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", false, true, true, true, true, true, "ShareNow",
				45, 45, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		gsRepo.save(gasStation1);
		gsRepo.save(gasStation2);
		List<GasStationDto> result = gsService.getGasStationByCarSharing("ShareNow");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(gasStation2.getCarSharing(), result.get(0).getCarSharing());
	}

	@Test
	public void setReportTest() throws PriceException, GPSDataException, InvalidGasTypeException,
			InvalidGasStationException, InvalidUserException {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true, true, true, true, true, "Enjoy", 2, 3,
				1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);

		GasStation gasStationDto = gsRepo.save(gasStation1);
		gsService.setReport(gasStationDto.getGasStationId(), 1.4, 1.5, 1.6, 1.3, 1.2, 1.7, 1);
		GasStation res = gsRepo.findOne(gasStation1.getGasStationId());
		assertNotNull(gasStationDto);
		assertEquals(gasStationDto.getDieselPrice(), res.getDieselPrice(), 1);
		assertEquals(gasStationDto.getSuperPrice(), res.getSuperPrice(), 1);
		assertEquals(gasStationDto.getSuperPrice(), res.getSuperPrice(), 1);
		assertEquals(gasStationDto.getGasPrice(), res.getGasPrice(), 1);
		assertEquals(gasStationDto.getMethanePrice(), res.getMethanePrice(), 1);
		assertEquals(gasStationDto.getPremiumDieselPrice(), res.getPremiumDieselPrice(), 1);

		// Scenario 7.1
		gsService.setReport(res.getGasStationId(), 1.6, 1.1, 1.2, 1.4, 1.5, 1.7, 1);
		assertNotEquals(gasStationDto.getReportTimestamp(), res.getReportTimestamp());

		// Scenario 7.2
		assertThrows(PriceException.class, () -> {
			gsService.setReport(res.getGasStationId(), -1.6, -1.1, -1.2, -1.4, -1.5, -1.7, 1);
		});
	}
}
