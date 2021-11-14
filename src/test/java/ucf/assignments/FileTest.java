/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileTest {

    private final String dPath = System.getProperty("initial");
    private String fPath = "/Users/shithead";
    private String fName = "nameOfFile";
    private String[] data = new String[1];


    @Test
    void getFileName() {
        assertEquals("initial", fName);
    }

    @Test
    void setFileName() {
        this.fName = "yo";
        assertEquals("yo", fName);
    }

    @Test
    void getFilePath() {
        assertEquals("/Users/shithead", fPath);
        assertEquals(fPath, dPath);
    }

    @Test
    void setFilePath() {
        this.fPath = "yo";
        assertEquals("yo", fPath);
    }

    @Test
    void writeFile() {
        data[0] = "checks";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Path.of(fPath + "--" + fName)));
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(Path.of(fPath + "--" + fName)));
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    void readFile() {
        data[0] = "checks";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Path.of(fPath + "--" + fName)));
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(Path.of(fPath + "--" + fName)));
        file.delete();
    }
}