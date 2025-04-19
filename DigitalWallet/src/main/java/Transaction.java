import java.math.BigDecimal;
import java.time.Instant;

public record Transaction(String ID, Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency, Instant timestamp) { }
