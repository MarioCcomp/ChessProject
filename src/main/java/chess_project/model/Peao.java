package chess_project.model;

import java.util.*;	
import java.io.IOException;

import chess_project.enums.Cor;
import javafx.util.Pair;
import chess_project.model.Peca.*;

public class Peao extends Peca{
	
	public Peao(Integer n, Integer m, Cor time, char id) {
		super(n, m, time, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> getMovimento (Pair <Integer, Integer> posFinal) throws IOException {
	    ArrayList<Pair<Integer, Integer>> posicoes = new ArrayList<>();
	    //System.out.println("testetetetet");
	    
	    this.validarMovimento(posFinal);

	    
	    if (Math.abs(this.getPosicao().getKey() - posFinal.getKey()) == 2) {
	        int meio = (this.getPosicao().getKey() + posFinal.getKey()) / 2;
	        posicoes.add(new Pair<>(meio, posFinal.getValue()));
	    }

	    posicoes.add(posFinal);
	    return posicoes;
	}

	
	private void validarMovimento(Pair<Integer, Integer> posFinal) throws IOException {
        int deltaLinha = posFinal.getKey() - this.getPosicao().getKey();
        int deltaColuna = posFinal.getValue() - this.getPosicao().getValue();
        int direcao = (this.getTime() == Cor.BRANCAS) ? 1 : -1;

        // Movimento para frente
        if (deltaColuna == 0) {
            // Verifica direção correta
            if (deltaLinha * direcao <= 0) {
                throw new IOException("ERRO!! Peão não pode mover para trás.");
            }

            // Verifica quantidade de casas
            if (Math.abs(deltaLinha) > 2) {
                throw new IOException("Movimento incorreto!! não é possível andar mais de duas casas");
            }

            // Verifica movimento inicial de duas casas
            if (Math.abs(deltaLinha) == 2) {
                if ((this.getTime() == Cor.BRANCAS && this.getPosicao().getKey() != 1) || 
                    (this.getTime() == Cor.PRETAS && this.getPosicao().getKey() != 6)) {
                    throw new IOException("ERRO!! Peão só pode se movimentar duas unidades no primeiro movimento!!");
                }
            }
        } 
        // Movimento diagonal (captura)
        else if (Math.abs(deltaColuna) == 1) {
            // Deve mover apenas uma casa na direção correta
            if (deltaLinha != direcao) {
                throw new IOException("ERRO!! Movimento diagonal do peão deve ser uma casa na direção correta.");
            }
        } 
        // Movimento inválido
        else {
            throw new IOException("ERRO!! Movimento não permitido para o peão.");
        }
    }
}
