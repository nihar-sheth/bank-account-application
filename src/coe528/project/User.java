package coe528.project;

/**
 *
 * @author Nihar Sheth
 */
public interface User {

    public boolean hasUsername(String username);

    public boolean hasPassword(String password);

    public String credentials();

    public String getUsername();
}
