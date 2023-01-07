package Pl2Project;
import java.io.*;
import java.util.*;

public class FileManger {

    public boolean write(String Query, String FilePath,boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath),appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    public ArrayList<Object> read(String FilePath) {
       // Scanner input = new Scanner(System.in);
        
        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("Users.txt")) {

            ArrayList<Person> Persons = new ArrayList<Person>();
            Person x;

            while (Reader.hasNext()) {

                x = new Person();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");
                x.name = seprated[0];
                x.password = seprated[1];
                x.jobTitle = seprated[2];
                Persons.add(x);
            }

            return (ArrayList<Object>) (Object) Persons;

        } else if(FilePath.equals("ReservedSpots.txt")){
            ArrayList<Customer> Customers = new ArrayList<Customer>();
            Customer x;

            while (Reader.hasNext()) {

                x = new Customer();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");
                x.id = Integer.parseInt(seprated[0]);
                x.plateNumber = (seprated[1]);
                x.date = (seprated[2]);
                Customers.add(x);
            }

            return (ArrayList<Object>) (Object) Customers;
  
        }else if(FilePath.equals("PaymentShifts.txt")){
             ArrayList<String> paymentShifts = new ArrayList<String>();
            

            while (Reader.hasNext()) {
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");
                paymentShifts.add(seprated[0]);
                paymentShifts.add(seprated[1]);

            }

            return (ArrayList<Object>) (Object) paymentShifts;
  
        }
        else
            return null;

    }



    public int reading(String FilePath) {
       // Scanner input = new Scanner(System.in);
        
        Scanner Reader = null;
        try {

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        if(FilePath.equals("ParkingSize.txt")){
        int size;
            size = Reader.nextInt();
           return size;
       }
        else
            return 0;

    }

}