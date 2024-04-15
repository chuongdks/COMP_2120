import java.util.ArrayList;
import java.sql.*;

public class Room {
    public enum RoomType{SINGLE, DOUBLE, STUDIO, SUITE};

    private RoomType type;
    private double price;
    private double size;
    private int floorNum;
    private int roomNum;
    private String description;
    private boolean vacant;
    private ArrayList<Reservation> reservations;


    public Room(RoomType type, double size, int floorNum, int roomNum, String description, boolean vacant, ArrayList<Reservation> reservations){
        this.type = type;
        this.size = size;
        this.floorNum = floorNum;
        this.roomNum = roomNum;
        this.description = description;
        this.vacant = vacant;
        this.reservations = reservations;
    }

    /**
     * @return booelan
     */
    public boolean getVacancyStatus(){
        return this.vacant;
    }

    /**
     * @return int
     */
    public int getRoomNum(){
        return this.roomNum;
    }

    /**
     * @return double
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * @return ArrayList<Reservation>
     */
    public ArrayList<Reservation> getReservations(){
        return this.reservations;
    }

    /**
     * @param double price
     * @return void
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * @param Date start
     * @param Date end
     * @param Person guest
     * @return int
     */
    public int reserve(Date start, Date end, Person guest){
        Reservation res = new Reservation(start, end, price, guest);
        reservations.add(res);
        return res.getResNum();
    }

    /**
     * @param int resNum
     * @return void
     */
    public void cancel(int resNum){
        for(int i = 0; i < reservations.size(); i++){
            if(reservations.get(i).getResNum() == resNum){
                reservations.remove(i);
                return;
            }
        }
    }

    /**
     * @return void
     */
    public void checkin(){
        this.vacant = false;
    }

    /**
     * @return void
     */
    public void checkout(){
        this.vacant = true;
    }

    /**
     * @return String
     */
    public String status(){
        String str = "";
        for(Reservation r : reservations){
            str = str+r.toString();
        }
        return "Reservation list of room number "+this.roomNum+": "+(this.vacant?"vacant":"not vacant")+".\n"+str;
    }

    @Override
    public String toString(){
        return this.type+", price=$"+this.price+", Size="+this.size+", Number="+this.roomNum+", Floor="+this.floorNum+"\nDescription: "+this.description+"\n";
    }
}
