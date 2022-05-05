package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public class Silver extends Level {

    final private double FEE = 20;

    /**
     * This method levels up the Customer from Silver to Gold
     *
     * @param c Customer to be leveled up
     */
    @Override
    public void levelUp(Customer c) {

        try {

            c.setLevel(gold);
        } catch (CloneNotSupportedException e) {

        }
    }

    /**
     * This method does nothing as Silver is the lowest level
     *
     * @param c Customer to be leveled down
     */
    @Override
    public void levelDown(Customer c) {

    }

    /**
     * This method returns the fixed fee needed for doing online purchases
     *
     * @return double Fee for the Silver level customers
     */
    @Override
    public double getFee() {

        return FEE;
    }
    
    /**
     * This method returns the String representation of the Silver class
     * 
     * @return String representation of the Silver class
     */
    @Override
    public String toString() {
        
        return "Silver";
    }
}
