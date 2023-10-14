package edu.wgu.d387_sample_code.international_functions;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.*;
import java.time.format.DateTimeFormatter;

// Class to handle time zone conversions between ET, MT and UTC.
public class TimeZoneConversion {

    // Method to calculate time zones
    public static ZonedDateTime convertTimezone(ZonedDateTime dateTime, ZoneId fromZoneId, ZoneId toZoneId) {
        return dateTime.withZoneSameInstant(toZoneId);
    }
    // Method to convert from ET to MT time.
    public static ZonedDateTime convertETToMT(ZonedDateTime dateTime) {
        return convertTimezone(dateTime, ZoneId.of("America/New_York"), ZoneId.of("America/Denver"));
    }
    // Method to convert from MT to ET time.
    public static ZonedDateTime convertMTToET(ZonedDateTime dateTime) {
        return convertTimezone(dateTime, ZoneId.of("America/Denver"), ZoneId.of("America/New_York"));
    }
    // Method to convert from ET to UTC time.
    public static ZonedDateTime convertETToUTC(ZonedDateTime dateTime) {
        return convertTimezone(dateTime, ZoneId.of("America/New_York"), ZoneId.of("UTC"));
    }
    // Method to convert from UTC to ET time.
    public static ZonedDateTime convertUTCToET(ZonedDateTime dateTime) {
        return convertTimezone(dateTime, ZoneId.of("UTC"), ZoneId.of("America/New_York"));
    }
    // Method to convert from MT to UTC time.
    public static ZonedDateTime convertMTToUTC(ZonedDateTime dateTime) {
        return convertTimezone(dateTime, ZoneId.of("America/Denver"), ZoneId.of("UTC"));
    }
    // Method to convert from UTC to MT time.
    public static ZonedDateTime convertUTCToMT(ZonedDateTime dateTime) {
        return convertTimezone(dateTime, ZoneId.of("UTC"), ZoneId.of("America/Denver"));
    }

    public static String showTime() {
        // String to display current time in ET time zone.
        ZonedDateTime dateTimeET = ZonedDateTime.now(ZoneId.of("America/New_York"));
        DateTimeFormatter timeFormatET = DateTimeFormatter.ofPattern("HH:mm");

        // Convert the ET ZonedDateTime object to MT
        ZonedDateTime dateTimeMT = TimeZoneConversion.convertETToMT(dateTimeET);
        DateTimeFormatter timeFormatMT = DateTimeFormatter.ofPattern("HH:mm");

        // Convert the MT ZonedDateTime object to UTC
        ZonedDateTime dateTimeUTC = TimeZoneConversion.convertMTToUTC(dateTimeMT);
        DateTimeFormatter timeFormatUTC = DateTimeFormatter.ofPattern("HH:mm");

        // Print the ET, MT, and UTC ZonedDateTime objects
        String timeZoneETC = dateTimeET.format(timeFormatET) + "EST\n";
        String timeZoneMT = dateTimeMT.format(timeFormatMT) + "MT\n";
        String timeZoneUTC = dateTimeUTC.format(timeFormatUTC) + "UTC";

        // Return time zone values
        return timeZoneETC + timeZoneMT + timeZoneUTC;

    }

}
