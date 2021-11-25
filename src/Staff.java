import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Staff {
    private BoardingPass boardingPass;
    private String Name;
    private String AadhaarNo;
    private String Gender;
    private int Age;
    //private Customer cust;

    public void setName(String Name){
        this.Name = Name;
    }

    public void setAadhaarNo(String AadhaarNo){
        this.AadhaarNo = AadhaarNo;
    }

    public void setGender(String Gender){
        this.Gender = Gender;
    }

    public void setAge(int Age){
        this.Age = Age;
    }

    public String getName(){
        return Name;
    }

    public String getAadhaarNo(){
        return AadhaarNo;
    }

    public String getGender(){
        return Gender;
    }

    public int getAge(){
        return Age;
    }
    
    public boolean VerifyDetails() {
        Scanner sc = new Scanner(System.in);   
        System.out.println("Enter your name: ");
        this.Name = sc.nextLine();
        System.out.println("Enter your Aadhar number: ");
        this.AadhaarNo = sc.nextLine();
        System.out.println("Enter your age: ");
        this.Age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter your gender: ");
        this.Gender = sc.nextLine();
        for (int g = 0; g < FlightFinder.Customers.size(); g++) {
            if (FlightFinder.Customers.get(g).getName().equals(this.Name)
                    &&  FlightFinder.Customers.get(g).getAadhaarNo().equals(this.AadhaarNo)
                    &&  FlightFinder.Customers.get(g).getGender().equals(this.Gender)) {
               // getCustomer(FlightFinder.Customers.get(g));
               //this.cust = FlightFinder.Customers.get(g);
                return true;
            }
        }
        return false;
    }

    // public Customer getCustomer(){
    //     return cust;
    // }
}
