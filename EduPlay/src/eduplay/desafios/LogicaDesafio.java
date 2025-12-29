package eduplay.desafios;

import java.util.*;

public class LogicaDesafio implements Desafio {

    private Random random = new Random();

    @Override
    public boolean executar() {
        Scanner sc = new Scanner(System.in);

        int a = random.nextInt(5) + 1;
        int b = random.nextInt(5) + 1;

        System.out.println("Qual o resultado de: " + a + " > " + b + " ?");
        String resposta = sc.nextLine();

        return resposta.equalsIgnoreCase(String.valueOf(a > b));
    }
}
