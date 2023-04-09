package useful;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceUseful {

    public static final String PORTUGUES = "pt";
    public static final String BRAZIL = "br";
    public static final String MAIN_FORMAT = "R$";
    public static final String FORMAT_ALTERED = "R$ ";

    public static String putPrice(BigDecimal price){

        NumberFormat formatBr = DecimalFormat.getCurrencyInstance(
                new Locale(PORTUGUES, BRAZIL));
        return formatBr
                .format(price)
                .replace(MAIN_FORMAT, FORMAT_ALTERED);
    }
}
