package creational.factorymethod;


public class Client {

    public static void main(String [] args){

    	Transport vehicle = new Transport();
    	System.out.println(vehicle.drive());
    	
    	Transport vehicle2 = new Car();
    	System.out.println(vehicle2.drive());
    	
    }
	
}
