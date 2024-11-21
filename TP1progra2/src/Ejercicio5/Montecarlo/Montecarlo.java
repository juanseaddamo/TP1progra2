package Ejercicio5.Montecarlo;


import java.util.ArrayList;
import java.util.List;

public class Montecarlo {
    public List<Coordenada> puntosDentroDelCuadrado; // Para inspección en el main
    private double ladoCuadrado;

    public Montecarlo(double ladoCuadrado) {
        this.ladoCuadrado = ladoCuadrado;
        this.puntosDentroDelCuadrado = new ArrayList<>();
    }

    public void agregarPunto(Coordenada punto) {
        if (punto.getX() >= 0 && punto.getX() <= ladoCuadrado &&
                punto.getY() >= 0 && punto.getY() <= ladoCuadrado) {
            puntosDentroDelCuadrado.add(punto);
        }
    }

    public double aproximarPi() {
        int puntosDentroDelCirculo = 0;
        double radio = ladoCuadrado / 2;
        double centro = ladoCuadrado / 2; // Centro en (0.5, 0.5)

        for (Coordenada punto : puntosDentroDelCuadrado) {
            if (punto.distanciaAlPunto(centro, centro) <= radio) {
                puntosDentroDelCirculo++;
            }
        }

        if (puntosDentroDelCuadrado.isEmpty()) {
            System.err.println("Error: No se generaron puntos válidos.");
            return 0;
        }

        System.out.println("Puntos dentro del círculo: " + puntosDentroDelCirculo);
        System.out.println("Total de puntos en el cuadrado: " + puntosDentroDelCuadrado.size());

        return 4.0 * puntosDentroDelCirculo / puntosDentroDelCuadrado.size();
    }
}
