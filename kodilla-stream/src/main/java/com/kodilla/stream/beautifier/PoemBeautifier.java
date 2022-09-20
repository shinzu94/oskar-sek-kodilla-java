package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public static String beautify(String string, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(string);
    }
}
