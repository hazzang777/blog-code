package me.hardy.datetime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class EventManager {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private long startEventTimeMillis;
    private long endEventTimeMillis;

    public static EventManager of(String startEventDateTime, String endEventDateTime, TimeZone timeZone) {
        ZonedDateTime startEventZonedDateTime = createEventDateTime(startEventDateTime, timeZone);
        ZonedDateTime endEventZonedDateTime = createEventDateTime(endEventDateTime, timeZone);

        EventManager eventManager = new EventManager();
        eventManager.setStartEventTimeMillis(convertToTimeMillis(startEventZonedDateTime));
        eventManager.setEndEventTimeMillis(convertToTimeMillis(endEventZonedDateTime));

        return eventManager;
    }

    private static ZonedDateTime createEventDateTime(String strDateTime, TimeZone timeZone) {
        DateTimeFormatter zonedDateTimeFormatter = DATE_TIME_FORMATTER.withZone(timeZone.toZoneId());
        return ZonedDateTime.parse(strDateTime, zonedDateTimeFormatter);
    }

    private static long convertToTimeMillis(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public boolean isEventPeriod() {
        long currentTimeMillis = System.currentTimeMillis();
        return this.startEventTimeMillis <= currentTimeMillis && currentTimeMillis <= endEventTimeMillis;
    }

    public void setStartEventTimeMillis(long startEventTimeMillis) {
        this.startEventTimeMillis = startEventTimeMillis;
    }

    public void setEndEventTimeMillis(long endEventTimeMillis) {
        this.endEventTimeMillis = endEventTimeMillis;
    }
}
