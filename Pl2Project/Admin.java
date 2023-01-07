package Pl2Project;
import java.util.*;
import java.io.*;

public class Admin extends Parking {
    private String dataFile = "Users.txt";
    FileManger FManger = new FileManger();
    private ArrayList<Person> Persons = new ArrayList<Person>();
    
    public void addSpots(int newSpots) throws FileNotFoundException {
    parkingSize = newSpots + getParkingSize();
    FManger.write(parkingSize+"","ParkingSize.txt",false);
    }
    
    public int getParkingSize() throws FileNotFoundException {
        return parkingSize;
                                } 
    
     private void commitToFile() {
        FManger.write(Persons.get(0).getPersonData(), dataFile, false);
        for (int i = 1; i < Persons.size(); i++) {
            FManger.write(Persons.get(i).getPersonData(), dataFile, true);
        }

    }
    
    private void loadFromFile() {
            Persons = (ArrayList<Person>) (Object) FManger.read(dataFile);
    }
    
    public int getPersonIndex(String n){
        for (int i = 0; i < Persons.size(); i++)
            if(Persons.get(i).name.equals(n))
                return i;
        
        return -1;
    }
    
    public boolean updatePerson(String oldName, Person x){
        loadFromFile();
        int index = getPersonIndex(oldName);
        int check = getPersonIndex(x.name);
          if(check == -1 || oldName.equals(x.name)){
            Persons.set(index, x);
            commitToFile();
            return true;
          }
          else
            return false;           
    } 
    
     public boolean deletePerson(String n){
        loadFromFile();
        int index = getPersonIndex(n);
        if(index == -1)
           return false;
        else{
        Persons.remove(index);
        commitToFile();
        return true;
        }
    } 
     
    public boolean addPerson(String name,String password,String jobTitle){
        loadFromFile();
        if(getPersonIndex(name) == -1){
        Person p=new Person(name,password,jobTitle);
        FManger.write(p.getPersonData(), dataFile, true);
        return true;
        }
        else
            return false;
    } 
    
    public Person returnPersonData(String uname){
    loadFromFile();
    int index = getPersonIndex(uname);
    Person p1 = new Person();
    p1.name = Persons.get(index).name;
    p1.password  = Persons.get(index).password;
    p1.jobTitle = Persons.get(index).jobTitle;
    return p1;
    }
    public boolean personIsExist(String n){
        loadFromFile();
        for (int i = 0; i < Persons.size(); i++)
            if(Persons.get(i).name.equals(n))
                return true;
        
        return false;
    }
    
    public ArrayList<String> printPaymentReport(){
        ArrayList<String> paymentShifts = new ArrayList<String>();
        paymentShifts = (ArrayList<String>) (Object) FManger.read("PaymentShifts.txt");
        return paymentShifts;                                               
    } 
   
    public ArrayList<Customer> printParkedCarsReport(){
      ArrayList<Customer> Customers = new ArrayList<Customer>();
      Customers = (ArrayList<Customer>) (Object)FManger.read("ReservedSpots.txt");
      return Customers;                           
    
    } 
    
    public ArrayList<Person> getPersons(){
        loadFromFile();
        return Persons;
    }
}