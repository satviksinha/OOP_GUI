import java.util.*;
import java.io.*;
import java.net.URL;
import javafx.application.Application;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FlightFinder extends Application implements Initializable {
        public static ArrayList<Customer> Customers = new ArrayList<Customer>();
        private ArrayList<Airline> ListOfAirlines = new ArrayList<Airline>();
        private Booking BookingRecord;
        private ArrayList<Flight> flightsDisplayed = new ArrayList<Flight>();
        private ArrayList<Flight> displayedFlights = new ArrayList<Flight>();
        private int counter = 0;
        private int num_of_tickets;

        @FXML
        private TableView<Flight> myTable;
        @FXML
        private TableColumn<Flight, String> firstColumn;
        @FXML
        private TableColumn<Flight, String> secondColumn;
        @FXML
        private TableColumn<Flight, String> thirdColumn;
        @FXML
        private TableColumn<Flight, String> fourthColumn;
        @FXML
        private TableColumn<Flight, String> fifthColumn;
        @FXML
        private TableColumn<Flight, String> sixthColumn;
        @FXML
        private TableColumn<Flight, String> seventhColumn;

        public FlightFinder() {
                Flight[] flights1 = new Flight[] {
                                new Flight("SG 101", Customer.Cities.get(0), Customer.Cities.get(1), "8:00", "10:00",
                                                new int[] { 1, 2, 3, 4, 6, 7 }),
                                new Flight("SG 701", Customer.Cities.get(0), Customer.Cities.get(4), "10:00", "12:30",
                                                new int[] { 1, 3, 4, 5, 7 }),
                                new Flight("SG 500", Customer.Cities.get(8), Customer.Cities.get(6), "12:40", "15:00",
                                                new int[] { 1, 2, 3, 5, 6, 7 }),
                                new Flight("SG 2001", Customer.Cities.get(0), Customer.Cities.get(10), "10:00", "12:00",
                                                new int[] { 1, 2, 5, 6, 7 }),
                                new Flight("SG 131", Customer.Cities.get(0), Customer.Cities.get(7), "12:05", "14:10",
                                                new int[] { 4, 5, 6, 7 }),
                                new Flight("SG 401", Customer.Cities.get(6), Customer.Cities.get(8), "15:00", "18:30",
                                                new int[] { 2, 3, 5, 6, 7 }),
                                new Flight("SG 571", Customer.Cities.get(7), Customer.Cities.get(4), "6:00", "12:00",
                                                new int[] { 4, 5, 6, 7 }),
                                new Flight("SG 100", Customer.Cities.get(1), Customer.Cities.get(0), "17:00", "19:00",
                                                new int[] { 1, 2, 3, 4, 5 }),
                                new Flight("SG 130", Customer.Cities.get(0), Customer.Cities.get(7), "5:45", "7:50",
                                                new int[] { 1, 2, 5 }),
                                new Flight("SG 400", Customer.Cities.get(5), Customer.Cities.get(3), "8:00", "12:30",
                                                new int[] { 1, 2, 3, 6, 7 }),
                                new Flight("SG 300", Customer.Cities.get(9), Customer.Cities.get(4), "20:30", "00:00",
                                                new int[] { 1, 3, 5, 7 }) };
                Flight[] flights2 = new Flight[] {
                                new Flight("6E 100", Customer.Cities.get(1), Customer.Cities.get(0), "18:00", "20:00",
                                                new int[] { 1, 3, 5, 6, 7 }),
                                new Flight("6E 400", Customer.Cities.get(5), Customer.Cities.get(3), "20:00", "00:30",
                                                new int[] { 1, 2, 3, 4, 5 }),
                                new Flight("6E 401", Customer.Cities.get(3), Customer.Cities.get(5), "10:30", "15:00",
                                                new int[] { 1, 2, 4, 5, 6 }),
                                new Flight("6E 301", Customer.Cities.get(0), Customer.Cities.get(2), "17:10", "17:55",
                                                new int[] { 3, 4, 5, 7 }),
                                new Flight("6E 2000", Customer.Cities.get(9), Customer.Cities.get(0), "14:00", "00:00",
                                                new int[] { 4, 5, 6, 7 }),
                                new Flight("6E 300", Customer.Cities.get(2), Customer.Cities.get(0), "7:40", "8:25",
                                                new int[] { 1, 3, 4, 6, 7 }),
                                new Flight("6E 101", Customer.Cities.get(0), Customer.Cities.get(1), "6:00", "8:00",
                                                new int[] { 1, 2, 3, 4, 5 }),
                                new Flight("6E 701", Customer.Cities.get(0), Customer.Cities.get(4), "16:00", "18:30",
                                                new int[] { 2, 3, 4, 5, 6 }),
                                new Flight("6E 570", Customer.Cities.get(7), Customer.Cities.get(4), "14:00", "19:50",
                                                new int[] { 2, 3, 4, 5, 6 }) };
                Flight[] flights3 = new Flight[] {
                                new Flight("KF 130", Customer.Cities.get(0), Customer.Cities.get(7), "7:45", "9:50",
                                                new int[] { 3, 4, 6, 7 }),
                                new Flight("KF 400", Customer.Cities.get(5), Customer.Cities.get(3), "12:30", "17:00",
                                                new int[] { 2, 3, 4, 6, 7 }),
                                new Flight("KF 300", Customer.Cities.get(9), Customer.Cities.get(4), "20:40", "00:10",
                                                new int[] { 1, 2, 6, 7 }),
                                new Flight("KF 570", Customer.Cities.get(7), Customer.Cities.get(4), "17:00", "22:50",
                                                new int[] { 1, 3, 4, 6, 7 }),
                                new Flight("KF 401", Customer.Cities.get(3), Customer.Cities.get(5), "7:00", "11:30",
                                                new int[] { 1, 2, 4, 5, 6 }),
                                new Flight("KF 301", Customer.Cities.get(4), Customer.Cities.get(9), "15:40", "19:10",
                                                new int[] { 4, 6, 7 }),
                                new Flight("KF 500", Customer.Cities.get(8), Customer.Cities.get(6), "12:40", "15:00",
                                                new int[] { 1, 2, 4 }),
                                new Flight("KF 2001", Customer.Cities.get(0), Customer.Cities.get(10), "7:00", "9:00",
                                                new int[] { 1, 2, 3, 4, 7 }) };
                Flight[] flights4 = new Flight[] {
                                new Flight("UK 100", Customer.Cities.get(1), Customer.Cities.get(0), "10:00", "12:00",
                                                new int[] { 2, 4, 5 }),
                                new Flight("UK 130", Customer.Cities.get(0), Customer.Cities.get(7), "7:25", "9:30",
                                                new int[] { 1, 2, 3, 5, 6 }),
                                new Flight("UK 300", Customer.Cities.get(2), Customer.Cities.get(0), "8:40", "9:25",
                                                new int[] { 1, 2, 4, 5, 7 }),
                                new Flight("UK 2001", Customer.Cities.get(0), Customer.Cities.get(10), "7:00", "9:00",
                                                new int[] { 1, 2, 3, 5, 6 }),
                                new Flight("UK 571", Customer.Cities.get(7), Customer.Cities.get(4), "6:00", "12:00",
                                                new int[] { 4, 5, 6, 7 }),
                                new Flight("UK 131", Customer.Cities.get(0), Customer.Cities.get(7), "17:05", "19:10",
                                                new int[] { 1, 2, 3 }),
                                new Flight("UK 301", Customer.Cities.get(0), Customer.Cities.get(2), "17:10", "17:55",
                                                new int[] { 1, 2, 6 }),
                                new Flight("UK 700", Customer.Cities.get(0), Customer.Cities.get(4), "5:00", "7:30",
                                                new int[] { 1, 2, 3, 4 }),
                                new Flight("UK 401", Customer.Cities.get(6), Customer.Cities.get(8), "15:00", "18:30",
                                                new int[] { 1, 4, 7 }) };
                Flight[] flights5 = new Flight[] {
                                new Flight("AI 300", Customer.Cities.get(9), Customer.Cities.get(4), "8:30", "12:00",
                                                new int[] { 1, 2, 4, 5, 6 }),
                                new Flight("AI 701", Customer.Cities.get(0), Customer.Cities.get(4), "16:00", "18:30",
                                                new int[] { 1, 3, 4, 5, 6, 7 }),
                                new Flight("AI 570", Customer.Cities.get(7), Customer.Cities.get(4), "10:00", "15:50",
                                                new int[] { 2, 3, 5, 6, 7 }),
                                new Flight("AI 401", Customer.Cities.get(3), Customer.Cities.get(5), "9:00", "13:30",
                                                new int[] { 1, 2, 3, 5, 7 }),
                                new Flight("AI 301", Customer.Cities.get(4), Customer.Cities.get(9), "15:40", "19:10",
                                                new int[] { 1, 2, 3, 5 }),
                                new Flight("AI 700", Customer.Cities.get(0), Customer.Cities.get(4), "8:00", "10:30",
                                                new int[] { 4, 5, 6, 7 }),
                                new Flight("AI 200", Customer.Cities.get(2), Customer.Cities.get(1), "7:00", "8:30",
                                                new int[] { 1, 2, 3, 5, 7 }),
                                new Flight("AI 201", Customer.Cities.get(1), Customer.Cities.get(2), "19:00", "20:30",
                                                new int[] { 3, 4, 5, 6 }),
                                new Flight("AI 571", Customer.Cities.get(7), Customer.Cities.get(4), "6:00", "12:00",
                                                new int[] { 1, 2, 3, 7 }),
                                new Flight("AI 2000", Customer.Cities.get(9), Customer.Cities.get(0), "14:00", "00:00",
                                                new int[] { 1, 2, 3, 4, 5 }) };

                ListOfAirlines.add(new Airline("SpiceJet", flights1));
                ListOfAirlines.add(new Airline("Indigo", flights2));
                ListOfAirlines.add(new Airline("Kingfisher", flights3));
                ListOfAirlines.add(new Airline("AirIndia", flights4));
                ListOfAirlines.add(new Airline("Vistara", flights5));
        }

        public ArrayList<Airline> getListOfAirLines() {
                return ListOfAirlines;
        }

        public Booking getBookingRecord() {
                return BookingRecord;
        }

        public ArrayList<Flight> getflightsDisplayed() {
                return flightsDisplayed;
        }

        public void findFlights(City DestinationCity, City SourceCity, int Day, int Ticketnos)
                        throws CityNotFoundException {

                this.num_of_tickets = Ticketnos;
                if (DestinationCity == null || SourceCity == null) {
                        throw new CityNotFoundException();
                }
                for (int i = 0; i < ListOfAirlines.size(); i++) {
                        Flight[] tempFlight = ListOfAirlines.get(i).getListOfFlights();
                        for (int j = 0; j < tempFlight.length; j++) {
                                if (tempFlight[j].getDestinationCity() == DestinationCity
                                                && tempFlight[j].getSourceCity() == SourceCity) {
                                        for (int k = 0; k < tempFlight[j].getRunningDays().length; k++) {
                                                if (tempFlight[j].getRunningDays()[k] == Day) {
                                                        if (tempFlight[j].checkCapacity(Ticketnos)) {
                                                                 this.flightsDisplayed.add(tempFlight[j]);

                                                                displayFlights(tempFlight[j]);
                                                        }

                                                }
                                        }
                                }
                        }
                }
                if (flightsDisplayed.size() == 0) {
                        System.out.println("No flights available");
                }
        }

        public void displayFlights(Flight flight) {
                counter++;
                System.out.println(counter);
                System.out.println(flight);
        }

        public void initialize(URL url, ResourceBundle rb) {
                firstColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("name"));
                secondColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("sourceCity"));
                thirdColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
                fourthColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureTime"));
                fifthColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalTime"));
                sixthColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("fare"));
                seventhColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("runningDays"));

                myTable.setItems(getFlights());
        }

        public ObservableList<Flight> getFlights() {
                ObservableList<Flight> flightList = FXCollections.observableArrayList();
                // flightList.add(new Flight("fdf", new City("Mumbai", "mk", 0), new
                // City("Pune", "pk", 100), "100", "200",
                // new int[] { 0, 1, 2 }));
                for (int i = 0; i < 5; i++) {
                         //flightList.add(new
                        // Flight(this.flightsDisplayed.get(i).getName(),this.flightsDisplayed.get(i).getDestinationCity(),this.flightsDisplayed.get(i).getSourceCity(),this.flightsDisplayed.get(i).getDepartureTime(),this.flightsDisplayed.get(i).getArrivalTime(),this.flightsDisplayed.get(i).getRunningDays()));
                        flightList.add(new Flight("6E 100", new City("Mumbai", "mk", 0), new City("Pune", "pk", 100),
                                        "100", "200", new int[] { 0, 1, 2 }));
                }

                return flightList;
        }

        public void start(Stage primaryStage) {
                try {
                        Parent root = FXMLLoader.load(getClass().getResource("Lp.fxml"));
                        Scene scene = new Scene(root, 1300, 800);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public static void main(String[] args) {
                launch(args);
                // Scanner sc = new Scanner(System.in);
                // FlightFinder.Customers.add(cust1);
                // // System.out.println(FlightFinder.Customers);
                // ArrayList<Flight> flights_displayed =
                // cust1.getFlightFinder().flightsDisplayed;
                // if(flights_displayed.size()!=0){
                // System.out.println("Select a flight for booking by entering the respective
                // number: ");
                // int opn_select = sc.nextInt();
                // sc.nextLine();
                // System.out.println(this.flights_displayed);
                // // System.out.println(FlightFinder.Customers.size());

                // Booking book = new Booking(flights_displayed.get(opn_select - 1));
                // flights_displayed.get(opn_select-1).decreaseCapacity(cust1.getFlightFinder().num_of_tickets);
                // int tickets = cust1.getTicketnos();
                // for(int i = 0; i < tickets-1;i++){
                // System.out.println("Enter fellow passenger " + (int)(i+1) + "'s details:");
                // cust1.getpsn().add(new Passenger());
                // }

                // cust1.getFlightFinder().BookingRecord = book;
                // System.out.println("Do you want to login ? 'y' or 'n'");
                // String login = sc.nextLine();
                // if (login.equals("y")) {
                // Staff staff = new Staff();
                // boolean valid = staff.VerifyDetails();
                // if (valid) {
                // System.out.println("Enter your luggage weight(kg): ");
                // int weight = sc.nextInt();
                // if (weight /cust1/*staff.getCustomer()*/.getFlightFinder().num_of_tickets <=
                // 7) {
                // BoardingPass bp = new BoardingPass(flights_displayed.get(opn_select - 1),
                // weight);
                // System.out.println(cust1);
                // System.out.println(bp.toString(cust1));
                // for(int i=0;i<tickets-1;i++){
                // BoardingPass bp1 = new BoardingPass(flights_displayed.get(opn_select -
                // 1),weight,bp.getGateNo());
                // System.out.println(bp1.toString(cust1.getpsn().get(i),cust1));
                // }

                // } else {
                // System.out.println("Your luggage is too heavy!");
                // }
                // } else {
                // System.out.println("No booking found as per the records.");
                // }
                // }
                // }
        }
}
