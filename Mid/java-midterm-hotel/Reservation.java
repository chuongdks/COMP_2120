import java.sql.*;

public class Reservation {
    private Date start;
    private Date end;
    private double price;
    private Person guest;
    private int resNum;
    private static int lastResNum = 100001;

    public Reservation(Date start, Date end, double price, Person guest){
        this.start = start;
        this.end = end;
        this.price = price;
        this.guest = guest;
        this.resNum = lastResNum;
        lastResNum++;
    }

    /**
     * @return Date
     */
    public Date getStart(){
        return this.start;
    }

    /**
     * @param Date start
     * @return void
     */
    public void setStart(Date start){
        this.start = start;
    }

    /**
     * @return Date
     */
    public Date getEnd(){
        return this.end;
    }

    /**
     * @param Date end
     * @return void
     */
    public void setEnd(Date end){
        this.end = end;
    }

    /**
     * @return int
     */
    public int getResNum(){
        return this.resNum;
    }

    /**
     * @param int resNum
     * @return void
     */
    public void setResNum(int resNum){
        this.resNum = resNum;
    }

    /**
     * @param Date start
     * @param Date end
     * @return booelan
     */
    public boolean isAvailable(Date start, Date end){
        if(start.before(this.start)){
            if(end.before(this.start)){
                return true;
            }
        }
        else if(start.after(this.end)){
            return true;
        }
        System.out.println("Booked");
        return false;
    }

    @Override
    public String toString(){

        return "Reservation Number: "+this.resNum+"\nFrom: "+this.start.toString()+" To: "+this.end.toString()+"\nGuest: "+this.guest+"\n$"+this.price+" per night\n";
    }
}
