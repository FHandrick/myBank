package business;

public class Count extends AbstractCount{


    void debit (double value)
    {balance = balance - value;
    }

    public Count (String n, String na) {number = n; name = na; balance = 0;}
}
