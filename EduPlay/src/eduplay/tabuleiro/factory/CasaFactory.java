package eduplay.tabuleiro.factory;

import eduplay.tabuleiro.*;
import eduplay.desafios.factory.*;

import java.util.Random;

public class CasaFactory {

    private final DesafioFactory matematica = new DesafioMatematicaFactory();
    private final DesafioFactory logica = new DesafioLogicaFactory();
    private final Random random = new Random();

    public Casa criarCasa(boolean desafio) {

        if (desafio) {
            if (random.nextBoolean()) {
                return new CasaDesafio(matematica.criarDesafio());
            } else {
                return new CasaDesafio(logica.criarDesafio());
            }
        }

        return new CasaComum();
    }
}
