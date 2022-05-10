package com.kodilla.testing.collection;

import java.util.List;
import java.util.stream.Collectors;

abstract public class OddNumbersExterminator {
    public static List<Integer> exterminate(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }
}
