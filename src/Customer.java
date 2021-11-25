import java.util.*;

public class Customer {
    private String Name;
    private String AadhaarNo;
    private int Age;
    private String Gender;
    private FlightFinder ff;
    public static ArrayList<City> Cities = new ArrayList<City>();
    private String Day;
    private int Ticketnos;
    private ArrayList<Passenger> psn = new ArrayList<Passenger>();

    static {
        Cities.add(new City("Mumbai", "Chhatrapati Shivaji Maharaj International Airport", 0));
        Cities.add(new City("Bengaluru", "Kempegowda International Airport", 100));
        Cities.add(new City("Pune", "Pune International Airport", 300));
        Cities.add(new City("Jaipur", "Jaipur International Airport", 500));
        Cities.add(new City("Chandigarh", "Shaheed-e-Azam Bhagat Singh Airport", 700));
        Cities.add(new City("Patna", "Jayprakash Narayan International Airport", 900));
        Cities.add(new City("Lucknow", "Chaudhary Charan Singh International Airport", 1100));
        Cities.add(new City("Nagpur", "Dr.Babasaheb Ambedkar International Airport", 130));
        Cities.add(new City("Amritsar", "Sri Guru Ram Das Ji International Airport", 1500));
        Cities.add(new City("Indore", "Devi Ahilya Bai Holkar Airport", 1000));
        Cities.add(new City("Chennai", "Chennai International Airport", 2000));
    }

    public FlightFinder getFlightFinder() {
        return ff;
    }
    public void setFlightFinder(FlightFinder ff){
        this.ff = ff;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public String getAadhaarNo() {
        return AadhaarNo;
    }
    public void setAadhaarNo(String AadharNo){
        this.AadhaarNo = AadharNo;
    }

    public int getAge() {
        return Age;
    }
    public void setAge(int Age){
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "Passenger name: " + this.Name + "\n" + "Aadhaar No: " + this.AadhaarNo + "\n" + "Age: " + this.Age
                + "\n" + "Gender: " + this.Gender;
    }

    public String getDay() {
        return Day;
    }
    public void setDay(String Day){
        this.Day = Day;
    }

    public int getTicketnos() {
        return Ticketnos;
    }
    public void setTicketnos(int Ticketnos){
        this.Ticketnos = Ticketnos;

    }

    public ArrayList<Passenger> getpsn() {
        return psn;
    }
    public void setpsn(ArrayList<Passenger> psn){
        this.psn = psn;
    }

}