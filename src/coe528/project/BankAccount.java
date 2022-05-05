package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public class BankAccount {
    /**
     * Overview: This class represents the bank account of a customer, it is mutable as the balance can change at any time
     * 
     * Abstraction function: AF(c) = a bank account B where B.balance = numerical balance of the account
     * Rep invariant: RI(c) = true if (balance >= 0)
     */
    private double balance;
    
    /**
     * Constructor for the BankAccount class
     * 
     * @param balance Initial balance for the account
     */
    public BankAccount(double balance) {

        this.balance = balance;
    }

    /**
     * This method returns the current bank account balance
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns current bank account balance value
     *
     * @return Bank account balance
     */
    public double getBalance() {

        return balance;
    }
    
    /**
     * This method sets the current bank account balance to the given value
     * REQUIRES: New balance must be a positive value
     * MODIFIES: balance
     * EFFECTS: Changes value of balance to new given value
     * 
     * @param balance New balance
     */
    public void setBalance(double balance) {

        this.balance = balance;
    }

    /**
     * This method adds funds to the current bank account balance
     * REQUIRES: Funds added must be a positive value
     * MODIFIES: balance
     * EFFECTS: Adds given value to current balance
     * 
     * @param d Funds to be added
     */
    public void addFunds(double d) {

        balance += d;
    }

    /**
     * This method removes funds from the current bank account balance
     * REQUIRES: Funds removed must be a positive value
     * MODIFIES: balance
     * EFFECTS: Removes given value from current balance
     * 
     * @param d Funds to be removed
     */
    public void removeFunds(double d) {

        balance -= d;
    }

    /**
     * This method returns a clone of the bank account
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns shallow copy of the BankAccount class
     * 
     * @return Clone of bank account
     * @throws CloneNotSupportedException
     */
    @Override
    public BankAccount clone() throws CloneNotSupportedException {

        return (BankAccount) super.clone();
    }
    
    /**
     * This method returns the String representation of the BankAccount class
     * REQUIRES: none
     * MODIFIES: none
     * EFFECTS: Returns String representation of the BankAccount class
     * 
     * @return String representation of the BankAccount class
     */
    @Override
    public String toString() {
        
        return "$" + balance;
    }
    
    /**
     * This method returns true if the rep invariant is valid, as in the balance is greater than or equal to 0
     * REQUIRES: balance must have a value
     * MODIFIES: none
     * EFFECTS: Returns true if balance is greater than or equal to 0
     * 
     * @return True if rep invariant is valid
     */
    public boolean repOk() {
        
        boolean ok = false;
        
        if (balance >= 0) {
            
            ok = true;
        }
        
        return ok;
    }
}
