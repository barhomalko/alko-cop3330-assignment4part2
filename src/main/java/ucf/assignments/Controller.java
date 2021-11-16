/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;


public class Controller {

    @FXML
    private TextField todoField;
    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private TableView<Todo> tableViewContainer;
    @FXML
    private ObservableList<Todo> data;
    @FXML
    private ObservableList<Todo> dataTemp;

    @FXML
    private TableColumn<Todo, String> dueDateColumn;
    @FXML
    private TableColumn<Todo, String> todoFieldColumn;
    @FXML
    private TableColumn<Todo, Boolean> boolColumn;

    @FXML
    private FileChooser fileChooser;
    @FXML
    private File f;


    // on app start:

    @FXML
    public void initialize() {

        fileChooser = new FileChooser();
        f = new File();
        tableViewContainer.setEditable(true);
        tableViewContainer.setPlaceholder(new Label("Check out HELP menu above for info."));

        // make todoLists an FXCollections with an observable array list
        data = FXCollections.observableArrayList();
        dataTemp = FXCollections.observableArrayList();

        // set default datepicker value
        dueDatePicker.setValue(LocalDate.now());
        todoField.setText("Todo");

        // use Columns class to set column data types
        ucf.assignments.Columns column = new ucf.assignments.Columns();

        ucf.assignments.Columns columns;
        columns.setDateColumn(dueDateColumn);
        columns.setTextColumn(todoFieldColumn);
        columns.setBoolColumn(boolColumn);


        // set items for listViewContainer from ObservableList
        tableViewContainer.setItems(data);

        // clear columns to make sure container is empty, then add all the columns to the container
        tableViewContainer.getColumns().clear();
        tableViewContainer.getColumns().addAll(dueDateColumn, todoFieldColumn, boolColumn);

    }
    
    @FXML
    public void clickAddList(ActionEvent actionEvent) {
        //launch a new TodoList app

        try {
            new App().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickDeleteList(ActionEvent actionEvent) {
        //clears program of data
        data.clear();
    }

    @FXML
    public void clickShowAll(ActionEvent actionEvent) {
        tableViewContainer.setItems(data);

    }

    @FXML
    public void clickShowCompleted(ActionEvent actionEvent) {
        //make objects that have completed=true to be visible in each column

        dataTemp.clear();
        dataTemp.addAll(data);
        dataTemp.removeIf(item -> !item.getBool());
        tableViewContainer.setItems(dataTemp);

    }

    @FXML
    public void clickShowIncomplete(ActionEvent actionEvent) {

        dataTemp.clear();
        dataTemp.addAll(data);

        dataTemp.removeIf(Todo::getBool);

        tableViewContainer.setItems(dataTemp);

    }

    @FXML
    public void clickNewTodo(ActionEvent actionEvent) {
        data.add(new Todo(
                dueDatePicker.getValue(),
                todoField.getText()));
                dueDatePicker.setValue(LocalDate.now());
                todoField.setText("Todo");

    }

    public void clickDeleteTodo(ActionEvent actionEvent) {
        int selectedIndex = tableViewContainer.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableViewContainer.getItems().remove(selectedIndex);
        }
    }

    @FXML
    public void menuLoadFile(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();

        ucf.assignments.File f;
        fileChooser.setInitialDirectory(new File(f.getFilePath()));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            f.setFileName(file);
            f.setFilePath(file);
            Object loadFile = f.readFile(((File) file).toPath());
            data.clear();
            data.addAll((ArrayList<Todo>) loadFile);
        }

    }

    @FXML
    public void menuSaveFile(ActionEvent actionEvent) {

        ArrayList<Todo> listofTodos = new ArrayList<>(data);

        fileChooser.setInitialFileName(File.getName());

        fileChooser.setInitialDirectory(new File(getFilePath()));

        File file = fileChooser.showSaveDialog(new Stage());

        //if file isn't empty/null run methods to save file
        if (file != null) {
            ucf.assignments.File f;
            f.setFileName(file);
            f.setFilePath(file);
            file.canWrite(file, listofTodos);
        }

    }

    public String getFilePath() {
        if (filePath == null) {
            return defaultPath;
        } else {
            return filePath;
        }
    }

    @FXML
    public void menuQuit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void clickAbout(ActionEvent actionEvent) {
        //displays About
        About.displayPopup();
    }

}