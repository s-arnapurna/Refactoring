Patterns-> Strategy , Observer

Strategy

Payment -> creditcard,debit

interface PaymentSTrategy{
		processPayment();
}

class CreditCard implements PaymentSTrategy{
 String CreditCardNumber;
 String cardHolderName;
 
 CreditCard(String CreditCardNumber, String cardHolderName){
 this.CreditCardNumber = CreditCardNumber;
 this.cardHolderName = cardHolderName;
 }

 processPayment(){
 	sout("Processing payment viosa credit card");
 }
}

class DebitCard implements PaymentSTrategy{
	processPayment(){
  sout("Processding payment via Debit card")
  }
}

class PaymentService{
	PaymentStrategy strategy;
  PaymentService(PaymentStrategy strategy){
  this.strategy = strategy;
  
  }
  
  public void pay(){
  	strategy.processPayment();
  }
 	
}



class Booking{
 psvm(Sa){
 	CreditCard creditCard = new CreditCard("3446748","mansi");
 	PaymentService service = new PaymentService();
  service.pay();
  
  PaymentService service = new PaymentService(new DebitCard);
  service.pay();
  
  
 }
 
 
 ----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Observer pattern


clarify Questions: do we need to send an email or is it like a list of services like email,push,sms is given

request, response time
totaLtme - send alrt to owner


class ApiTimeMonitor{
	recordRequestTime();
  recordResponseTime();
}


class Controller{


	@RestTemplate
	@Get("/getanswer")
	public void getAnswer(){
		recordRequestTime();
  	service.execute();
		responseRequestTime();
  }
}

class Subject{

 attach();
 detach();
 notify(Microservice service, Owner owner);
 
}


class MonitorService{

 List<Microservices> services;
 List<Owner> owners;
}

WeatherStation -> list of devices Mobile, Laptop, Tablet, 
temp -26


class WeatherStation{
 void notify();
 List<Device> list;
 
 
 WeatherStation(Temperature temp){
 this.temp = temp;
 this.list = new ArrayList<>();
 }
 
 attach(Device device){
 list.add(device);
 
 }
 detach(){
 
 }
 notify(){
 	for(List<Observer> obs: list){
     obs.notify();
 }
 	
}


interface Device{

}
class Mobile implememnts Device{

}
class Laptop implements device{

}




interface WeatherStation{

	void attach();
  void detach();
  void notify();
}



class Temperature{
	Double degree;
  String unit;
}

class MonitoringDevice implements Subject{
private Temperature temp;
List<Observer> list;

	MonitoringDevice(Temperature temp){
  	this.temp = temp;
    list = new ArrayList();
  }
  
  void attach(Observer obs){
  	list.add(obs);
  }
  void detach(Observer obs){
  	list.remove(obs);
  }
  
  
	@Override
	void notifyObservers(){
  	//send current tempearture
    for(List<Observer> obs: list){
     obs.update();
    
    }        
  }		
}
 

interface Device{
	void update(Temperature temp);
	
}

class Mobile implements Device{
int deviceId;
String ip;
D1(int id, String ip){

}

	@Override
	void update(Temperature temp){
  	//Use the temp;
  }
  
}


class Main{
	Temperature temp = new Temperature("65","C");
	MonitoringDevice monitor = new MonitoringDevice(temp);
  Device mobile = new Mobile("123","12.134.56.123");
	Device laptop = new Laptop("123","12.134.56.123");
	monitor.attach(mobile);
	monitor.attach(laptop);
	monitor.notify();
}




