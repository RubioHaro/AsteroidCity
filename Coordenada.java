class Coordenada implements Comparable<Coordenada> {

    private double x, y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double abcisa() {
        return x;
    }

    public double ordenada() {
        return y;
    }

    public double getDistancia(Coordenada c2) {
        double abcisas = c2.abcisa() - this.abcisa();
        double ordenadas = c2.ordenada() - this.ordenada();
        return Math.sqrt(abcisas * abcisas + ordenadas * ordenadas);
    }

    @Override
    public String toString() {
        // return "[" + x + "," + y + "]";
        return "(" + x + "," + y + ")";
    }

    public double getPendiente(Coordenada c2) {
        double delta_y = c2.ordenada() - this.ordenada();
        double delta_x = c2.abcisa() - this.abcisa();
        return delta_y / delta_x;
    }

    @Override
    public int compareTo(Coordenada toCompare) {
        double distanciaThisToCompare = this.getDistancia(toCompare);
        // Compara las distancias y devuelve el resultado
        if (distanciaThisToCompare < 0) {
            return -1;
        } else if (distanciaThisToCompare > 0) {
            return 1;
        } else {
            return 0;
        }

    }

    public int comparebyPosition(Coordenada toCompare) {
        if (this.ordenada() >= 0 && toCompare.ordenada() < 0 && this.abcisa() >= 0 && toCompare.abcisa() < 0)
            return -1;

        if (this.ordenada() < toCompare.ordenada() && this.abcisa() < toCompare.abcisa())
            return -1;

        return 1;

    }

    public int comparebySlope(Coordenada toCompare, Coordenada origin) {
        double pendiente1 = this.getPendiente(origin);
        double pendiente2 = toCompare.getPendiente(origin);
        // Compara las distancias y devuelve el resultado
        if (pendiente1 < pendiente2) {
            return -1;
        } else {
            return 1;
        }
    }

    public int comparebySlopeAndPosition(Coordenada toCompare, Coordenada origin) {
        double pendiente1 = this.getPendiente(origin);
        double pendiente2 = toCompare.getPendiente(origin);
        if (this.ordenada() >= 0 && toCompare.ordenada() < 0) {
            return -1;
        }
        if (this.abcisa() >= 0 && toCompare.abcisa() < 0) {
            return -1;
        }
        // Compara las distancias y devuelve el resultado
        if (pendiente1 < pendiente2) {
            return -1;
        } else {
            return 1;
        }

    }

}