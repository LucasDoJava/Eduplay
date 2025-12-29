package eduplay.interfacejogo;

import eduplay.jogo.Jogador;
import eduplay.tabuleiro.Tabuleiro;

import java.util.List;
import java.util.stream.Collectors;

public class InterfaceTerminal {

    private Tabuleiro tabuleiro;
    private List<Jogador> jogadores;

    public InterfaceTerminal(Tabuleiro tabuleiro, List<Jogador> jogadores) {
        this.tabuleiro = tabuleiro;
        this.jogadores = jogadores;
    }

    public void renderizar() {
        System.out.println("\nTABULEIRO:");

        for (int i = 0; i < tabuleiro.tamanho(); i++) {

            final int pos = i;

            List<Jogador> naCasa = jogadores.stream()
                    .filter(j -> j.getPosicao() == pos)
                    .collect(Collectors.toList());

            if (!naCasa.isEmpty()) {
                System.out.print("[");
                naCasa.forEach(j -> System.out.print(j.getNome().charAt(0)));
                System.out.print("]");
            } else {
                System.out.print("[   ]");
            }
        }

        System.out.println("\n\nPONTUAÇÃO:");
        jogadores.forEach(j ->
                System.out.println(j.getNome() + ": " + j.getPontos() + " pts")
        );
    }
}
