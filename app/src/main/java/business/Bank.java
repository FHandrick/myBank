package business;

public class Bank {
    public Count[] counts;
    public int index = 0;

    public void register(Count c) {
        counts[index] = c;
        index = index + 1;
    }
    public String auditor(){
        String auditReport = "";
        double totalValue = 0;
        int j = 0;
        while (j<index){
            auditReport = auditReport + "Count Number:"+counts[j].getNumber()+"\n"+"Client name:"+counts[j].getName()+"\n"+
                    "Balance:"+counts[j].getBalance()+"\n"+"-------------------------------------"+"\n";


            totalValue = totalValue+counts[j].getBalance();
            j++;
        }
        auditReport = auditReport + "Accounts number:"+index+"\n";
        auditReport = auditReport + "Total balance:"+totalValue;
        return auditReport;
    }
    public Count find(String n) {
        int          i = 0;
        boolean     find = false;
        while ((! find) && (i < index)) {
            if (counts[i].getNumber().equals(n)) find = true;
            else i = i + 1;
        }
        if (find == true) return counts[i];
        else return null;
    }
    public void transfer(String d, String cr, double vl){
        Count c1,c2;
        c1 = this.find(d);
        c2 = this.find(cr);
        if (c1 != null)
            c1.debit(vl);
        else
            System.out.println("ERROR");
        if (c2 != null)
            c2.credit(vl);
        else
            System.out.println("ERROR");
    }
    /*void rendejurosBanco(String num, double t){
        Conta c;
        c = this.procurar(num);
        if (c != null){
            if (c instanceof Poupanca)
                ((Poupanca) c).rende_juros(t);
            else
                System.out.println("Essa Conta nao eh Poupanca");
        }

        else
            System.out.println("Conta a render juros Inexistente!");


    }
    */

    public double balance(String num){
        Count c;
        c = this.find(num);
        if (c != null)
            return c.getBalance();
        else
            return 0;
    }
    public void debit(String num, double val) {
        Count c;
        c = this.find(num);
        if (c != null)
            c.debit(val);
        else
            System.out.println("ERROR");
    }
    public void credit(String num, double val) {
        Count c;
        c = this.find(num);
        if (c != null)
            c.credit(val);
        else
            System.out.println("ERROR");
    }

    public Bank( ) {
        counts=new Count[50];
    }
}
