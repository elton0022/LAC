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
public class SistemasManeger {

    public double[][] gauss(double[][] matrix) {
        double[][] resultado = new double[matrix.length][matrix[0].length];
        double fm = 0; // variavel multiplicado
        double ep = 0;// pivo

        for (int i = 0; i < matrix.length; i++) { // gera copia da matriz
            for (int j = 0; j < matrix[0].length; j++) {
                resultado[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < resultado.length - 1; k++) {
            ep = resultado[k][k];
            for (int i = k + 1; i < resultado.length; i++) {
                fm = resultado[i][k] / ep;
                for (int j = 0; j < resultado[i].length; j++) {
                    resultado[i][j] = resultado[i][j] - (fm * resultado[k][j]);
                }
                mostrarMatriz(resultado);
            }
        }
        return resultado;
    }

    public double[][] linhasNulas(double[][] matrix) {
        double[][] resultado = new double[matrix.length][matrix[0].length];
        double fm = 0; // variavel multiplicado
        double ep = 0;// pivo

        for (int i = 0; i < matrix.length; i++) { // gera copia da matriz
            for (int j = 0; j < matrix[0].length; j++) {
                resultado[i][j] = matrix[i][j];
            }
        }

        for (int k = 0; k < resultado.length - 1; k++) {
            ep = resultado[k][k];
            for (int i = k + 1; i < resultado.length; i++) {
                fm = resultado[i][k] / ep;
                for (int j = 0; j < resultado[i].length; j++) {
                    resultado[i][j] = resultado[i][j] - (fm * resultado[k][j]);
                }
            }
        }
        return resultado;
    }

    public double[] solucoes(double[][] matrix) {
        double[] variables = new double[matrix.length];

        // variavel final
        variables[matrix.length - 1] = matrix[matrix.length - 1][matrix[0].length - 1] / matrix[matrix.length - 1][matrix[0].length - 2];

        for (int i = matrix.length - 2; i >= 0; i--) {
            variables[i] = matrix[i][matrix[i].length - 1];
            for (int j = matrix[i].length - 2; j >= i; j--) {
                if (i != j) {

                    variables[i] = variables[i] - (matrix[i][j] * variables[j]);

                } else {
                    variables[i] = variables[i] / matrix[i][j];
                }
            }
        }
        return variables;
    }

    public double[][] gaussJordan(double[][] matrix) {
        double fm = 0;// fator de multiplicacao

        double[][] matrixSol = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrixSol[i] = matrix[i].clone();
        }

        for (int i = 0; i < matrixSol.length; i++) {
            double pivote = matrixSol[i][i];
            for (int j = 0; j < matrixSol[0].length; j++) {
                //System.out.println("i: " + i + " j: " + j);
                //displayMatrix(matrixSol);
                matrixSol[i][j] = matrixSol[i][j] / pivote;
            }
            for (int k = 0; k < matrixSol.length; k++) {
                if (k != i) {
                    fm = matrixSol[k][i];
                    for (int j = 0; j < matrixSol[0].length; j++) {
                        matrixSol[k][j] = matrixSol[k][j] - (fm * matrixSol[i][j]);
                    }
                    mostrarMatriz(matrixSol);
                }
            }
        }

        return matrixSol;
    }

    public void fatoracaoLU(double[][] matr) {

        int m = matr.length;
        int n = matr[0].length;
        double soma = 0;
        double[][] l = new double[m][m];
        double[][] u = matr;
        double[] x = new double[n];
        double[] y = new double[m];

        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i < m; i++) {
                l[i][j] = u[i][j] / u[j][j];
                for (int k = j + 1; k < n; k++) {
                    u[i][k] = u[i][k] - l[i][j] * u[j][k];
                }
                u[i][j] = 0;
            }
        }
        // Triangular inferior
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    l[i][j] = 1;
                }
                //ta.appendText(" " + formato.format(l[i][j]));
            }
            //ta.appendText("\n");
        }
        // Triangular superior
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //ta.appendText(" " + formato.format(u[i][j]));
            }
            //ta.appendText("\n");
        }
        mostrarMatrizL(l);
        mostrarMatrizU(u);
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

    public void mostrarMatrizL(double[][] matriz) {
        String resultado = "            Matriz L \n";
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz[0].length; x++) {
                resultado = resultado + "     " + matriz[i][x];
            }
            resultado += "\n"; // Quebra a linha pra ficar um embaixo do outro
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public void mostrarMatrizU(double[][] matriz) {
        String resultado = "            Matriz U \n";
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz[0].length; x++) {
                resultado = resultado + "     " + matriz[i][x];
            }
            resultado += "\n"; // Quebra a linha pra ficar um embaixo do outro
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

}
