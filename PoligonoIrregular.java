import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class PoligonoIrregular {
    private List<Coordenada> vertices;

    public PoligonoIrregular(int n) {
        vertices = new ArrayList<Coordenada>(n);
    }

    public void anadeVertice(Coordenada vertice) {
        vertices.add(vertice);
    }

    public List<Coordenada> getVertices() {
        this.ordenar();
        return vertices;
    }

    public List<Coordenada> ordenar() {
        Collections.sort(vertices, new SortbyPosition()); 
        List<Coordenada> lista_inferior = new ArrayList<>();
        List<Coordenada> lista_superior = new ArrayList<>();
        List<Coordenada> lista_intermedia_positiva = new ArrayList<>();
        List<Coordenada> lista_intermedia_negativa = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            Coordenada c1 = vertices.get(i);
            if (c1.abcisa() < 0 && c1.ordenada() < 0) {
                lista_inferior.add(c1);
            } else if (c1.abcisa() >= 0 && c1.ordenada() >= 0) {
                lista_superior.add(c1);
            } else if (c1.abcisa() >= 0) {
                lista_intermedia_negativa.add(c1);
            } else {
                lista_intermedia_positiva.add(c1);
            }
        }
        ArrayList<Coordenada> nuevaLista = new ArrayList<>();
        Collections.sort(lista_inferior, new SortbySlope(new Coordenada(0,0)));
        nuevaLista.addAll(lista_inferior);

        Collections.sort(lista_intermedia_negativa, new SortbySlope(new Coordenada(0,0)));
        nuevaLista.addAll(lista_intermedia_negativa);

        Collections.sort(lista_superior, new SortbySlope(new Coordenada(0,0)));
        nuevaLista.addAll(lista_superior);

        Collections.sort(lista_intermedia_positiva, new SortbySlope(new Coordenada(0,0)));
        nuevaLista.addAll(lista_intermedia_positiva);
        
        vertices = nuevaLista;
        return nuevaLista;
    }

    public void ordenarPorPendiente(Coordenada origin) {
        Collections.sort(vertices, new SortbySlope(origin)); 
        //Collections.sort(vertices, new SortbyDistance());
    }

    @Override
    public String toString() {
        String pol = "El " + this.getClass().getName() + " cuenta con " + vertices.size() + " vertices, dados por: \n";
        for (Coordenada vertice : vertices) {
            pol += vertice  + "\n";
            pol += " pendiente m=" + vertice.getPendiente(this.getPromedio()) + "\n\n";
        }
        pol += "Centroide: " + this.getPromedio();
        pol += "\n";
        return pol;
    }

    public void sortByPendienteAndPosition(Coordenada origin){
        Collections.sort(vertices, new SortbyPosition());        
        // Collections.sort(vertices, new SortbySlopeAndPosition(origin));

    }

    public Coordenada getPromedio() {
        double prom_x, prom_y;
        double sum_x, sum_y;
        sum_x = sum_y = 0;
        for (Coordenada vertice : this.getVertices()) {
            sum_x += vertice.abcisa();
            sum_y += vertice.ordenada();
        }

        int num_vertices = this.getVertices().size();
        prom_x = sum_x / num_vertices;
        prom_y = sum_y / num_vertices;

        return new Coordenada(prom_x, prom_y);

    }
}

class SortbyDistance implements Comparator<Coordenada> {
    public int compare(Coordenada a, Coordenada b) {
        return (int) a.getDistancia(b);
    }
}

class SortbyPosition implements Comparator<Coordenada> {
    public int compare(Coordenada a, Coordenada b) {
        return (int) a.comparebyPosition(b);
    }
}

class SortbySlope implements Comparator<Coordenada> {
    private Coordenada origin;

    public SortbySlope(Coordenada origin) {
        this.origin = origin;
    }

    public int compare(Coordenada a, Coordenada b) {
        return (int) a.comparebySlope(b, origin);
    }
}

class SortbySlopeAndPosition implements Comparator<Coordenada> {
    private Coordenada origin;

    public SortbySlopeAndPosition(Coordenada origin) {
        this.origin = origin;
    }

    public int compare(Coordenada a, Coordenada b) {
        return (int) a.comparebySlopeAndPosition(b, origin);
    }
}