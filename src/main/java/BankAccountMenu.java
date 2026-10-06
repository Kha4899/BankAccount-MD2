import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMenu {
    private final BankAccountManager manager = new BankAccountManager();
    private final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\n===== HE THONG QUAN LY TAI KHOAN NGAN HANG =====");
            System.out.println("1. Them tai khoan tiet kiem");
            System.out.println("2. Them tai khoan thanh toan");
            System.out.println("3. Hien thi tat ca tai khoan");
            System.out.println("4. Hien thi chi tiet tai khoan");
            System.out.println("5. Tim theo ten chu tai khoan");
            System.out.println("6. Sua tai khoan");
            System.out.println("7. Xoa tai khoan");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    addSavingsAccount();
                    break;
                case 2:
                    addPaymentAccount();
                    break;
                case 3:
                    showAllAccounts();
                    break;
                case 4:
                    showDetailAccount();
                    break;
                case 5:
                    searchByOwnerName();
                    break;
                case 6:
                    updateAccount();
                    break;
                case 7:
                    deleteAccount();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung he thong!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
                    break;
            }
        } while (choice != 0);
    }

    private void addSavingsAccount() {
        System.out.println("\n===== THEM TAI KHOAN TIET KIEM =====");
        int id = readInt("Nhap ID tai khoan: ");
        String code = readString("Nhap ma tai khoan: ");
        String owner = readString("Nhap ten chu tai khoan: ");
        String createdDate = readString("Nhap ngay tao tai khoan: ");
        double depositAmount = readDouble("Nhap so tien gui tiet kiem: ");
        String depositDate = readString("Nhap ngay gui tiet kiem: ");
        double interestRate = readDouble("Nhap lai suat (%): ");
        int term = readInt("Nhap ky han (thang): ");

        SavingsAccount account = new SavingsAccount(id, code, owner, createdDate, depositAmount, depositDate, interestRate, term);
        manager.add(account);
        System.out.println("Them tai khoan tiet kiem thanh cong!");
    }

    private void addPaymentAccount() {
        System.out.println("\n===== THEM TAI KHOAN THANH TOAN =====");
        int id = readInt("Nhap ID tai khoan: ");
        String code = readString("Nhap ma tai khoan: ");
        String owner = readString("Nhap ten chu tai khoan: ");
        String createdDate = readString("Nhap ngay tao tai khoan: ");
        String cardNumber = readString("Nhap so the: ");
        double balance = readDouble("Nhap so tien trong tai khoan: ");

        PaymentAccount account = new PaymentAccount(id, code, owner, createdDate, cardNumber, balance);
        manager.add(account);
        System.out.println("Them tai khoan thanh toan thanh cong!");
    }

    private void showAllAccounts() {
        System.out.println("\n===== DANH SACH TAT CA TAI KHOAN =====");
        ArrayList<BankAccount> accounts = manager.findAll();
        if (accounts.isEmpty()) {
            System.out.println("Chua co tai khoan nao.");
            return;
        }

        for (BankAccount account : accounts) {
            account.displayInfo();
            System.out.println("So du hien tai: " + account.getBalance());
            System.out.println("-------------------------------------");
        }
    }

    private void showDetailAccount() {
        System.out.println("\n===== CHI TIET TAI KHOAN =====");
        int id = readInt("Nhap ID tai khoan can xem: ");
        BankAccount account = manager.findById(id);

        if (account == null) {
            System.out.println("Khong tim thay tai khoan co ID = " + id);
            return;
        }

        account.displayInfo();
        System.out.println("So du hien tai: " + account.getBalance());
    }

    private void searchByOwnerName() {
        System.out.println("\n===== TIM KIEM THEO TEN CHU TAI KHOAN =====");
        String keyword = readString("Nhap ten chu tai khoan: ");
        ArrayList<BankAccount> results = manager.findByOwnerName(keyword);

        if (results.isEmpty()) {
            System.out.println("Khong co tai khoan nao phu hop.");
            return;
        }

        for (BankAccount account : results) {
            account.displayInfo();
            System.out.println("-------------------------------------");
        }
    }

    private void updateAccount() {
        System.out.println("\n===== CAP NHAT TAI KHOAN =====");
        int id = readInt("Nhap ID tai khoan can sua: ");
        BankAccount account = manager.findById(id);

        if (account == null) {
            System.out.println("Khong tim thay tai khoan co ID = " + id);
            return;
        }

        String newCode = readString("Nhap ma tai khoan moi: ");
        String newOwner = readString("Nhap ten chu tai khoan moi: ");
        String newDate = readString("Nhap ngay tao tai khoan moi: ");

        account.setAccountCode(newCode);
        account.setOwnerName(newOwner);
        account.setCreatedDate(newDate);

        if (account instanceof SavingsAccount) {
            SavingsAccount saving = (SavingsAccount) account;
            System.out.print("Nhap so tien gui moi: ");
            saving.setDepositAmount(readDouble());
            System.out.print("Nhap ngay gui moi: ");
            saving.setDepositDate(scanner.nextLine());
            System.out.print("Nhap lai suat moi (%): ");
            saving.setInterestRate(readDouble());
            System.out.print("Nhap ky han moi (thang): ");
            saving.setTerm(readInt());
        } else if (account instanceof PaymentAccount) {
            PaymentAccount payment = (PaymentAccount) account;
            System.out.print("Nhap so the moi: ");
            payment.setCardNumber(scanner.nextLine());
            System.out.print("Nhap so tien trong tai khoan moi: ");
            payment.setBalance(readDouble());
        }

        System.out.println("Cap nhat tai khoan thanh cong!");
    }

    private void deleteAccount() {
        System.out.println("\n===== XOA TAI KHOAN =====");
        int id = readInt("Nhap ID tai khoan can xoa: ");
        BankAccount account = manager.findById(id);

        if (account == null) {
            System.out.println("Khong tim thay tai khoan co ID = " + id);
            return;
        }

        manager.removeById(id);
        System.out.println("Da xoa tai khoan: " + account.getOwnerName());
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Gia tri khong hop le. Nhap lai: ");
            }
        }
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Gia tri khong hop le. Nhap lai: ");
            }
        }
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        return readDouble();
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
