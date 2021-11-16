/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Columns {

    public void setDateColumn(TableColumn<Todo, String> dateColumn) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Due_Date"));
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        dateColumn.setOnEditCommit(
                (javafx.scene.control.TableColumn.CellEditEvent<Todo, String> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDueDate(t.getNewValue())
        );

    }

    public void setTextColumn(TableColumn<Todo, String> textColumn) {
        textColumn.setCellValueFactory(new PropertyValueFactory<>("Sample"));
        textColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        textColumn.setOnEditCommit(
                (javafx.scene.control.TableColumn.CellEditEvent<Todo, String> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setTodoText(t.getNewValue())
        );

    }

    public void setBoolColumn(TableColumn<Todo, Boolean> boolCol) {
        boolCol.setCellValueFactory(new PropertyValueFactory<>("boolean"));
        boolCol.setCellFactory(ComboBoxTableCell.forTableColumn(true, false));
        boolCol.setOnEditCommit(
                (javafx.scene.control.TableColumn.CellEditEvent<Todo, Boolean> t) ->
                        (t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setBool(t.getNewValue())
        );

    }


}