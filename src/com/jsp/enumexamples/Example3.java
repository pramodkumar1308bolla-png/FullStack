package com.jsp.enumexamples;

enum Trafic{
	RED,GREEN,YELLOW
}

public class Example3 {

	public static void main(String[] args) {
		Trafic light=Trafic.YELLOW;
		switch(light) {
		case GREEN:
			System.out.println("Go");
			break;
		case RED:
			System.out.println("Stop");
			break;
		case YELLOW:
			System.out.println("Get ready");
			
		}
		
	}

}
