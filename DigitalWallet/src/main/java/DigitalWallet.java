import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class DigitalWallet {
    private static volatile DigitalWallet instance;
    private DigitalWallet() {
        users = new ConcurrentHashMap<>();
        accounts = new ConcurrentHashMap<>();
        paymentMethods = new ConcurrentHashMap<>();
    }
    private final Map<String, User> users;
    private final Map<String, Account> accounts;
    private final Map<String, PaymentMethod> paymentMethods;
    public static DigitalWallet getInstance() {
        DigitalWallet result = instance;
        if (result != null) {
            return result;
        }
        synchronized (DigitalWallet.class) {
            if (instance == null) {
                instance = new DigitalWallet();
            }
            return instance;
        }
    }

    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void createAccount(Account account) {
        accounts.put(account.getId(), account);
        account.getUser().addAccount(account);
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public PaymentMethod getPaymentMethod(String paymentMethodId) {
        return paymentMethods.get(paymentMethodId);
    }
    public List<Transaction> getTransactionHistory(Account account) {
        return account.getTransactions();
    }
    public synchronized void transferFunds(Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency) {
        if (sourceAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(currency, sourceAccount.getCurrency(), amount);
        }
        sourceAccount.withdraw(amount);

        if (destinationAccount.getCurrency() != currency) {
            amount = CurrencyConverter.convert(currency, destinationAccount.getCurrency(),amount);
        }
        destinationAccount.deposit(amount);

        String transactionId = generateTransactionId();
        Transaction transaction = new Transaction(transactionId, sourceAccount, destinationAccount, amount, currency, Instant.now());
        sourceAccount.addTransaction(transaction);
        destinationAccount.addTransaction(transaction);
    }
    private String generateTransactionId() {
        return "TXN" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
