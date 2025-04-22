package chess_project.model.pecas;

import java.io.IOException;
import java.util.ArrayList;

import chess_project.enums.Cor;
import chess_project.model.Peca;
import javafx.util.Pair;

public class Torre extends Peca {

	public Torre(Integer n, Integer m, Cor cor, char id) {
		super(n, m, cor, id);
	}

	@Override
	public ArrayList<Pair<Integer, Integer>> getMovimento(Pair<Integer, Integer> posFinal, Cor cor) throws IOException {

		int linhaInicial = this.getPosicao().getKey();
		int colunaInicial = this.getPosicao().getValue();

		int linhaFinal = posFinal.getKey();
		int colunaFinal = posFinal.getValue();

		if (linhaInicial != linhaFinal && colunaInicial != colunaFinal) {
			throw new IOException("vc nao pode mudar a coluna e a linha ao mesmo tempo ne chefe");
		}

		ArrayList<Pair<Integer, Integer>> trajeto = new ArrayList<Pair<Integer, Integer>>();

		if (linhaFinal > linhaInicial || colunaFinal > colunaInicial) {

			if (linhaInicial != linhaFinal) {
				for (int i = linhaInicial + 1; i <= linhaFinal; i++) {
					trajeto.add(new Pair<Integer, Integer>(i, colunaInicial));
				}
			} else {
				for (int i = colunaInicial + 1; i <= colunaFinal; i++) {
					trajeto.add(new Pair<Integer, Integer>(linhaInicial, i));
				}
			}
			return trajeto;
		}
		
		// dependendo do destino final, a logica muda
		
		if (linhaInicial != linhaFinal) {
			for (int i = linhaFinal + 1; i <= linhaInicial; i++) {
				trajeto.add(new Pair<Integer, Integer>(i, colunaInicial));
			}
		} else {
			for (int i = colunaFinal + 1; i <= colunaInicial; i++) {
				trajeto.add(new Pair<Integer, Integer>(linhaInicial, i));
			}
		}
		return trajeto;
		
		

		
	}

}
