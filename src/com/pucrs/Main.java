package com.pucrs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        int tamanho = 8;
        List<ArrayList<String>> listaDeResultados = NRainha.resolve(tamanho);

        for (ArrayList<String> resultado : listaDeResultados) {
            System.out.println(resultado);
        }
    }
}
