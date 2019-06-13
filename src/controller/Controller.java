package controller;

import java.util.Scanner;

import model.Game;
import model.Square;

public class Controller {
	Game game;

	public Controller(Game game) {
		this.game = game;
	}

	public void getKeyboard() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char c = ' ';

		
		System.out.println(" I.Up	  K.Down    S.Dig-SW | Power: " + game.getPower());
		System.out.println(" J.Left	  L.Right   F.Dig-SE | Moves: " + game.getMoves());
		
		try {
			c = sc.nextLine().charAt(0);
		}catch (Exception e) {
			getKeyboard();
		}
	//	sc.close(); //FIXME
		game.incrtMoves();
		if(c == 'i' || c == 'I')
			move_up();
		else if(c == 'k' || c == 'K')
			move_down();
		else if(c == 'j' || c == 'J')
			move_left();
		else if(c == 'l' || c == 'L')
			move_right();
		else if(c == 's' || c == 'S')
			dig_sw();
		else if(c == 'f' || c == 'F')
			dig_se();
		else if(c == 'n' || c == 'N') //FIXME Next level
			System.exit(0);
		else if(c == 'q' || c == 'Q')
			System.exit(0);
		else 
			getKeyboard();
	}

	public void move_up() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();

		game.move(board[y][x].getHuman(), y-1, x);
	}

	public void move_down() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();

		game.move(board[y][x].getHuman(), y+1, x);
	}

	public void move_right() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();
		
		game.move(board[y][x].getHuman(), y, x+1);
	}

	public void move_left() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();

		game.move(board[y][x].getHuman(), y, x-1);
	}

	public void dig_sw() {
		int x = game.getHumanX();
		int y = game.getHumanY();
		
		if(game.getPower() > 0 && game.getBoard()[y+1][x-1].isBrick() 
			&& game.getBoard()[y][x-1].isFree() && !game.getBoard()[y+1][x-1].isDig()) {
			game.getBoard()[y+1][x-1].addDig();
			game.powerDown();
		}
		
	}

	public void dig_se() {
		int x = game.getHumanX();
		int y = game.getHumanY();
		
		if(game.getPower() > 0 && game.getBoard()[y+1][x+1].isBrick() 
			&& game.getBoard()[y][x+1].isFree() && !game.getBoard()[y+1][x+1].isDig()) {
			game.getBoard()[y+1][x+1].addDig();
			game.powerDown();
		}
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
