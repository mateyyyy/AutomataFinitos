package com.example;

public class AutomataOP {
    public Automata Concatenar(Automata a, Automata b){
        Transicion[] transiciones = new Transicion[a.estadoFinal.length];
        for(int i=0; i<a.estadoFinal.length; i++){
            transiciones[i] = new Transicion(a.estadoFinal[i], '-', b.estadoInicial);
        }

        Automata c = new Automata(a.estadoInicial, b.estadoFinal, concatenarArreglos(a.transiciones, b.transiciones, transiciones));
        return c;
    }

    public static Transicion[] concatenarArreglos(Transicion[]... arreglos) {
        int totalLength = 0;
        for (Transicion[] arr : arreglos) {
            totalLength += arr.length;
        }

        Transicion[] resultado = new Transicion[totalLength];
        int currentIndex = 0;

        for (Transicion[] arr : arreglos) {
            System.arraycopy(arr, 0, resultado, currentIndex, arr.length);
            currentIndex += arr.length;
        }

        return resultado;
    }

    // public Automata Union(Automata a, Automata b){
    //     Transicion transicion0 = new Transicion(0, '-', a.estadoInicial);
    //     Transicion transicion1 = new Transicion(0, '-', b.estadoInicial);
    //     int[] estadosFinales = new int[(a.estadoFinal.length+b.estadoFinal.length)];
    //     int index = 0;
    //     for(int i=0; i<a.estadoFinal.length; i++){
    //         estadosFinales[index++] = a.estadoFinal[i];
    //     }
    //     for(int i=0; i<b.estadoFinal.length; i++){
    //         estadosFinales[index++] = b.estadoFinal[i];
    //     }
    //     Automata c = new Automata(0, , null);
    // }
}