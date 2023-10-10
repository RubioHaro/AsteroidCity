import java.util.ArrayList;

public class PruebaRectangulo {
    public static void main(String[] args) {
        // SistemaEspacial espacioAsteroides = new SistemaEspacial();
        ArrayList<Asteroide> AsteroidsSet = new ArrayList<>();
        Asteroide aster = new Asteroide();
        aster.anadeVertice(new Coordenada(-3.08441663326602,9.21057202241192));        
        aster.anadeVertice(new Coordenada(9.39303504821389,-3.0158308490225068));
        aster.anadeVertice(new Coordenada(-8.464892462841778,-8.247444198502535));
        aster.anadeVertice(new Coordenada(-5.388966575476928,-9.154097769497913));
        aster.anadeVertice(new Coordenada(0.10964759878992147,2.2806777610908178));
        System.out.println(aster);
        aster.sortByPendienteAndPosition(aster.getCentro());

        System.out.println("Sorter:");
        System.out.println(aster);

        

        
    }
}