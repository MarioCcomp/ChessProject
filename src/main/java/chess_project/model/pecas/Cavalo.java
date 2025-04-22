package chess_project.model.pecas;
import java.io.IOException;
import java.util.ArrayList;

import chess_project.enums.Cor;
import chess_project.model.*;
import javafx.util.Pair;


public class Cavalo extends Peca {

	public Cavalo(Integer n, Integer m, Cor cor, char id) {
		super(n, m, cor, id);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public ArrayList<Pair<Integer, Integer>> getMovimento(Pair<Integer, Integer> posFinal, Cor cor) throws IOException {
		int diffColuna = Math.abs(posFinal.getValue() - this.getPosicao().getValue());
		int diffLinha = Math.abs(posFinal.getKey() - this.getPosicao().getKey());
		if(diffColuna + diffLinha != 3 || (diffColuna == 0 || diffLinha == 0)) {
			throw new IOException("Posicao invalida pro caramello");
		}
		ArrayList<Pair<Integer, Integer>> trajeto = new ArrayList<Pair<Integer, Integer>>();
		trajeto.add(posFinal);
		return trajeto;
	}
}
