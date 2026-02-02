package eduplay.tabuleiro.factory;

import eduplay.tabuleiro.*;

import java.util.*;

public class TabuleiroFactory {

    private final CasaFactory casaFactory = new CasaFactory();
    private final Random random = new Random();

    public Tabuleiro criar(int totalCasas, int totalDesafios) {

        List<Casa> lista = new ArrayList<>();

        Set<Integer> posicoesDesafio = new HashSet<>();

        while (posicoesDesafio.size() < totalDesafios) {
            posicoesDesafio.add(random.nextInt(totalCasas - 1) + 1);
        }

        for (int i = 0; i < totalCasas; i++) {
            boolean ehDesafio = posicoesDesafio.contains(i);
            lista.add(casaFactory.criarCasa(ehDesafio));
        }

        return new Tabuleiro(lista);
    }
}
