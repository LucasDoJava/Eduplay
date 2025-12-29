package eduplay.jogo.state;

public class JogoFinalizado implements EstadoJogo {

    @Override
    public void iniciar() {
        System.out.println("O jogo já terminou.");
    }

    @Override
    public void jogar() {
        System.out.println("Não é possível jogar.");
    }

    @Override
    public void finalizar() {
        System.out.println("O jogo já está encerrado.");
    }
}

