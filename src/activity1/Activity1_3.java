package activity1;

import java.util.Random;

public class Activity1_3 {
    public static int number;
    public static byte check =0;
    public static void main(String[] args) {
        Thread1 thread1= new Thread1();
        Thread2 thread2=new Thread2();
        thread1.start();
        thread2.start();
    }
}
class Thread1 extends Thread{
    @Override
    public void run() {
        while (true){
            if(Activity1_3.check==0){
                Random random = new Random();
                Activity1_3.number=random.nextInt(999)+1000;
                System.out.println("Thread "+currentThread().getName());
                Activity1_3.check=1;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
class Thread2 extends Thread{
    @Override
    public void run() {
        while(true){
            if(Activity1_3.check==1){
                if(Activity1_3.number%4==0||Activity1_3.number%400==0&&Activity1_3.number%100!=0){
                    System.out.println("năm "+Activity1_3.number+" : là năm nhuận");
                }else{
                    System.out.println("năm "+Activity1_3.number+" : không là năm nhuận");
                }
                Activity1_3.check=0;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
