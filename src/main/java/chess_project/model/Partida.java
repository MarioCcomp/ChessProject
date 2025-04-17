package chess_project.model;

import chess_project.enums.*;

public class Partida {
	private Tabuleiro tabuleiro;
	private Jogador jogadorAtual;
	
	public Partida (Tabuleiro tabuleiro, Jogador jogadorAtual) {
		this.tabuleiro = tabuleiro;
		this.jogadorAtual = jogadorAtual;
	}
}
