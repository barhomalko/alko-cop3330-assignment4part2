/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import java.io.Serializable;
import java.time.LocalDate;

public class Todo implements Serializable {


    private String dueDate;
    private String todoText;
    private Boolean bool;


    public Todo() {
        this.dueDate = (LocalDate.now().toString());
        this.todoText = ("");
        this.bool = false;

    }

    public Todo(LocalDate date, String string) {
        setDueDate(date.toString());
        setTodoText(string);
        this.bool = false;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getTodoText() {
        return todoText;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setDueDate(String date) {
        // this.dueDate = date
        this.dueDate = date;
    }

    public void setTodoText(String string) {
        //max 256 characters
        if (string.length() > 256) {
            this.todoText = (string.substring(0, 256));}
        else {
            this.todoText = (string);
        }
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }


}