package pkg1ero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelTablero extends JPanel implements MouseListener {

    final int BaseCubo = 10, PanelSIZE = 500;
    Simulacion simulation = new Simulacion(PanelSIZE, PanelSIZE);
    int x, y, opciones;
    boolean valorBooleano = false, NAVECITA = false, corazon = false;

    PanelTablero() {
        setBounds(15, 15, PanelSIZE, PanelSIZE);
        setBackground(Color.WHITE);
        addMouseListener(this);

    }

    void jugar() {
        valorBooleano = true;
    }

    void pausar() {
        valorBooleano = false;
    }

    void borrar() {
        simulation.borrarTablero();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (valorBooleano) {
            try {
                simulation.JuegoVida();
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Excepcion");

            }
        }
        for (int i = 0; i < PanelSIZE; i += BaseCubo) {
            for (int j = 0; j < PanelSIZE; j += BaseCubo) {
                g.setColor(Color.BLACK);
                g.drawRect(j, i, BaseCubo, BaseCubo);//es el Grid pero no me gusta

                if (simulation.tablero[j][i] == 1) {

                    g.setColor(Color.red);
                    g.fillRect(j, i, BaseCubo, BaseCubo);   
                    g.setColor(Color.BLACK);
                    g.fillRect(j + (2 * BaseCubo), (2 * BaseCubo) + i, BaseCubo, BaseCubo);
//                    g.fillRect(j + (2 * BaseCubo), (2 * BaseCubo) + i, BaseCubo, BaseCubo);
                }
                repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = (e.getX() / BaseCubo) * BaseCubo;
        y = (e.getY() / BaseCubo) * BaseCubo;

        if (simulation.tablero[x][y] == 0) {
            //navecita
//            switch (opciones) {
//                case 1:
//                    simulation.setVivo(x - BaseCubo, y - BaseCubo);
//                    simulation.setVivo(x + BaseCubo, y - BaseCubo);
//
//                    simulation.setVivo(x - BaseCubo, y);
//                    simulation.setVivo(x + BaseCubo, y);
//
//                    simulation.setVivo(x - BaseCubo, y + BaseCubo);
//                    simulation.setVivo(x, y + BaseCubo);
//                    simulation.setVivo(x + BaseCubo, y + BaseCubo);
//                case 2:
//                    
//            }
            if (NAVECITA) {
                simulation.setVivo(x - BaseCubo, y - BaseCubo);
                simulation.setVivo(x, y - BaseCubo);
                simulation.setVivo(x + BaseCubo, y - BaseCubo);

                simulation.setVivo(x + BaseCubo, y);

                simulation.setVivo(x, y + BaseCubo);

            } else {

                simulation.setVivo(x, y);
            }
        } else if (simulation.tablero[x][y] == 1) {
            simulation.setMuerto(x + BaseCubo, y + BaseCubo);
            simulation.setMuerto(x, y + BaseCubo);
            simulation.setMuerto(x + BaseCubo, y);
            simulation.setMuerto(x, y);
            simulation.setMuerto(x, y);
            simulation.setMuerto(x, y);

        }
    }

    //metodos que no uso
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
