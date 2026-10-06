public class SavingsAccount extends BankAccount {
    private double depositAmount;
    private String depositDate;
    private double interestRate;
    private int term;

    public SavingsAccount() {
    }

    public SavingsAccount(int id, String accountCode, String ownerName, String createdDate,
                          double depositAmount, String depositDate, double interestRate, int term) {
        super(id, accountCode, ownerName, createdDate);
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String getAccountType() {
        return "Tai khoan tiet kiem";
    }

    @Override
    public void displayInfo() {
        System.out.println("Loai tai khoan: " + getAccountType());
        System.out.println("ID: " + getId());
        System.out.println("Ma tai khoan: " + getAccountCode());
        System.out.println("Ten chu tai khoan: " + getOwnerName());
        System.out.println("Ngay tao: " + getCreatedDate());
        System.out.println("So tien gui: " + depositAmount);
        System.out.println("Ngay gui: " + depositDate);
        System.out.println("Lai suat: " + interestRate + "%");
        System.out.println("Ky han: " + term + " thang");
    }

    @Override
    public double getBalance() {
        return depositAmount + (depositAmount * interestRate * term / 100);
    }
}
