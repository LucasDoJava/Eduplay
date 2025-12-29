package eduplay.tabuleiro;

import eduplay.desafios.Desafio;
import eduplay.jogo.Jogador;

public class CasaDesafio implements Casa {

    private Desafio desafio;

    public CasaDesafio(Desafio desafio) {
        this.desafio = desafio;
    }

    @Override
    public void acao(Jogador jogador) {
        boolean acertou = desafio.executar();

        if (acertou) {
            System.out.println("✅ Acertou! +3 pontos e avança +1 casa.");
            jogador.adicionarPontos(3);
            jogador.avancar(1);
        } else {
            System.out.println("❌ Errou! -2 pontos e volta -1 casa.");
            jogador.adicionarPontos(-2);
            jogador.avancar(-1);
        }
    }
}
