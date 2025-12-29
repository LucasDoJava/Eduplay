package eduplay.jogo;

import eduplay.jogo.state.*;
import eduplay.tabuleiro.*;
import eduplay.interfacejogo.InterfaceTerminal;

import java.util.*;

public class Jogo {

    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private InterfaceTerminal interfaceTerminal;

    private EstadoJogo estado;
    private Random dado = new Random();

    public Jogo(List<Jogador> jogadores, Tabuleiro tabuleiro, InterfaceTerminal interfaceTerminal) {
        this.jogadores = jogadores;
        this.tabuleiro = tabuleiro;
        this.interfaceTerminal = interfaceTerminal;
        this.estado = new JogoNaoIniciado();
    }
    
    private void anunciarVencedor() {
        Jogador vencedor = jogadores.get(0);

        for (Jogador j : jogadores) {
            if (j.getPontos() > vencedor.getPontos()) {
                vencedor = j;
            }
        }

        System.out.println("\n🏆 VENCEDOR: " + vencedor.getNome());
        System.out.println("Pontuação: " + vencedor.getPontos());
    }
    
    private boolean todosFinalizaram() {
        for (Jogador j : jogadores) {
            if (!j.finalizou()) {
                return false;
            }
        }
        return true;
    }

    public void iniciar() {
        estado.iniciar();
        estado = new JogoEmAndamento();

        boolean terminou = false;

        while (!terminou) {
            for (Jogador jogador : jogadores) {

                interfaceTerminal.renderizar();

                int valorDado = dado.nextInt(6) + 1;
                System.out.println("\n🎲 " + jogador.getNome() + " tirou " + valorDado);

                jogador.avancar(valorDado);

                Casa casa = tabuleiro.getCasa(jogador.getPosicao());
                casa.acao(jogador);

                if (jogador.getPosicao() >= tabuleiro.tamanho() - 1 && !jogador.finalizou()) {
                    jogador.finalizar();
                    System.out.println("🏁 " + jogador.getNome() + " chegou ao final!");
                }

                if (todosFinalizaram()) {
                    estado.finalizar();
                    estado = new JogoFinalizado();
                    anunciarVencedor();
                    terminou = true;
                    break;
            }
        }
    }
}
}
