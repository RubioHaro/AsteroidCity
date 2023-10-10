import java.util.ArrayList;

public class GeneradorAsteroides {
    public Asteroide getAsteroide() {
        return new Asteroide(0);
    }

    public Asteroide getRandomAsteroide(int numeroVertices) {
        Asteroide aster = new Asteroide(numeroVertices);
        for (int i = 0; i < numeroVertices; i++)
            aster.anadeVertice(new Coordenada((Math.random() * 20) - 10, (Math.random() * 20) - 10));

        aster.sortByPendienteAndPosition(aster.getCentro());
        return aster;
    }


    public ArrayList<Asteroide> getSetOfAsteroids(int numberOfAsteroids, int verticesNumber){
        ArrayList<Asteroide> AsteroidsSet = new ArrayList<>();
        for (int i = 0; i < numberOfAsteroids; i++) 
            AsteroidsSet.add(getRandomAsteroide(verticesNumber));
        
        return AsteroidsSet;
    }

    public ArrayList<Asteroide> getDummyList(){
        ArrayList<Asteroide> AsteroidsSet = new ArrayList<>();
        Asteroide aster = new Asteroide();
        aster.anadeVertice(new Coordenada(-3.08441663326602,9.21057202241192));        
        aster.anadeVertice(new Coordenada(9.39303504821389,-3.0158308490225068));
        aster.anadeVertice(new Coordenada(-8.464892462841778,-8.247444198502535));
        aster.anadeVertice(new Coordenada(-5.388966575476928,-9.154097769497913));
        aster.anadeVertice(new Coordenada(0.10964759878992147,2.2806777610908178));
        // aster.sortByPendienteAndPosition(aster.getCentro());

        
        AsteroidsSet.add(aster);
        

        return AsteroidsSet;
    }
}
