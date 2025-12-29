package eduplay.desafios.factory;

import eduplay.desafios.Desafio;
import eduplay.desafios.MatematicaDesafio;

public class DesafioMatematicaFactory implements DesafioFactory {

    @Override
    public Desafio criarDesafio() {
        return new MatematicaDesafio();
    }
}
