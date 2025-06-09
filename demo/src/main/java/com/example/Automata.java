package com.example;

public class Automata {
    int estadoInicial;
    int[] estadoFinal;
    Transicion[] transiciones;
    int estadoActual;
    int pos=0;

    public Automata(int estadoInicial, int[] estadoFinal, Transicion[] transiciones) {
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
        this.transiciones = transiciones;
        this.estadoActual = estadoInicial;
    }
    
      public void validarCadena(String cadena) {
        while (cadena.charAt(pos) != '#') {
            estadoActual = transicion(estadoActual, cadena.charAt(pos));
            pos++;
        }

        if (esEstadoFinal(estadoActual)) {
            System.out.println("Cadena válida");
        } else {
            System.out.println("Syntax error");
        }
    }

    private boolean esEstadoFinal(int estado) {
        for (int finalState : estadoFinal) {
            if (estado == finalState) {
                return true;
            }
        }
        return false;
    }

    private int transicion(int estadoActual, char caracter) {
        for (Transicion t : transiciones) {
            if (t != null &&
                t.getEstadoInicial() == estadoActual &&
                t.getCaracter() == caracter) {
                return t.getEstadoFinal();
            }
        }
        return -1;
    }
}
