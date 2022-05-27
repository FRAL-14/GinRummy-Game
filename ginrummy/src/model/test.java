package model;

import java.sql.Timestamp;
import java.time.Instant;

public class test {
    public static void main(String[] args) {

        Timestamp start = Timestamp.valueOf("2022-05-21 19:38:38.000239");
        Timestamp finish= Timestamp.from(Instant.now());

        System.out.println("Start at: "+start);
        System.out.println("Finish at: "+finish);

        long milliseconds = finish.getTime() - start.getTime();
        System.out.println(milliseconds);
        //In milliseconds

        int seconds = (int) milliseconds / 1000;
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;

        System.out.println("Difference: ");
        System.out.println(" Hours: " + hours);
        System.out.println(" Minutes: " + minutes);
        System.out.println(" Seconds: " + seconds);

    }
}
