public class City {

    private String Name;
    private String Airport;
    private int Position;

    City(String Name, String Airport, int Position) {
        this.Name = Name;
        this.Airport = Airport;
        this.Position = Position;
    }

    public String getName() {
        return Name;
    }

    public String getAirport() {
        return Airport;
    }

    public int getPosition() {
        return Position;
    }
}
