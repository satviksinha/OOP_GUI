public class Booking /*extends Customer*/ {
    private Flight FlightDetails;
    

    public Booking(Flight FlightDetails){
        this.FlightDetails = FlightDetails;
    }

    public void getFlightDetails() {
        System.out.println("Name: " + FlightDetails.getName());
        System.out.println("Destination City: " + FlightDetails.getDestinationCity().getName());
        System.out.println("Source City: " + FlightDetails.getSourceCity().getName());
        System.out.println("Departure Time: " + FlightDetails.getDepartureTime());
        System.out.println("Arrival Time: " + FlightDetails.getArrivalTime());
        FlightDetails.printRunningDays();
        System.out.println("Fare: " + FlightDetails.getFare());
        System.out.println("Capacity: " + FlightDetails.getCapacity());
    }

    public void getFlightDetails(boolean bool) {
        System.out.println("Name: " + FlightDetails.getName());
        System.out.println("Destination City: " + FlightDetails.getDestinationCity().getName());
        System.out.println("Source City: " + FlightDetails.getSourceCity().getName());
        System.out.println("Departure Time: " + FlightDetails.getDepartureTime());
        System.out.println("Arrival Time: " + FlightDetails.getArrivalTime());
    }
}
