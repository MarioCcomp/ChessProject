package chess_project.model;
import chess_project.enums.*;
import javafx.util.Pair;
import java.util.*;
import java.util.Scanner;

public class Partida {
	private Tabuleiro tabuleiro;
	private Cor jogadorAtual;
	private Scanner scanner;
	
	public Partida()
    {
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = Cor.BRANCAS;
        this.scanner = new Scanner(System.in);
    }
	
	public void jogar()
    {
        
        while (true) {
            this.tabuleiro.printarTabuleiro();
            System.out.println("Vez do jogador: " + this.jogadorAtual);
            List<Pair<Integer, Integer>> dadosDoMovimento = this.lerMovimento();
            
            Peca peca = tabuleiro.getPeca(dadosDoMovimento.get(0));
            if (peca == null || peca.getTime() != this.jogadorAtual) {
            	System.out.println("ERRO: Não é sua peça ou posição inválida!");
                continue;
            }
            //passa a posicao atual e a final
            this.tabuleiro.movimentarPeca(dadosDoMovimento.get(0), dadosDoMovimento.get(1));
            //so alterna se o movimento for valido
            this.jogadorAtual = (this.jogadorAtual == Cor.BRANCAS) ? Cor.PRETAS : Cor.BRANCAS;
            
        }
    }
	private List<Pair<Integer, Integer>> lerMovimento() {
        System.out.print("Digite quatro números inteiros separados por espaço (ex: 1 2 3 4): ");
        String linha = scanner.nextLine();
        String[] partes = linha.trim().split("\\s+");

        if (partes.length < 4) {
            System.out.println("Entrada inválida. Digite exatamente 4 números.");
            return this.lerMovimento(); // tenta novamente
        }

        try {
            int x1 = Integer.parseInt(partes[0]);
            int y1 = Integer.parseInt(partes[1]);
            int x2 = Integer.parseInt(partes[2]);
            int y2 = Integer.parseInt(partes[3]);

            List<Pair<Integer, Integer>> movimentos = new ArrayList<>();
            movimentos.add(new Pair<>(x1, y1));
            movimentos.add(new Pair<>(x2, y2));
            return movimentos;

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Use apenas números inteiros.");
            return this.lerMovimento(); // tenta novamente
        }
    }
	
}
