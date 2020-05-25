package it.polito.ezgas.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GasStationTests {
	
	@Test
	public void testGetGasStationId() {
		GasStation instance = new GasStation();
	    Integer expResult = 100;
	    instance.setGasStationId(100);
	    Integer result = instance.getGasStationId();
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testSetGasStationId() {
	    Integer value = 100;
	    GasStation instance = new GasStation();
	    instance.setGasStationId(value);
	    assertEquals(instance.getGasStationId(), value);
	}

	@Test
    public void testGetGasStationName() {
    	GasStation instance = new GasStation();
	    String expResult = "Test";
	    instance.setGasStationName("Test");
	    String result = instance.getGasStationName();
	    assertEquals(expResult, result);
    }

	@Test
    public void testSetGasStationName() {
	    String value = "Test";
	    GasStation instance = new GasStation();
	    instance.setGasStationName(value);
	    assertEquals(instance.getGasStationName(), value);
    }
    
	@Test
    public void testGetGasStationAddress() {
    	GasStation instance = new GasStation();
	    String expResult = "Test";
	    instance.setGasStationAddress("Test");
	    String result = instance.getGasStationAddress();
	    assertEquals(expResult, result);
    }
    
	@Test
    public void testSetGasStationAddress() {
    	String value = "Test";
	    GasStation instance = new GasStation();
	    instance.setGasStationAddress(value);
	    assertEquals(instance.getGasStationAddress(), value);
    }
    
	@Test
    public void testGetReportDependability() {
    	GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setReportDependability(1.5);
	    double result = instance.getReportDependability();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetReportDependability() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setReportDependability(value);
	    assertEquals(instance.getReportDependability(), value);
	}

	@Test
	public void testGetReportUser() {
		GasStation instance = new GasStation();
	    Integer expResult = 100;
	    instance.setReportUser(100);
	    Integer result = instance.getReportUser();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetReportUser() {
		Integer value = 100;
	    GasStation instance = new GasStation();
	    instance.setReportUser(value);
	    assertEquals(instance.getReportUser(), value);
	}

	@Test
	public void testGetReportTimestamp() {
		GasStation instance = new GasStation();
	    String expResult = "Test";
	    instance.setReportTimestamp("Test");
	    String result = instance.getReportTimestamp();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSsetReportTimestamp() {
		String value = "Test";
	    GasStation instance = new GasStation();
	    instance.setReportTimestamp(value);
	    assertEquals(instance.getReportTimestamp(), value);
	}

	@Test
	public void testGetHasDiesel() {
		GasStation instance = new GasStation();
	    boolean expResult = true;
	    instance.setHasDiesel(true);
	    boolean result = instance.getHasDiesel();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetHasDiesel() {
		boolean value = true;
	    GasStation instance = new GasStation();
	    instance.setHasDiesel(value);
	    assertEquals(instance.getHasDiesel(), value);
	}

	@Test
	public void testGetHasSuper() {
		GasStation instance = new GasStation();
	    boolean expResult = true;
	    instance.setHasSuper(true);
	    boolean result = instance.getHasSuper();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetHasSuper() {
		boolean value = true;
	    GasStation instance = new GasStation();
	    instance.setHasSuper(value);
	    assertEquals(instance.getHasSuper(), value);
	}

	@Test
	public void testGetHasSuperPlus() {
		GasStation instance = new GasStation();
	    boolean expResult = true;
	    instance.setHasSuperPlus(true);
	    boolean result = instance.getHasSuperPlus();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetHasSuperPlus() {
		boolean value = true;
	    GasStation instance = new GasStation();
	    instance.setHasSuperPlus(value);
	    assertEquals(instance.getHasSuperPlus(), value);
	}

	@Test
	public void testGetHasGas() {
		GasStation instance = new GasStation();
	    boolean expResult = true;
	    instance.setHasGas(true);
	    boolean result = instance.getHasGas();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetHasGas() {
		boolean value = true;
	    GasStation instance = new GasStation();
	    instance.setHasGas(value);
	    assertEquals(instance.getHasGas(), value);
	}

	@Test
	public void testGetLat() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setLat(1.5);
	    double result = instance.getLat();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetLat() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setLat(value);
	    assertEquals(instance.getLat(), value);
	}
	
	@Test
	public void testGetLon() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setLon(1.5);
	    double result = instance.getLon();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetLon() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setLon(value);
	    assertEquals(instance.getLon(), value);
	}

	@Test
	public void testGetDieselPrice() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setDieselPrice(1.5);
	    double result = instance.getDieselPrice();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetDieselPrice() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setDieselPrice(value);
	    assertEquals(instance.getDieselPrice(), value);
	}

	@Test
	public void testGetSuperPrice() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setSuperPrice(1.5);
	    double result = instance.getSuperPrice();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetSuperPrice() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setSuperPrice(value);
	    assertEquals(instance.getSuperPrice(), value);
	}

	@Test
	public void testGetSuperPlusPrice() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setSuperPlusPrice(1.5);
	    double result = instance.getSuperPlusPrice();
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testSetSuperPlusPrice() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setSuperPlusPrice(value);
	    assertEquals(instance.getSuperPlusPrice(), value);
	}

	@Test
	public void testGetGasPrice() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setGasPrice(1.5);
	    double result = instance.getGasPrice();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetGasPrice() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setGasPrice(value);
	    assertEquals(instance.getGasPrice(), value);
	}

	@Test
	public void testGetUser() {
		GasStation instance = new GasStation();
	    User expResult = new User();
	    instance.setUser(expResult);
	    User result = instance.getUser();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetUser() {
		User value = new User();
	    GasStation instance = new GasStation();
	    instance.setUser(value);
	    assertEquals(instance.getUser(), value);
	}

	@Test
	public void testGetHasMethane() {
		GasStation instance = new GasStation();
	    boolean expResult = true;
	    instance.setHasMethane(true);
	    boolean result = instance.getHasMethane();
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testSetHasMethane() {
		boolean value = true;
	    GasStation instance = new GasStation();
	    instance.setHasMethane(value);
	    assertEquals(instance.getHasMethane(), value);
	}

	@Test
	public void testGetMethanePrice() {
		GasStation instance = new GasStation();
	    double expResult = 1.5;
	    instance.setMethanePrice(1.5);
	    double result = instance.getMethanePrice();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetMethanePrice() {
		double value = 1.5;
	    GasStation instance = new GasStation();
	    instance.setMethanePrice(value);
	    assertEquals(instance.getMethanePrice(), value);
	}

	@Test
	public void testGetCarSharing() {
		GasStation instance = new GasStation();
	    String expResult = "Test";
	    instance.setCarSharing("Test");
	    String result = instance.getCarSharing();
	    assertEquals(expResult, result);
	}

	@Test
	public void testSetCarSharing() {
		String value = "Test";
	    GasStation instance = new GasStation();
	    instance.setCarSharing(value);
	    assertEquals(instance.getCarSharing(), value);
	}
	@Test
    public void testConstructor() {
	    GasStation instance = new GasStation("test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
	    assertEquals(instance.getCarSharing(), "testCar");
	    assertEquals(instance.getUser(),null);
	    assertEquals(instance.getLat(),30.0);
	    assertEquals(instance.getLon(),20.0);
	    assertEquals(instance.getHasDiesel(),true);
	    assertEquals(instance.getHasGas(),true);
	    assertEquals(instance.getHasMethane(),true);
	    assertEquals(instance.getHasSuper(),true);
	    assertEquals(instance.getHasSuperPlus(),true);
	    assertEquals(instance.getReportTimestamp(),"testTime");
	    assertEquals(instance.getReportDependability(),0);
	    assertEquals(instance.getGasStationId(),null);
	    assertEquals(instance.getGasStationName(),"test");
	    assertEquals(instance.getGasStationAddress(),"testAddress");
	    assertEquals(instance.getReportUser(),22);
	    assertEquals(instance.getDieselPrice(),1.6);
	    assertEquals(instance.getSuperPrice(),1.6);
	    assertEquals(instance.getSuperPlusPrice(),2.24);
	    assertEquals(instance.getGasPrice(),3.14);
	    assertEquals(instance.getMethanePrice(),1.45);
    }

}