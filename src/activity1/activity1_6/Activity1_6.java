package activity1.activity1_6;
public class Activity1_6 {
    public static int maxTotalDivisor =0;//tổng số ước của số có nhiều ước nhất
    public static int i=0;//lưu số có nhiều ước nhất

    public static void main(String[] args) {
        countDivisor countDivisor= new countDivisor();
        Threading threading1 = new Threading(1,20000,countDivisor);
        Thread threading2 = new Thread(new Threading(20001,40000,countDivisor));
        Thread threading3 = new Thread(new Threading(40001,60000,countDivisor));
        Thread threading4 = new Thread(new Threading(60001,80000,countDivisor));
        Thread threading5 = new Thread(new Threading(80001,100000,countDivisor));
        threading1.start();
        threading2.start();
        threading3.start();
        threading4.start();
        threading5.start();
    }

}

class countDivisor{
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
    }

    synchronized int countDivisor(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }
}
class Threading extends Thread{
    private int startNumber;
    private int endNumber;
    private countDivisor countDivisor= new countDivisor();

    public Threading(int startNumber, int endNumber, activity1.activity1_6.countDivisor countDivisor) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.countDivisor = countDivisor;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }


    @Override
    public void run() {
        for(int j=this.startNumber;j<=this.endNumber;j++){
            int x= this.countDivisor.countDivisor(j);
            if(Activity1_6.maxTotalDivisor<x) {
                Activity1_6.maxTotalDivisor = x;
                Activity1_6.i = j;
            }
            this.countDivisor.setCount(0);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName());
        System.out.println("số ước lớn nhât là: "+Activity1_6.maxTotalDivisor +" của số "+Activity1_6.i);
    }
}


