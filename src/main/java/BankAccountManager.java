import java.util.ArrayList;

public class BankAccountManager implements IManager<BankAccount> {
    private final ArrayList<BankAccount> list = new ArrayList<>();

    @Override
    public void add(BankAccount account) {
        if (account != null) {
            list.add(account);
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

    public void removeById(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            list.remove(index);
        }
    }

    @Override
    public void update(int index, BankAccount account) {
        if (index >= 0 && index < list.size() && account != null) {
            list.set(index, account);
        }
    }

    public void updateById(int id, BankAccount account) {
        int index = findIndexById(id);
        if (index != -1 && account != null) {
            list.set(index, account);
        }
    }

    @Override
    public ArrayList<BankAccount> findAll() {
        return new ArrayList<>(list);
    }

    public BankAccount findById(int id) {
        for (BankAccount account : list) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public BankAccount findByCode(String accountCode) {
        for (BankAccount account : list) {
            if (account.getAccountCode().equalsIgnoreCase(accountCode)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<BankAccount> findByOwnerName(String keyword) {
        ArrayList<BankAccount> result = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return result;
        }

        String search = keyword.trim().toLowerCase();
        for (BankAccount account : list) {
            if (account.getOwnerName() != null && account.getOwnerName().toLowerCase().contains(search)) {
                result.add(account);
            }
        }
        return result;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
