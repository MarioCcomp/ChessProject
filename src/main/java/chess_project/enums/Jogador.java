package chess_project.enums;

public enum Jogador {
	PRETAS(0), BRANCAS(1);
	
	private int valor;
	
	private Jogador(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
}
