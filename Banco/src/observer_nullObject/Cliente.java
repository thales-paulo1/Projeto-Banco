package observer_nullObject;

import nullObject.ClienteAbstrato;
import observer.Observable;
import observer.Observer;

public class Cliente extends ClienteAbstrato implements Observer{

	private String name;

	public Cliente(String name) {
		super();
		this.name = name;
	}

	public void notify(Observable observable, String message) {
		System.out.println(name + " você tem uma notificação do banco " + observable + ": " + message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
