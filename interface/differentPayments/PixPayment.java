package differentPayments;

public class PixPayment extends PaymentMethod{


    public PixPayment(String owner){
        super(owner);
    }

    @Override
    public void pay(double amount , Payment destination) {
        balance -= amount;
        ((PaymentMethod) destination).recive(amount);

    }

}
