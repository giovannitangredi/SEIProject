package it.polito.ezgas;

import static org.hamcrest.CoreMatchers.instanceOf;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.converter.UserConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.service.impl.GasStationServiceimpl;
import it.polito.ezgas.service.impl.UserServiceimpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GasStationServiceTests {

	@Autowired
	GasStationServiceimpl gsService;

	@MockBean
	GasStationRepository gsRepo;

	@Autowired
	UserServiceimpl uService;

	GasStation gs;
	GasStation gs2;
	GasStation gs3;
	Integer gasStationId;
	String gasStationName;
	String gasStationAddress;
	boolean hasDiesel;
	boolean hasSuper;
	boolean hasSuperPlus;
	boolean hasGas;
	boolean hasMethane;
	String carSharing;
	double lat;
	double lon;
	double dieselPrice;
	double superPrice;
	double superPlusPrice;
	double gasPrice;
	double methanePrice;
	Integer reportUser;
	UserDto userDto;
	String reportTimestamp;
	double reportDependability;

	ArrayList<GasStation> lst;

	@Before
	public void setup() {

		gasStationId = 2;
		gasStationName = "GasStation 1";
		gasStationAddress = "Via Saliceto";
		hasDiesel = true;
		hasSuper = false;
		hasSuperPlus = true;
		hasGas = false;
		hasMethane = false;
		carSharing = "Enjoy";
		lat = 45.039188;
		lon = 7.642538;
		dieselPrice = 1.2;
		superPrice = 1.3;
		superPlusPrice = 1.5;
		gasPrice = 1.4;
		methanePrice = 1.1;
		reportUser = 1;
		userDto = new UserDto(1, "user1", "password", "user@user.com", 20);
		reportTimestamp = "2020-05-20T10:11:41.111";
		reportDependability = 30;

		gs = new GasStation(gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane,
				carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, reportUser,
				reportTimestamp, reportDependability);
		gs.setGasStationId(gasStationId);
		gs.setUser(UserConverter.toUser(userDto));

		gs2 = new GasStation(gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane,
				carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, reportUser,
				reportTimestamp, reportDependability);
		gs2.setGasStationId(3);
		gs2.setHasDiesel(false);
		gs2.setHasSuperPlus(false);
		gs2.setHasSuper(true);
		gs2.setLat(35.039188);
		gs2.setLon(2.642538);
		gs2.setCarSharing("ShareNow");
		gs2.setUser(UserConverter.toUser(userDto));

		lst = new ArrayList<GasStation>();
		lst.add(gs);
		lst.add(gs2);

		gs3 = new GasStation(gasStationName, gasStationAddress, false, false, false, false, false, "Free", 76.26462,
				45.04123, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, reportUser, reportTimestamp,
				reportDependability);
		gs3.setGasStationId(10);

		lst.add(gs3);

		when(gsRepo.findOne(gasStationId)).thenReturn(gs);
		when(gsRepo.save(any(GasStation.class))).thenReturn(gs);
		when(gsRepo.findAll()).thenReturn(lst);
		doNothing().when(gsRepo).delete(gs);

	}

	@Test
	public void getGasStationById() throws InvalidUserException, InvalidGasStationException {
		assertThrows(InvalidUserException.class, () -> {
			uService.getUserById(-1);
		});
		assertThrows(InvalidGasStationException.class, () -> {
			gsService.getGasStationById(-1);
		});
		assertThrows(InvalidGasStationException.class, () -> {
			gsService.getGasStationById(null);
		});

		GasStationDto gasStationDto = gsService.getGasStationById(2);
		assertTrue(gasStationDto.getGasStationId() == 2);

		when(gsService.getGasStationById(4)).thenReturn(null);

		gs.setUser(new User());
		gs.setReportTimestamp("2020-05-2044:42:31.434");
	    gasStationDto = gsService.getGasStationById(2);
	}

	@Test
	public void saveGasStationTest() throws PriceException, GPSDataException {
		GasStationDto res;

		res = gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		assertThat(res, instanceOf(GasStationDto.class));
		assertEquals(res.getGasStationId(), gasStationId);
		assertEquals(res.getGasStationName(), "GasStation 1");
		assertEquals(res.getGasStationAddress(), "Via Saliceto");
		assertTrue(res.getHasDiesel());
		assertFalse(res.getHasSuper());
		assertTrue(res.getHasSuperPlus());
		assertFalse(res.getHasGas());
		assertFalse(res.getHasMethane());
		assertEquals(res.getCarSharing(), "Enjoy");
		assertEquals(res.getLat(), 45.039188, 2);
		assertEquals(res.getLon(), 7.642538, 2);
		assertEquals(res.getDieselPrice(), 1.2, 1);
		assertEquals(res.getSuperPrice(), 1.3, 1);
		assertEquals(res.getSuperPlusPrice(), 1.5, 1);
		assertEquals(res.getGasPrice(), 1.4, 1);
		assertEquals(res.getMethanePrice(), 1.1, 1);
		assertEquals(res.getReportUser(), new Integer(1));
		assertEquals(res.getUserDto().getUserId(), userDto.getUserId());
		assertEquals(res.getReportTimestamp(), reportTimestamp);
		assertEquals(res.getReportDependability(), 30d, 1);

		assertThrows(GPSDataException.class, () -> {
			gs.setLat(91.043252);
			gs.setLon(181.541263);
			gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		});
		assertThrows(GPSDataException.class, () -> {
			gs.setLat(-91.043252);
			gs.setLon(-181.541263);
			gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		});
		assertThrows(GPSDataException.class, () -> {
			gs.setLat(45.043252);
			gs.setLon(181.541263);
			gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		});
		assertThrows(GPSDataException.class, () -> {
			gs.setLat(45.043252);
			gs.setLon(-181.541263);
			gsService.saveGasStation(GasStationConverter.toGasStationDto(gs));
		});
	}

	@Test
	public void getAllGasStationsTest() throws InvalidUserException {
		List<GasStationDto> lstGasStations = gsService.getAllGasStations();
		assertTrue(lstGasStations.size() == 3);

		when(gsRepo.findAll()).thenReturn(null);
		lstGasStations = gsService.getAllGasStations();
		assertTrue(lstGasStations.size() == 0);
	}

	@Test
	public void deleteGasStationTest() throws InvalidGasStationException {
		assertThrows(InvalidGasStationException.class, () -> {
			gsService.deleteGasStation(-1);
		});
		when(gsRepo.exists(gasStationId)).thenReturn(true).thenReturn(false);
		assertTrue(gsService.deleteGasStation(gasStationId));
		when(gsRepo.exists(gasStationId)).thenReturn(false);
		assertFalse(gsService.deleteGasStation(gasStationId));
		when(gsRepo.exists(gasStationId)).thenReturn(true).thenReturn(true);
		assertFalse(gsService.deleteGasStation(gasStationId));
	}

	@Test
	public void getGasStationsByGasolineTypeTest() throws InvalidGasTypeException {
		List<GasStationDto> lstGasoline = gsService.getGasStationsByGasolineType("diesel");
		assertEquals(lstGasoline.size(), 1);
		assertEquals(lstGasoline.get(0).getGasStationId(), GasStationConverter.toGasStationDto(gs).getGasStationId());

		lstGasoline = gsService.getGasStationsByGasolineType("super");
		assertEquals(lstGasoline.size(), 1);
		lstGasoline = gsService.getGasStationsByGasolineType("superplus");
		assertEquals(lstGasoline.size(), 1);
		lstGasoline = gsService.getGasStationsByGasolineType("gas");
		assertEquals(lstGasoline.size(), 1);
		lstGasoline = gsService.getGasStationsByGasolineType("methane");
		assertEquals(lstGasoline.size(), 0);

		assertThrows(InvalidGasTypeException.class, () -> {
			gsService.getGasStationsByGasolineType("ddd");
		});

		when(gsRepo.findAll()).thenReturn(null);
		lstGasoline = gsService.getGasStationsByGasolineType("diesel");
		assertTrue(lstGasoline.size() == 0);
	}

	@Test
	public void getGasStationsByProximityTest() throws GPSDataException {

		assertThrows(GPSDataException.class, () -> {
			gsService.getGasStationsByProximity(91.4222, 181.541263);
		});
		assertThrows(GPSDataException.class, () -> {
			gsService.getGasStationsByProximity(-91.043252, -181.541263);
		});
		assertThrows(GPSDataException.class, () -> {
			gsService.getGasStationsByProximity(45.043252, 181.541263);
		});
		assertThrows(GPSDataException.class, () -> {
			gsService.getGasStationsByProximity(45.043252, -181.541263);
		});

		List<GasStationDto> lstGasStations = gsService.getGasStationsByProximity(45.039188, 7.642538);
		assertTrue(lstGasStations.size() == 1);
		assertEquals(lstGasStations.get(0).getLat(), lat, 2);
		assertEquals(lstGasStations.get(0).getLon(), lon, 2);

		when(gsRepo.findAll()).thenReturn(null);
		lstGasStations = gsService.getGasStationsByProximity(45.039188, 7.642538);
		assertTrue(lstGasStations.size() == 0);
	}

	@Test
	public void getGasStationsWithCoordinatesTest() throws InvalidGasTypeException, GPSDataException {
		assertThrows(GPSDataException.class, () -> {
			gsService.getGasStationsWithCoordinates(91.039188, 7.642538, "diesel", "Enjoy");
		});
		List<GasStationDto> lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, "diesel",
				"Enjoy");
		assertTrue(lstGasStations.size() == 1);
		assertEquals(lstGasStations.get(0).getLat(), lat, 2);
		assertEquals(lstGasStations.get(0).getLon(), lon, 2);
		assertEquals(lstGasStations.get(0).getHasDiesel(), true);
		assertEquals(lstGasStations.get(0).getCarSharing(), carSharing);

		lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, null, "Enjoy");
		assertTrue(lstGasStations.size() == 1);
		lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, "null", "Enjoy");
		assertTrue(lstGasStations.size() == 1);

		lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, "diesel", "Ennjoy");
		assertTrue(lstGasStations.size() == 0);
		lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, "diesel", null);
		assertTrue(lstGasStations.size() == 1);
		lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, "diesel", "null");
		assertTrue(lstGasStations.size() == 1);

		when(gsRepo.findAll()).thenReturn(null);
		lstGasStations = gsService.getGasStationsWithCoordinates(45.039188, 7.642538, "diesel", "Enjoy");
		assertTrue(lstGasStations.size() == 0);
	}

	@Test
	public void getGasStationsWithOutCoordinatesTest() throws InvalidGasTypeException, GPSDataException {
		assertThrows(InvalidGasTypeException.class, () -> {
			gsService.getGasStationsWithoutCoordinates("diesele", "ShareNow");
		});
		List<GasStationDto> lstGasStations = gsService.getGasStationsWithoutCoordinates("diesel", "Enjoy");
		assertTrue(lstGasStations.size() == 1);
		assertEquals(lstGasStations.get(0).getLat(), lat, 2);
		assertEquals(lstGasStations.get(0).getLon(), lon, 2);
		assertEquals(lstGasStations.get(0).getHasDiesel(), true);
		assertEquals(lstGasStations.get(0).getCarSharing(), carSharing);

		lstGasStations = gsService.getGasStationsWithoutCoordinates(null, "Enjoy");
		assertTrue(lstGasStations.size() == 1);
		lstGasStations = gsService.getGasStationsWithoutCoordinates("null", "Enjoy");
		assertTrue(lstGasStations.size() == 1);
		lstGasStations = gsService.getGasStationsWithoutCoordinates("diesel", "Ennjoy");
		assertTrue(lstGasStations.size() == 0);
		lstGasStations = gsService.getGasStationsWithoutCoordinates("diesel", null);
		assertTrue(lstGasStations.size() == 1);
		lstGasStations = gsService.getGasStationsWithoutCoordinates("diesel", "null");
		assertTrue(lstGasStations.size() == 1);

		when(gsRepo.findAll()).thenReturn(null);
		lstGasStations = gsService.getGasStationsWithoutCoordinates("diesel", "Enjoy");
		assertTrue(lstGasStations.size() == 0);
	}

	@Test
	public void setReportTest() throws InvalidGasStationException, PriceException, InvalidUserException {
		assertThrows(InvalidGasStationException.class, () -> {
			gsService.setReport(-1, 1.2, 1.3, 1.4, 1.5, 1.6, userDto.getUserId());
		});
		assertThrows(InvalidUserException.class, () -> {
			gsService.setReport(gasStationId, 1.2, 1.3, 1.4, 1.5, 1.6, -1);
		});
		assertThrows(PriceException.class, () -> {
			gsService.setReport(gasStationId, -1.2, 1.3, 1.4, 1.5, 1.6, userDto.getUserId());
		});

		gsService.setReport(gasStationId, 1.6, 1.5, 1.7, 1.4, 1.1, userDto.getUserId());
		GasStationDto result = gsService.getGasStationById(gasStationId);
		assertEquals(result.getDieselPrice(), 1.6, 1);
		assertEquals(result.getSuperPrice(), 1.7, 1);
		assertEquals(result.getGasPrice(), 1.4, 1);
		assertEquals(result.getMethanePrice(), 1.1, 1);

		when(gsRepo.findOne(gasStationId)).thenReturn(null);
		gsService.setReport(gasStationId, 1.6, 1.5, 1.7, 1.4, 1.1, userDto.getUserId());

		gsService.setReport(gs3.getGasStationId(), 1.6, 1.5, 1.7, 1.4, 1.1, userDto.getUserId());
		
		when(gsRepo.findOne(gs3.getGasStationId())).thenReturn(gs3);
		
		gs3.setHasDiesel(true);
		assertThrows(PriceException.class, () -> {
			gsService.setReport(gs3.getGasStationId(), -1.2, 1.3, 1.4, 1.5, 1.6, userDto.getUserId());
		});
		gs3.setHasSuper(true);
		assertThrows(PriceException.class, () -> {
			gsService.setReport(gs3.getGasStationId(), 1.2, -1.3, 1.4, 1.5, 1.6, userDto.getUserId());
		});
		gs3.setHasSuperPlus(true);
		assertThrows(PriceException.class, () -> {
			gsService.setReport(gs3.getGasStationId(), 1.2, 1.3, -1.4, 1.5, 1.6, userDto.getUserId());
		});
		
		gs3.setHasSuperPlus(false);
		gsService.setReport(gs3.getGasStationId(), 1.2, 1.3, -1.4, 1.5, 1.6, userDto.getUserId());
		
//		gs3.setHasGas(true);
//		assertThrows(PriceException.class, () -> {
//			gsService.setReport(gs3.getGasStationId(), 1.2, 1.3, 1.4, -1.5, 1.6, userDto.getUserId());
//		});
		
		gs3.setHasMethane(true);
		assertThrows(PriceException.class, () -> {
			gsService.setReport(gs3.getGasStationId(), 1.2, 1.3, 1.4, 1.5, -1.6, userDto.getUserId());
		});
		gs3.setHasMethane(false);
		gsService.setReport(gs3.getGasStationId(), 1.2, 1.3, 1.4, 1.5, -1.6, userDto.getUserId());
	}

	@Test
	public void getGasStationByCarSharingTest() {
		List<GasStationDto> lstGasStations = gsService.getGasStationByCarSharing("ShareNow");
		assertEquals(lstGasStations.size(), 1);
		assertEquals(lstGasStations.get(0).getGasStationId(), GasStationConverter.toGasStationDto(gs2).getGasStationId());
		
		when(gsRepo.findAll()).thenReturn(null);
		lstGasStations = gsService.getGasStationByCarSharing("ShareNow");
		assertTrue(lstGasStations.size() == 0);
	}
}
