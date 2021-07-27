import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightInterfaceTest {
	AirportMap map;
	BackEndAirport backEnd;

	@BeforeEach
	void graphInit() {
		try {
			map = new AirportMap();
			backEnd = new BackEndAirport();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testArithmetic() {

		double check = 7574.0 * .3 + 50.0;
		double epsilon = .000001;
		double check2 = backEnd.getPrices(backEnd.airportGraph.getAirport("atlanta"),
				backEnd.airportGraph.getAirport("dubai"));
		if (check + epsilon > check2 && check - epsilon < check2) {

		} else {
			fail("prices calculated incorrectly - case 1");
		}
		check = 4427.0 * .3 + 50.0;
		check2 = backEnd.getPrices(backEnd.airportGraph.getAirport("atlanta"),
				backEnd.airportGraph.getAirport("paris"));
		if (check + epsilon > check2 && check - epsilon < check2) {

		} else {
			fail("prices calculated incorrectly - case 2");
		}
	}

	@Test
	void testShortestFlight() {
		if (!(backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("london"),
				backEnd.airportGraph.getAirport("newark")) == 4890)) {
			fail("Failed to give correct distance for shortest flight - case 1");
		}
		if (!(backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("beijing"),
				backEnd.airportGraph.getAirport("seattle")) == 5380)) {
			fail("Failed to give correct distance for shortest flight - case 2");
		}
		if (!(backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("newark"),
				backEnd.airportGraph.getAirport("dubai")) == 8162)) {
			fail("Failed to give correct distance for shortest flight - case 3");
		}
		if (!(backEnd.airportGraph.graph.getPathCost(backEnd.airportGraph.getAirport("atlanta"),
				backEnd.airportGraph.getAirport("chicago")) == 606)) {
			fail("Failed to give correct distance for shortest flight - case 4");
		}
	}

	@Test
	void testFlightBetweenTwoAirports() {
		int i;
		String expected = "LondonChicagoMadisonNewark";
		String actual = "";
		List<Airport> airports = backEnd.airportGraph.graph.dijkstrasShortestPath(
				backEnd.airportGraph.getAirport("london"), backEnd.airportGraph.getAirport("newark")).dataSequence;

		for (i = 0; i < airports.size(); i++) {
			actual += (airports.get(i).getCity());
		}

		if (!(actual.contentEquals(expected))) {
			fail("incorrect path - case 1");
		}

		expected = "BeijingSeattle";
		actual = "";
		airports = backEnd.airportGraph.graph.dijkstrasShortestPath(
				backEnd.airportGraph.getAirport("beijing"), backEnd.airportGraph.getAirport("seattle")).dataSequence;

		for (i = 0; i < airports.size(); i++) {
			actual += (airports.get(i).getCity());
		}
		if (!(actual.contentEquals(expected))) {
			fail("incorrect path - case 2");
		}

		expected = "NewarkMadisonChicagoDubai";
		String expected2 = "NewarkMilwaukeeMadisonChicagoDubai";
		actual = "";
		airports = backEnd.airportGraph.graph.dijkstrasShortestPath(
				backEnd.airportGraph.getAirport("newark"), backEnd.airportGraph.getAirport("dubai")).dataSequence;

		for (i = 0; i < airports.size(); i++) {
			actual += (airports.get(i).getCity());
		}
		if (!(actual.contentEquals(expected))) {
			if (!(actual.contentEquals(expected2))) {
			fail("incorrect path - case 3");
			}
		}

		expected = "AtlantaChicago";
		actual = "";
		airports = backEnd.airportGraph.graph.dijkstrasShortestPath(
				backEnd.airportGraph.getAirport("atlanta"),
				backEnd.airportGraph.getAirport("chicago")).dataSequence;

		for (i = 0; i < airports.size(); i++) {
			actual += (airports.get(i).getCity());
		}
		if (!(actual.contentEquals(expected))) {
			fail("incorrect path - case 4");
		}

	}

	@Test
	void testFunFact() {
		if (map.getAirport("atlanta").getFact()
				.contentEquals("The Georgia Aquarium in Atlanta is the largest aquarium in the western hemisphere.")) {

		} else {
			fail("Fun fact failed - case 1");
		}
		if (backEnd.airportGraph.getAirport("dubai").getFact().equals("Home for the tallest tower in the world")) {

		} else {
			fail("Fun fact failed - case 2");
		}
	}

	@Test
	void testInvalidInput() {
		try {
			backEnd.getShortestFlight(null, null);
			fail("No error thrown when given Erroneous input");
		} catch (Exception e) {

		} 
		
		}

}
