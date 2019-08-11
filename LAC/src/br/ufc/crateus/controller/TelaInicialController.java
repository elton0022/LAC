/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.controller;

import aplicacao.App;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author Elton
 */
public class TelaInicialController implements Initializable {

    @FXML
    ImageView im = new ImageView("file:imagens/logo.png");

    @FXML
    private void irParaMatrizes(ActionEvent event) {
        App.changeScreen("Matriz");
    }

    @FXML
    private void irParaSistemas(ActionEvent event) {
        App.changeScreen("Sistema");
    }

    @FXML
    private void irParaEspacos(ActionEvent event) {
        App.changeScreen("Espaco");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
