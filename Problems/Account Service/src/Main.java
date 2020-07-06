import java.util.ArrayList;
import java.util.Arrays;


//class Main {
//
//    public static void main(String[] args) {
//        Account[] accounts = {new Account(1,100, new User(1,"Sergei","Sergeev")),new Account(2,150, new User(2,"Ivan","Ivanov"))};
//        AccountService service = new AccountServiceImpl(accounts);
//        System.out.println(service.findAccountByOwnerId(1));
//        System.out.println(service.countAccountsWithBalanceGreaterThan(90));
//    }
//}


interface AccountService {
    /**
     * It finds an account by owner id
     *
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);

    /**
     * It count the number of account with balance > the given value
     *
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {
    Account[] accounts;


    public AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts;

    }


    @Override
    public Account findAccountByOwnerId(long id) {

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getOwner().getId() == id) {
                return accounts[i];
            }
        }
        return null;
    }


    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long counter = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getBalance() > value) {
                counter++;
            }
        }
        return counter;
    }
}

// Declare and implement your AccountServiceImpl here

class Account {

    private long id;
    private long balance;
    private User owner;


    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;

    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", owner=" + owner +
                '}';
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}