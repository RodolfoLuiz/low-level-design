public class CurrencyConverter {
    public static float Converter(Currency currentCurrency, Currency destinationCurrency, float amount){
        return amount * (destinationCurrency.value/currentCurrency.value);
    }
}
