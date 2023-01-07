package Pl2Project;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

import static java.lang.Integer.*;


public class Operator extends Parking{

    /* in (GUI)
    // // Show free spots.(from Spot class, using getFreeSpots() )
    // // Take the Id from Customer to calculate parking hours and its cost.(by this class)
    // // Free one spot.(from Spot Class, using freeSpotWithId() )*/

    private String plate;
    private int hrs1;
    private int mins1;
    private int secs1;
    private int hrs2;
    private int mins2;
    private int secs2;
    private int day1;
    private int day2;
    private int days;
    private int bookedId;
    private int cost = 0;
    private final int costForHour = 10;
    private long newCost=0;
    private String firstDateAsString;
    private String firstTimeAsString;
    private String lastDateAndTimeAsString;
    private String lastDateAsString;
    private String lastTimeAsString;
    public static String timeOfParking; //must run "getCosOfParking()" before using it.
    private ArrayList<Customer> oper = new ArrayList<Customer>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    Customer customer = new Customer();
    //create object for the data customer file.
    File file = new File("ReservedSpots.txt");
    FileManger FManger = new FileManger();
    
    public Operator(){}
    
    //returns Id if the Id is entered is parking now and returns zero if it's not.(Run before using setParkingHoursWithId(int id) )
    public Boolean checkId(int id) throws IOException{
        oper=(ArrayList<Customer>) (Object)FManger.read("ReservedSpots.txt"); //create object file.

        for (int i = 0; i < oper.size(); i++) {
            if (id ==oper.get(i).id) {
                bookedId=id;
                this.plate = oper.get(i).plateNumber; //his plate number.
                this.firstDateAsString =oper.get(i).date.substring(0, 10); //the date that he entered.
                this.firstTimeAsString =oper.get(i).date.substring(11) ; //the time that he entered.
                return true; 
            }
        }
            return false;
    }
    //Returns cost of the parking,And print message of time he parked using (obj.timeOfParking).(Run after using getTotalParkingHoursWithId(int id) )
    public long getCostOfParking() {
        this.lastDateAndTimeAsString = customer.setDate();
        this.lastDateAsString = lastDateAndTimeAsString.substring(0, 11); //get date he left.
        this.lastTimeAsString = lastDateAndTimeAsString.substring(11, 19); //get time he left.

        //get The time of entry as integer.
        hrs1 = parseInt(firstTimeAsString.substring(0, 2)); //the hours he entered.
        mins1 = parseInt(firstTimeAsString.substring(3, 5)); //the minutes he entered.
        secs1 = parseInt(firstTimeAsString.substring(6, 8)); //the seconds he entered.
        //get The time of exit as integer.
        hrs2 = parseInt(lastTimeAsString.substring(0, 2)); //the minutes that he left.
        mins2 = parseInt(lastTimeAsString.substring(3, 5)); //the minutes that he left.
        secs2 = parseInt(lastTimeAsString.substring(6, 8)); //the seconds that he left.

        //check if the customer parked for more than one day.
        day1 = parseInt(firstDateAsString.substring(8, 10)); //get the day he entered.
        day2 = parseInt(lastDateAsString.substring(8, 10)); //get the day he left.

        this.days = (day2 - day1);
        if (days == 0) {

            //calculate if the customer parked the number of hours and minutes(means another hour).
            if (!(mins1 == 0 && mins2 == 0)) {
                int hrs3;

                if (hrs2-hrs1 == 0) {
                    if ( (mins2-mins1) <= 15) {
                        this.cost = 0;
                        this.timeOfParking = "parked for " + (mins2-mins1) + " minutes."; //to prints to customer the time of parking.
                        return cost;
                    } else {
                        this.cost = costForHour;
                        this.timeOfParking = "parked for " + (mins2-mins1)  + " minutes."; //to prints to customer the time of parking.
                        return cost;
                    }
                } else if (hrs1 == 0) //if customer enterd at 12 AM
                     hrs3 = hrs2 + 1;

                    /*if customer left at 12 AM it means he parked for num of days and it can't happen here, so we skipped this condition*/
                else
                    hrs3 = hrs2 - hrs1;

                this.timeOfParking = "parked for " + hrs3 + " hours."; //to prints to customer the time of parking.
                this.cost = costForHour * hrs3;
                return cost;
            }
            //calculate if the customer only parked a number of hours.
            else {
                int hrs3 = hrs2 - hrs1;

                this.cost = costForHour * hrs3;
                this.timeOfParking = "parked for " + hrs3 + " hours."; //to prints to customer the time of parking.
                return cost;
            }
        } else if ((day2 - day1) == 1) {
            if (!( mins2 == 0)) {
                int hrs3;

                hrs3 = (24-hrs1) + hrs2 + 1;

                this.timeOfParking = "parked for " + hrs3 + " hours."; //to prints to customer the time of parking.
                this.cost = costForHour * hrs3;
                return cost;
            }
            else{
                int hrs3;

                hrs3 = (24-hrs1) + hrs2;

                this.timeOfParking = "parked for " + hrs3 + " hours."; //to prints to customer the time of parking.
                this.cost = costForHour * hrs3;
                return cost;
            }
        } else {//calculate if the customer parked for more than one day.

            //calculate if the customer parked the number of hours in minutes(that means another hour).
            if (!(mins2 == 0)) {
                int hrs3;
                if (hrs1 == 0) //if customer enterd at 12 AM
                    hrs3 = hrs2 + 1;
                else if (hrs2 == 0) //if customer leaves at 12 AM
                    hrs3 = 1;
                else {
                    hrs3 = hrs2 + 1;
                }

                cost = costForHour * (hrs3 + ((day2 - day1) * 24));
                this.timeOfParking = "parked for " + days + " of days, And " + hrs3 + " hours."; //to prints to customer the time of parking.
                return cost;
            }
            //calculate if the customer only parked a number of hours.
            else {
                int hrs3;

                if (hrs1 == 0) //if customer entered at 12 AM
                    hrs3 = hrs2;
                else if (hrs2 == 0) //if customer leaves at 12 AM
                    hrs3 = 0;
                else
                    hrs3 = hrs2;

                cost = costForHour * (hrs3 + ((day2 - day1) * 24));
                this.timeOfParking = "parked for " + days + " of days, And " + hrs3 + " hours."; //to prints to customer the time of parking.

                return cost;
            }
        }
    }

