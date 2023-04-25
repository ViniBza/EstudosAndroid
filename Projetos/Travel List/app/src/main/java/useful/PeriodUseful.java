package useful;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Package;

public class PeriodUseful {

   public static String setPeriod(Package packageVar){
       Calendar checkIn = Calendar.getInstance();
       Calendar checkOut = Calendar.getInstance();
       checkOut.add(Calendar.DATE, packageVar.getDias());
       SimpleDateFormat formatBr = new SimpleDateFormat("dd/MM");
       String dateCheckIn = formatBr.format(checkIn.getTime());
       String dateCheckOut = formatBr.format(checkOut.getTime());
       String allPeriod = dateCheckIn + " - " + dateCheckOut +" de " + checkOut.get(Calendar.YEAR);
       return allPeriod;

    }
}
