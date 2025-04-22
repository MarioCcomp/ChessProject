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
		
		Cavalo cavaloBrancas1 = new Cavalo(0, 1, Cor.BRANCAS, 'C');
		Cavalo cavaloBrancas2 = new Cavalo(0, 6, Cor.BRANCAS, 'C');
		
		Cavalo cavaloPretas1 = new Cavalo(7, 1, Cor.PRETAS, 'C');
		Cavalo cavaloPretas2 = new Cavalo(7, 6, Cor.PRETAS, 'C');
		
		this.casas[0][1] = cavaloBrancas1;
		this.casas[0][6] = cavaloBrancas2;
		
		this.casas[7][1] = cavaloPretas1;
		this.casas[7][6] = cavaloPretas2;
		
		
		
		Torre torreBrancas1 = new Torre(0, 0, Cor.BRANCAS, 'T');
		Torre torreBrancas2 = new Torre(0, 7, Cor.BRANCAS, 'T');
		
		Torre torrePretas1 = new Torre(7, 0, Cor.PRETAS, 'T');
		Torre torrePretas2 = new Torre(7, 7, Cor.PRETAS, 'T');
		
		this.casas[0][0] = torreBrancas1;
		this.casas[0][7] = torreBrancas2;
		
		this.casas[7][0] = torrePretas1;
		this.casas[7][7] = torrePretas2;
		
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

		
		
		if(casas[posAtual.getKey()][posAtual.getValue()].getCor() != cor) {
			throw new IOException("vc nao pode mexer a peca do outro timeee");
		}
		Peca peca = casas[posAtual.getKey()][posAtual.getValue()];
		ArrayList<Pair<Integer, Integer>> trajeto = peca.getMovimento(posFinal, cor);
		
		
		
		
		if(peca.getClass().equals(Peao.class)) {
			this.validarPeao(posAtual, posFinal, cor);
			
		}
		
		if(peca.getClass().equals(Cavalo.class)) {
			this.validarCavalo(posAtual, posFinal, cor);
		}
		
		if(peca.getClass().equals(Torre.class)) {
			this.validarTorre(posAtual, posFinal, cor, trajeto);
		}
		
		
		for(Pair<Integer, Integer> par : trajeto) {
			System.out.println("(" + par.getKey() + ", " + par.getValue() + ") ");
		}
		
		
		
	}
	
	private void validarPeao(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal, Cor cor) throws IOException {
		
		if(posFinal.getValue() != posAtual.getValue()) { // se a pos final diz que o peao mudou de coluna
			if(casas[posFinal.getKey()][posFinal.getValue()] != null && casas[posFinal.getKey()][posFinal.getValue()].getCor() != cor) { // se a posicao final nao for nula e nao for da mesma cor, o peao come oq tava la
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
	
	private void validarCavalo(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal, Cor cor) throws IOException {
		if(this.casas[posFinal.getKey()][posFinal.getValue()] != null && this.casas[posFinal.getKey()][posFinal.getValue()].getCor() == cor) {
			throw new IOException("vc nao pode ocmer alguem do seu time ne chefe");
		}
		Cavalo cavalo = (Cavalo) casas[posAtual.getKey()][posAtual.getValue()];
		casas[posFinal.getKey()][posFinal.getValue()] = cavalo;
		casas[posAtual.getKey()][posAtual.getValue()] = null;
		cavalo.setPosicao(posFinal);
		
	}
	
	private void validarTorre(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal, Cor cor, ArrayList<Pair<Integer, Integer>> trajeto) throws IOException {
		int linhaFinal = posFinal.getKey();
		int colunaFinal = posFinal.getValue();
		if(casas[linhaFinal][colunaFinal] != null && casas[linhaFinal][colunaFinal].getCor() == cor) {
			throw new IOException("vc nao pode comer alguem do seu time");
		}
		
		int tamanhoArray = trajeto.size();
		for(int i = 0; i < tamanhoArray; i++) {
			int linha = trajeto.get(i).getKey();
			int coluna = trajeto.get(i).getValue();
			if(casas[linha][coluna] != null && i != tamanhoArray - 1) {
				throw new IOException("tem uma peca no caminho chefe");
			}
		}
		
		int linhaInicial = posAtual.getKey();
		int colunaInicial = posAtual.getValue();
		
		
		
		
		Torre torre = (Torre) casas[linhaInicial][colunaInicial];
		
		casas[linhaInicial][colunaInicial] = null;
		torre.setPosicao(posFinal);
		casas[linhaFinal][colunaFinal] = torre;
		
		
	}
	
	
}
