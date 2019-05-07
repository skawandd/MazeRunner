package Controller;

import java.util.Scanner;

public class Controller {
	
	public Controller() {
		
	}
	
	public char getKeyboard() {
		Scanner sc = new Scanner(System.in);
		char c = ' ';
		
		while(c != 'i' && c != 'k' && c != 'j' && c != 'l' && c != 's' && c != 'f' 
		   && c != 'I' && c != 'K' && c != 'J' && c != 'L' && c != 'S') {
			System.out.println("I.Up	  K.Down");
			System.out.println("J.Left	  L.Right");
			System.out.println("S.Dig-SW  F.Dig-SE");
			
			c = sc.nextLine().charAt(0);
		}
		sc.close();
		return c;
	}
}
