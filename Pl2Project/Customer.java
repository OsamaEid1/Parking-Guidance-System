package Pl2Project;

import java.io.IOException;
import java.util.*;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Customer extends Parking{
    public int id;
    public String date;
    public String plateNumber;
    public String totalTime;
    private String dataFile = "ReservedSpots.txt";
    FileManger FManger = new FileManger();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    public ArrayList<Customer> Customers = new ArrayList<Customer>();
    
    public Customer() {
    }
    
    public void printId(String plateNumber) {
        int x = getRandomElement();
        this.id = x;
        this.plateNumber = plateNumber;
        this.date = setDate();
        FManger.write(getCustomerData(), dataFile, true);
        System.out.println("Your id is: " + x + 
                "\nYour plateNumber is: " + plateNumber +
                "\nDate: " + date);   
    }// a function that returns a free random id for the specifc plate

    public String setDate() {
        this.date = dtf.format(now);
        return dtf.format(now);

    }// sets the current date since it's called
    
    public String pay(int id) throws IOException {
        Operator cost = new Operator();
        if(cost.checkId(id)){
          long x = cost.getCostOfParking();
           cost.setPaymentReport(x);
           totalTime = cost.timeOfParking;
//         deleteCustomer(id);
           return "The cost is: "+ x + " $";
        }
        else 
            return "ID Not Found"; 
    }
    
    private void commitToFile() {
        FManger.write(Customers.get(0).getCustomerData(), dataFile, false);
        for (int i = 1; i < Customers.size(); i++) {
            FManger.write(Customers.get(i).getCustomerData(), dataFile, true);
        }

    }
    
    public void loadFromFile() {
            Customers = (ArrayList<Customer>) (Object) FManger.read(dataFile);
    }
    
    private int getCustomerIndex(int id){
        for (int i = 0; i < Customers.size(); i++)
            if(Customers.get(i).id == id)
                return i;
        
        return -1;
    }
    
    public void deleteCustomer(int id){
        loadFromFile();
        int index = getCustomerIndex(id);
        Customers.remove(index);
        commitToFile();
    } 
     
    private String getCustomerData() {
        return this.id + "@" + this.plateNumber + "@" + this.date;
    }

}
