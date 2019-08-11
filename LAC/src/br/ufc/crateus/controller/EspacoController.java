/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.controller;

import aplicacao.App;
import br.ufc.crateus.interfaces.EspacoServicos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Elton Mendes
 */
public class EspacoController implements Initializable {
    
   EspacoServicos servicos = new EspacoServicos();
    
    @FXML private TextField dimVetor;
    @FXML private TextField numVetor;
    @FXML private GridPane grid1;
    
     @FXML
    private void criaMatrizLC(ActionEvent e){
        grid1.getChildren().clear();
        
        servicos.geraMatrizLC(grid1,dimVetor, numVetor);
    
    }

    @FXML
    private void Sair(ActionEvent e){
        
        App.changeScreen("TelaInicial");
    
    }
    
    @FXML
    private void solucao(ActionEvent e){
    
        servicos.resolverEspaco(grid1, dimVetor, numVetor);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
