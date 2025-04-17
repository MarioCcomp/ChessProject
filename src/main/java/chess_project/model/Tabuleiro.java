package chess_project.model;
import chess_project.enums.Cor;
import chess_project.model.pecas.*;
import java.util.ArrayList;

import javafx.util.Pair;

public class Tabuleiro {
	private Peca[][] casas = new Peca[8][8];
	
	public Tabuleiro() {
		
		for(int i = 0; i < 8; i++) {
			Peao peao = new Peao(1, i, Cor.BRANCAS, 'P');
			casas[1][i] = peao;
			Peao peao2 = new Peao(6, i, Cor.PRETAS, 'P');
			casas[6][i] = peao2;
		}
	}
	
	public void printarTabuleiro() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(this.casas[i][j] != null) {
					System.out.print(this.casas[i][j].getId() + "\t");
				}
				else {
					System.out.print(".\t");
				}
			}
			System.out.println();
		}
	}
	
	public void movimentarPeca(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal) {
		Peca peca = casas[posAtual.getKey()][posAtual.getValue()];
		ArrayList<Pair<Integer, Integer>> trajeto = peca.getMovimento(posFinal);
		if(trajeto.isEmpty()) {
			System.out.println("alguma verificacao na peca falhou");
			return;
		}
		for(Pair<Integer, Integer> par : trajeto) {
			System.out.println("(" + par.getKey() + ", " + par.getValue() + ") ");
		}
		
		if(peca.getClass().equals(Peao.class)) {
			this.validarPeao(posAtual, posFinal);
		}
		
		
	}
	
	private void validarPeao(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal) {
		
		if(posFinal.getValue() != posAtual.getValue()) { // se a pos final diz que o peao mudou de coluna
			if(casas[posFinal.getKey()][posFinal.getValue()] != null) { // se a posicao final nao for nula, o peao come oq tava la
				System.out.println("peao come1");
				return;
			}
			else {
				System.out.println("vc nao pode vir pra ca1"); // se for nula, o peao nao pode ir pra la
				return;
			}
		}
		
		
		
		
	}
	
	
}
