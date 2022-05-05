package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public abstract class Level {

    static protected Level silver = new Silver();
    static protected Level gold = new Gold();
    static protected Level platinum = new Platinum();

    public abstract void levelUp(Customer c);

    public abstract void levelDown(Customer c);

    public abstract double getFee();

    @Override
    public Level clone() throws CloneNotSupportedException {

        return (Level) super.clone();
    }

    @Override
    public abstract String toString();
}
