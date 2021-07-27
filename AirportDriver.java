

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AirportDriver extends BackEndAirport {

	public AirportDriver() throws FileNotFoundException {
		super();
		// default constructor
	}

	public static void main(String[] args) throws FileNotFoundException {

		BackEndAirport system = new BackEndAirport();

		// welcome page of driver
		System.out.println("Welcome to the Flight Finder! Please enter a single letter command below:");
		boolean end = false;

		// repeated loop till user exits system
		while (!end) {
			commands();
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();

			// displays shortest flight path between two airports
			if (input.equals("S") || input.equals("s")) {

				System.out.println("Enter city of departure");
				String departure = scanner.next();

				System.out.println("Enter city of arrival");
				String arrival = scanner.next();

				// create airport objects from provided strings
				Airport departureNode = system.airportGraph.getAirport(departure);
				Airport arrivalNode = system.airportGraph.getAirport(arrival);

				// in case of invalid input
				if (departureNode == null || arrivalNode == null) {
					System.out.println("Please enter valid city names/codes \n");
				}
				// call shortest path method
				else
					system.getShortestFlight(departureNode, arrivalNode);

			}

			// displays list of all airports user can choose from
			else if (input.equals("L") || input.equals("l")) {
				system.listAirports();

			}

			// looks for fun fact about entered airport
			else if (input.equals("F") || input.equals("f")) {

				System.out.println("Enter airport for fun fact.");
				String funFactAirport = scanner.next();

				Airport funFactNode = system.airportGraph.getAirport(funFactAirport);

				// in case of invalid input
				if (funFactNode == null) {
					System.out.println("Please enter a valid city name/code");
				}
				// call getFunFact() method and format display
				else
					System.out.println(
							"Fun fact about " + funFactNode.getCity() + " : " + system.getFunFact(funFactNode) + "!");

			}

			// displays the price of flight between two airport
			else if (input.equals("P") || input.equals("p")) {

				System.out.println("Enter city of departure");
				String departure = scanner.next();

				System.out.println("Enter city of arrival");
				String arrival = scanner.next();

				Airport departureNode = system.airportGraph.getAirport(departure);
				Airport arrivalNode = system.airportGraph.getAirport(arrival);

				// in case of invalid input
				if (departureNode == null || arrivalNode == null) {
					System.out.println("Please enter valid city names/codes");

				}
				// call getPrices() method and format display
				else
					System.out.println("Price from " + departureNode.getCity() + "(" + departureNode.getName() + ")"
							+ " to " + arrivalNode.getCity() + "(" + arrivalNode.getName() + ")" + " is $"
							+ system.getPrices(departureNode, arrivalNode));

			}

			// if user wants to quit
			else if (input.equals("Q") || input.equals("q")) {
				end = true;
				scanner.close();
				System.out.println("Thanks!");
			} else {
				System.out.println("Not a valid command. Please input a valid command.");
			}
		}

	}

	// options of commands for user to choose from
	private static void commands() {
		System.out.println("\nS - Search Shortest Flights ");
		System.out.println("F - Get a Fun Fact!");
		System.out.println("P - Lowest Priced Flights");
		System.out.println("L - List of Airports Supported by the System");
		System.out.println("Q - Quit");
	}

}
