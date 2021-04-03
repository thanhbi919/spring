package activity1.activity1_5;

public class WithdrawThread  extends Thread {
    private String name;
    private BankAccount bankAccount = new BankAccount();
    private long withdrawAmount ;

    public  WithdrawThread(String name, BankAccount bankAccount, long withdrawAmount) {
        this.name = name;
        this.bankAccount = bankAccount;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        bankAccount.withDraw(name,withdrawAmount);
    }
}
