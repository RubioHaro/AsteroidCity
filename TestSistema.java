import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestSistema {
    public static void main(String[] args) {

        GeneradorAsteroides generador = new GeneradorAsteroides();
        Asteroide aster = generador.getDummyList().get(0);
        System.out.println("Asteroide de prueba generado.");

        Coordenada centroide = aster.getCentro();
        double absisa_teorica = -1.487118604916183;
        double ordenada_teorica = -1.7852246067040434;

        double diferencia1 = Math.abs(centroide.abcisa() - absisa_teorica);
        double diferencia2 = Math.abs(centroide.ordenada() - ordenada_teorica);
        double margen = 0.01;

        System.out.println("Prueba 1. Calculo centroide.");
        if (diferencia1 <= margen && diferencia2 <= margen)
            System.out.println("Prueba 1. OK. Centroide Calculado Correctamente:" + aster.getPromedio());
        else {
            System.out.println("El centroide no ha sido generado correctamente. Detalles:");
            System.out.println("diferencia absisas:" + diferencia1);
            System.out.println("diferencia ordenadas:" + diferencia2);
            System.out.println(aster);
            System.out.println("prom: " + aster.getCentro());
            System.out.println("Prueba 1. FAILED.");

            return;
        }

        System.out.println("Prueba 2. Cantidad de Vertices.");
        if (aster.getVertices().size() <= 0) {
            System.out.println("Prueba 2. FAILED.");
            return;
        } else
            System.out.println("Prueba 2. OK.");

        System.out.println("Prueba 3. Ordenamiento.");
        List<Coordenada> listaVertices = aster.getVertices();
        listaVertices= aster.ordenar();
        
        Coordenada c1 = listaVertices.get(0);
        System.out.println("paso1.v1: " + c1);

        c1 = listaVertices.get(1);
        System.out.println("paso2.v1: " + c1);

        c1 = listaVertices.get(2);
        System.out.println("paso3.v1: " + c1);

        c1 = listaVertices.get(3);
        System.out.println("paso4.v1: " + c1);

        c1 = listaVertices.get(4);
        System.out.println("paso5.v1: " + c1);

    }
}
