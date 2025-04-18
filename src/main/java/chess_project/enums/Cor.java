package chess_project.enums;

public enum Cor {
	PRETAS(0), BRANCAS(1);
	
	private int valor;
	
	private Cor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
