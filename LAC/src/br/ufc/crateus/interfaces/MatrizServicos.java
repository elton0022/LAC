/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.interfaces;

import br.ufc.crateus.operacoes.MatrizManeger;
import br.ufc.crateus.operacoes.MatrizManeger;
import java.awt.Font;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Elton
 */
public class MatrizServicos {

    MatrizManeger m = new MatrizManeger();
    TextField tt;

    public void geraMatrizLC(GridPane p, TextField linhas1, TextField colunas1) {
        for (int i = 0; i < Integer.parseInt(linhas1.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(colunas1.getText()); j++) {
                tt = new TextField();
                tt.setPrefSize(38, 28);
                p.add(tt, j, i);
            }
        }
    }

    public void geraMatrizQuadrada(GridPane p, TextField tamanho) {
        for (int i = 0; i < Integer.parseInt(tamanho.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tamanho.getText()); j++) {
                tt = new TextField();
                tt.setPrefSize(38, 28);
                p.add(tt, j, i);
            }
        }
    }

    public String determinante(GridPane a, TextField tamanho) {
        double determinante1;

        double[][] matrizM1 = new double[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];

        transformaDET(tamanho, tamanho, a, matrizM1);

        determinante1 = m.calcularDeterminante(matrizM1, 0);

        return String.valueOf(determinante1);
    }

    public void somaDeMatrizes(GridPane matriz1, GridPane matriz2, GridPane matriz3, TextField tamanho) {

        int[][] matrizM1 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];
        int[][] matrizM2 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];
        int[][] matrizM3 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];
        //m.imprime(t);
        transforma(tamanho, matriz1, matriz2, matrizM1, matrizM2);
        matrizM3 = m.soma(matrizM1, matrizM2);

        //m.imprime(m.InversaTotal(t));
        //m.matrizInversa(t,tt);
        //m.imprime(tt);
        setConteudo(matrizM3, tamanho, matriz3);

    }

    public void subtracaoDeMatrizes(GridPane matriz1, GridPane matriz2, GridPane matriz3, TextField tamanho) {

        int[][] matrizM1 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];
        int[][] matrizM2 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];
        int[][] matrizM3 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];

        transforma(tamanho, matriz1, matriz2, matrizM1, matrizM2);
        matrizM3 = m.subtracao(matrizM1, matrizM2);
        setConteudo(matrizM3, tamanho, matriz3);

    }

    public void transpostaMatriz(GridPane matriz2, GridPane matriz3, TextField linha, TextField coluna) {
        int tamanhoLin = Integer.parseInt(linha.getText());
        int tamanhoCol = Integer.parseInt(coluna.getText());

        int[][] matrizM2 = new int[tamanhoLin][tamanhoCol];
        int[][] matrizM3 = new int[tamanhoCol][tamanhoLin];

        transformaTransposta(linha, coluna, matriz2, matrizM2);
        matrizM3 = m.transposta(matrizM2);

        for (int i = 0; i < matrizM3.length; i++) {
            for (int j = 0; j < matrizM3[0].length; j++) {
                ((TextField) matriz3.getChildren().get((i * matrizM3[0].length) + j)).setText(String.valueOf(matrizM3[i][j]));
            }
        }

    }

    public void cofatoraMatriz(GridPane matriz2, GridPane matriz3, TextField tamanhomt) {
        int tamanho = Integer.parseInt(tamanhomt.getText());

        double[][] matrizM2 = new double[tamanho][tamanho];
        double[][] matrizM3 = new double[tamanho][tamanho];

        transformaCofatora(tamanhomt, matriz2, matrizM2);
        matrizM3 = m.matrizCofatora(matrizM2);
        setConteudoCof(matrizM3, tamanhomt, matriz3);
    }

    public void adjuntaMatriz(GridPane matriz2, GridPane matriz3, TextField tamanhomt) {
        int tamanho = Integer.parseInt(tamanhomt.getText());

        double[][] matrizM2 = new double[tamanho][tamanho];
        double[][] matrizM3 = new double[tamanho][tamanho];

        transformaCofatora(tamanhomt, matriz2, matrizM2);
        matrizM3 = m.matrizTranposta(m.matrizCofatora(matrizM2));
        setConteudoCof(matrizM3, tamanhomt, matriz3);
    }

    ////////apagar --------
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

    public void inversaMatriz(GridPane matriz2, GridPane matriz3, TextField linha, TextField coluna) {
        int tamanhoLin = Integer.parseInt(linha.getText());
        int tamanhoCol = Integer.parseInt(coluna.getText());

        double[][] matrizM2 = new double[tamanhoLin][tamanhoCol];
        double[][] matrizM3 = new double[tamanhoCol][tamanhoLin];

        transformaTransposta2(linha, coluna, matriz2, matrizM2);
        matrizM3 = m.matrizInversa(matrizM2);

        for (int i = 0; i < matrizM3.length; i++) {
            for (int j = 0; j < matrizM3[0].length; j++) {
                ((TextField) matriz3.getChildren().get((i * matrizM3[0].length) + j)).setText(String.valueOf(matrizM3[i][j]));
            }
        }

    }

    public void multiplicaoDeMatrizes(GridPane matriz1, GridPane matriz2, GridPane matriz3, TextField linha1, TextField linha2, TextField coluna1, TextField coluna2) {

        int[][] matrizM1 = new int[Integer.parseInt(linha1.getText())][Integer.parseInt(coluna1.getText())];
        int[][] matrizM2 = new int[Integer.parseInt(linha2.getText())][Integer.parseInt(coluna2.getText())];
        int[][] matrizM3 = new int[Integer.parseInt(linha1.getText())][Integer.parseInt(coluna2.getText())];

        transformaMulti(matriz1, matriz2, matrizM1, matrizM2, linha1, coluna1, linha2, coluna2);
        matrizM3 = m.calculaProduto(matrizM1, matrizM2);
        setConteudoMulti(matrizM3, linha1, coluna2, matriz3);

    }

    public void multiplicacaoEscalar(GridPane matriz1, GridPane matriz2, TextField linha, TextField coluna, TextField escalar) {
        int linhas = Integer.parseInt(linha.getText());
        int colunas = Integer.parseInt(coluna.getText());
        int escal = Integer.parseInt(escalar.getText());
        int total;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {

                total = escal * Integer.parseInt(getConteudo(matriz1, i, j, coluna));
                ((TextField) matriz2.getChildren().get(((i * colunas) + j))).setText(String.valueOf(total));
            }
        }
    }

    public void potenciaMatriz(GridPane matriz1, GridPane matriz2, TextField tamanho, TextField potencia) {

        int[][] matrizM1 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];
        int[][] matrizM2 = new int[Integer.parseInt(tamanho.getText())][Integer.parseInt(tamanho.getText())];

        transformaPotencia(matriz1, tamanho, matrizM1);
        matrizM2 = m.potencia(matrizM1, Integer.parseInt(potencia.getText()));
        setConteudo(matrizM2, tamanho, matriz2);
    }

    //////////////////////////Operações que serão utilizadas acima/////////
    public String getConteudo(GridPane matriz, int linha, int coluna, TextField colunMat) {
        return ((TextField) matriz.getChildren().get((linha * Integer.parseInt(colunMat.getText())) + coluna)).getText();
    }

    public void setConteudo(int[][] matriz, TextField tamanho, GridPane resultado) {

        for (int i = 0; i < Integer.parseInt(tamanho.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tamanho.getText()); j++) {
                ((TextField) resultado.getChildren().get((i * Integer.parseInt(tamanho.getText())) + j)).setText(String.valueOf(matriz[i][j]));
            }
        }
    }

    public void setConteudoCof(double[][] matriz, TextField tamanho, GridPane resultado) {

        for (int i = 0; i < Integer.parseInt(tamanho.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tamanho.getText()); j++) {
                ((TextField) resultado.getChildren().get((i * Integer.parseInt(tamanho.getText())) + j)).setText(String.valueOf(matriz[i][j]));
            }
        }
    }

    public void setConteudoMulti(int[][] matriz, TextField linha, TextField coluna, GridPane resultado) {

        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {
                ((TextField) resultado.getChildren().get((i * Integer.parseInt(coluna.getText())) + j)).setText(String.valueOf(matriz[i][j]));
            }
        }
    }

    public void transformaCofatora(TextField tam, GridPane matriz1, double[][] mat1) {
        for (int i = 0; i < Integer.parseInt(tam.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tam.getText()); j++) {
                mat1[i][j] = Double.parseDouble(getConteudo(matriz1, i, j, tam));
            }
        }
    }

    public void transformaTransposta(TextField linha, TextField coluna, GridPane matriz1, int[][] mat1) {
        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {
                mat1[i][j] = Integer.parseInt(getConteudo(matriz1, i, j, coluna));
            }
        }
    }

    public void transforma(TextField tamanho, GridPane matriz1, GridPane matriz2, int[][] mat1, int[][] mat2) {
        for (int i = 0; i < Integer.parseInt(tamanho.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tamanho.getText()); j++) {

                mat1[i][j] = Integer.parseInt(getConteudo(matriz1, i, j, tamanho));
                mat2[i][j] = Integer.parseInt(getConteudo(matriz2, i, j, tamanho));
            }
        }
    }

    public void transformaTransposta2(TextField linha, TextField coluna, GridPane matriz1, double[][] mat1) {
        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {

                mat1[i][j] = Integer.parseInt(getConteudo(matriz1, i, j, coluna));
            }
        }
    }

    public void transformaDET(TextField linha, TextField coluna, GridPane matriz1, double[][] mat1) {
        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {

                mat1[i][j] = Double.valueOf(getConteudo(matriz1, i, j, coluna));
            }
        }
    }

    public void transformaMulti(GridPane matriz1, GridPane matriz2, int[][] matrizM1, int[][] matrizM2, TextField linha1, TextField coluna1, TextField linha2, TextField coluna2) {

        for (int i = 0; i < Integer.parseInt(linha1.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna1.getText()); j++) {
                matrizM1[i][j] = Integer.parseInt(getConteudo(matriz1, i, j, coluna1));
            }
        }
        for (int i = 0; i < Integer.parseInt(linha2.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna2.getText()); j++) {
                matrizM2[i][j] = Integer.parseInt(getConteudo(matriz2, i, j, coluna2));
            }
        }

    }

    public void transformaPotencia(GridPane matriz, TextField tamanho, int[][] mat2) {
        for (int i = 0; i < Integer.parseInt(tamanho.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tamanho.getText()); j++) {

                mat2[i][j] = Integer.parseInt(getConteudo(matriz, i, j, tamanho));
            }
        }
    }

}
