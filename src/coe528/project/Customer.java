package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public class Customer implements User {

    private String username;
    private String password;
    private String role;
    private BankAccount bankAccount;
    private Level level;

    /**
     * Constructor for the Customer class
     * 
     * @param username Username of Customer
     * @param password Password of Customer
     */
    public Customer(String username, String password) {

        this.username = username;
        this.password = password;
        this.role = "customer";
        this.bankAccount = new BankAccount(0);
        this.level = new Silver();
    }
    
    /**
     * This method checks if a given username is the same as the Customer's username
     * 
     * @param username Username to check
     * @return True if given username matches this Customer's username
     */
    @Override
    public boolean hasUsername(String username) {

        return (this.username.equals(username));
    }
    
    /**
     * This method checks if a given password is the same as the Customer's password
     * 
     * @param password Password to check
     * @return True if given password matches this Customer's password
     */
    @Override
    public boolean hasPassword(String password) {

        return (this.password.equals(password));
    }

    /**
     * This method levels up the Customer to next level
     */
    public void levelUp() {

        level.levelUp(this);
    }

    /**
     * This method levels down the Customer to previous level
     */
    public void levelDown() {

        level.levelDown(this);
    }

    /**
     * This method updates the Customer's level according to their bank account
     * balance
     */
    public void updateLevel() {

        try {
            if (getBalance() < 10000) {

                level = new Silver();

            } else if (getBalance() >= 10000 && getBalance() < 20000) {

                level = new Gold();
            } else {

                level = new Platinum();
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method sets the Customer's level to a specified level
     *
     * @param level Level to set the Customer to
     * @throws CloneNotSupportedException
     */
    public void setLevel(Level level) throws CloneNotSupportedException {

        this.level = (Level) level.clone();
    }

    /**
     * This method returns the Customer's current level
     *
     * @return Customer level
     */
    public Level getLevel() {

        return this.level;
    }
    
    /**
     * This method returns the String representation of the Customer's current level
     * @return String representation of the Customer's current level
     */
    public String getLevelString() {

        return "" + level;
    }

    /**
     * This method deposits funds into the Customer's bank account balance
     *
     * @param d Amount to deposit into bank account balance
     */
    public void deposit(double d) {

        bankAccount.addFunds(d);
    }
    
    /**
     * This method withdraws funds from the Customer's bank account balance
     *
     * @param d Amount to withdraw from bank account balance
     */
    public void withdraw(double d) {

        bankAccount.removeFunds(d);
    }

    /**
     * This method gets the current balance in the Customer's bank account balance
     *
     * @return Current bank account balance
     */
    public double getBalance() {

        return bankAccount.getBalance();
    }
    
    /**
     * This method changes the Customer's bank account balance to the new value
     * 
     * @param balance New balance
     */
    public void setBalance(double balance) {

        bankAccount.setBalance(balance);
    }

    /**
     * This method does an online purchase using funds from the Customer's bank
     * account balance
     *
     * @param d Amount paid when doing purchase
     */
    public void doOnlinePurchase(double d) {

        if (d >= 50) {

            bankAccount.removeFunds(d + level.getFee());
        }
        updateLevel();
    }

    /**
     * This method performs a deep copy of a Customer object
     *
     * @return Clone of Customer
     * @throws CloneNotSupportedException
     */
    @Override
    public Customer clone() throws CloneNotSupportedException {
        Customer clonedCustomer = (Customer) super.clone();
        clonedCustomer.bankAccount = this.bankAccount.clone();
        clonedCustomer.level = this.level.clone();
        return clonedCustomer;
    }
    /**
     * This method returns a String representation of the Customer's username and password to be written to a file
     * 
     * @return String representation of the Customer's username and password
     */
    @Override
    public String credentials() {

        return (username + "\t" + password + "\t" + bankAccount.getBalance());
    }
    
    /**
     * This method returns the Customer's username
     * 
     * @return Customer's username
     */
    @Override
    public String getUsername() {

        return username;
    }
    
    /**
     * This method returns the Customer's password
     * 
     * @return Customer's password
     */
    public String getPassword() {

        return password;
    }

    /**
     * This method returns a String representation of the Customer with their
     * name and bank account balance
     *
     * @return String representation of Customer
     */
    @Override
    public String toString() {

        return ("User type: " + role + "\nUser: " + username + "\nBalance: " + getBalance() + "\n");
    }
}
