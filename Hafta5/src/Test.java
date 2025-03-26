public class Test {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(500,"Adam", "505987", "USD");

        account1.getBalance();
        account1.getBankID();
        account1.getCurrency();
        account1.getOwnerName();

        account1.withdrawBalance(50);
        account1.depositBalance(200);

        account1.info();
    }
}