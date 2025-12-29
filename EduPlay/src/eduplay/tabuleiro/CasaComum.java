package eduplay.tabuleiro;

import eduplay.jogo.Jogador;

public class CasaComum implements Casa{

	@Override
	public void acao(Jogador jogador) {
		System.out.println("Você está numa casa comum");
		
	}

}
