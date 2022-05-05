package coe528.project;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Nihar Sheth
 */
public class Manager implements User {

    private String username;
    private String password;
    private String role;
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    
    /**
     * Constructor for the Manager class
     * 
     * @param username Username of Manager
     * @param password Password of Manager
     */
    public Manager(String username, String password) {

        this.username = username;
        this.password = password;
        this.role = "manager";
    }
    
    /**
     * This method checks if a given username is the same as the Manager's username
     * 
     * @param username Username to check
     * @return True if given username matches this Manager's username
     */
    @Override
    public boolean hasUsername(String username) {

        return (this.username.equals(username));
    }
    
    /**
     * This method checks if a given password is the same as the Manager's password
     * 
     * @param password Password to check
     * @return True if given password matches this Manager's password
     */
    @Override
    public boolean hasPassword(String password) {

        return (this.password.equals(password));
    }
    
    /**
     * This method creates a new file or overwrites an existing one given a Customer, it writes the Customer's username, password and current balance
     * 
     * @param c Customer whose file is to be made
     */
    public void makeCustomerFile(Customer c) {

        try {

            PrintWriter outfile = new PrintWriter(new File(".").getAbsolutePath() + "//Customers//" + c.getUsername() + ".txt");
            //BufferedWriter out = new BufferedWriter(outfile);
            outfile.print(c.credentials());
            outfile.close();
        } catch (Exception e) {
            System.out.println("Invalid username: " + e);
        }
    }
    
    /**
     * This method reads a Customer's file by comparing the given username and password to the ones in the file, and updating their balance
     * 
     * @param c Customer whose file is to be read
     * @return True if given Customer's username and password match the ones in the file
     */
    public boolean readCustomerFile(Customer c) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(".").getAbsolutePath() + "//Customers//" + c.getUsername() + ".txt"));
            String l = reader.readLine();

            if (l != null) {

                String tmp[] = l.split("\t");
                String tempUsername = c.getUsername();
                String tempPassword = c.getPassword();

                if (tmp[0].equals(tempUsername) == true && tmp[1].equals(tempPassword) == true) {

                    //Customer tempCustomer = new Customer(tempUsername, tempPassword);
                    c.setBalance(Double.parseDouble(tmp[2]));
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid username: " + e);
            return false;
        }
        return false;
    }
    
    /**
     * This method returns a String representation of a given Customer's current balance
     * 
     * @param c Customer whose current balance is to be read
     * @return String representation of the given Customer's current balance
     */
    public String getCustomerBalance(Customer c) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(new File(".").getAbsolutePath() + "//Customers//" + c.getUsername() + ".txt"));
            String l = reader.readLine();

            if (l != null) {

                String tmp[] = l.split("\t");
                String b = "" + Double.parseDouble(tmp[2]);
                return b;
            }
        } catch (Exception e) {

            System.out.println("Invalid username: " + e);
        }
        return null;
    }

    /**
     * This method adds a Customer to the list of customers
     *
     * @param c Customer to be added
     */
    public void addCustomer(Customer c) {

        makeCustomerFile(c);
        customerList.add(c);
    }

    /**
     * This method removes a Customer from the list of customers
     *
     * @param name Customer to be removed
     */
    public void deleteCustomer(String name) {
        try {
            File outfile = new File(new File(".").getAbsolutePath() + "//Customers//" + name + ".txt");
            outfile.delete();
            Customer deleted = new Customer(null, null);

            for (Customer search : customerList) {

                if (name.equals(search.getUsername())) {
                    deleted = search;
                }
            }

            customerList.remove(deleted);
        } catch (Exception e) {
            System.out.println("Invalid username: " + e);
        }
    }
    
    /**
     * This method returns a String representation of the Manager's username and password to be written to a file
     * 
     * @return String representation of the Manager's username and password
     */
    @Override
    public String credentials() {

        return (username + "\t" + password);
    }
    
    /**
     * This method returns the Manager's username
     * 
     * @return Manager's username
     */
    @Override
    public String getUsername() {

        return username;
    }

    /**
     * This method returns the string representation of the Manager
     *
     * @return String representation of Manager
     */
    @Override
    public String toString() {

        return ("User type: " + role + "\nUser: " + username);
    }

}
