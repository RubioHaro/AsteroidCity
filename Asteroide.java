import java.util.List;

public class Asteroide extends PoligonoIrregular {
    private int numeroVertices;

    public Asteroide() {
        super(0); 
        numeroVertices = 0;
    }

    public Asteroide(int numeroVertices) {
        super(numeroVertices); // call the default constructor of PoligonoIrregular
        this.numeroVertices = numeroVertices;
    }
    
    public int getNumeroVertices() {
        return numeroVertices;
    }

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

    public int obtienePerimetro() {
        int perimetro = 0;
        return perimetro;
    }

    public Coordenada getCentro(){
        return this.getPromedio();
    }
}