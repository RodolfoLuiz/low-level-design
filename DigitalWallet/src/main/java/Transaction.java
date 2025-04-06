import java.time.Instant;

public record Transaction(String ID, Account sourceAccount, Account destinationAccount, float amount, Currency currency, Instant timestamp) { }
