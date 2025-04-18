package chess_project.model;

import java.util.*;	

import chess_project.enums.Cor;
import javafx.util.Pair;
import chess_project.model.Peca.*;

public class Peao extends Peca{
	
	public Peao(Integer n, Integer m, Cor time, char id) {
		super(n, m, time, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> getMovimento (Pair <Integer, Integer> posFinal) {
	    ArrayList<Pair<Integer, Integer>> posicoes = new ArrayList<>();

	    if (!this.validarMovimento(posFinal)) {
	        return posicoes; 
	    }

	    
	    if (Math.abs(this.getPosicao().getKey() - posFinal.getKey()) == 2) {
	        int meio = (this.getPosicao().getKey() + posFinal.getKey()) / 2;
	        posicoes.add(new Pair<>(meio, posFinal.getValue()));
	    }

	    posicoes.add(posFinal);
	    return posicoes;
	}

	
	private Boolean validarMovimento (Pair<Integer, Integer> posFinal) {
		if (this.getPosicao().getKey() - posFinal.getKey() > 2) {
			System.out.println("Movimento incorreto!! não é possível andar mais de duas casas");
			return false;
		}
		
		if (this.getPosicao().getKey() != 6 && this.getPosicao().getKey() - posFinal.getKey() >= 2) {
			System.out.print("ERRO!! Peão só pode se movimentar duas unidades no primeiro movimento!!");
			return false;
		}
		
		if ((this.getPosicao().getValue() != posFinal.getValue()) && (this.getPosicao().getKey() <= posFinal.getKey() )) {
			System.out.println ("ERRO!! Você não pode voltar com um  peão!!");
			return false;
		}
		// tentativa de mover um peao mais de uma casa na diagonal
		if (posFinal.getValue() - this.getPosicao().getValue() > 1 || this.getPosicao().getValue() - posFinal.getValue() > 1) {
			System.out.println("ERRO!! movimento não segue as regras do jogo!!");
			return false;
		}
		if (posFinal.getKey() >= this.getPosicao().getKey()) {
			System.out.println("movimento incorreto!!");
			return false;
		}
//		if (posFinal.getKey() - this.getPosicao().getKey() >= 1 ) {
//			System.out.println("Voce nao pode voltar!!");
//			return false;
//		}
		
	return true;
	}
}
