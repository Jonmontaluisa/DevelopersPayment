import java.util.Calendar;

public class WorkPeriod {
    // a Work period details the time a developer. It has a start working time and end working time and a day
    private String day;
    private int startHour;
    private int endHour;
    private int startMinute;
    private int endMinute;

    public WorkPeriod(String token){
        fillWorkPeriod( token);

    }
    public void fillWorkPeriod(String token){
        day = token.substring(0,2);
        startHour= Integer.parseInt(token.substring(2,4));
        startMinute = Integer.parseInt(token.substring(5,7));
        endHour = Integer.parseInt(token.substring(8,10));
        endMinute = Integer.parseInt(token.substring(11,13));

    }
    public String getDay(){
        return day;
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
}
