import java.util.Scanner;
class BankAccount{
    private double bal;
    public BankAccount(double initial)
    {
        this.bal=initial;
    }
    public double getbal()
    {
        return bal;
    }
    public void deposit(double amount)
    {
        bal+=amount;
    }
    public boolean withdraw(double amount)
    {
        if(amount<=bal)
        {
            bal-=amount;
            return true;
      }
      else
      {
        System.out.println("Insufficient balance.withdraw failed");
        return false;
      }
    }
}
class Atm{
    private BankAccount userAccount;
    public Atm(BankAccount userAccount)
    {
        this.userAccount=userAccount;
    }
    public void display()
    {
        System.out.println("Menu:");
        System.out.println("1.Check Balance:");
        System.out.println("2.withdraw:");
        System.out.println("3.Deposit:");
        System.out.println("4.Exit:");

    }
    public void process(int option)
    {
        switch(option)
        {
           case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option . Please try again.");
        }
    }
    private void checkBalance()
    {
        double bal=userAccount.getbal();
           System.out.println("Your account balance is: $" + bal);
    }
    
    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            boolean success = userAccount.withdraw(amount);
            if (success) {
                System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getbal());
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the deposit amount: $");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: $" + userAccount.getbal());
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(1000);
        Atm atm = new Atm(userAccount);
        while (true) {
            atm.display();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter option (1-4): ");
            int option = scanner.nextInt();

            atm.process(option);
        }
    }
}
    