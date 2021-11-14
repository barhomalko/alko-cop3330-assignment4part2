/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.Objects;

/*runs app*/


public class App {

    @Override
    public void start(Stage stage) {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("App.fxml")));
        stage.setTitle("Application Assignment");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }



}