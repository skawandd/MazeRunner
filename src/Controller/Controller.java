package Controller;

import java.util.Scanner;

import model.Creature;
import model.Game;
import model.Square;
import model.creatures.Human;

public class Controller {
	Game game;

	public Controller(Game game) {
		this.game = game;
	}

	public void getKeyboard() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		char c = ' ';

		
		System.out.println(" I.Up	  K.Down    S.Dig-SW");
		System.out.println(" J.Left	  L.Right   F.Dig-SE");
		
		try {
			c = sc.nextLine().charAt(0);
		}catch (Exception e) {
			getKeyboard();
		}
	//	sc.close();

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

		if (board[y - 1][x].isFree()) {
		//	board[y - 1][x] = new Human(y-1, x, board[y - 1][x]);
			board[y - 1][x].addCreature(new Human(y-1, x));
			board[y][x].removeCreature(board[y][x].getHuman());
			game.setHumanY(y - 1);
			if(game.getBoard()[y - 1][x].getApple()) {
				game.powerUp();
				game.getBoard()[y - 1][x].removeApple();
			}
		}
		Creature c = board[game.getHumanY()][game.getHumanX()].getHuman();
		game.applyGravity(c);
	}

	public void move_down() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();

		if (board[y + 1][x].isFree()) {
		//	board[y + 1][x] = new Human(y+1, x, board[y + 1][x]);
			board[y + 1][x].addCreature(new Human(y+1, x));
			board[y][x].removeCreature(board[y][x].getHuman());
			game.setHumanY(y+1);
			if(game.getBoard()[y + 1][x].getApple()) {
				game.powerUp();
				game.getBoard()[y - 1][x].removeApple();
			}
		}
		Creature c = board[game.getHumanY()][game.getHumanX()].getHuman();
		game.applyGravity(c);
	}

	public void move_right() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();
		
		if (board[y][x + 1].isFree()) {
		//	board[y][x + 1] = new Human(y, x+1, board[y][x + 1]);
			board[y][x + 1].addCreature(new Human(y, x+1));
			board[y][x].removeCreature(board[y][x].getHuman());
			game.setHumanX(x+1);
			if(game.getBoard()[y][x + 1].getApple()) {
				game.powerUp();
				game.getBoard()[y][x + 1].removeApple();
			}
		}
		Creature c = board[game.getHumanY()][game.getHumanX()].getHuman();
		game.applyGravity(c);
	}

	public void move_left() {
		Square[][] board = game.getBoard();
		int x = game.getHumanX();
		int y = game.getHumanY();

		if (board[y][x - 1].isFree()) {
		//	board[y][x - 1] = new Human(y, x-1, board[y][x - 1]);
			board[y][x - 1].addCreature(new Human(y, x-1));
			board[y][x].removeCreature(board[y][x].getHuman());
			game.setHumanX(x- 1);
			if(game.getBoard()[y][x - 1].getApple()) {
				game.powerUp();
				game.getBoard()[y][x - 1].removeApple();
			}
		}
		Creature c = board[game.getHumanY()][game.getHumanX()].getHuman();
		game.applyGravity(c);
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
