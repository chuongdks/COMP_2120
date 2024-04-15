import java.util.ArrayList;
import java.time.*;
import java.sql.*;

/**
* This is a class that represent a hotal. Users can add owners, rooms, set prices, and make/cancel reservations
*/

public class Hotel extends Building{
    private String name;
    private double rate;
    private ArrayList<Person> owners;
    private ArrayList<Room> rooms;

    public Hotel(){
        super();
    }

    public Hotel(String name, ArrayList<Person> owners, Year yearBuilt, int numFloors, double rate){
        super(yearBuilt, numFloors);
        this.rooms = new ArrayList<Room>();
        this.owners = owners;
        this.rate = rate;
        this.name = name;
    }

    /**
     * @return String
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return ArrayList<Person>
     */
    public ArrayList<Person> getOwners(){
        return this.owners;
    }

    /**
     * @return ArrayList<Room>
     */
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    /**
     * @param int roomNum
     * @return Room
     */
    public Room getRoom(int roomNum){
        for(Room r : this.rooms){
            if(r.getRoomNum() == roomNum) return r;
        }
        return null;
    }

    /**
     * @param Person owner
     * @return void
     */
    public void addOwner(Person owner){
        this.owners.add(owner);
    }

    /**
     * @param Room room
     * @return void
     */
    public void addRoom(Room room){
        this.rooms.add(room);
    }

    /**
     * @param int roomNum
     * @param Date start
     * @param Date end
     * @param Person guest
     * @return int
     */
    public int reserve(int roomNum, Date start, Date end, Person guest){
        for(Room r : rooms){
            if(r.getRoomNum() == roomNum){
                if(r.getVacancyStatus()){
                    return r.reserve(start, end, guest);
                }
                return 0;
            }
        }
        return 0;
    }

    /**
     * @param int resNum
     * @return boolean
     */
    public boolean cancel(int resNum){
        for(Room r : rooms){
            for(Reservation res : r.getReservations()){
                if(res.getResNum() == resNum){
                    r.cancel(resNum);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String owners = "";
        String rooms = "";
        for(Person p : this.owners){
            owners = owners+" "+p.toString();
        }
        for(Room r : this.rooms){
            rooms = rooms+r.toString();
        }
        return this.name+", "+this.rate+" stars.\nHotel Owners: "+owners+"\nRooms:\n"+rooms+"\n";
    }
}
