import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String email;
    private final String password;
    private final String ID;
    private final List<Account> accountList = new ArrayList<>();
    public User(String name, String email, String password, String ID) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ID = ID;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }
    public void removeAccount(Account account) {
        accountList.remove(account);
    }
    public List<Account> getAccountList() {
        return accountList;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getId() {
        return ID;
    }
}
