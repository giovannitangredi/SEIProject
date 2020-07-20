package it.polito.ezgas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.repository.GasStationRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
public class GasStationRepositoryTests {

	@Autowired
	GasStationRepository gasStationRepository;
	@Before
	public void setUp() {
		gasStationRepository.deleteAll();
	}
	@Test
	public void testFindOne() {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gasStationRepository.save(gasStation);
		assertNotNull(gasStationRepository.findOne(gasStation.getGasStationId()));
	}
	
	@Test
	public void testFindAll() {
		GasStation gasStation1 = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		GasStation gasStation2 = new GasStation("GS2", "Via dei pazzi, 0", true, true,
												true, true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		
		gasStationRepository.save(gasStation1);
		gasStationRepository.save(gasStation2);
		List<GasStation> result = gasStationRepository.findAll();
		assertNotNull(result);
		assertEquals(2, result.size());
		
	}
	
	@Test
	public void testExists() {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		gasStationRepository.save(gasStation);
		assertTrue(gasStationRepository.exists(gasStation.getGasStationId()));
	}
	
	@Test
	public void testSave() {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		gasStationRepository.save(gasStation);
		GasStation result = gasStationRepository.findOne(gasStation.getGasStationId());
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
	public void testDelete() {
		GasStation gasStation = new GasStation("GS1", "Via dei pazzi, 0", true, true,
												true, true, true, true, "Enjoy", 45, 45, 1.0, 
												1.0, 1.0, 1.0, 1.0, 1.0, 1, "23/05/2020", 1.0);
		gasStationRepository.save(gasStation);
		gasStationRepository.delete(gasStation.getGasStationId());
		assertNull(gasStationRepository.findOne(gasStation.getGasStationId()));
	}
}
