package chess_project.model;
import chess_project.enums.Cor;
import chess_project.model.pecas.*;

import java.io.IOException;
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
			System.out.println();
		}
	
	}
	
	public void movimentarPeca(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal, Cor cor) throws IOException {
		if(casas[posAtual.getKey()][posAtual.getValue()] == null) {
			throw new IOException("deu nulo no atual");
		}
		
		
		if(casas[posAtual.getKey()][posAtual.getValue()].getCor() != cor) {
			throw new IOException("vc nao pode mexer a peca do outro timeee");
		}
		Peca peca = casas[posAtual.getKey()][posAtual.getValue()];
		ArrayList<Pair<Integer, Integer>> trajeto = peca.getMovimento(posFinal, cor);
		
		
		
		
		if(peca.getClass().equals(Peao.class)) {
			this.validarPeao(posAtual, posFinal);
			
		}
		
		for(Pair<Integer, Integer> par : trajeto) {
			System.out.println("(" + par.getKey() + ", " + par.getValue() + ") ");
		}
		
		
		
	}
	
	private void validarPeao(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal) throws IOException {
		
		if(posFinal.getValue() != posAtual.getValue()) { // se a pos final diz que o peao mudou de coluna
			if(casas[posFinal.getKey()][posFinal.getValue()] != null) { // se a posicao final nao for nula, o peao come oq tava la
				Peca peao = casas[posAtual.getKey()][posAtual.getValue()];
				casas[posAtual.getKey()][posAtual.getValue()] = null;
				casas[posFinal.getKey()][posFinal.getValue()] = peao;
				casas[posFinal.getKey()][posFinal.getValue()].setPosicao(posFinal);
				return;
			}
			else {
						// se for nula, o peao nao pode ir pra la
				throw new IOException("vc njao pode vir pra ca");
			}
		}
		else if(casas[posFinal.getKey()][posFinal.getValue()] != null){
			throw new IOException("vc nao pode atravessar a peca seu burroo");
		}
		Peca peao = casas[posAtual.getKey()][posAtual.getValue()];
		casas[posAtual.getKey()][posAtual.getValue()] = null;
		casas[posFinal.getKey()][posFinal.getValue()] = peao;
		casas[posFinal.getKey()][posFinal.getValue()].setPosicao(posFinal);
		
		
	}
	
	
}
