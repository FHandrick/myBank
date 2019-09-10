package business;

public abstract class AbstractCount {
    protected String     number;
    protected double    balance;
    protected String    name;
    void credit (double value) {
        balance = balance + value;
    }
    abstract void debit (double value);

    public String getNumber() {return number;}
    public double getBalance() {return balance;}
    public String getName() {return  name;}
}
