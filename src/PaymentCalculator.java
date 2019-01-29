import java.util.ArrayList;
import java.util.List;

public class PaymentCalculator {

    public static List<String> weekdays = new ArrayList<>();
    public static List<String> weekend = new ArrayList<>();
    public static ShiftManager  sM = new ShiftManager();


    public PaymentCalculator(){
        addDays();
    }
    public void addDays(){
        weekdays.add("MO");
        weekdays.add("TU");
        weekdays.add("WE");
        weekdays.add("TH");
        weekdays.add("FR");
        weekend.add("SA");
        weekend.add("SU");
    }
    // iterate through the WorkPeriods of a developer and add up the corresponding payment per WorkPeriod
    public static int calculatePayment(Developer dev){
        int total=0;
        for (WorkPeriod wP : dev.getWorkPeriods()){
            total += calculatePaymentForWP(wP);

        }
        return total;
    }

    public static int calculatePaymentForWP( WorkPeriod wP){
        int total=0;
        if(weekdays.contains(wP.getDay())){
            total=calculateWeekdaysPayment(wP);
        }else {
            total=calculateWeekendPayment(wP);
        }
        return total;
    }

    // get the payment for an individual WorKPeriod during weekdays
    public static int calculateWeekdaysPayment(WorkPeriod wP){


        int workedHours;
        int workedHoursPayment;
        int workedHoursFS;
        int workedHoursSS;
        int workedHoursTS;
        int workedHoursFSPayment;
        int workedHoursSSPayment;
        int workedHoursTSPayment;

        if(sM.getFirstShiftWeekday().startWPInShift(wP)){
            if(sM.getFirstShiftWeekday().endWPInShift(wP)){
                workedHours=wP.getEndHour()-wP.getStartHour();
                workedHoursPayment= sM.getFirstShiftWeekday().getPaymentPerHour()*(workedHours);
            }else if (sM.getSecondShiftWeekday().endWPInShift(wP)) {
                workedHoursFS= sM.getFirstShiftWeekday().getEndHour()-wP.getStartHour();
                workedHoursSS = wP.getEndHour()- sM.getSecondShiftWeekday().getStartHour();
                workedHoursFSPayment = workedHoursFS * sM.getFirstShiftWeekday().getPaymentPerHour();
                workedHoursSSPayment = workedHoursSS * sM.getSecondShiftWeekday().getPaymentPerHour();
                workedHoursPayment = workedHoursFSPayment + workedHoursSSPayment;
            }else{
                workedHoursFS= sM.getFirstShiftWeekday().getEndHour()-wP.getStartHour();
                workedHoursSS = sM.getSecondShiftWeekday().getEndHour()- sM.getSecondShiftWeekday().getStartHour();
                workedHoursTS = wP.getEndHour()-sM.getThirdShiftWeekday().getStartHour();
                workedHoursFSPayment = workedHoursFS * sM.getFirstShiftWeekday().getPaymentPerHour();
                workedHoursSSPayment = workedHoursSS * sM.getSecondShiftWeekday().getPaymentPerHour();
                workedHoursTSPayment = workedHoursTS * sM.getThirdShiftWeekday().getPaymentPerHour();
                workedHoursPayment = workedHoursFSPayment + workedHoursSSPayment + workedHoursTSPayment;

            }

        }else if (sM.getSecondShiftWeekday().startWPInShift(wP)){
            if(sM.getSecondShiftWeekday().endWPInShift(wP)) {
                workedHours = wP.getEndHour() - wP.getStartHour();
                workedHoursPayment = sM.getSecondShiftWeekday().getPaymentPerHour() * (workedHours);

            }else{
                workedHoursSS = sM.getSecondShiftWeekday().getEndHour()-wP.getStartHour();
                workedHoursTS = wP.getEndHour() - sM.getSecondShiftWeekday().getStartHour();
                workedHoursSSPayment = workedHoursSS * sM.getSecondShiftWeekday().getPaymentPerHour();
                workedHoursTSPayment = workedHoursTS * sM.getThirdShiftWeekday().getPaymentPerHour();
                workedHoursPayment = workedHoursSSPayment + workedHoursTSPayment;
            }
        } else {
            workedHours=wP.getEndHour()-wP.getStartHour();
            workedHoursPayment= sM.getThirdShiftWeekday().getPaymentPerHour()*(workedHours);
        }
        return workedHoursPayment;
    }


    // get the payment for an individual WorKPeriod during weekend
    public static int calculateWeekendPayment(WorkPeriod wP){
        int workedHours;
        int workedHoursPayment;
        int workedHoursFS;
        int workedHoursSS;
        int workedHoursTS;
        int workedHoursFSPayment;
        int workedHoursSSPayment;
        int workedHoursTSPayment;

        if(sM.getFirstShiftWeekend().startWPInShift(wP)){
            if(sM.getFirstShiftWeekend().endWPInShift(wP)){
                workedHours=wP.getEndHour()-wP.getStartHour();
                workedHoursPayment= sM.getFirstShiftWeekend().getPaymentPerHour()*(workedHours);
            }else if (sM.getSecondShiftWeekend().endWPInShift(wP)) {
                workedHoursFS= sM.getFirstShiftWeekend().getEndHour()-wP.getStartHour();
                workedHoursSS = wP.getEndHour()- sM.getSecondShiftWeekend().getStartHour();
                workedHoursFSPayment = workedHoursFS * sM.getFirstShiftWeekend().getPaymentPerHour();
                workedHoursSSPayment = workedHoursSS * sM.getSecondShiftWeekend().getPaymentPerHour();
                workedHoursPayment = workedHoursFSPayment + workedHoursSSPayment;
            }else{
                workedHoursFS= sM.getFirstShiftWeekend().getEndHour()-wP.getStartHour();
                workedHoursSS = sM.getSecondShiftWeekend().getEndHour()- sM.getSecondShiftWeekend().getStartHour();
                workedHoursTS = wP.getEndHour()-sM.getThirdShiftWeekend().getStartHour();
                workedHoursFSPayment = workedHoursFS * sM.getFirstShiftWeekend().getPaymentPerHour();
                workedHoursSSPayment = workedHoursSS * sM.getSecondShiftWeekend().getPaymentPerHour();
                workedHoursTSPayment = workedHoursTS * sM.getThirdShiftWeekend().getPaymentPerHour();
                workedHoursPayment = workedHoursFSPayment + workedHoursSSPayment + workedHoursTSPayment;

            }

        }else if (sM.getSecondShiftWeekend().startWPInShift(wP)){
            if(sM.getSecondShiftWeekend().endWPInShift(wP)){
                workedHours = wP.getEndHour() - wP.getStartHour();
                workedHoursPayment = sM.getSecondShiftWeekend().getPaymentPerHour() * (workedHours);
            }else{
                workedHoursSS = sM.getSecondShiftWeekend().getEndHour()-wP.getStartHour();
                workedHoursTS = wP.getEndHour() - sM.getSecondShiftWeekend().getStartHour();
                workedHoursSSPayment = workedHoursSS * sM.getSecondShiftWeekend().getPaymentPerHour();
                workedHoursTSPayment = workedHoursTS * sM.getThirdShiftWeekend().getPaymentPerHour();
                workedHoursPayment = workedHoursSSPayment + workedHoursTSPayment;
            }
        } else {
            workedHours=wP.getEndHour()-wP.getStartHour();
            workedHoursPayment= sM.getThirdShiftWeekend().getPaymentPerHour()*(workedHours);
        }
        return workedHoursPayment;
    }
}
