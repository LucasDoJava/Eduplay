package eduplay.facade;

import eduplay.jogo.*;
import eduplay.tabuleiro.*;
import eduplay.tabuleiro.factory.TabuleiroFactory;
import eduplay.interfacejogo.InterfaceTerminal;

import java.util.*;

public class EduPlayFacade {

    private static final int MAX_JOGADORES = 3;
    private Scanner sc = new Scanner(System.in);

    public void iniciarJogo() {

        System.out.println("🎮 EDUPLAY");
        System.out.println("1 - Modo padrão");
        System.out.println("2 - Modo customizado");
        System.out.print("Escolha o modo: ");

        int modo = sc.nextInt();
        sc.nextLine();

        int totalCasas;
        int totalDesafios;

        if (modo == 1) {
            totalCasas = 15;
            totalDesafios = 6;
        } else if (modo == 2) {
            totalCasas = configurar("Quantas casas terá o tabuleiro?", 5, 50);
            totalDesafios = configurar("Quantos desafios?", 1, totalCasas - 1);
        } else {
            System.out.println("Modo inválido. Usando modo padrão.");
            totalCasas = 15;
            totalDesafios = 6;
        }

        List<Jogador> jogadores = criarJogadores();

        TabuleiroFactory tabuleiroFactory = new TabuleiroFactory();
        Tabuleiro tabuleiro = tabuleiroFactory.criar(totalCasas, totalDesafios);

        InterfaceTerminal interfaceTerminal = new InterfaceTerminal(tabuleiro, jogadores);

        Jogo jogo = new Jogo(jogadores, tabuleiro, interfaceTerminal);
        jogo.iniciar();
    }

    private int configurar(String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg + " (" + min + " - " + max + "): ");
            valor = sc.nextInt();
            sc.nextLine();
        } while (valor < min || valor > max);
        return valor;
    }

    private List<Jogador> criarJogadores() {
        int qtd;
        do {
            System.out.print("Quantos jogadores? (1 a " + MAX_JOGADORES + "): ");
            qtd = sc.nextInt();
            sc.nextLine();
        } while (qtd < 1 || qtd > MAX_JOGADORES);

        List<Jogador> jogadores = new ArrayList<>();

        for (int i = 1; i <= qtd; i++) {
            System.out.print("Nome do jogador " + i + ": ");
            jogadores.add(new Jogador(sc.nextLine()));
        }

        return jogadores;
    }
}
