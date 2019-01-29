import java.util.List;
import java.util.ArrayList;

public class Developer {
    List <WorkPeriod> workPeriods = new ArrayList<WorkPeriod>();
    private String developerName;
    public Developer(String devInfo){

        fillDevInfo(devInfo);
        List <WorkPeriod> wPeriod = new ArrayList<WorkPeriod>();

    }
    public void fillDevInfo(String devInfo){
        String[] tokens = devInfo.split("[=,]");
        fillNameDev(tokens[0]);
        fillWorkedSchedule(devInfo);
    }
    public void fillNameDev(String devName){
        developerName = devName;
    }
    private void fillWorkedSchedule(String devInfo){
        String[] tokens = devInfo.split("[=,]");
        for ( int i=1; i < (tokens.length) ; i++){
            WorkPeriod wp = new WorkPeriod(tokens[i]);
            workPeriods.add(wp);
        }
    }
    public List<WorkPeriod> getWorkPeriods(){
        return workPeriods;
    }
    public String getDeveloperName(){
        return developerName;
    }
}
