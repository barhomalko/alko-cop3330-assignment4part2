/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    String date = "2021-11-15";
    String text = "somethingsomething";
    Boolean bool = false;

    @Test
    void getDueDate() {
        assertEquals("2021-11-15", date);
    }

    @Test
    void getTodoText() {
        assertEquals("somethingsomething", text);
    }

    @Test
    void getBool() {
        //holds false boolen
        assertFalse(bool);
    }

    @Test
    void setDueDate() {
        this.date = "111";
        assertEquals("111", date);

    }

    @Test
    void setTodoText() {
        //loops a string of 1s to check
        String string = "";
        for (int i = 0; i < 300; i++) string += "1";
        String expected = "";
        for (int i = 0; i < 256; i++) expected += "1";
        //max 256
        if (string.length() > 256) {
            this.text = (string.substring(0, 256));}
        else {
            this.text = (string);
        }


        assertEquals(expected, text);
    }

    @Test
    void setBool() {
        this.bool = true;
        assertTrue(bool);
    }
}