/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class About {

    public static String getText() {

        String text = null;

        URL resource = About.class.getResource("about.txt");
        assert resource != null;
        String filepath = resource.getPath();

        try {
            text = Files.readString(Path.of(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;

    }

    public static void displayPopup() {
        //displays
        Stage popUp = new Stage();


        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setTitle("About");
        Label label1 = new Label(getText());
        Button button1 = new Button("Close");
        button1.setOnAction(e -> popUp.close());
        VBox layout = new VBox(10);



        //alignment
        label1.setAlignment(Pos.CENTER);
        label1.setPadding(new Insets(10, 10, 10, 10));
        button1.setAlignment(Pos.BOTTOM_CENTER);
        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(layout);
        popUp.setScene(scene);
        popUp.showAndWait();

    }

}