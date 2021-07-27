run: compile
        java AirportDriver
compile: AirportDriver.class
GraphADT.class:
        javac GraphADT.java
CS400Graph.class: GraphADT.class
        javac CS400Graph.java
Airport.class:
        javac Airport.java
AirportMap.class: Airport.class airports.txt
        javac AirportMap.java
BackEndAirport.class: AirportMap.class
        javac BackEndAirport.java
AirportDriver.class: airports.txt BackEndAirport.java
        javac AirportDriver.java
test1:  BackEndAirport.class AirportMap.class airports.txt
          javac -cp .:junit5.jar FlightInterfaceTest.java
          java -jar junit5.jar -cp . --scan-classpath -n FlightInterfaceTest
test2: BackEndAirport.class AirportMap.class airports.txt
        javac -cp .:junit5.jar ProjectTest.java
        java -jar junit5.jar -cp . --scan-classpath -n ProjectTest
clean:
        $(RM) *.class