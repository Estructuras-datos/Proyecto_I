package Juego;
import Model.Iterador;
import Model.Lista;
import Piezas.*;

/**
 *
 * @authors Denis Rodriguez, Sergio Vega
 */

public class Matriz{
    
    private Lista<Lista> matriz;
    private int contadorBlancas, contadorNegras;
    
    public Matriz() {
        this.matriz = new Lista<Lista>();
        contadorBlancas=12;
        contadorNegras=12;
        inicializarTablero();
    }
    
        private void inicializarTablero() {
        for (int i = 0; i < 8; i++) {
            Lista fi = new Lista<Campo>(); //creo las columnas cada vez que creo una nueva fila
            for (int j = 0; j < 8; j++) {
                switch (i % 2) {
                    case 0: //fila par
                        switch (j % 2) {
                            case 0: //columna par
                                fi.agregarFinal(new Campo(new Vacio('b'), i, j, 'b')); //todo en la columna y fila par es vacio en blanco
                                break;
                            case 1: //columna impar
                                if (i < 3) { //fichas del jugador negro
                                    fi.agregarFinal(new Campo(new Ficha('n', 'n'), i, j, 'n'));
                                } else if (i > 4) { //fichas del jugador blanco
                                    fi.agregarFinal(new Campo(new Ficha('b', 'n'), i, j, 'n'));
                                } else { //fichas vacias
                                    fi.agregarFinal(new Campo(new Vacio('n'), i, j, 'n')); 
                                }
                                break;
                        }
                        break;
                    case 1: //fila impar
                        switch (j % 2) {
                            case 0: //columna par
                                if (i < 3) { //fichas del jugador negro
                                    fi.agregarFinal(new Campo(new Ficha('n', 'n'), i, j, 'n'));
                                } else if (i > 4) { //fichas del jugador blanco
                                    fi.agregarFinal(new Campo(new Ficha('b', 'n'), i, j, 'n'));
                                } else { //fichas vacias
                                    fi.agregarFinal(new Campo(new Vacio('n'), i, j, 'n'));
                                }
                                break;
                            case 1: //columna impar
                                fi.agregarFinal(new Campo(new Vacio('b'), i, j, 'b')); //posiciones nulas
                                break;
                        }
                        break;
                }
            }
            matriz.agregarFinal(fi);
        }
    }

    public Lista<Lista> getMatriz() {
        return matriz;
    }

    public void setMatriz(Lista<Lista> matriz) {
        this.matriz = matriz;
    }
    
    public Campo getCampo(int x, int y){
        Iterador it = new Iterador(matriz);
        Iterador it2=new Iterador((Lista)it.getPos(x));
        return (Campo)it2.getPos(y);
    }
    
    public void restaNegras(){
        contadorNegras--;
    }
    
    public void restaBlancas(){
        contadorBlancas--;
    }

    public int getContadorBlancas() {
        return contadorBlancas;
    }

    public int getContadorNegras() {
        return contadorNegras;
    }
    
}
