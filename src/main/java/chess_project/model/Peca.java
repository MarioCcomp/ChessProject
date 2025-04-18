package chess_project.model;
import javafx.util.Pair;

import java.util.ArrayList;

import chess_project.enums.*;

public abstract class Peca {
	private Pair<Integer, Integer> posicao;
	private Cor time;
	private char id;
	
	public Peca(Integer n, Integer m, Cor time, char id) {
		this.posicao = new Pair<> (n, m);
		this.time = time;
		this.id = id;
	}
	
	
	
	
	public Pair<Integer, Integer> getPosicao() {
		return posicao;
	}




	public void setPosicao(Pair<Integer, Integer> posicao) {
		this.posicao = posicao;
	}




	public Cor getTime() {
		return time;
	}




	public void setTime(Cor time) {
		this.time = time;
	}




	public char getId() {
		return id;
	}




	public void setId(char id) {
		this.id = id;
	}




	public abstract ArrayList<Pair<Integer, Integer>> getMovimento (Pair <Integer, Integer> posFinal) ; 
}
