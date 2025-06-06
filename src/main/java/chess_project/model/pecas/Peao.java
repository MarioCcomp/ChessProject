package chess_project.model.pecas;

import java.io.IOException;
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
	public ArrayList<Pair<Integer, Integer>> getMovimento(Pair<Integer, Integer> posFinal, Cor cor) throws IOException {
		this.validarMovimento(posFinal.getKey(), posFinal.getValue(), cor);
		ArrayList<Pair<Integer, Integer>> posicoes = new ArrayList<Pair<Integer, Integer>>();
		if(this.getPosicao().getKey() - posFinal.getKey() > 1) {  // se o peao andou 2 casas
			posicoes.add(new Pair<Integer, Integer>(this.getPosicao().getKey() - 1, this.getPosicao().getValue())); // passo a casa acima dele
			posicoes.add(posFinal);  // passo a casa final
			return posicoes;
		}
		posicoes.add(posFinal);
		return posicoes;
		
		
	
		
	}
	
	private void validarMovimento(int n, int m, Cor cor) throws IOException {
		Pair<Integer, Integer> posIni = this.getPosicao();
		
		
		Pair<Integer, Integer> posFinal = cor == Cor.BRANCAS ? new Pair<Integer, Integer>(7 - n, m) : new Pair<Integer, Integer>(n, m);
		if(cor == Cor.BRANCAS) {
			this.setPosicao(new Pair<Integer, Integer>(7 - posIni.getKey(), posIni.getValue()));
		}
		
		
		if((this.getPosicao().getKey() - posFinal.getKey()) > 2) {
			
			System.out.println(posFinal + " " + this.getPosicao() + " nao pode andar mais de 2 casas");
			setPosicao(posIni);
			throw new IOException("nao pode andar mais de 2 casas");
		}
		if((posFinal.getValue() != this.getPosicao().getValue()) && (posFinal.getKey() >= this.getPosicao().getKey())) {
			setPosicao(posIni);
			throw new IOException("nao pode mudar de coluna e diminuir ou manter a linha");
		}
		if(this.getPosicao().getValue() - posFinal.getValue() > 1 || posFinal.getValue() - this.getPosicao().getValue() > 1) {
			setPosicao(posIni);
			throw new IOException("vc nao pode andar mais de 2 colunas");
		}
		if(this.getPosicao().getKey() != 6 && this.getPosicao().getKey() - posFinal.getKey() == 2) {
			setPosicao(posIni);
			throw new IOException("vc nao pode andar 2 casas");
			
		}
		
		if(posFinal.getKey() >= this.getPosicao().getKey()) {
			setPosicao(posIni);
			throw new IOException("peao nao anda pra tras burro, ou vc ja ta ai");
			
		}
		setPosicao(posIni);
	}
	
}
