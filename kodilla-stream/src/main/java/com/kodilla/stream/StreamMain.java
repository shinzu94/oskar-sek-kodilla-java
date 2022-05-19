package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println(PoemBeautifier.beautify("test", String::toUpperCase));
        System.out.println(PoemBeautifier.beautify("test", string -> "abc" + string.toUpperCase()));
        System.out.println(PoemBeautifier.beautify("test", string -> string.repeat(3)));
        System.out.println(PoemBeautifier.beautify(" test4 ", string -> string.trim()));
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
