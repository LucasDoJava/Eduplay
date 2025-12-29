package eduplay.jogo.state;

public class JogoEmAndamento implements EstadoJogo {

    @Override
    public void iniciar() {
        System.out.println("O jogo já está em andamento.");
    }

    @Override
    public void jogar() {
       
    }

    @Override
    public void finalizar() {
        System.out.println("🏁 Jogo finalizado!");
    }
}
