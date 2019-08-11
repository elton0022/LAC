/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates ggf
 * and open the template in the editor.
 */
package aplicacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Elton
 */
public class App extends Application {

    static int linha = 4;
    static int coluna = 4;
    private static Stage stage;
    private static Scene TelaInicial;
    private static Scene Matriz;
    private static Scene Sistemas;
    private static Scene Espacos;

    @Override
    public void start(Stage stage1) throws Exception {

        stage = stage1;

        stage1.setTitle("LAC");

        Parent mainfx = FXMLLoader.load(getClass().getResource("TelaInicial.fxml"));
        TelaInicial = new Scene(mainfx);
        Parent detalhesfx = FXMLLoader.load(getClass().getResource("Matriz.fxml"));
        Matriz = new Scene(detalhesfx);

        Parent cadastrofx = FXMLLoader.load(getClass().getResource("Sistemas.fxml"));
        Sistemas = new Scene(cadastrofx);

        Parent espacofx = FXMLLoader.load(getClass().getResource("Espaco.fxml"));
        Espacos = new Scene(espacofx);

        stage1.setScene(TelaInicial);
        stage1.setResizable(false);
        stage1.show();
    }

    public static void changeScreen(String scr) {

        switch (scr) {
            case "TelaInicial":

                stage.setScene(TelaInicial);
                break;

            case "Matriz":

                stage.setScene(Matriz);
                break;

            case "Sistema":

                stage.setScene(Sistemas);
                break;

            case "Espaco":

                stage.setScene(Espacos);

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
