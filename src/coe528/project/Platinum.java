package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public class Platinum extends Level {

    final private double FEE = 0;

    /**
     * This method does nothing as Silver is the highest level
     *
     * @param c Customer to be leveled up
     */
    @Override
    public void levelUp(Customer c) {

    }

    /**
     * This method levels down the Customer from Platinum to Gold
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
     * @return Fee for the Platinum level customers
     */
    @Override
    public double getFee() {

        return FEE;
    }
    
    /**
     * This method returns the String representation of the Platinum class
     * 
     * @return String representation of the Platinum class
     */
    @Override
    public String toString() {
        
        return "Platinum";
    }
}
