import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String ID;
    private final String UserID;
    private final List<Transaction> transactionsList = new ArrayList<>();
    public Account(String UserID, String ID) {
        this.ID = ID;
        this.UserID = UserID;
    }

    public void addTransaction(Transaction transaction) {
        transactionsList.add(transaction);
    }
    public void removeTransaction(Transaction transaction) {
        transactionsList.remove(transaction);
    }
    public List<Transaction> gettransactionsList() {
        return transactionsList;
    }
    public String getUserID() {
        return UserID;
    }
    public String getID() {
        return ID;
    }
}
