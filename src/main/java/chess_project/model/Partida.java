package chess_project.model;

import chess_project.enums.*;
import java.util.Scanner;
import chess_project.model.*;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Pair;


public class Partida {
	private Tabuleiro tabuleiro;
	private Cor jogadorAtual;
	private Scanner scanner;
	
	public Partida () {
		this.tabuleiro = new Tabuleiro();
		this.jogadorAtual = Cor.BRANCAS;
		this.scanner = new Scanner(System.in);
	}
	
	public void jogar()
    {
        while (true) {
            try {
            	this.tabuleiro.printarTabuleiro();
                List<Pair<Integer, Integer>> dadosDoMovimento = this.lerMovimento();
                
                this.tabuleiro.movimentarPeca(dadosDoMovimento.get(0), dadosDoMovimento.get(1), jogadorAtual);
                	mudarTurno();
            } catch(IOException error) {
            	System.out.println(error.getMessage());
            }
            
            
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
//            for(Pair<Integer, Integer> movimento : movimentos) {
//            	System.out.println("aqui um movimento: " + movimento);
//            }
            return movimentos;

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Use apenas números inteiros.");
            return this.lerMovimento(); // tenta novamente
        }
    }
	
	private void mudarTurno() {
		this.jogadorAtual = this.jogadorAtual == Cor.BRANCAS ? Cor.PRETAS : Cor.BRANCAS;
	}

	
	
	
	
}
