
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class initiates the graph and can be used to return airport objects
 * @author ALIAL
 *
 */
public class AirportMap {

	public CS400Graph<Airport> graph;
	ArrayList<Airport> list;
	
	
	public AirportMap()  {
		createGraph();
	}
	/**
	 * creates the graph for the connected airports
	 * @throws FileNotFoundException
	 */
	 public void createGraph() {
		 	graph = new CS400Graph<>();
		 	
	        File file = new File("airports.txt");
	        Scanner sc;
			try {
				sc = new Scanner(file);
				list = new ArrayList<Airport>();
		        String[] temp;
		        
		        while (sc.hasNextLine()) {
		        	temp = sc.nextLine().split(",");
		        	Airport currAp = new Airport(temp) ;
		        	graph.insertVertex(currAp);
		        	list.add(currAp);
		        	
		        }
		        sc.close();
			} catch (FileNotFoundException e) {
				
				System.out.println("txt file not found");
			}
	        
	         
	       
	      
	        	
	        
	        
	        //chicago edges
	        graph.insertEdge(list.get(0),list.get(1),3955);
	        graph.insertEdge(list.get(0),list.get(2),4139);
	        graph.insertEdge(list.get(0),list.get(4),136);
	        graph.insertEdge(list.get(0),list.get(5),1721);
	        graph.insertEdge(list.get(0),list.get(6),1154);
	        graph.insertEdge(list.get(0),list.get(7),606);
	        graph.insertEdge(list.get(0),list.get(8),6560);
	        graph.insertEdge(list.get(0),list.get(9),7227);
	        //london edges
	        graph.insertEdge(list.get(1),list.get(0),3955);
	        graph.insertEdge(list.get(1),list.get(2),216);
	        graph.insertEdge(list.get(1),list.get(7),4211);
	        graph.insertEdge(list.get(1),list.get(8),5052);
	        graph.insertEdge(list.get(1),list.get(9),3420);
	        //France Edges
	        graph.insertEdge(list.get(2),list.get(1),216);
	        graph.insertEdge(list.get(2),list.get(0),4139);
	        graph.insertEdge(list.get(2),list.get(8),5102);
	        graph.insertEdge(list.get(2),list.get(9),3259);
	        // Milwaukee edges
	        graph.insertEdge(list.get(3),list.get(4),74);
	        graph.insertEdge(list.get(3),list.get(5),1694);
	        graph.insertEdge(list.get(3),list.get(6),725);
	        graph.insertEdge(list.get(3),list.get(7),669);
	        //Madison edges
	        graph.insertEdge(list.get(4),list.get(3),74);
	        graph.insertEdge(list.get(4),list.get(0),136);
	        graph.insertEdge(list.get(4),list.get(5),1622);
	        graph.insertEdge(list.get(4),list.get(6),799);
	        graph.insertEdge(list.get(4),list.get(7),707);
	        //Seattle edges
	        graph.insertEdge(list.get(5),list.get(4),1622);
	        graph.insertEdge(list.get(5),list.get(3),1694);
	        graph.insertEdge(list.get(5),list.get(0),1721);
	        graph.insertEdge(list.get(5),list.get(6),2402);
	        graph.insertEdge(list.get(5),list.get(7),2182);
	        graph.insertEdge(list.get(5),list.get(8),5380);
	        //Newark edges
	        graph.insertEdge(list.get(6),list.get(5),2402);
	        graph.insertEdge(list.get(6),list.get(4),799);
	        graph.insertEdge(list.get(6),list.get(3),725);
	        graph.insertEdge(list.get(6),list.get(0),1154);
	        graph.insertEdge(list.get(6),list.get(7),746);
	        //Atlanta edges
	        graph.insertEdge(list.get(7),list.get(6),746);
	        graph.insertEdge(list.get(7),list.get(5),2182);
	        graph.insertEdge(list.get(7),list.get(4),707);
	        graph.insertEdge(list.get(7),list.get(3),669);
	        graph.insertEdge(list.get(7),list.get(1),4211);
	        graph.insertEdge(list.get(7),list.get(0),606);
	        graph.insertEdge(list.get(7),list.get(8),7158);
	        graph.insertEdge(list.get(7),list.get(9),7574);
	        //Beijing edges
	        graph.insertEdge(list.get(8),list.get(7),7158);
	        graph.insertEdge(list.get(8),list.get(5),5380);
	        graph.insertEdge(list.get(8),list.get(2),5102);
	        graph.insertEdge(list.get(8),list.get(1),5052);
	        graph.insertEdge(list.get(8),list.get(0),6560);
	        graph.insertEdge(list.get(8),list.get(9),3638);
	        //Dubai edges
	        graph.insertEdge(list.get(9),list.get(8),3638);
	        graph.insertEdge(list.get(9),list.get(7),7574);
	        graph.insertEdge(list.get(9),list.get(2),3259);
	        graph.insertEdge(list.get(9),list.get(1),3420);
	        graph.insertEdge(list.get(9),list.get(0),7227);
	        
	    }
	 /**
	  * returns an Airport object
	  * @param cityOrAirportcode to search for
	  * @return
	  */
	 public Airport getAirport(String cityOrAirportcode) {
		 
		 cityOrAirportcode = cityOrAirportcode.trim().toLowerCase();
		 
		 for (Airport a: list) {
			 if (a.getCity().toLowerCase().equals(cityOrAirportcode)) {
				 return a;
			 }
		 }
		 
		 for (Airport a: list) {
			 if (a.getName().toLowerCase().equals(cityOrAirportcode)) {
				 return a;
			 }
		 }
		 
		// throw new NoSuchElementException("City not found");
		return null; 
	 }
}
