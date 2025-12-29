package eduplay.desafios.factory;

import eduplay.desafios.Desafio;
import eduplay.desafios.LogicaDesafio;

public class DesafioLogicaFactory implements DesafioFactory {

    @Override
    public Desafio criarDesafio() {
        return new LogicaDesafio();
    }
}
