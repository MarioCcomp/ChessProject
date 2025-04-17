package chess_project.model.pecas;

import java.util.*;

import chess_project.enums.*;
import chess_project.model.Peca;
import javafx.util.Pair;

public class Peao extends Peca{
	Boolean enPassant = false;
	
	
	public Peao(int n, int m, Cor cor, char id) {
		super(n, m, cor, id);
		
	}
	
	@Override
	public ArrayList<Pair<Integer, Integer>> getMovimento(Pair<Integer, Integer> posFinal) {
		if(this.validarMovimento(posFinal)) {
		ArrayList<Pair<Integer, Integer>> posicoes = new ArrayList<Pair<Integer, Integer>>();
		if(this.getPosicao().getKey() - posFinal.getKey() > 1) {  // se o peao andou 2 casas
			posicoes.add(new Pair<Integer, Integer>(this.getPosicao().getKey() - 1, this.getPosicao().getValue())); // passo a casa acima dele
			posicoes.add(posFinal);  // passo a casa final
			return posicoes;
		}
		posicoes.add(posFinal);
		return posicoes;
		}
		
		ArrayList<Pair<Integer, Integer>> posicoes = new ArrayList<Pair<Integer, Integer>>();
		return posicoes;
	
		
	}
	
	private Boolean validarMovimento(Pair<Integer, Integer> posFinal) {
		if(this.getPosicao().getKey() - posFinal.getKey() > 2) {
			System.out.println("nao pode andar mais de 2 casas");
			return false;
		}
		if((posFinal.getValue() != this.getPosicao().getValue()) && (posFinal.getKey() <= this.getPosicao().getKey())) {
			System.out.println("nao pode mudar de coluna e diminuir ou manter a linha");
			return false;
		}
		if(this.getPosicao().getValue() - posFinal.getValue() > 1) {
			System.out.println("vc nao pode andar mais de 2 colunas");
			return false;
		}
		if(this.getPosicao().getKey() != 6 && this.getPosicao().getKey() - posFinal.getKey() == 2) {
			System.out.println("vc nao pode andar 2 casas");
			return false;
			
		}
		else if(this.getPosicao().getKey() == 6 && this.getPosicao().getKey() - posFinal.getKey() == 2){
			System.out.println("ta liberado andar 2 casas pai");
		}
		return true;
	}
	
}
