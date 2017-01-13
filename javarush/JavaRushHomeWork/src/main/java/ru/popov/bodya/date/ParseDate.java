package ru.popov.bodya.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ParseDate {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        String sName1 = reader.readLine();
        SimpleDateFormat sf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        SimpleDateFormat sf1 = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sf1.parse(sName1);
        System.out.println(sf.format(date).toUpperCase());
    }
}
