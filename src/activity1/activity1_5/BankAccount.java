package activity1.activity1_5;

public class BankAccount {
    private long amount=20000000;

    public BankAccount() {
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
    public synchronized void withDraw(String threadName,long withdrawAmount){
        System.out.println(threadName+" needs: "+withdrawAmount);
        if(amount<withdrawAmount){
            System.out.println(threadName+" withdraw error!");
        }else{
            amount=amount-withdrawAmount;
            System.out.println(threadName+" withdraw success: "+withdrawAmount);
        }

        System.out.println(threadName+" see balance: "+ amount);
    }
}
