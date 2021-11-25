public class Airline {
    private String Name;
    private Flight[] ListOfFlights;

    public Airline(String Name, Flight[] ListOfFlights) {
        this.Name = Name;
        this.ListOfFlights = ListOfFlights;
    }

    public String getName() {
        return Name;
    }

    public Flight[] getListOfFlights() {
        return ListOfFlights;
    }
}