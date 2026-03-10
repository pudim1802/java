package differentPayments;

import java.util.Scanner;

public class CreditCardPayment extends PaymentMethod{




    public CreditCardPayment(String owner){
        this.ownerName = owner;
    }

    @Override
    public void pay(double amount, Payment destination) {
        System.out.println("em quantas vezes voce ira fazer: ");
        Scanner ler = new Scanner(System.in);
        int i = ler.nextInt();
        ((PaymentMethod) destination).recive(amount);

        amount = amount/i;

        balance -= amount;


    }

}
