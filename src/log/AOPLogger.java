package log;

import models.Contact;

public class AOPLogger {
	
	public void log(Contact contact) {
		System.out.println("AOP Logger : before removing " + contact);
	}

}
