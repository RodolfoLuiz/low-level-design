import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {
    public static BigDecimal convert(Currency currentCurrency, Currency destinationCurrency, BigDecimal amount){
        return amount.multiply(destinationCurrency.value).divide(currentCurrency.value, RoundingMode.HALF_UP);
    }
}
