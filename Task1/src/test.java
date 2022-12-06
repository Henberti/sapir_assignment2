import java.io.File;

public class test {
    public static long time = System.currentTimeMillis();
    public static void main(String[] args) {

        File f = new File("VehicleLogger.txt");

        VehicleLogger vl = new VehicleLogger(f);

       

       VehicleWasher s = new VehicleWasher(4);
        Thread t1 = new Thread(new Car(1, s, vl));
        Thread t2 = new Thread(new Car(2, s, vl));//-
        Thread t3 = new Thread(new Truck(3, s, vl));
        Thread t4 = new Thread(new MiniBus(4, s, vl));
        Thread t5 = new Thread(new Car(5, s, vl));
        Thread t6 = new Thread(new SUV(6, s, vl));
        Thread t7 = new Thread(new Truck(7, s, vl));
        Thread t8 = new Thread(new SUV(8, s, vl));
        Thread t9 = new Thread(new Car(9, s, vl));//+
        Thread t10 = new Thread(new Truck(10, s, vl));
        Thread t11 = new Thread(new MiniBus(11, s, vl));
        Thread t12 = new Thread(new Truck(12, s, vl));

        

    



   

    

       

        

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i=0; i<s.getWashed_v().length; i++){
            System.out.println(s.getWashed_v()[i]);
        }

        vl.getPw().close();

        
       
        
       
        
    }
}
