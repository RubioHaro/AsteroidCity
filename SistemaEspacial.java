import java.util.List;

public class SistemaEspacial {

    private List<Asteroide> asteroides;

    public SistemaEspacial() {
        GeneradorAsteroides generador = new GeneradorAsteroides();
        asteroides = generador.getSetOfAsteroids(1, 4);
    }

    public SistemaEspacial(int numberOfAsteroids) {
        GeneradorAsteroides generador = new GeneradorAsteroides();
        asteroides = generador.getSetOfAsteroids(numberOfAsteroids, 20);
        // asteroides = generador.getDummyList();
    }

     public SistemaEspacial(int numberOfAsteroids, int maxVertex) {
        GeneradorAsteroides generador = new GeneradorAsteroides();
        asteroides = generador.getSetOfAsteroids(numberOfAsteroids, maxVertex);
        // asteroides = generador.getDummyList();
    }

    public List<Asteroide> getAsteroides() {
        return asteroides;
    }

    public void setAsteroides(List<Asteroide> asteroides) {
        this.asteroides = asteroides;
    }

    @Override
    public String toString() {
        String pol = "El Sistema espacial cuenta con: \n";
        for (Asteroide asteroide : asteroides) {
            pol += asteroide;
            pol += "Centroide: " + asteroide.getPromedio() + "\n";            
        }


        return pol;
    }
}
