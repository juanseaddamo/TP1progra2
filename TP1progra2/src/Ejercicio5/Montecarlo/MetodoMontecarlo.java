package Ejercicio5.Montecarlo;

import java.util.Random;

public class MetodoMontecarlo {
    public static void main(String[] args) {
        final int numeroDeCoordenadas = 1000;
        final double ladoDelCuadrado = 1.0;

        Montecarlo montecarlo = new Montecarlo(ladoDelCuadrado);
        Random random = new Random();

        System.out.println("Generando coordenadas aleatorias...");
        for (int i = 0; i < numeroDeCoordenadas; i++) {
            double x = random.nextDouble() * ladoDelCuadrado;
            double y = random.nextDouble() * ladoDelCuadrado;

            Coordenada coordenada = new Coordenada(x, y);
            if (i < 10) { // Solo imprime las primeras 10 para depuración
                System.out.println("Generada coordenada: " + coordenada);
            }
            montecarlo.agregarPunto(coordenada);
        }

        double aproximacionPi = montecarlo.aproximarPi();
        System.out.printf("Aproximación de π: %.5f%n", aproximacionPi);
    }

}
