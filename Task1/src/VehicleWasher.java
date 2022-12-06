import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleWasher {
    enum Type {Car,SUV, Truck, MiniBus}
    private Queue<Vehicle> washerLine, wash, washed_v[];
    Semaphore full = new Semaphore(0);
    Semaphore empty;
    Lock lock_line = new ReentrantLock();
    Lock lock_wash = new ReentrantLock();

   


    public VehicleWasher(int size){
        this.washerLine = new Queue<>();
        wash = new Queue<>();
        washed_v = new Queue[4];
        empty = new Semaphore(5, true);


        for(int i=0; i<washed_v.length; i++)
            washed_v[i] = new Queue<>();
    }
    public Queue<Vehicle> getWasherLine() {
        return washerLine;
    }

    public void getInLine(Vehicle vehicle) {
       
        try {
            empty.acquire();
            System.out.println("in line: "+vehicle);
            lock_line.lock();
            washerLine.enQueue(vehicle);
            lock_line.unlock();
            full.release();
            System.out.println("line->"+washerLine);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public void getInWash(Vehicle vehicle) {
        try {
            full.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock_line.lock();
        System.out.println("out of line:"+ vehicle);
        Vehicle temp = washerLine.deQueue();
        System.out.println(temp);
        lock_line.unlock();
        

        System.out.println("inwash->line queue: "+washerLine);
    
        lock_wash.lock();
        System.out.println("in wash: "+ vehicle);
        wash.enQueue(temp);
        lock_wash.unlock();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("wash queue: "+wash);

        empty.release();

        lock_wash.lock();
        System.out.println("out wash: "+ vehicle);
        Vehicle temp2 = wash.deQueue();
        lock_wash.unlock();

        synchronized(washed_v){
        washed_v[Type.valueOf(temp2.getClass().getSimpleName()).ordinal()].enQueue(temp2);
        }
           

    }
    public Queue<Vehicle>[] getWashed_v() {
        return washed_v;
    }

}
