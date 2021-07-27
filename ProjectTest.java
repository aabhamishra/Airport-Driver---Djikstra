
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectTest {
	static AirportMap map;
	static BackEndAirport backEnd;
	
	/**
	 * Sets up the AirportMap and the BackEndAirport in order to test the project.
	 */
	@BeforeEach
	void setUp() {
		map = new AirportMap();
		backEnd = new BackEndAirport();
	}
	/**
	 * Tests when an airport is entered that is not on the list of airports. 
	 * Should throw a NoSuchElementException.
	 */
	@Test
	void testInvalidInput() {
	Airport fake1 = new Airport(new String[] {"1", "2", "3","4"});
	Airport fake2 = new Airport(new String[] {"1", "2", "3","4"});
	
	try {
		backEnd.getShortestFlight(fake1, fake2);
	
		} catch (NoSuchElementException e) {
			return;
			
		} 
		fail();
	}
	/**
	 * Tests the price of plane tickets to various airports. (i.e. the price of a plane ticket from London to Paris). 
	 */
	@Test
	void testArithmetic() {
		double test1 = backEnd.getPrices(backEnd.airportGraph.getAirport("london"),backEnd.airportGraph.getAirport("paris"));
		double test2 = backEnd.getPrices(backEnd.airportGraph.getAirport("dubai"),backEnd.airportGraph.getAirport("newark"));
		double test3 = backEnd.getPrices(backEnd.airportGraph.getAirport("seattle"),backEnd.airportGraph.getAirport("dubai"));

		if (test1 != 114.8) {
			fail();
		} else if (test2 != 2498.6) {
			fail();
		} else if (test3 != 2734.4) {
			fail();
		}
		
	}
	/**
	 * Tests the shortest distance required to fly to another airport. 
	 */
	@Test
	void testShortestFlightCost() {
		
		int test1 = backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("paris"), backEnd.airportGraph.getAirport("newark"));
		int test2 = backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("newark"), backEnd.airportGraph.getAirport("madison"));
		int test3 = backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("london"), backEnd.airportGraph.getAirport("beijing"));

		if (test1 != 5074) {
			fail();
		} else if (test2 != 799) {
			fail();
		} else if (test3 != 5052) {
			fail();
		}
	}
	/**
	 * Tests the path printed out between two airports. 
	 * Catches the output from the printStream and uses that to test the correct path.
	 */
	@Test
	void testFlightPath() {
		
		ByteArrayOutputStream catcher1 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(catcher1));
		backEnd.getShortestFlight(backEnd.airportGraph.getAirport("beijing"), backEnd.airportGraph.getAirport("seattle"));
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		String content1 = catcher1.toString();
		
		ByteArrayOutputStream catcher2 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(catcher2));
		backEnd.getShortestFlight(backEnd.airportGraph.getAirport("madison"), backEnd.airportGraph.getAirport("paris"));
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		String content2 = catcher2.toString();
		
		ByteArrayOutputStream catcher3 = new ByteArrayOutputStream();
		System.setOut(new PrintStream(catcher3));
		backEnd.getShortestFlight(backEnd.airportGraph.getAirport("milwaukee"), backEnd.airportGraph.getAirport("dubai"));
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		String content3 = catcher3.toString();
		
		if (!(content1.substring(content1.lastIndexOf("Beijing")).contains("Beijing, Seattle"))) {
			fail();
		} else if (!(content2.substring(content2.lastIndexOf("Madison")).contains("Madison, Chicago, Paris"))) {
			fail();
		} else if (!(content3.substring(content3.lastIndexOf("Milwaukee")).contains("Milwaukee, Madison, Chicago, Dubai"))) {
			fail();
		}
		
	}
	/*
	 * Tests that the fun fact for an airport is correct.
	 */
	@Test
	void testFunFact() {
		
		String test1 = map.getAirport("milwaukee").getFact(); 
		String test2 = map.getAirport("beijing").getFact();
		String test3 = map.getAirport("seattle").getFact();

		
		if (!test1.contains("The ice rink in downtown Milwaukee is bigger than the Time Square")) {
			fail();
		} else if (!test2.contains("Beijing home to the Forbidden City the world's largest emperial palace")) {
			fail();
		} else if (!test3.contains("Has the largest man made island (Seattle Harbor)")) {
			fail();
		}
		
	}
	

}
