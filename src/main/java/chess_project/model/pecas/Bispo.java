package chess_project.model.pecas;

import java.io.IOException;
import java.util.ArrayList;

import chess_project.enums.Cor;
import chess_project.model.Peca;
import javafx.util.Pair;

public class Bispo extends Peca {

	public Bispo(Integer n, Integer m, Cor cor, char id) {
		super(n, m, cor, id);
	
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> getMovimento(Pair<Integer, Integer> posFinal, Cor cor) throws IOException {
		
		
		
		
		ArrayList<Pair<Integer, Integer>> trajeto = new ArrayList<Pair<Integer, Integer>>();
		
		int linhaInicial = this.getPosicao().getKey();
		int colunaInicial = this.getPosicao().getValue();
		
		int linhaFinal = posFinal.getKey();
		int colunaFinal = posFinal.getValue();
		
		
		ArrayList<Pair<Integer, Integer>> possibilidades = new ArrayList<Pair<Integer, Integer>>();
		
		for(int i = linhaInicial + 1, j = colunaInicial + 1; i <= 7 && j <=7; i++, j++) {
			possibilidades.add(new Pair<Integer, Integer>(i, j));
		}
		
		for(int i = linhaInicial - 1, j = colunaInicial - 1; i >= 0 && j >= 0; i--, j--) {
			possibilidades.add(new Pair<Integer, Integer>(i, j));
		}																										// CALCULANDO TODAS AS POSSIBILIDADES DE UM BISPO																								
		
		for(int i = linhaInicial + 1, j = colunaInicial - 1; i <= 7 && j >= 0; i++, j--) {
			possibilidades.add(new Pair<Integer, Integer>(i, j));
		}
		
		for(int i = linhaInicial - 1, j = colunaInicial + 1; i >= 0 && j <=7; i--, j++) {
			possibilidades.add(new Pair<Integer, Integer>(i, j));
		}
		
		if(!possibilidades.contains(posFinal)) {
			throw new IOException("essa nao eh uma posicao disponivel para o bispo");
		}
		
		
		if(linhaFinal < linhaInicial && colunaFinal < colunaInicial) {
			for(int i = linhaInicial - 1, j = colunaInicial - 1; i > linhaFinal; i--, j--) {
				trajeto.add(new Pair<Integer, Integer>(i, j));
			}
			return trajeto;
		}
		
		else if (linhaFinal < linhaInicial && colunaFinal > colunaInicial) {
			for(int i = linhaInicial - 1, j = colunaInicial + 1; i > linhaFinal; i--, j++) {
				trajeto.add(new Pair<Integer, Integer>(i, j));
			}
			return trajeto;
		}
		
		else if (linhaFinal > linhaInicial && colunaFinal < colunaInicial) {
			for(int i = linhaInicial + 1, j = colunaInicial - 1; i < linhaFinal; i++, j--) {
				trajeto.add(new Pair<Integer, Integer>(i, j));
			}
			return trajeto;
		}
		
		else if (linhaFinal > linhaInicial && colunaFinal > colunaInicial) {
			for(int i = linhaInicial + 1, j = colunaInicial + 1; i < linhaFinal; i++, j++) {
				trajeto.add(new Pair<Integer, Integer>(i, j));
			}
			return trajeto;
		}
		
		return null;
	}

}
