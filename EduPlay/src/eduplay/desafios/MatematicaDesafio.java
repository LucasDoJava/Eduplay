package eduplay.desafios;

import java.util.*;

public class MatematicaDesafio implements Desafio {

    private Random random = new Random();

    @Override
    public boolean executar() {
        Scanner sc = new Scanner(System.in);

        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;

        System.out.println("Quanto é " + a + " + " + b + "?");
        int resposta = sc.nextInt();

        return resposta == (a + b);
    }
}
