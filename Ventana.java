
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.Random;

public class Ventana extends JFrame {

    private SistemaEspacial sistema;

    public Ventana() {
        sistema = new SistemaEspacial(getNumberInputs(), 10);
        initUI();

    }

    private static int getNumberInputs() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos asteroides quieres?"));
        } catch (Exception e) {
            return 5;
        }
    }

    private void initUI() {
        setSize(400, 500);
        setTitle("Sistema Espacial de Asteroides");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var drawPanel = new DrawPanel(this.sistema, "RANDOM");
        

        add(drawPanel);
        setVisible(true);

        try {
            Thread.sleep(1000);
            drawPanel.repaint();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        drawPanel = new DrawPanel(sistema, "BYTIME");
        add(drawPanel);

    }

}

class DrawPanel extends JPanel {

    private SistemaEspacial sistema;
    private Graphics2D g2d;
    private String mode;

    public DrawPanel(SistemaEspacial sistema, String mode) {
        this.sistema = sistema;
        this.mode = mode;
    }

    private void painStars() {
        var size = getSize();
        var insets = getInsets();

        for (int i = 0; i <= 1000; i++) {

            int w = size.width - insets.left - insets.right;
            int h = size.height - insets.top - insets.bottom;

            var r = new Random();
            int x = Math.abs(r.nextInt()) % w;
            int y = Math.abs(r.nextInt()) % h;

            g2d.drawLine(x, y, x, y);

        }
    }

    private void paintAsteroid(Asteroide a, Coordenada base) {
        Iterator<Coordenada> iterator = a.getVertices().iterator();
        Coordenada astrPrev, first;

        if (iterator.hasNext())
            astrPrev = first = iterator.next();
        else
            return;

        var size = getSize();
        double coeff = 1;
        if (size.width / 30 - 10 > 1) 
            coeff = size.width / 30 - 10;
        
        coeff = 5;

        double centerx = size.width / 2;
        double centery = size.height / 2;

        double screenxPrev, screenyPrev, screenxNext, screenyNext;
        while (iterator.hasNext()) {
            Coordenada astrNext = iterator.next();

            screenxPrev = centerx + coeff * (astrPrev.abcisa() + base.abcisa());
            screenyPrev = centery + coeff * (astrPrev.ordenada() + base.ordenada());

            screenxNext = centerx + coeff * (astrNext.abcisa() + base.abcisa());
            screenyNext = centery + coeff * (astrNext.ordenada() + base.ordenada());

            // screenxPrev = centerx + coeff * (astrPrev.abcisa() - mx);
            // screenyPrev = centery + coeff * (astrPrev.ordenada() - my);

            // screenxNext = centerx + coeff * (astrNext.abcisa() - mx);
            // screenyNext = centery + coeff * (astrNext.ordenada() - my);

            g2d.drawLine((int) screenxPrev, (int) screenyPrev, (int) screenxNext, (int) screenyNext);
            astrPrev = astrNext;
        }

        screenxPrev = centerx + coeff * (astrPrev.abcisa()+ base.abcisa());
        screenyPrev = centery + coeff * (astrPrev.ordenada()+ base.ordenada());

        screenxNext = centerx + coeff * (first.abcisa()+ base.abcisa());
        screenyNext = centery + coeff * (first.ordenada()+ base.ordenada());

        // screenxPrev = centerx + coeff * (astrPrev.abcisa() - mx);
        // screenyPrev = centery + coeff * (astrPrev.ordenada() - my);

        // screenxNext = centerx + coeff * (first.abcisa() - mx);
        // screenyNext = centery + coeff * (first.ordenada() - my);

        g2d.drawLine((int) screenxPrev, (int) screenyPrev, (int) screenxNext, (int) screenyNext);
    }

    private void doDrawing(Graphics g) {
        g2d = (Graphics2D) g;
        g2d.setColor(Color.yellow);
        g2d.scale(1.0, -1.0);
        g2d.translate(0, -getHeight());
        painStars();

        g2d.setColor(Color.WHITE);

        if(mode.equals("RANDOM"))
            paintListAsteroidsByTime();
        else
            paintListAsteroidsRandom();

    }

    private void paintListAsteroidsByTime(){
        for (Asteroide asteroide : sistema.getAsteroides()) {
            try {
                // g2d.getTransform();
                Thread.sleep(5000);
                paintAsteroid(asteroide, new Coordenada(0.0,0.0)); 

            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    private void paintListAsteroidsRandom(){
        for (Asteroide asteroide : sistema.getAsteroides()) {
            try { 
                paintAsteroid(asteroide, new Coordenada((Math.random() * 60) - 40, (Math.random() * 60) - 40)); 
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.BLACK);
        doDrawing(g);
    }
}