    //put the cost of this payment in the "PaymentShifts".(Run after using getCosOfParking() )
    public void setPaymentReport(long cost) {

        FManger.write(getPaymentReport(cost),"PaymentShifts.txt", true);
//            System.out.println("Successfully wrote to the file.");
    }
    
     public String getPaymentReport(long cost) {
         Customer x = new Customer();
        return  x.setDate() + "@" + cost + " $" ;
    }
     
     public void displayFreeSpots() {
        System.out.println(getFreeSpots());
    }

    public static void main(String[] args) throws IOException {
        Operator o = new Operator();
        o.checkId(13);
        System.out.println(o.getCostOfParking());
        System.out.println(o.timeOfParking);

//        if(hrs1 == 0 ) //if customer enterd at 12 AM
//            hrs3 = hrs2  + 24;
//        else if(hrs2 == 0) //if customer leaves at 12 AM
//            hrs3 = hrs1;
//        else {
//            if (hrs2 > hrs1)
//                hrs3 = (hrs2 - hrs1);
//            else
//                hrs3 = (hrs2 - hrs1) + hrs2;

//
//        if(hrs1 == 0 ) //if customer enterd at 12 AM
//            hrs3 = hrs2+1;
//        else if(hrs2 == 0) //if customer leaves at 12 AM
//            hrs3 = 1;
//        else {
//                hrs3 = hrs2+1;
//        }

        }

    }

