import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentCalculatorTest {

    Developer dev1 = new Developer("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
    Developer dev2 = new Developer("ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
    Developer dev3 = new Developer("SHELDON=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
    Developer dev4 = new Developer("PLANKTON=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00");
    Developer dev5 = new Developer("FELIX=MO08:00-19:00");
    Developer dev6 = new Developer("ANA=SU08:00-19:00");
    PaymentCalculator pC = new PaymentCalculator();
    @Test
    public void calculatePaymentTest() {
        assertEquals(215,pC.calculatePayment(dev1)) ;
        assertEquals(85,pC.calculatePayment(dev2)) ;
        assertEquals(215,pC.calculatePayment(dev3)) ;
        assertEquals(85,pC.calculatePayment(dev4)) ;
        assertEquals(180,pC.calculatePayment(dev5)) ;
        assertEquals(235,pC.calculatePayment(dev6)) ;


    }



    @Test
    public void calculateWeekdaysPaymentTest() {
        WorkPeriod wP1 = new WorkPeriod("MO10:00-12:00");
        WorkPeriod wP2 = new WorkPeriod("TU10:00-12:00");
        WorkPeriod wP3 = new WorkPeriod("TH14:00-18:00");
        WorkPeriod wP4 = new WorkPeriod("TH12:00-14:00");
        WorkPeriod wP5 = new WorkPeriod("WE20:00-21:00");
        WorkPeriod wP6 = new WorkPeriod("MO01:00-03:00");
        WorkPeriod wP7 = new WorkPeriod("TU00:00-06:00");
        WorkPeriod wP8 = new WorkPeriod("WE10:00-12:00");
        WorkPeriod wP9 = new WorkPeriod("FR07:00-12:00");
        WorkPeriod wP10 = new WorkPeriod("FR06:00-09:00");

        assertEquals(30,pC.calculateWeekdaysPayment(wP1));
        assertEquals(30,pC.calculateWeekdaysPayment(wP2));
        assertEquals(60,pC.calculateWeekdaysPayment(wP3));
        assertEquals(30,pC.calculateWeekdaysPayment(wP4));
        assertEquals(20,pC.calculateWeekdaysPayment(wP5));
        assertEquals(50,pC.calculateWeekdaysPayment(wP6));
        assertEquals(150,pC.calculateWeekdaysPayment(wP7));
        assertEquals(30,pC.calculateWeekdaysPayment(wP8));
        assertEquals(95,pC.calculateWeekdaysPayment(wP9));
        assertEquals(75,pC.calculateWeekdaysPayment(wP10));


    }

    @Test
    public void calculateWeekendPaymentTest() {
        WorkPeriod wP1 = new WorkPeriod("SA01:00-03:00");
        WorkPeriod wP2 = new WorkPeriod("SA00:00-03:00");
        WorkPeriod wP3 = new WorkPeriod("SA16:00-18:00");
        WorkPeriod wP4 = new WorkPeriod("SU16:00-18:00");
        WorkPeriod wP5 = new WorkPeriod("SU05:00-09:00");
        WorkPeriod wP6 = new WorkPeriod("SU23:00-24:00");

        assertEquals(60,pC.calculateWeekendPayment(wP1));
        assertEquals(90,pC.calculateWeekendPayment(wP2));
        assertEquals(40,pC.calculateWeekendPayment(wP3));
        assertEquals(40,pC.calculateWeekendPayment(wP4));
        assertEquals(120,pC.calculateWeekendPayment(wP5));
        assertEquals(25,pC.calculateWeekendPayment(wP6));
    }
}