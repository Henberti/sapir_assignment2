public abstract class Vehicle  implements Runnable{
    private final int LICENSE;
    private VehicleWasher vehicleWasher;
    protected VehicleLogger log;


    public Vehicle(int license, VehicleWasher vehicleWasher, VehicleLogger log ){
        this.LICENSE = license;
        this.vehicleWasher = vehicleWasher;
        this.log = log;
    }


    @Override
    public void run() {
        vehicleWasher.getInLine(this);
        vehicleWasher.getInWash(this);
        log.printLog(this);
        
    }

    @Override
    public String toString() {
        return ""+LICENSE;
    }
    public int getLICENSE() {
        return LICENSE;
    }




    
    
}
