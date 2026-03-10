package differentPayments;

public abstract class PaymentMethod implements Payment{

    protected String ownerName;
    protected Double balance;

    public PaymentMethod(String owner){
        this.ownerName = owner;
    }

    public PaymentMethod(){
        super();

    }

    @Override
    public String getOwner(){return ownerName;}
    @Override
    public Double getBalance(){return balance;}

    @Override
    public void setOwner(String owner){
        this.ownerName = owner;
    }
    @Override
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void recive(double amount){
        balance +=amount;
    }



}
