
import java.util.List;

public class BackEndAirport {

  AirportMap airportGraph = new AirportMap();

  /**
   * Prints out the shortest path between the user's chosen airport starting point and the
   * destination airport
   * 
   * @param start       - the airport that the user starts at
   * @param destination - the airport that the user arrives at
   */
  public void getShortestFlight(Airport start, Airport destination) {
    List<Airport> airportList = airportGraph.graph.shortestPath(start, destination);

    System.out.println(
        "This is the shortest path between " + start.getCity() + " and " + destination.getCity());

    String locations = "";
    for (int i = 0; i < airportList.size(); i++) {
      Airport temp = airportList.get(i);
      if (i != airportList.size() - 1)
        locations += temp.getCity() + ", ";
      else
        locations += temp.getCity();
    }

    System.out.println(locations);
  }

  /**
   * Prints out a fun fact about the airport that the user chooses
   * 
   * @param airport - the airport that the user wants to know more about
   * @return - the String containing the fun fact about the airport
   */
  public String getFunFact(Airport airport) {
    return airport.getFact();
  }

  /**
   * Calculates the price of the flight between two different destinations. I used my own algorithm
   * to decide the price of the flight based on the distance between the airports.
   * 
   * @param start       - the airport the user starts at
   * @param destination - the airport the user arrives at
   * @return - the price the user will have to pay for the flight
   */
  public double getPrices(Airport start, Airport destination) {

    double price = 50.0;
    double pathCost = (double) airportGraph.graph.getPathCost(start, destination);
    price += pathCost * 0.3;

    return price;

  }

  /**
   * List all the airports that the user can choose from
   */
  public void listAirports() {
    System.out.println("Here is a list of all the airports: ");
    for (int i = 0; i < airportGraph.list.size(); i++) {
      if (i != airportGraph.list.size() - 1)
        System.out.println(
            airportGraph.list.get(i).getCity() + "(" + airportGraph.list.get(i).getName() + ") ");
      else
        System.out.println(
            airportGraph.list.get(i).getCity() + "(" + airportGraph.list.get(i).getName() + ")");
    }

  }

}