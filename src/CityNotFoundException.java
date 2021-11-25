public class CityNotFoundException extends Exception {

    @Override
    public String toString() {
        return "City not found! Please enter a valid city.";
    }
}