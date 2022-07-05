package TestingAcademy;

public class StaticVar {

	String name;
	String address;// these are instance variables as these are tied up to object 
	//and asssigned automatically when an onject crested everytime
	
	static String city; // This variable is not changed
	//for every instance object creation and it belongs to class
	static int i;
	
	static {
		city="bangalore";
		i=0;
	}
	
	StaticVar(String name, String address){ // variables coming from here are local variable
		this.name=name;
		this.address=address;
		i++;
		System.out.println(i);
		
	}
	
	public void getAddress() {
		System.out.println(address+" "+city);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Cannot create object outside of void main
		
		StaticVar obj=new StaticVar("Bob","Marthahalli");
		StaticVar obj1=new StaticVar("mary","jay nagar");
		obj.getAddress();
		obj1.getAddress();
		//Static methods can be directly called using class name
		StaticVar.getCity();
		StaticVar.i=4;
		
		
	}
	// Static methods takes only static variables
	public static void getCity() {
		
	}


}
