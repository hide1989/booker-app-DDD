package booker.app.maroos.branches.domain.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class TimeRange {
    private final String openDoors;
    private final String closeDoors;

    public TimeRange(String openDoorsAt, String closeDoorsAt) throws ParseException {
        verifyCorrectTime(openDoorsAt, closeDoorsAt);
        this.openDoors = openDoorsAt;
        this.closeDoors = closeDoorsAt;
    }

    public String openDoors() {
        return openDoors;
    }

    public String closeDoors() {
        return closeDoors;
    }

    private void verifyCorrectTime(String openDoorsAt, String closeDoorsAt) throws ParseException{
        new SimpleDateFormat("HH:mm").parse(openDoorsAt);
        new SimpleDateFormat("HH:mm").parse(closeDoorsAt);
        String regEx = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        if(!openDoorsAt.matches(regEx) || !closeDoorsAt.matches(regEx)){
            throw new ParseException("The format time is not correct, should be HH:mm", 0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeRange)) return false;
        TimeRange timeRange = (TimeRange) o;
        return Objects.equals(openDoors, timeRange.openDoors) &&
                Objects.equals(closeDoors, timeRange.closeDoors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openDoors, closeDoors);
    }
}
