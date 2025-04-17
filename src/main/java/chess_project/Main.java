package chess_project;
import chess_project.model.*;
import chess_project.enums.*;



public class Main {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.movimentarPeca(1, 0, 3, 0);
		
		tabuleiro.printarTabuleiro();
	}
}
