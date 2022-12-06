import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VehicleLogger {
    Lock lock_time = new ReentrantLock(true);
    Lock lock_file = new ReentrantLock(true);
    Scanner s;
    PrintWriter pw;
    File f;

    public VehicleLogger(File file){
        this.f = file;
        try {
            pw = new PrintWriter(f);
            s = new Scanner(f);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
    public void printLog(Vehicle vehicle){
        long time;
        lock_time.lock();
        time =System.currentTimeMillis() - test.time;
        lock_time.unlock();
        lock_file.lock();
        pw.print("time pass from start: ");
        pw.print(time);
        pw.print("  license number: ");
        pw.println(vehicle.getLICENSE());
        lock_file.unlock();
        
    }

    public PrintWriter getPw() {
        return pw;
    }

}
