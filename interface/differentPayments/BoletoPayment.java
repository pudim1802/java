package differentPayments;

public class BoletoPayment extends PaymentMethod{

    private Double rate = 0.2;

    public BoletoPayment(String owner){
        this.ownerName = owner;

    }


    @Override
    public void pay(double amount, Payment destination) {
        balance -= amount * rate;
        ((PaymentMethod) destination).recive(amount);




    }
}
