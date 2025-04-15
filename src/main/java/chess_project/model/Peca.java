package chess_project.model;

public abstract class Peca {
	private String nome;
	
	public Peca(String nome) {
		this.nome = nome;
	}
	
	public abstract void getMovimento();
}
