/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.interfaces;

import br.ufc.crateus.operacoes.SistemasManeger;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author Elton
 */
public class SistemasServicos {

    SistemasManeger maneger = new SistemasManeger();
    TextField tt;

    public void resolverGauss(GridPane a, GridPane b, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText()) + 1];

        transforma(linha, coluna, a, b, matriz1);
        matriz1 = maneger.gauss(matriz1);
        //solucoes(matriz1);
    }

    public void resolverGaussJordan(GridPane a, GridPane b, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText()) + 1];

        transforma(linha, coluna, a, b, matriz1);
        matriz1 = maneger.gaussJordan(matriz1);
        //solucoesGJ(matriz1);
    }

    public void fatorarLU(GridPane a, GridPane b, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText()) + 1];
        transforma(linha, coluna, a, b, matriz1);
        maneger.fatoracaoLU(matriz1);
    }

    public void solucaoSistema(GridPane a, GridPane b, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText()) + 1];
        transforma(linha, coluna, a, b, matriz1);
        solucoes(matriz1);
    }

    public void postoA(GridPane a, GridPane b, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText()) + 1];

        transforma(linha, coluna, a, b, matriz1);
        matriz1 = maneger.linhasNulas(matriz1);
        postoAmpliada(matriz1);
    }

    public void postoC(GridPane a, GridPane b, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText()) + 1];

        transforma(linha, coluna, a, b, matriz1);
        matriz1 = maneger.linhasNulas(matriz1);
        postoCoeficientes(matriz1);
    }

    public void classificacao(double[][] matriz) {
        String resultado = "";
        double[] soluc = new double[matriz[0].length];
        int x = 1;
        int i, j = 0;

        soluc = maneger.solucoes(matriz);

        if (String.valueOf(soluc[0]) == "NaN") {
            JOptionPane.showMessageDialog(null, "Sistema possivel indeterminado");
        } else if (String.valueOf(soluc[0]) == "-Infinity" || String.valueOf(soluc[0]) == "Infinity") {
            JOptionPane.showMessageDialog(null, "Sistema impossivel");
        } else {
            JOptionPane.showMessageDialog(null, "Sistema possivel determinado");
        }
    }

    public void classificaoGJ(double[][] matrix) {
        double[] vRes = new double[matrix.length];
        String resultado = "";
        int x = 1;
        for (int i = 0; i < matrix.length; i++) {
            vRes[i] = matrix[i][matrix[0].length - 1];
        }

        if (String.valueOf(vRes[0]) == "NaN") {
            JOptionPane.showMessageDialog(null, "Sistema possivel indeterminado");
        } else if (String.valueOf(vRes[0]) == "-Infinity" || String.valueOf(vRes[0]) == "Infinity") {
            JOptionPane.showMessageDialog(null, "Sistema impossivel");
        } else {
            JOptionPane.showMessageDialog(null, "Sistema possivel determinado");

        }
    }

    public void postoCoeficientes(double[][] matriz) {
        double[][] aux = new double[matriz.length][matriz[0].length];
        int flag = matriz.length;
        int ver = 0;
        int linhasNulas = 0;

        aux = matriz;
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[0].length - 1; j++) {
                if (aux[i][j] == 0) {
                    ver++;
                }
            }
            if (ver == flag) {
                linhasNulas++;
            }
        }

        JOptionPane.showMessageDialog(null, linhasNulas + 1);
    }

    public void postoAmpliada(double[][] matriz) {

        double[][] aux = new double[matriz.length][matriz[0].length];
        int flag = matriz.length;
        int ver = 0;
        int linhasNulas = flag;

        aux = matriz;
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[0].length; j++) {
                if (aux[i][j] == 0) {
                    ver++;
                }
            }
            if (ver == flag) {
                linhasNulas--;
            }
        }
        JOptionPane.showMessageDialog(null, linhasNulas + 1);
    }

    public void solucoes(double[][] matriz) {

        String resultado = "";
        double[] soluc = new double[matriz[0].length];
        int x = 1;
        double[][] aux = new double[matriz.length][matriz[0].length];
        int flag = 0;

        aux = maneger.gaussJordan(matriz);
        soluc = maneger.solucoes(aux);

        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[0].length; j++) {
                if (String.valueOf(aux[i][j]) == "NaN") {
                    flag = 1;
                }
            }
        }

        if (matriz.length < matriz[0].length) {
            flag = 2;
        }

        //if (flag == 2) {
        //  JOptionPane.showMessageDialog(null, "Sistema possível e indeterminado");
        //JOptionPane.showMessageDialog(null, "Possui infinitas soluções");
        //return;
        //}
        if (String.valueOf(soluc[0]) == "NaN") {
            JOptionPane.showMessageDialog(null, "Sistema possível e indeterminado");
            JOptionPane.showMessageDialog(null, "Possui infinitas soluções");
        } else if (String.valueOf(soluc[0]) == "-Infinity" || String.valueOf(soluc[0]) == "Infinity") {
            JOptionPane.showMessageDialog(null, "Sistema impossível");
            JOptionPane.showMessageDialog(null, "Não há Soluções");
        } else {
            for (int i = 0; i < soluc.length; i++) {
                resultado = resultado + "X" + x + ": " + soluc[i] + "\n";
                x++;
            }
            JOptionPane.showMessageDialog(null, "Sistema possível e determinado");
            JOptionPane.showMessageDialog(null, resultado);

        }
    }

    public void solucoesGJ(double[][] matrix) {
        double[] vRes = new double[matrix.length];
        String resultado = "";
        int x = 1;
        for (int i = 0; i < matrix.length; i++) {
            vRes[i] = matrix[i][matrix[0].length - 1];
        }

        if (String.valueOf(vRes[0]) == "NaN") {
            JOptionPane.showMessageDialog(null, "Sistema possivel indeterminado");
            JOptionPane.showMessageDialog(null, "Possui infinitas soluções");
        } else if (String.valueOf(vRes[0]) == "-Infinity" || String.valueOf(vRes[0]) == "Infinity") {
            JOptionPane.showMessageDialog(null, "Sistema impossivel");
            JOptionPane.showMessageDialog(null, "Não possui soluções");
        } else {
            for (int i = 0; i < vRes.length; i++) {
                resultado = resultado + "X" + x + ": " + vRes[i] + "\n";
                x++;
            }
            //mostrarMatriz(matrix);
            JOptionPane.showMessageDialog(null, "Sistema possivel determinado");
            JOptionPane.showMessageDialog(null, resultado);

        }
    }

    public void geraMatrizLC(GridPane p, GridPane x, TextField linhas1, TextField colunas1) {
        for (int i = 0; i < Integer.parseInt(linhas1.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(colunas1.getText()); j++) {
                tt = new TextField();
                tt.setPrefSize(55, 30);
                tt.setFont(Font.font(15));
                p.add(tt, j, i);
            }
        }

        for (int i = 0; i < Integer.parseInt(linhas1.getText()); i++) {
            for (int j = 0; j < 1; j++) {
                tt = new TextField();
                tt.setPrefSize(55, 30);
                tt.setFont(Font.font(15));
                x.add(tt, j, i);
            }
        }
    }

    public void geraMatrizQuadrada(GridPane p, TextField tamanho) {
        for (int i = 0; i < Integer.parseInt(tamanho.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(tamanho.getText()); j++) {
                tt = new TextField();
                tt.setPrefSize(50, 38);
                tt.setFont(Font.font(15));
                p.add(tt, j, i);
            }
        }
    }

    public void setConteudo(int[][] matriz, TextField linha, TextField coluna, GridPane resultado) {

        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {
                ((TextField) resultado.getChildren().get((i * Integer.parseInt(coluna.getText())) + j)).setText(String.valueOf(matriz[i][j]));
            }
        }
    }

    public void transforma(TextField linha, TextField coluna, GridPane matriz1, GridPane matriz2, double[][] mat1) {
        int iLinha = 0;
        int iColuna = 0;

        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {

                mat1[i][j] = Double.parseDouble(getConteudo(matriz1, i, j, coluna));
            }
        }

        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = mat1[0].length - 1; j < Integer.parseInt(coluna.getText()) + 1; j++) {
                mat1[i][j] = Double.parseDouble(getConteudoTermos(matriz2, iLinha, iColuna, 0));
                iLinha++;
                iColuna++;
            }
        }

    }

    public String getConteudo(GridPane matriz, int linha, int coluna, TextField colunMat) {
        return ((TextField) matriz.getChildren().get((linha * Integer.parseInt(colunMat.getText())) + coluna)).getText();
    }

    public String getConteudoTermos(GridPane matriz, int linha, int coluna, int totalcoluna) {
        return ((TextField) matriz.getChildren().get((linha * totalcoluna) + coluna)).getText();
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

}
