package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public class Gold extends Level {

    final private double FEE = 10;

    /**
     * This method levels up the Customer from Gold to Platinum
     *
     * @param c Customer to be leveled up
     */
    @Override
    public void levelUp(Customer c) {

        try {

            c.setLevel(platinum);
        } catch (CloneNotSupportedException e) {

        }
    }

    /**
     * This method levels down the Customer from Gold to Silver
     *
     * @param c Customer to be leveled down
     */
    @Override
    public void levelDown(Customer c) {

        try {

            c.setLevel(gold);
        } catch (CloneNotSupportedException e) {

        }
    }

    /**
     * This method returns the fixed fee needed for doing online purchases
     *
     * @return Fee for the Gold level customers
     */
    @Override
    public double getFee() {

        return FEE;
    }
    
    /**
     * This method returns the String representation of the Gold class
     * 
     * @return String representation of the Gold class
     */
    @Override
    public String toString() {
        
        return "Gold";
    }
}
