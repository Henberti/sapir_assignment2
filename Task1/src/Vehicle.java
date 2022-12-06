public abstract class Vehicle  implements Runnable{
    private final int LICENSE;
    private VehicleWasher vehicleWasher;


    public Vehicle(int license, VehicleWasher vehicleWasher){
        this.LICENSE = license;
        this.vehicleWasher = vehicleWasher;
    }


    @Override
    public void run() {
        vehicleWasher.getInLine(this);
        vehicleWasher.getInWash(this);
        
    }

    @Override
    public String toString() {
        return ""+LICENSE;
    }




    
    
}
