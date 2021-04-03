package activity1.activity1_5;

public class Main {
    private static BankAccount bankAccount= new BankAccount();
    public static void main(String[] args) {
        WithdrawThread husbandThread = new WithdrawThread("husband",bankAccount,25000000);
        husbandThread.start();
        WithdrawThread wifeThread = new WithdrawThread("wife",bankAccount,5000000);
        wifeThread.start();
    }
}
