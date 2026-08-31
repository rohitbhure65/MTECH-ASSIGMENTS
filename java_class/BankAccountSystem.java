class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + ". New Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Withdrawal denied! Minimum balance of $100 must be maintained. Attempted withdrawal: $" + amount + ", Current balance: $" + balance);
        } else {
            super.withdraw(amount);
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        System.out.println("=== Bank Account System ===");
        SavingsAccount savings = new SavingsAccount(500);
        
        savings.deposit(100);
        savings.withdraw(200); 
        
        savings.withdraw(350); 
        
        System.out.println("Final Balance: $" + savings.getBalance());
    }
}
