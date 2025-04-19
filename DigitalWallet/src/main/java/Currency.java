import java.math.BigDecimal;

public enum Currency {
    DOLAR(BigDecimal.valueOf(1)),
    REAL(BigDecimal.valueOf(6));
    public final BigDecimal value;
    Currency(BigDecimal value) {
        this.value = value;
    }
}
