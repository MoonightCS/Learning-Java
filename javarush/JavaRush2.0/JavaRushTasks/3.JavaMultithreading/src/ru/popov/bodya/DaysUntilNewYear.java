package ru.popov.bodya;

import java.util.Calendar;
import java.util.Date;

public class DaysUntilNewYear {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, 0);

        Date date = cal.getTime();
        Date currentTime = new Date();

        long msTimeDistance = currentTime.getTime() - date.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance / msDay); //количество целых дней
        System.out.println("Days from start of year: " + dayCount);
    }
}
