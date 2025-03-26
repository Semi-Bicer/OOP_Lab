public class BankAccount {
    private float balance;
    private String ownerName;
    private String bankID;
    private String currency;



    public BankAccount(float balance, String name, String id, String currency){
        setBalance(balance);
        setOwnerName(name);
        setBankID(id);
        setCurrency(currency);
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        if (balance < 0)
            balance = 0;

        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }



    public void withdrawBalance(float amount){
        if (amount <= 0)
            System.out.println("İşlem miktarı 0'dan büyük olmalıdır!");
        else
            balance -= amount;
    }

    public void depositBalance(float amount){
        if (amount <= 0)
            System.out.println("İşlem miktarı 0 dan büyük olmalıdır!");
        else
            balance += amount;
    }

    public void info(){
        System.out.println("********************************************");
        System.out.println("Hesap ismi: " + getOwnerName());
        System.out.println("Hesap numarası: " + getBankID());
        System.out.println("Hesap bakiyesi: " + getBalance());
        System.out.println("Hesapın para birmi: " + getCurrency());
        System.out.println("*********************************************");
    }

}
