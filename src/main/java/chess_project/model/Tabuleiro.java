package chess_project.model;

import java.nio.channels.Pipe.SourceChannel;
import java.io.IOException;

import chess_project.enums.Cor;
import chess_project.model.Peao.*;
import chess_project.model.Peca;
import javafx.util.Pair;
import java.util.*;

public class Tabuleiro {
	private Peca[][] casas = new Peca[8][8];
	
	public Tabuleiro() {
		for (int i = 0; i < 8; i++) {
			Peao peao = new Peao(1, i, Cor.BRANCAS, 'P');
			Peao peao2 = new Peao(6, i, Cor.PRETAS, 'P');
			casas[1][i] = peao;
			casas[6][i] = peao2;
		}
			
	}
	
	public void printarTabuleiro() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (casas[i][j] == null) {
						System.out.print("\t ." );
				}
				else {
					System.out.print("\t" + casas[i][j].getId());
				}
			}
			System.out.println();
			System.out.println();
		}
	}
	
	
	public void movimentarPeca(Pair<Integer, Integer> posAtual, Pair<Integer, Integer> posFinal) throws IOException {
	    Peca peca = casas[posAtual.getKey()][posAtual.getValue()];
	    if (peca == null) return;
	    ArrayList <Pair<Integer, Integer>> trajeto = peca.getMovimento(posFinal);
	    if (trajeto.isEmpty()) {
	    	return;
	    }
	    
	    // Validação específica para peões
	    if (peca instanceof Peao) {
	        this.validarPeao(posFinal, posAtual);
	    }

	    // Restante da lógica (atualiza matriz)
	    casas[posFinal.getKey()][posFinal.getValue()] = peca;
	    casas[posAtual.getKey()][posAtual.getValue()] = null;
	    peca.setPosicao(posFinal);
	}
	
	
	private void validarPeao(Pair<Integer, Integer> posFinal, Pair<Integer, Integer> posAtual) throws IOException {
	    Peca peca = casas[posAtual.getKey()][posAtual.getValue()];
	    int diffColuna = Math.abs(posFinal.getValue() - posAtual.getValue());

	    // Movimento reto (nao pode ter peca no destino)
	    if (diffColuna == 0 && casas[posFinal.getKey()][posFinal.getValue()] != null) {
	    	throw new IOException("ERRO! Peão não pode capturar para frente."); 
	    }

	    // Movimento diagonal deve ter peça adversaria
	    if (diffColuna == 1) {
	        Peca pecaAlvo = casas[posFinal.getKey()][posFinal.getValue()];
	        if (pecaAlvo == null || pecaAlvo.getTime() == peca.getTime()) {
	        	throw new IOException("ERRO! Só pode mover na diagonal para capturar.");
	        }
	    } 
	}
	
	public Peca getPeca(Pair<Integer, Integer> posicao) {
	    return casas[posicao.getKey()][posicao.getValue()];
	}
}
