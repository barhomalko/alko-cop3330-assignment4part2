/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AboutTest {

    String text = "check";

    @Test
    void getText() {
        String text = null;
        URL resource = About.class.getResource("about.txt");
        assert resource != null;
        String filepath = resource.getPath();

        try {
            text = Files.readString(Path.of(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotEquals("check", text);
    }