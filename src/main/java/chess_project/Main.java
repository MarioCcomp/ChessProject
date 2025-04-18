package chess_project;
import chess_project.model.*;
import chess_project.enums.*;
import javafx.util.Pair;


public class Main {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.movimentarPeca(new Pair<Integer, Integer>(6, 5), new Pair<Integer, Integer>(6, 5));
		
	}
}
