package differentPayments;

public interface Payment {

    void pay (double amount , Payment destination);

    void setBalance(double balance);
    void setOwner(String owner);

    Double getBalance();
    String getOwner();




}
