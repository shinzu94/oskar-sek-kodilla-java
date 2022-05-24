package com.kodilla.exception.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() throws FileReaderException {
        readFile("names.txt");
    }

    public void readFile(final String fileName) throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();

        try (Stream<String> fileLines = Files.lines(Path.of(classLoader.getResource(fileName).toURI()))) {
            fileLines.forEach(System.out::println);
        } catch (Exception exception) {
            throw new FileReaderException();
        } finally {
            System.out.print("Exist or not exist");
        }
    }
}
