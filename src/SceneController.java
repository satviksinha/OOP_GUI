import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static Customer customer;
    private static Staff staff;

    @FXML
    private TextField tField1;
    @FXML
    private TextField tField2;
    @FXML
    private TextField tField3;
    @FXML
    private TextField tField4;
    @FXML
    private TextField tField5;
    @FXML
    private TextField tField6;
    @FXML
    private TextField tField8;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button submitButton;

    @FXML
    private TextField textfield1;
    @FXML
    private TextField textfield2;
    @FXML
    private TextField textfield3;
    @FXML
    private TextField textfield4;
    @FXML 
    private Button loginButton;


    public void switchToBookTicket(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Customer cust1 = new Customer();
        customer = cust1;
    }

    public void submitDetails(ActionEvent event) throws IOException {
        customer.setName(tField1.getText()); 
        customer.setAadhaarNo(tField2.getText());
        customer.setGender(tField3.getText());
        customer.setAge(Integer.parseInt(tField4.getText()));
        String sourceCity = tField5.getText();
        String desCity = tField6.getText();
        LocalDate myDate = datePicker.getValue();
        String date = myDate.toString();
        String arr[] = date.split("-");
        customer.setTicketnos(Integer.parseInt(tField8.getText()));
        City scy = null, dcy = null;
        for (int i = 0; i < Customer.Cities.size(); i++) {
            if (sourceCity.equals(Customer.Cities.get(i).getName()))
                scy = Customer.Cities.get(i);
        }
        for (int i = 0; i < Customer.Cities.size(); i++) {
            if (desCity.equals(Customer.Cities.get(i).getName()))
                dcy = Customer.Cities.get(i);
        }
        customer.setFlightFinder(new FlightFinder());
        java.time.DayOfWeek dayOfWeek = myDate.getDayOfWeek();
        int day_no = dayOfWeek.getValue();
        customer.setDay(dayOfWeek.toString());
        try {
            customer.getFlightFinder().findFlights(dcy, scy, day_no,customer.getTicketnos());
        } catch (CityNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("Name: " + customer.getName() + "AadharNo: " + customer.getAadhaarNo() + "Gender: " + customer.getGender() + "Age: " +customer.getAge() + "Date: "
                + arr[0] + " " + arr[1] + " " + arr[2]);
        root = FXMLLoader.load(getClass().getResource("FlightDetails.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLogin(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Staff staff1 = new Staff();
        staff = staff1;
    }

    public void submit(ActionEvent event){
        try{
        staff.setName(textfield1.getText());
        staff.setAadhaarNo(textfield2.getText());
        staff.setGender(textfield3.getText()) ;
        staff.setAge(Integer.parseInt(textfield4.getText()));
        System.out.println("Name:" + staff.getName() + "Aadhar No:" + staff.getAadhaarNo() + "Gender:" + staff.getGender() + "Age:" + staff.getAge());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
