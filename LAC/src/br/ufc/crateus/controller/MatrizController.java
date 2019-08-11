/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.controller;

import aplicacao.App;
import br.ufc.crateus.interfaces.MatrizServicos;
import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 *
 */
public class MatrizController implements Initializable {

    MatrizServicos servico = new MatrizServicos();

    @FXML
    GridPane pane1;
    @FXML
    GridPane pane2;
    @FXML
    GridPane pane3;
    @FXML
    ScrollPane sp;
    @FXML
    Button soma;
    @FXML
    Button total;
    @FXML
    Button limpar1;
    @FXML
    Button limpar2;
    @FXML
    Button limpar3;
    @FXML
    Button ok1;
    @FXML
    Button ok2;
    @FXML
    Label matriz1;
    @FXML
    Label matriz2;
    @FXML
    Label det1;
    @FXML
    Label det2;
    @FXML
    Label det3;
    @FXML
    Label determinante;
    @FXML
    Label operacao;
    @FXML
    TextField tamanho;
    @FXML
    TextField linhas1;
    @FXML
    TextField colunas1;
    @FXML
    TextField linhas2;
    @FXML
    TextField colunas2;
    @FXML
    TextField potencia;
    @FXML
    TextField escalar;

    TextField tt;
    int col;
    int lin;

    @FXML
    private void acionarSoma(ActionEvent event) {
        det1.setText("");
        det2.setText("");
        det3.setText("");
        determinante.setVisible(true);
        total.setVisible(true);
        tamanho.setVisible(true);
        soma.setVisible(true);
        matriz1.setVisible(false);
        matriz2.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        linhas1.setVisible(false);
        colunas1.setVisible(false);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(true);
        potencia.setVisible(false);
        operacao.setText("+");
        operacao.setVisible(true);
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarSubtracao(ActionEvent event) {
        determinante.setVisible(true);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(true);
        soma.setVisible(true);
        matriz1.setVisible(false);
        matriz2.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        linhas1.setVisible(false);
        colunas1.setVisible(false);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(true);
        potencia.setVisible(false);
        operacao.setText("-");
        operacao.setVisible(true);
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarMultiplicaçãoMatrizes(ActionEvent event) {
        determinante.setVisible(true);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(false);
        soma.setVisible(false);
        matriz1.setVisible(true);
        matriz2.setVisible(true);
        ok1.setVisible(true);
        ok2.setVisible(false);
        linhas1.setVisible(true);
        colunas1.setVisible(true);
        linhas2.setVisible(true);
        colunas2.setVisible(true);
        escalar.setVisible(false);
        sp.setVisible(true);
        potencia.setVisible(false);
        operacao.setText("X");
        operacao.setVisible(true);
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarCofatora(ActionEvent event) {
        determinante.setVisible(false);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(true);
        soma.setVisible(true);
        matriz1.setVisible(false);
        matriz2.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        linhas1.setVisible(false);
        colunas1.setVisible(false);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(false);
        potencia.setVisible(false);
        operacao.setVisible(false);
        operacao.setText("c");
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarAdjunta(ActionEvent event) {
        determinante.setVisible(false);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(true);
        soma.setVisible(true);
        matriz1.setVisible(false);
        matriz2.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        linhas1.setVisible(false);
        colunas1.setVisible(false);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(false);
        potencia.setVisible(false);
        operacao.setVisible(false);
        operacao.setText("Ad");
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarTransposta(ActionEvent event) {
        determinante.setVisible(false);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(false);
        soma.setVisible(false);
        matriz1.setVisible(true);
        matriz2.setVisible(false);
        ok1.setVisible(true);
        ok2.setVisible(false);
        linhas1.setVisible(true);
        colunas1.setVisible(true);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(false);
        potencia.setVisible(false);
        operacao.setVisible(false);
        operacao.setText("T");
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarInversa(ActionEvent event) {
        determinante.setVisible(false);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(false);
        soma.setVisible(false);
        matriz1.setVisible(true);
        matriz2.setVisible(false);
        ok1.setVisible(true);
        ok2.setVisible(false);
        linhas1.setVisible(true);
        colunas1.setVisible(true);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(false);
        potencia.setVisible(false);
        operacao.setVisible(false);
        operacao.setText("-1");
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void acionarPotencia(ActionEvent event) {
        determinante.setVisible(false);
        det1.setText("");
        det2.setText("");
        det3.setText("");
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        total.setVisible(true);
        tamanho.setVisible(true);
        soma.setVisible(true);
        matriz1.setVisible(false);
        matriz2.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        linhas1.setVisible(false);
        colunas1.setVisible(false);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(false);
        potencia.setVisible(true);
        operacao.setVisible(false);
        operacao.setText("p");
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
    }

    @FXML
    private void criaMatrizSomaESubtracao(ActionEvent e) {

        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();

        det1.setText("");
        det2.setText("");
        det3.setText("");

        servico.geraMatrizQuadrada(pane1, tamanho);
        servico.geraMatrizQuadrada(pane2, tamanho);
        servico.geraMatrizQuadrada(pane3, tamanho);
    }

    @FXML
    private void acionarMultiplicaçãoEscalar(ActionEvent event) {
        determinante.setVisible(false);
        tamanho.setVisible(false);
        soma.setVisible(false);
        matriz1.setVisible(true);
        matriz2.setVisible(false);
        ok1.setVisible(true);
        ok2.setVisible(false);
        linhas1.setVisible(true);
        colunas1.setVisible(true);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(true);
        sp.setVisible(false);
        potencia.setVisible(false);
        operacao.setText("x");
        operacao.setVisible(true);
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();
        det1.setText("");
        det2.setText("");
        det3.setText("");

    }

    @FXML
    private void criaMatriz(ActionEvent e) {
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();

        switch (operacao.getText()) {
            case "+":
                limpar1.setVisible(true);
                limpar2.setVisible(true);
                servico.geraMatrizQuadrada(pane1, tamanho);
                servico.geraMatrizQuadrada(pane2, tamanho);
                servico.geraMatrizQuadrada(pane3, tamanho);
                break;
            case "p":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizQuadrada(pane2, tamanho);
                servico.geraMatrizQuadrada(pane3, tamanho);
                break;
            case "-":
                limpar1.setVisible(true);
                limpar2.setVisible(true);
                servico.geraMatrizQuadrada(pane1, tamanho);
                servico.geraMatrizQuadrada(pane2, tamanho);
                servico.geraMatrizQuadrada(pane3, tamanho);
                break;
            case "c":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizQuadrada(pane2, tamanho);
                servico.geraMatrizQuadrada(pane3, tamanho);
                break;
            case "Ad":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizQuadrada(pane2, tamanho);
                servico.geraMatrizQuadrada(pane3, tamanho);
        }
    }

    @FXML
    private void criaMatrizBTN1(ActionEvent e) {
        pane1.getChildren().clear();
        pane2.getChildren().clear();
        pane3.getChildren().clear();

        switch (operacao.getText()) {
            case "X":
                limpar1.setVisible(true);
                servico.geraMatrizLC(pane1, linhas1, colunas1);
                ok2.setVisible(true);
                break;
            case "-1":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizLC(pane2, linhas1, colunas1);
                servico.geraMatrizLC(pane3, linhas1, colunas1);
                break;
            case "T":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizLC(pane2, linhas1, colunas1);
                servico.geraMatrizLC(pane3, colunas1, linhas1);
                break;
            case "p":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizLC(pane2, linhas1, colunas1);
                servico.geraMatrizLC(pane3, linhas1, colunas1);
                break;
            case "x":
                limpar1.setVisible(false);
                limpar2.setVisible(true);
                servico.geraMatrizLC(pane2, linhas1, colunas1);
                servico.geraMatrizLC(pane3, linhas1, colunas1);
                break;
        }
    }

    @FXML
    private void criaMatrizMultiplicaoBTN2(ActionEvent e) {

        switch (operacao.getText()) {

            case "X":
                limpar2.setVisible(true);
                if (Integer.parseInt(colunas1.getText()) == Integer.parseInt(linhas2.getText())) {
                    servico.geraMatrizLC(pane2, linhas2, colunas2);
                    servico.geraMatrizLC(pane3, linhas1, colunas2);
                } else {
                    JOptionPane.showMessageDialog(null, "O Número de colunas da Matriz 1 devem ser igual ao número de linhas da Matriz 2");
                }
        }
    }

    @FXML
    private void resultado(ActionEvent event) {
        det1.setText("");
        det2.setText("");
        det3.setText("");

        switch (operacao.getText()) {
            case "c":
                servico.cofatoraMatriz(pane2, pane3, tamanho);
                det2.setText(servico.determinante(pane2, tamanho));
                det3.setText(servico.determinante(pane3, tamanho));
                break;
            case "Ad":
                servico.adjuntaMatriz(pane2, pane3, tamanho);
                det2.setText(servico.determinante(pane2, tamanho));
                det3.setText(servico.determinante(pane3, tamanho));
                break;
            case "+":
                servico.somaDeMatrizes(pane1, pane2, pane3, tamanho);
                det1.setText(servico.determinante(pane1, tamanho));
                det2.setText(servico.determinante(pane2, tamanho));
                det3.setText(servico.determinante(pane3, tamanho));
                break;
            case "-":
                servico.subtracaoDeMatrizes(pane1, pane2, pane3, tamanho);
                det1.setText(servico.determinante(pane1, tamanho));
                det2.setText(servico.determinante(pane2, tamanho));
                det3.setText(servico.determinante(pane3, tamanho));
                break;
            case "X":
                servico.multiplicaoDeMatrizes(pane1, pane2, pane3, linhas1, linhas2, colunas1, colunas2);
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det1.setText(servico.determinante(pane1, linhas1));
                }
                if (Integer.parseInt(linhas2.getText()) == Integer.parseInt(colunas2.getText())) {
                    det2.setText(servico.determinante(pane2, linhas2));
                }
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas2.getText())) {
                    det3.setText(servico.determinante(pane3, linhas1));
                }

                break;
            case "T":
                servico.transpostaMatriz(pane2, pane3, linhas1, colunas1);
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det2.setText(servico.determinante(pane2, linhas1));
                }
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det3.setText(servico.determinante(pane3, linhas1));
                }
                break;
            case "x":
                servico.multiplicacaoEscalar(pane2, pane3, linhas1, colunas1, escalar);
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det2.setText(servico.determinante(pane2, linhas1));
                }
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det3.setText(servico.determinante(pane3, linhas1));
                }
                break;
            case "p":
                servico.potenciaMatriz(pane2, pane3, tamanho, potencia);
                det2.setText(servico.determinante(pane2, tamanho));
                det3.setText(servico.determinante(pane3, tamanho));
                break;
            case "-1":
                servico.inversaMatriz(pane2, pane3, linhas1, colunas1);
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det2.setText(servico.determinante(pane2, linhas1));
                }
                if (Integer.parseInt(linhas1.getText()) == Integer.parseInt(colunas1.getText())) {
                    det3.setText(servico.determinante(pane3, linhas1));
                }
                break;

        }

    }

    @FXML
    private void limpa1(ActionEvent event) {
        det1.setText("");
        det2.setText("");
        det3.setText("");
        switch (operacao.getText()) {
            case "+":
                pane1.getChildren().clear();
                servico.geraMatrizQuadrada(pane1, tamanho);
                break;
            case "X":
                pane1.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizLC(pane1, linhas1, colunas1);
                break;
            case "-":
                pane1.getChildren().clear();
                servico.geraMatrizQuadrada(pane1, tamanho);
                break;
        }

    }

    @FXML
    private void limpa2(ActionEvent event) {
        det1.setText("");
        det2.setText("");
        det3.setText("");
        switch (operacao.getText()) {
            case "+":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizQuadrada(pane2, tamanho);
            case "-":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizQuadrada(pane2, tamanho);

                break;
            case "X":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizLC(pane2, linhas2, colunas2);
                break;
            case "-1":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizQuadrada(pane2, tamanho);
                break;
            case "p":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizQuadrada(pane2, tamanho);
                break;
            case "T":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizLC(pane2, linhas1, colunas1);
                break;
            case "x":
                pane2.getChildren().clear();
                pane3.getChildren().clear();
                servico.geraMatrizLC(pane2, linhas1, colunas1);
                break;
        }

    }

    @FXML
    private void sair(ActionEvent event) {
        App.changeScreen("TelaInicial");
    }

    @FXML
    private void irSistemas(ActionEvent event) {
        App.changeScreen("Sistemas");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tamanho.setVisible(false);
        soma.setVisible(false);
        matriz1.setVisible(false);
        matriz2.setVisible(false);
        ok1.setVisible(false);
        ok2.setVisible(false);
        linhas1.setVisible(false);
        colunas1.setVisible(false);
        linhas2.setVisible(false);
        colunas2.setVisible(false);
        escalar.setVisible(false);
        sp.setVisible(true);
        potencia.setVisible(false);
        operacao.setVisible(false);
        total.setVisible(false);
        limpar1.setVisible(false);
        limpar2.setVisible(false);
        det1.setText("");
        det2.setText("");
        det3.setText("");
    }

}
