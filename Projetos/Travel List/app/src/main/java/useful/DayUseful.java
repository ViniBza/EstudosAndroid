package useful;

public class DayUseful {

    public static final String SINGULAR = " days";
    public static final String PLURAL = " day";

    public static String putDays(int countDays){
        if (countDays > 1) {
            return countDays + SINGULAR;}
        return  countDays + PLURAL;
    }

}
