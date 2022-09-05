package me.hardy.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class DateTimeTest {
    public static void main(String[] args) {
        // 뉴욕의 현재 순간을 알아보자.
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime newyork = ZonedDateTime.now(zoneId);
        System.out.println(newyork);
    }
}
