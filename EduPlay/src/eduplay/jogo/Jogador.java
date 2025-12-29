package eduplay.jogo;

public class Jogador {

    private String nome;
    private int posicao = 0;
    private int pontos = 0;
    private boolean finalizou = false;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void avancar(int casas) {
        posicao += casas;
        if (posicao < 0) posicao = 0;
    }

    public void adicionarPontos(int valor) {
        pontos += valor;
        if (pontos < 0) pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean finalizou() {
        return finalizou;
    }

    public void finalizar() {
        this.finalizou = true;
    }
}
