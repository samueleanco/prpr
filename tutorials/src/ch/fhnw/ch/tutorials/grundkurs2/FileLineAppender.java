package ch.fhnw.ch.tutorials.grundkurs2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileLineAppender {

    private final Path targetFile;

    public FileLineAppender(String target) {
        this.targetFile = Path.of(target);
    }

    void appendLineToFile(String line) throws IOException {
        line = line + System.lineSeparator();
        try {
            Files.write(targetFile,line.getBytes(), StandardOpenOption.APPEND);
        } catch (NoSuchFileException e) {
            Files.createFile(targetFile);
            Files.write(targetFile,line.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to file "+ e);
        }


    }
     public static void main (String[] args) throws IOException {
        FileLineAppender appender = new FileLineAppender("test.txt");
        appender.appendLineToFile("firstline");

     }
}
