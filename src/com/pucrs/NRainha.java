package com.pucrs;

import java.util.ArrayList;
import java.util.List;

public class NRainha {
    private static int numeroRainhas;

    private static char[][] populaTabuleiro() {
        char[][] tabuleiro = new char[numeroRainhas][numeroRainhas];

        for (int linha = 0; linha < numeroRainhas; linha++) {
            for (int coluna = 0; coluna < numeroRainhas; coluna++) {
                tabuleiro[linha][coluna] = '-';
            }
        }
        return tabuleiro;
    }

    public static List<ArrayList<String>> resolve(int input) throws Exception {
        if (input <= 2) {
            throw new Exception("Você tem que selecionar um tamanho maior que 2");
        }
        numeroRainhas = input;

        char[][] tabuleiro = populaTabuleiro();
        List<ArrayList<String>> analise = new ArrayList<>();

        return resolveAux(0, analise, tabuleiro);
    }

    private static List<ArrayList<String>> resolveAux(int coluna, List<ArrayList<String>> retorno, char[][] tabuleiro) {

        if (coluna == numeroRainhas) {
            ArrayList<String> aux = new ArrayList<>();
            for (int linha = 0; linha < numeroRainhas; linha++) {
                aux.add(new String(tabuleiro[linha]));
            }
            retorno.add(aux);
            return retorno;
        }

        for (int linha = 0; linha < numeroRainhas; linha++) {
            if (ehSeguro(linha, coluna, tabuleiro)) {
                tabuleiro[linha][coluna] = 'R';
                resolveAux(coluna + 1, retorno, tabuleiro);
                tabuleiro[linha][coluna] = '-';
            }
        }
        return retorno;
    }

    private static boolean ehSeguro(int i, int j, char[][] tabuleiro) {

        for (int coluna = 0; coluna < j; coluna++) {
            if (tabuleiro[i][coluna] == 'R') {
                return false;
            }
        }
        int linha = i;
        int coluna = j;
        while (linha >= 0 && coluna >= 0) {
            if (tabuleiro[linha][coluna] == 'R') {
                return false;
            }
            linha--;
            coluna--;
        }
        coluna = j;
        linha = i;
        while (linha < numeroRainhas && coluna >= 0) {
            if (tabuleiro[linha][coluna] == 'R') {
                return false;
            }
            linha++;
            coluna--;
        }
        return true;
    }
}