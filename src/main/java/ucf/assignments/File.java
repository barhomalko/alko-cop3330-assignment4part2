/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 barhom alko
 */

package ucf.assignments;



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class File {

    public final String defaultPath = System.getProperty("initial");
    public String filePath;
    public String fileName;
    public File() {
        //sets default name
        this.fileName = "new";
    }


    public String getFileName() {
        //return string of file name
        return fileName;
    }

    public void setFileName(File file) {
        //sets file name
        this.fileName = file.getName();
    }

    private String getName() {
    }


    public String getFilePath() {
        if (filePath == null) {
            return defaultPath;
        } else {
            return filePath;
        }
    }

    public void setFilePath(File file) {
        this.filePath = file.getFileParent();


    }

    private String getFileParent() {
    }


    public void writeFile(File file, ArrayList<Todo> data) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(file.tofilePath()));
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private Path tofilePath() {
    }

    public Object readFile(Path file) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(file));
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }