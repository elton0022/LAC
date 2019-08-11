/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.interfaces;

import br.ufc.crateus.operacoes.EspacoManeger;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

public class EspacoServicos {

    EspacoManeger maneger = new EspacoManeger();

    TextField tt;

    public void geraMatrizLC(GridPane p, TextField linhas1, TextField colunas1) {
        for (int i = 0; i < Integer.parseInt(linhas1.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(colunas1.getText()); j++) {
                tt = new TextField();
                tt.setPrefSize(70, 30);
                tt.setFont(Font.font(15));
                p.add(tt, j, i);
            }
        }
    }

    public void resolverEspaco(GridPane a, TextField linha, TextField coluna) {

        double[][] matriz1 = new double[Integer.parseInt(linha.getText())][Integer.parseInt(coluna.getText())];

        transforma(linha, coluna, a, matriz1);
        matriz1 = maneger.ortogonalizar(matriz1);
        mostrarMatriz(matriz1);
        matriz1 = maneger.ortonormalizar(matriz1);
        mostrarMatriz(matriz1);

    }

    public void transforma(TextField linha, TextField coluna, GridPane matriz1, double[][] mat1) {
        for (int i = 0; i < Integer.parseInt(linha.getText()); i++) {
            for (int j = 0; j < Integer.parseInt(coluna.getText()); j++) {
                mat1[i][j] = Integer.parseInt(getConteudo(matriz1, i, j, coluna));
            }
        }
    }

    public String getConteudo(GridPane matriz, int linha, int coluna, TextField colunMat) {
        return ((TextField) matriz.getChildren().get((linha * Integer.parseInt(colunMat.getText())) + coluna)).getText();
    }

    public void mostrarMatriz(double[][] matriz) {
        String resultado = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int x = 0; x < matriz[0].length; x++) {
                resultado = resultado + "     " + matriz[x][i];
            }
            resultado += "\n"; // Quebra a linha pra ficar um embaixo do outro
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

}
