/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.controller;

import aplicacao.App;
import br.ufc.crateus.interfaces.SistemasServicos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Elton
 */
public class SistemasController implements Initializable {

    SistemasServicos servicos = new SistemasServicos();

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid1;
    @FXML
    private GridPane grid2;
    @FXML
    private TextField linha;
    @FXML
    private TextField coluna;
    @FXML
    private TextField matrizEscalonada;
    @FXML
    private TextField text4;
    @FXML
    private Button bt3;
    @FXML
    private Button bt4;

    @FXML
    private void criaMatrizLC(ActionEvent e) {
        grid1.getChildren().clear();
        grid2.getChildren().clear();

        servicos.geraMatrizLC(grid1, grid2, linha, coluna);

    }

    @FXML
    private void Sair(ActionEvent e) {

        App.changeScreen("TelaInicial");

    }

    @FXML
    private void resolverGauss(ActionEvent e) {

        servicos.resolverGauss(grid1, grid2, linha, coluna);

    }

    @FXML
    private void resolverGaussJordan(ActionEvent e) {

        servicos.resolverGaussJordan(grid1, grid2, linha, coluna);
    }

    @FXML
    private void resolverFatoracaoLU(ActionEvent e) {

        servicos.fatorarLU(grid1, grid2, linha, coluna);
    }

    @FXML
    private void solucoes(ActionEvent e) {
        servicos.solucaoSistema(grid1, grid1, linha, coluna);
    }

    @FXML
    private void postoAmpliada(ActionEvent e) {
        servicos.postoA(grid1, grid1, linha, coluna);
    }

    @FXML
    private void postoCoeficientes(ActionEvent e) {
        servicos.postoC(grid1, grid1, linha, coluna);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
