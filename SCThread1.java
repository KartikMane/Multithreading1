
class ATMS
{

    synchronized public void checkBalance(String name)
    {
        System.out.print(name + " Checking ");

        try{Thread.sleep(1000);}catch(Exception e){}

        System.out.println("Balance");
    }

    synchronized public void withdraw(String name,int amount)
    {
        System.out.print(name + " withdrawing ");

        try{Thread.sleep(1000);}catch(Exception e){}

        System.out.println(amount);

    }
}

class Customers extends Thread
{
    String name;
    int amount;
    ATMS atm;

    Customers(String n,ATMS a,int amt)
    {
        name=n;
        atm=a;
        amount=amt;
    }
    public void useATM()
    {
        atm.checkBalance(name);
        atm.withdraw(name, amount);
    }
    public void run()
    {
        useATM();
    }
}

public class SCThread1
{
    public static void main(String[] args)
    {
        ATMS atms=new ATMS();
        Customers c3=new Customers("Smith",atms,100);
        Customers c4=new Customers("John",atms,200);
        c3.start();
        c4.start();
    }
}