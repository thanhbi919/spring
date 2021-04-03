package activity1;

import java.util.*;

public class Activity1_4 {
    public static Map<String,String> map = new HashMap<>();
    public static String vn[] =new String[7];
    public static String english = new String();
    public static int check=0;
    public static void main(String[] args) {
        map.put("Monday", "Thứ 2");
        map.put("Tuesday","Thứ 3");
        map.put("Wednesday","Thứ 4");
        map.put("Thursday","Thứ 5");
        map.put("Friday", "Thứ 6");
        map.put("Saturday","Thứ 7");
        map.put("Sunday","Chủ nhật");
        Set<String> set =map.keySet();
        vn = set.toArray(new String[0]);
        RamdomDay ramdomDay = new RamdomDay();
        CheckDay checkDay= new CheckDay();
        ramdomDay.start();
        checkDay.start();
    }
}
class RamdomDay extends Thread{
    @Override
    public void run() {
        while(true){
            if(Activity1_4.check==0){
                Random rd= new Random();
                int lucky= rd.nextInt(6);
                Activity1_4.english = Activity1_4.vn[lucky];
                System.out.print(Activity1_4.english+": ");
                Activity1_4.check=1;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
class CheckDay extends Thread{
    synchronized void checkDay(){
        System.out.println(Activity1_4.map.get(Activity1_4.english));
    }
    @Override
    public void run() {
        while (true){
            if(Activity1_4.check==1){
                checkDay();
                Activity1_4.check=0;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}