package it.polito.ezgas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;

public class GasStationDtoTests {

	@Test
	public void testGetGasStationId() {
		GasStationDto instance = new GasStationDto();
		Integer expResult = 100;
		instance.setGasStationId(100);
		Integer result = instance.getGasStationId();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetGasStationId() {
		Integer value = 100;
		GasStationDto instance = new GasStationDto();
		instance.setGasStationId(value);
		assertEquals(instance.getGasStationId(), value);
	}

	@Test
	public void testGetGasStationName() {
		GasStationDto instance = new GasStationDto();
		String expResult = "Test";
		instance.setGasStationName("Test");
		String result = instance.getGasStationName();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetGasStationName() {
		String value = "Test";
		GasStationDto instance = new GasStationDto();
		instance.setGasStationName(value);
		assertEquals(instance.getGasStationName(), value);
	}

	@Test
	public void testGetGasStationAddress() {
		GasStationDto instance = new GasStationDto();
		String expResult = "Test";
		instance.setGasStationAddress("Test");
		String result = instance.getGasStationAddress();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetGasStationAddress() {
		String value = "Test";
		GasStationDto instance = new GasStationDto();
		instance.setGasStationAddress(value);
		assertEquals(instance.getGasStationAddress(), value);
	}

	@Test
	public void testGetReportDependability() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setReportDependability(1.5);
		double result = instance.getReportDependability();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetReportDependability() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setReportDependability(value);
		assertEquals(instance.getReportDependability(), value);
	}

	@Test
	public void testGetReportUser() {
		GasStationDto instance = new GasStationDto();
		Integer expResult = 100;
		instance.setReportUser(100);
		Integer result = instance.getReportUser();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetReportUser() {
		Integer value = 100;
		GasStationDto instance = new GasStationDto();
		instance.setReportUser(value);
		assertEquals(instance.getReportUser(), value);
	}

	@Test
	public void testGetReportTimestamp() {
		GasStationDto instance = new GasStationDto();
		String expResult = "Test";
		instance.setReportTimestamp("Test");
		String result = instance.getReportTimestamp();
		assertEquals(expResult, result);
	}

	@Test
	public void testSsetReportTimestamp() {
		String value = "Test";
		GasStationDto instance = new GasStationDto();
		instance.setReportTimestamp(value);
		assertEquals(instance.getReportTimestamp(), value);
	}

	@Test
	public void testGetHasDiesel() {
		GasStationDto instance = new GasStationDto();
		boolean expResult = true;
		instance.setHasDiesel(true);
		boolean result = instance.getHasDiesel();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetHasDiesel() {
		boolean value = true;
		GasStationDto instance = new GasStationDto();
		instance.setHasDiesel(value);
		assertEquals(instance.getHasDiesel(), value);
	}

	@Test
	public void testGetHasSuper() {
		GasStationDto instance = new GasStationDto();
		boolean expResult = true;
		instance.setHasSuper(true);
		boolean result = instance.getHasSuper();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetHasSuper() {
		boolean value = true;
		GasStationDto instance = new GasStationDto();
		instance.setHasSuper(value);
		assertEquals(instance.getHasSuper(), value);
	}

	@Test
	public void testGetHasSuperPlus() {
		GasStationDto instance = new GasStationDto();
		boolean expResult = true;
		instance.setHasSuperPlus(true);
		boolean result = instance.getHasSuperPlus();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetHasSuperPlus() {
		boolean value = true;
		GasStationDto instance = new GasStationDto();
		instance.setHasSuperPlus(value);
		assertEquals(instance.getHasSuperPlus(), value);
	}

	@Test
	public void testGetHasGas() {
		GasStationDto instance = new GasStationDto();
		boolean expResult = true;
		instance.setHasGas(true);
		boolean result = instance.getHasGas();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetHasGas() {
		boolean value = true;
		GasStationDto instance = new GasStationDto();
		instance.setHasGas(value);
		assertEquals(instance.getHasGas(), value);
	}

	@Test
	public void testGetLat() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setLat(1.5);
		double result = instance.getLat();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetLat() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setLat(value);
		assertEquals(instance.getLat(), value);
	}

	@Test
	public void testGetLon() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setLon(1.5);
		double result = instance.getLon();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetLon() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setLon(value);
		assertEquals(instance.getLon(), value);
	}

	@Test
	public void testGetDieselPrice() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setDieselPrice(1.5);
		double result = instance.getDieselPrice();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetDieselPrice() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setDieselPrice(value);
		assertEquals(instance.getDieselPrice(), value);
	}

	@Test
	public void testGetSuperPrice() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setSuperPrice(1.5);
		double result = instance.getSuperPrice();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetSuperPrice() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setSuperPrice(value);
		assertEquals(instance.getSuperPrice(), value);
	}

	@Test
	public void testGetSuperPlusPrice() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setSuperPlusPrice(1.5);
		double result = instance.getSuperPlusPrice();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetSuperPlusPrice() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setSuperPlusPrice(value);
		assertEquals(instance.getSuperPlusPrice(), value);
	}

	@Test
	public void testGetGasPrice() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setGasPrice(1.5);
		double result = instance.getGasPrice();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetGasPrice() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setGasPrice(value);
		assertEquals(instance.getGasPrice(), value);
	}

	@Test
	public void testGetUserDto() {
		GasStationDto instance = new GasStationDto();
		UserDto expResult = new UserDto();
		instance.setUserDto(expResult);
		UserDto result = instance.getUserDto();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetUserDto() {
		UserDto value = new UserDto();
		GasStationDto instance = new GasStationDto();
		instance.setUserDto(value);
		assertEquals(instance.getUserDto(), value);
	}

	@Test
	public void testGetHasMethane() {
		GasStationDto instance = new GasStationDto();
		boolean expResult = true;
		instance.setHasMethane(true);
		boolean result = instance.getHasMethane();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetHasMethane() {
		boolean value = true;
		GasStationDto instance = new GasStationDto();
		instance.setHasMethane(value);
		assertEquals(instance.getHasMethane(), value);
	}

	@Test
	public void testGetMethanePrice() {
		GasStationDto instance = new GasStationDto();
		double expResult = 1.5;
		instance.setMethanePrice(1.5);
		double result = instance.getMethanePrice();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetMethanePrice() {
		double value = 1.5;
		GasStationDto instance = new GasStationDto();
		instance.setMethanePrice(value);
		assertEquals(instance.getMethanePrice(), value);
	}

	@Test
	public void testGetCarSharing() {
		GasStationDto instance = new GasStationDto();
		String expResult = "Test";
		instance.setCarSharing("Test");
		String result = instance.getCarSharing();
		assertEquals(expResult, result);
	}

	@Test
	public void testSetCarSharing() {
		String value = "Test";
		GasStationDto instance = new GasStationDto();
		instance.setCarSharing(value);
		assertEquals(instance.getCarSharing(), value);
	}
}
