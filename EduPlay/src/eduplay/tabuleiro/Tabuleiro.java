package eduplay.tabuleiro;

import java.util.List;

public class Tabuleiro {

    private List<Casa> casas;

    public Tabuleiro(List<Casa> casas) {
        this.casas = casas;
    }

    public Casa getCasa(int posicao) {
        if (posicao >= casas.size()) {
            return casas.get(casas.size() - 1);
        }
        return casas.get(posicao);
    }

    public int tamanho() {
        return casas.size();
    }
}

