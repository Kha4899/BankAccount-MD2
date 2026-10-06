import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountManagerTest {

    @Test
    void shouldAddAndListBankAccounts() {
        BankAccountManager manager = new BankAccountManager();
        manager.add(new SavingsAccount(1, "TK001", "Nguyen Van A", "2024-01-10", 5000000, "2024-01-15", 6.8, 12));
        manager.add(new PaymentAccount(2, "TK002", "Tran Thi B", "2024-02-10", "123456789", 15000000));

        ArrayList<BankAccount> accounts = manager.findAll();

        assertEquals(2, accounts.size());
        assertEquals("Nguyen Van A", accounts.get(0).getOwnerName());
    }

    @Test
    void shouldFindAccountsByOwnerName() {
        BankAccountManager manager = new BankAccountManager();
        manager.add(new SavingsAccount(1, "TK001", "Nguyen Van A", "2024-01-10", 5000000, "2024-01-15", 6.8, 12));
        manager.add(new PaymentAccount(2, "TK002", "Tran Thi B", "2024-02-10", "123456789", 15000000));

        ArrayList<BankAccount> results = manager.findByOwnerName("Nguyen");

        assertEquals(1, results.size());
        assertEquals("TK001", results.get(0).getAccountCode());
    }
}
