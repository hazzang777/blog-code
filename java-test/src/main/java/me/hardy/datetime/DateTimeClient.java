package me.hardy.datetime;

import java.util.TimeZone;

public class DateTimeClient {
    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getDefault();
        EventManager eventManager = EventManager.of("2022-08-01 14:00:00", "2022-08-20 14:00:00", timeZone);
        System.out.println(eventManager.isEventPeriod());
    }
}
