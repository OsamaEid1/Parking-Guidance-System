package Pl2Project;
import java.util.*;

@SuppressWarnings("unchecked")
public class Parking {    
protected int parkingSize;
FileManger FManger = new FileManger();

public Parking() {
    this.parkingSize = FManger.reading("ParkingSize.txt");
            }

public  ArrayList<Integer> getFreeSpots() {
 ArrayList<Integer> freeSpots = new ArrayList<Integer>();
 ArrayList<Integer> id = new ArrayList<Integer>();
 ArrayList<Customer> reservedSpots = new ArrayList<Customer>();
 reservedSpots = (ArrayList<Customer>) (Object) FManger.read("ReservedSpots.txt");
  for (int i = 0; i < reservedSpots.size(); i++) {
      id.add(reservedSpots.get(i).id);
    } 
 
 for (int i = 0; i < parkingSize; i++) {
      
      if(!id.contains(i))
           freeSpots.add(i);
    } 
 return freeSpots;
}

public int getRandomElement() {
    ArrayList<Integer> randomSpots = new ArrayList<Integer>();
    randomSpots = getFreeSpots();
    int rand = (int) (Math.random() * randomSpots.size());
        return randomSpots.get(rand);
    }
 }//parking