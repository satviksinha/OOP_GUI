import java.util.*;

public class Passenger  {
    private String Name;
    private String AadhaarNo;
    private int Age;
    private String Gender;

    public Passenger(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.Name = sc.nextLine();
        System.out.println("Enter Aadhar number: ");
        this.AadhaarNo = sc.nextLine();
        System.out.println("Enter age: ");
        this.Age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter gender: ");
        this.Gender = sc.nextLine();
    }

    public String getName() {
        return Name;
    }

    public String getAadhaarNo() {
        return AadhaarNo;
    }

    public int getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String toString(){
        return "Passenger name: " + this.Name + "\n" + "Aadhaar No: " + this.AadhaarNo + "\n" + "Age: " + this.Age + "\n" + "Gender: " + this.Gender;
    }
}
