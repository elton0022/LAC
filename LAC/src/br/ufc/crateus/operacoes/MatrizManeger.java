/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.operacoes;

import javax.swing.JOptionPane;

/**
 *
 * @author Elton
 */
public class MatrizManeger {

    public int[][] soma(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                m1[i][j] += m2[i][j];
            }
        }
        return m1;
    }

    public int[][] subtracao(int[][] m1, int[][] m2) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {

                m1[i][j] -= m2[i][j];

            }
        }

        return m1;
    }

    public int[][] calculaProduto(int[][] a, int[][] b) {

        if (a[0].length != b.length) {
            throw new RuntimeException("Dimensões inconsistentes. Impossível multiplicar as matrizes");
        }

        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }

        return result;
    }

    public int[][] transposta(int[][] a) {

        int[][] aux = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                aux[j][i] = a[i][j];

            }
        }
        return aux;
    }

    public int[][] escalar(int[][] a, int x) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                a[i][j] *= x;

            }
        }
        return a;
    }

    public int[][] potencia(int[][] matr, int p) {
        int[][] result = matr;

        if (p == 0) {
            result = iPot(matr.length);
        } else {

            for (int n = 1; n < p; ++n) {
                result = mult(result, matr, matr.length, matr[0].length);
            }
        }

        return result;
    }

    public int[][] mult(int[][] Matriz1, int[][] Matriz2, int L1, int C1) {
        int[][] Matriz3 = new int[L1][C1];
        for (int i = 0; i < L1; i++) {
            for (int j = 0; j < C1; j++) {
                for (int k = 0; k < C1; k++) {
                    Matriz3[i][j] += (Matriz1[i][k] * Matriz2[k][j]);
                }
            }
        }
        return Matriz3;
    }

////////////////////////////////////////////////////////////////////////////////
    public double[][] matrizAdjunta(double[][] matriz) {

        double[][] aux1 = new double[matriz.length][matriz.length];
        double[][] aux = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //aux[][] = this.subMatriz(i,j,matriz);
                double numAdjunto = Math.pow(-1, i + j); //* this.calcularDeterminante(matriz, 0);
                aux1[i][j] *= numAdjunto;
            }
        }
        System.out.println(aux[0][0]);
        return aux1;
    }

    public double[][] InversaTotal(double[][] matriz) {
        double det = calcularDeterminante(matriz, 0);
        double[][] matAdjunta = this.matrizAdjunta(matriz);
        //imprime(this.matrizAdjunta(matriz));
        double[][] Inversa = this.matrizTranposta(matAdjunta);

        return Inversa;
    }

    public double[][] matrizTranposta(double m[][]) {
        double[][] mt = new double[m.length][m.length];
        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m.length; j++) {
                mt[i][j] = m[j][i];
            }
        }
        return mt;
    }

    public double calcularDeterminante(double[][] m, int linha) {
        if (m.length == 2) {
            double det = m[0][0] * m[1][1] - m[0][1] * m[1][0];
            return det;
        } else {
            double det = 0;
            for (int j = 0; j < m.length; j++) {
                double[][] matrizTemp = subMatriz(linha, j, m);
                det += Math.pow(-1, linha + j) * m[linha][j] * calcularDeterminante(matrizTemp, linha);
            }
            return det;
        }
    }

    private double[][] subMatriz(int l, int c, double[][] m) {
        double[][] matrizTemp = new double[m.length - 1][m.length - 1];
        int aux1 = 0;
        int aux2 = 0;

        for (int i = 0; i < m.length; i++) {
            if (i != l) {
                aux2 = 0;
                for (int j = 0; j < m.length; j++) {
                    if (j != c) {
                        matrizTemp[aux1][aux2] = m[i][j];
                        aux2++;
                    }
                }
                aux1++;
            }
        }
        return matrizTemp;
    }

    private double[][] dividePorDeterminante(double[][] matriz, double determinante) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] /= determinante;
            }
        }
        return matriz;
    }

    public double[][] matrizCofatora(double[][] m) {

        double[][] matrizCofatora = new double[m.length][m.length];

        if (matrizCofatora.length == 2) {

            matrizCofatora[0][0] = m[1][1];
            matrizCofatora[0][1] = m[1][0] * (-1);
            matrizCofatora[1][0] = m[0][1] * (-1);
            matrizCofatora[1][1] = m[0][0];

        } else {
            for (int i = 0; i < matrizCofatora.length; i++) {
                for (int j = 0; j < matrizCofatora.length; j++) {
                    double[][] aux = subMatriz(i, j, m);
                    double elementoCofator = Math.pow(-1, i + j) * calcularDeterminante(aux, 0);
                    //JOptionPane.showMessageDialog(null, calcularDeterminante(aux, 0));
                    matrizCofatora[i][j] = elementoCofator;
                }
            }
        }
        return matrizCofatora;
    }

    public void mostrarMatriz(double[][] matriz) {
        String resultado = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz[0].length; x++) {
                resultado = resultado + "     " + matriz[i][x];
            }
            resultado += "\n"; // Quebra a linha pra ficar um embaixo do outro
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public double[][] matrizInversa(double[][] m) {
        double det = calcularDeterminante(m, 0);
        if (det != 0) {
            if (m.length == 2 && m[0].length == 2) {
                double[][] aux = new double[m.length][m[0].length];

                aux[0][0] = m[1][1] / det;
                aux[0][1] = (m[0][1] / det) * (-1);
                aux[1][0] = (m[1][0] / det) * (-1);

                aux[1][1] = (m[0][0]) / (det);
                System.out.println("M [0][0] : " + m[0][0]);
                System.out.println("M [0][1] : " + m[0][1]);
                System.out.println("M [1][0] : " + m[1][0]);
                System.out.println("M [1][1] : " + m[1][1]);
                System.out.println("DET : " + det);
                System.out.println("AUX [1][1] : " + aux[1][1]);
                return aux;
            } else {
                double[][] matrizInversa = new double[m.length][m.length];
                double[][] matrizAdjunta = matrizTranposta(matrizCofatora(m));
                matrizAdjunta = dividePorDeterminante(matrizAdjunta, det);
                for (int i = 0; i < m.length; i++) {
                    for (int j = 0; j < m.length; j++) {
                        matrizInversa[i][j] = matrizAdjunta[i][j];
                    }
                }
                return matrizInversa;
            }
        }
        return null;
    }

    public int auxCof(int i, int j) {

        if (((i + j) + 2) % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public String[][] inversaString(int[][] mat, int det) {

        String[][] matr = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (mat[i][j] % det == 0) {

                    matr[i][j] = String.valueOf(mat[i][j] / det);

                } else {
                    //String.valueOf(mat[i][j]/determinante(mat));
                    matr[i][j] = "" + mat[i][j] + "/" + det;
                }

            }
        }

        return matr;
    }
    /////////////////////////INVERSA////////////////////////////////

    public void imprime(double[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                System.out.println(mat[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void imprimeString(String[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {

                System.out.println(mat[i][j]);
            }
        }
    }

    private int[][] iPot(int length) {
        int l, c;
        l = c = 0;
        int[][] matr = new int[length][length];
        while (c < length) {
            while (l < length) {
                if (c == l) {
                    matr[c][l] = 1;
                } else {
                    matr[c][l] = 0;
                }
                l++;
            }
            c++;
            l = 0;
        }

        return matr;
    }
}
