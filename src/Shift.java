//Shift is a fixed time with start and end with a specific payment
public class Shift {
    private int startHour;
    private  int startMinute;
    private int endHour;
    private int endMinute;
    private  int paymentPerHour;

    public Shift( int startH, int startM, int endH, int endM, int paymentPerH){
        startHour = startH;
        startMinute = startM;
        endHour =endH;
        endMinute = endM;
        paymentPerHour =paymentPerH;

    }

    //Check if the start of a WorkPeriod is inside a shift
    public boolean startWPInShift(WorkPeriod wP){
        if( startHour <= wP.getStartHour() && endHour >= wP.getStartHour()){
            return true;
        }
        return false;
    }
    //Check if the end of a WorkPeriod is inside a shift
    public boolean endWPInShift(WorkPeriod wP){
        if( startHour <= wP.getEndHour() && endHour >= wP.getEndHour()){
            return true;
        }
        return false;
    }


    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }
}
