package eduplay.jogo.state;

public class JogoNaoIniciado implements EstadoJogo {

    @Override
    public void iniciar() {
        System.out.println("🎮 Jogo iniciado!");
    }

    @Override
    public void jogar() {
        System.out.println("O jogo ainda não começou.");
    }

    @Override
    public void finalizar() {
        System.out.println("O jogo não foi iniciado.");
    }
}

