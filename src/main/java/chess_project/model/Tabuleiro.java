package chess_project.model;
import chess_project.enums.Cor;
import chess_project.model.pecas.*;

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
					System.out.print(this.casas[i][j].getId() + " ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
	
	public void movimentarPeca(int linhaIni, int colunaIni, int linhaFim, int colunaFim) {
		this.casas[linhaFim][colunaFim] = this.casas[linhaIni][colunaIni];
		this.casas[linhaIni][colunaIni] = null;
	}
	
	
}
