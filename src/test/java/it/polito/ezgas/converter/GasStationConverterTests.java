package it.polito.ezgas.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.converter.GasStationConverter;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GasStationConverterTests {

	@Test
	public void testToGasStationDto1() {
		GasStation gasStation = new GasStation("test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		gasStation.setGasStationId(1);
		GasStationDto expected = new GasStationDto(1,"test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		GasStationDto conv=GasStationConverter.toGasStationDto(gasStation);
		assertEquals(conv.getCarSharing(),expected.getCarSharing());
		assertEquals(conv.getDieselPrice(),expected.getDieselPrice());
		assertEquals(conv.getGasPrice(),expected.getGasPrice());
		assertEquals(conv.getMethanePrice(),expected.getMethanePrice());
		assertEquals(conv.getSuperPlusPrice(),expected.getSuperPlusPrice());
		assertEquals(conv.getSuperPrice(),expected.getSuperPrice());
		assertEquals(conv.getHasDiesel(),expected.getHasDiesel());
		assertEquals(conv.getHasGas(),expected.getHasGas());
		assertEquals(conv.getHasMethane(),expected.getHasMethane());
		assertEquals(conv.getHasSuper(),expected.getHasSuper());
		assertEquals(conv.getHasSuperPlus(),expected.getHasSuperPlus());
		assertEquals(conv.getGasStationAddress(),expected.getGasStationAddress());
		assertEquals(conv.getGasStationId(),expected.getGasStationId());
		assertEquals(conv.getGasStationName(),expected.getGasStationName());
		assertEquals(conv.getUserDto(),null);
		assertEquals(conv.getReportTimestamp(),expected.getReportTimestamp());
		assertEquals(conv.getReportDependability(),expected.getReportDependability());
		assertEquals(conv.getReportUser(),expected.getReportUser());
	}
	
	@Test
	public void testToGasStationDto2() {
		GasStation gasStation = new GasStation("test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		gasStation.setGasStationId(1);
		User user= new User();
		gasStation.setUser(user);
		GasStationDto expected = new GasStationDto(1,"test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		UserDto userDto= new UserDto();
		expected.setUserDto(userDto);
		GasStationDto conv=GasStationConverter.toGasStationDto(gasStation);
		assertEquals(conv.getCarSharing(),expected.getCarSharing());
		assertEquals(conv.getDieselPrice(),expected.getDieselPrice());
		assertEquals(conv.getGasPrice(),expected.getGasPrice());
		assertEquals(conv.getMethanePrice(),expected.getMethanePrice());
		assertEquals(conv.getSuperPlusPrice(),expected.getSuperPlusPrice());
		assertEquals(conv.getSuperPrice(),expected.getSuperPrice());
		assertEquals(conv.getHasDiesel(),expected.getHasDiesel());
		assertEquals(conv.getHasGas(),expected.getHasGas());
		assertEquals(conv.getHasMethane(),expected.getHasMethane());
		assertEquals(conv.getHasSuper(),expected.getHasSuper());
		assertEquals(conv.getHasSuperPlus(),expected.getHasSuperPlus());
		assertEquals(conv.getGasStationAddress(),expected.getGasStationAddress());
		assertEquals(conv.getGasStationId(),expected.getGasStationId());
		assertEquals(conv.getGasStationName(),expected.getGasStationName());
		assertEquals(conv.getReportTimestamp(),expected.getReportTimestamp());
		assertEquals(conv.getReportDependability(),expected.getReportDependability());
		assertEquals(conv.getReportUser(),expected.getReportUser());
		assertEquals(expected.getUserDto().getAdmin(), conv.getUserDto().getAdmin());
		assertEquals(expected.getUserDto().getEmail(), conv.getUserDto().getEmail());
		assertEquals(expected.getUserDto().getReputation(), conv.getUserDto().getReputation());
		assertEquals(expected.getUserDto().getPassword(), conv.getUserDto().getPassword());
		assertEquals(expected.getUserDto().getUserId(), conv.getUserDto().getUserId());
		assertEquals(expected.getUserDto().getUserName(), conv.getUserDto().getUserName());
	}
	
	@Test
	public void testToGasStation1() {
		GasStation expected = new GasStation("test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		expected.setGasStationId(1);
		GasStationDto gasStationDto = new GasStationDto(1,"test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		GasStation conv=GasStationConverter.toGasStation(gasStationDto);
		assertEquals(conv.getCarSharing(),expected.getCarSharing());
		assertEquals(conv.getDieselPrice(),expected.getDieselPrice());
		assertEquals(conv.getGasPrice(),expected.getGasPrice());
		assertEquals(conv.getMethanePrice(),expected.getMethanePrice());
		assertEquals(conv.getSuperPlusPrice(),expected.getSuperPlusPrice());
		assertEquals(conv.getSuperPrice(),expected.getSuperPrice());
		assertEquals(conv.getHasDiesel(),expected.getHasDiesel());
		assertEquals(conv.getHasGas(),expected.getHasGas());
		assertEquals(conv.getHasMethane(),expected.getHasMethane());
		assertEquals(conv.getHasSuper(),expected.getHasSuper());
		assertEquals(conv.getHasSuperPlus(),expected.getHasSuperPlus());
		assertEquals(conv.getGasStationAddress(),expected.getGasStationAddress());
		assertEquals(conv.getGasStationId(),expected.getGasStationId());
		assertEquals(conv.getGasStationName(),expected.getGasStationName());
		assertEquals(conv.getUser(),null);
		assertEquals(conv.getReportTimestamp(),expected.getReportTimestamp());
		assertEquals(conv.getReportDependability(),expected.getReportDependability());
		assertEquals(conv.getReportUser(),expected.getReportUser());
	}
	@Test
	public void testToGasStation2() {
		GasStation expected = new GasStation("test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		expected.setGasStationId(1);
		expected.setUser(new User());
		GasStationDto gasStationDto = new GasStationDto(1,"test", "testAddress", 
	    		true, true, true, true, 
	    		true, "testCar", 30.0, 20.0, 1.6, 
	    		1.6, 2.24, 3.14, 1.45, 
	    		22, "testTime", 0.0);
		gasStationDto.setUserDto(new UserDto());
		GasStation conv=GasStationConverter.toGasStation(gasStationDto);
		assertEquals(conv.getCarSharing(),expected.getCarSharing());
		assertEquals(conv.getDieselPrice(),expected.getDieselPrice());
		assertEquals(conv.getGasPrice(),expected.getGasPrice());
		assertEquals(conv.getMethanePrice(),expected.getMethanePrice());
		assertEquals(conv.getSuperPlusPrice(),expected.getSuperPlusPrice());
		assertEquals(conv.getSuperPrice(),expected.getSuperPrice());
		assertEquals(conv.getHasDiesel(),expected.getHasDiesel());
		assertEquals(conv.getHasGas(),expected.getHasGas());
		assertEquals(conv.getHasMethane(),expected.getHasMethane());
		assertEquals(conv.getHasSuper(),expected.getHasSuper());
		assertEquals(conv.getHasSuperPlus(),expected.getHasSuperPlus());
		assertEquals(conv.getGasStationAddress(),expected.getGasStationAddress());
		assertEquals(conv.getGasStationId(),expected.getGasStationId());
		assertEquals(conv.getGasStationName(),expected.getGasStationName());
		assertEquals(conv.getReportTimestamp(),expected.getReportTimestamp());
		assertEquals(conv.getReportDependability(),expected.getReportDependability());
		assertEquals(conv.getReportUser(),expected.getReportUser());
		assertEquals(conv.getUser().getAdmin(), conv.getUser().getAdmin());
		assertEquals(expected.getUser().getEmail(), conv.getUser().getEmail());
		assertEquals(expected.getUser().getReputation(), conv.getUser().getReputation());
		assertEquals(expected.getUser().getPassword(), conv.getUser().getPassword());
		assertEquals(expected.getUser().getUserId(), conv.getUser().getUserId());
		assertEquals(expected.getUser().getUserName(), conv.getUser().getUserName());
	}

}
