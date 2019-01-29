
public class ShiftManager {



    private Shift firstShiftWeekday= new Shift(0,1,9,0,25);
    private Shift secondShiftWeekday = new Shift(9,1,18,0,15);
    private Shift thirdShiftWeekday = new Shift(18,0,24,0,20);
    private Shift firstShiftWeekend= new Shift(0,1,9,0,30);
    private Shift secondShiftWeekend= new Shift(9,1,18,0,20);
    private Shift thirdShiftWeekend = new Shift(18,0,24,0,25);
    public ShiftManager(){


    }
    public Shift getFirstShiftWeekday() {
        return firstShiftWeekday;
    }

    public Shift getSecondShiftWeekday() {
        return secondShiftWeekday;
    }

    public Shift getThirdShiftWeekday() {
        return thirdShiftWeekday;
    }

    public Shift getFirstShiftWeekend() {
        return firstShiftWeekend;
    }

    public Shift getSecondShiftWeekend() {
        return secondShiftWeekend;
    }

    public Shift getThirdShiftWeekend() {
        return thirdShiftWeekend;
    }


}


