package Ejercicio5.Montecarlo;

public class Coordenada {
    private double x;
    private double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanciaAlPunto(double centroX, double centroY) {
        return Math.sqrt(Math.pow(x - centroX, 2) + Math.pow(y - centroY, 2));
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }
}
