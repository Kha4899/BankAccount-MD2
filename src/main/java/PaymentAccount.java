public class PaymentAccount extends BankAccount {
    private String cardNumber;
    private double balance;

    public PaymentAccount() {
    }

    public PaymentAccount(int id, String accountCode, String ownerName, String createdDate,
                         String cardNumber, double balance) {
        super(id, accountCode, ownerName, createdDate);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String getAccountType() {
        return "Tai khoan thanh toan";
    }

    @Override
    public void displayInfo() {
        System.out.println("Loai tai khoan: " + getAccountType());
        System.out.println("ID: " + getId());
        System.out.println("Ma tai khoan: " + getAccountCode());
        System.out.println("Ten chu tai khoan: " + getOwnerName());
        System.out.println("Ngay tao: " + getCreatedDate());
        System.out.println("So the: " + cardNumber);
        System.out.println("So tien trong tai khoan: " + balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
