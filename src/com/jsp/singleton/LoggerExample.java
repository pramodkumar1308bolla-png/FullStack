package com.jsp.singleton;

class Logger{
	private static Logger instance;
	private Logger() {
		System.out.println("Logger Created");
	}
	public static Logger getInstance() {
		if(instance==null) {
			instance=new Logger();
		}
		return instance;
	}
	public void log(String message) {
		
	}
}

public class LoggerExample {

	public static void main(String[] args) {
		

	}

}
