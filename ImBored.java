import java.time.*;
public class ImBored {
    public static void main(String[] args) {
        ZonedDateTime DateOfBirth = ZonedDateTime.of(2007, 8, 1, 4, 28, 17, 0, ZoneId.systemDefault());
        Duration duration = Duration.between(DateOfBirth, ZonedDateTime.now());
        long days = duration.toDays();
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.getSeconds();
        long millis = duration.toMillis();
        long years = days / 365;
        days = days % 365;
        long months = days / 30;
        days = days % 30;
        hours = hours % 24;
        minutes = minutes % 60;
        seconds = seconds % 60;
        System.out.println("Years: " + years + " Months: " + months + " Days: " + days + " Hours: " + hours + " Minutes: " + minutes + " Seconds: " + seconds);
    }
}
