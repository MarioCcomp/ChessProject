package chess_project.model;

import chess_project.enums.*;
import javafx.util.Pair;

public abstract class Peca {
	private Pair<Integer, Integer> posicao;
	private Cor cor;
	private char id;
	
	public Peca (Integer n, Integer m, Cor cor, char id) {
		this.posicao = new Pair<Integer, Integer>(n, m);
		this.cor = cor;
		this.id = id;
	}
	
	public void printarPeca() {
		System.out.print(this.id);
	}
	
	
	
	
	public Pair<Integer, Integer> getPosicao() {
		return posicao;
	}

	public void setPosicao(Pair<Integer, Integer> posicao) {
		this.posicao = posicao;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public abstract void getMovimento();
}
