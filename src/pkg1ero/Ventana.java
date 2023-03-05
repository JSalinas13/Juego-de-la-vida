package pkg1ero;

import javax.swing.*;

public class Ventana extends JFrame {

    PanelTablero Tablero = new PanelTablero();
    JButton iniciarJuego, pausarJuego, borrarDiseño, nave,Corazon;

    public Ventana() {
        setSize(580, 700);
        setVisible(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setLayout(null);
        add(Tablero);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarJuego = new JButton("J U G A R");
        iniciarJuego.setBounds(20, 544, 100, 55);
        iniciarJuego.addActionListener((e) -> {

            Tablero.jugar();

        });
        add(iniciarJuego);
        pausarJuego = new JButton("P A U S A R");
        pausarJuego.setBounds(150, 544, 100, 55);
        pausarJuego.addActionListener((e) -> {

            Tablero.pausar();

        });
        add(pausarJuego);

        borrarDiseño = new JButton("B O R R A R");
        borrarDiseño.setBounds(410, 544, 100, 55);
        borrarDiseño.addActionListener((e) -> {
            Tablero.borrar();
        });
        add(borrarDiseño);

        nave = new JButton("N A V E");
        nave.setBounds(280, 544, 100, 25);
        nave.addActionListener((e) -> {
            if (Tablero.NAVECITA == false) {
                Tablero.NAVECITA=true;
            } else if (Tablero.NAVECITA == true) {
                Tablero.NAVECITA = false;

            }
        });
        add(nave);
        
         }

}
