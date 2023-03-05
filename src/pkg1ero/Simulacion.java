package pkg1ero;

public class Simulacion {

    int ancho;
    int alto;
    int tablero[][];
    int avance = 10;

    public Simulacion(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.tablero = new int[ancho][alto];

    }

    void imprimirTablero() {
        System.out.println("--------");
        for (int y = 0; y < alto; y += avance) {//renglones
            String S = "| ";
            for (int x = 0; x < ancho; x += avance) {//columnas
                if (this.tablero[x][y] == 0) {
                    S += "📒 ";
                }
                if (this.tablero[x][y] == 1) {
                    S += "🐟 ";
                }
            }
            S += "|";
            System.out.println(S);
        }
        System.out.println("---------\n");
    }

    int Vecinos(int x, int y) {
        int Vecinos = 0;
        int xmenos1, xmas1, ymenos1, ymas1;

        if (x - avance < 0) {
            xmenos1 = ancho - avance;
        } else {
            xmenos1 = x - avance;
        }
        if (y - avance < 0) {
            ymenos1 = alto - avance;
        } else {
            ymenos1 = y - avance;
        }
        if (x + avance >= ancho) {
            xmas1 = 0;
        } else {
            xmas1 = x + avance;
        }

        if (y + avance >= alto) {
            ymas1 = 0;
        } else {
            ymas1 = y + avance;
        }
        Vecinos += tablero[xmenos1][ymenos1];
        Vecinos += tablero[x][ymenos1];
        Vecinos += tablero[xmas1][ymenos1];

        Vecinos += tablero[xmenos1][y];
        Vecinos += tablero[xmas1][y];

        Vecinos += tablero[xmenos1][ymas1];
        Vecinos += tablero[x][ymas1];
        Vecinos += tablero[xmas1][ymas1];
        return Vecinos;

    }

    void JuegoVida() {
        int[][] nuevoTablero = new int[ancho][alto];

        for (int y = 0; y < alto; y += avance) {
            for (int x = 0; x < ancho; x += avance) {
                int CelulasVivas = Vecinos(x, y);
                if (this.tablero[x][y] == 1) {
                    if (CelulasVivas < 2) {
                        nuevoTablero[x][y] = 0;
                    } else if (CelulasVivas == 2 || CelulasVivas == 3) {
                        nuevoTablero[x][y] = 1;
                    } else if (CelulasVivas > 3) {
                        nuevoTablero[x][y] = 0;
                    }
                } else {
                    if (CelulasVivas == 3) {
                        nuevoTablero[x][y] = 1;
                    }
                }
            }

        }

        this.tablero = nuevoTablero;
    }

    void setMuerto(int x, int y) {
        this.tablero[x][y] = 0;
    }

    void setVivo(int x, int y) {
        this.tablero[x][y] = 1;
    }

    
     void borrarTablero(){
        int[][] nuevoTablero = new int[ancho][alto];

        for (int y = 0; y < alto; y+=avance) {
            for (int x = 0; x < ancho; x+=avance) {
                int CelulasVivas = 0;

                if (this.tablero[x][y] == 1) {
                    if (CelulasVivas < 2) {
                        nuevoTablero[x][y] = 0;
                    } 
                } 

            }
        }
        this.tablero = nuevoTablero;
    }
}
