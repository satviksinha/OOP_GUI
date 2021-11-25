import java.util.*;

public class BoardingPass extends Booking {
        private float BaggageCharge;
        private int GateNo;
        private String SeatNo;
        private static ArrayList<ArrayList<String>> Seats = new ArrayList<ArrayList<String>>();
        private int weight;

        static {
                Seats.add(new ArrayList<String>(Arrays.asList("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9",
                                "A10", "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20")));
                Seats.add(new ArrayList<String>(Arrays.asList("B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9",
                                "B10", "B11", "B12", "B13", "B14", "B15", "B16", "B17", "B18", "B19", "B20")));
                Seats.add(new ArrayList<String>(Arrays.asList("C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9",
                                "C10", "C11", "C12", "C13", "C14", "C15", "C16", "C17", "C18", "C19", "C20")));
                Seats.add(new ArrayList<String>(Arrays.asList("D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9",
                                "D10", "D11", "D12","D13", "D14", "D15", "D16", "D17", "D18", "D19", "D20")));
                Seats.add(new ArrayList<String>(Arrays.asList("E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9",
                                "E10", "E11", "E12", "E13", "E14", "E15", "E16", "E17", "E18", "E19", "E20")));
        }

        public BoardingPass(Flight flightDetails,int weight, int GateNo){
                super(flightDetails);
                this.GateNo = GateNo;
                int row = 5*(int)Math.random();
                int col = 20*(int)Math.random();
                this.SeatNo = Seats.get(row).get(col);
                Seats.get(row).remove(col);
        }

        public BoardingPass(Flight flightDetails, int weight) {
                super(flightDetails);
                this.weight = weight;
                this.BaggageCharge = 20*weight;
                this.GateNo = 5 * (int) Math.random() + 1;
                int row = 5*(int)Math.random();
                int col = 20*(int)Math.random();
                this.SeatNo = Seats.get(row).get(col);
                Seats.get(row).remove(col);
        }

        public float getBaggageCharge() {
                return BaggageCharge;
        }

        public int getGateNo() {
                return GateNo;
        }

        public String toString(Customer cust1) {
                this.getFlightDetails(true);
                System.out.println("Day of travel: " + cust1.getDay());
                return "Baggage Charge: " + BaggageCharge + "\n" + "Gate No. : " + GateNo + "\n" + "Seat No. : "
                                + SeatNo;
        }

        public String toString(Passenger psn, Customer cust1){
                System.out.println(psn);
                this.getFlightDetails(true);
                System.out.println("Day of travel: " + cust1.getDay());
                return "Gate No. : " + GateNo + "\n" + "Seat No. : " + SeatNo;
        }
}
