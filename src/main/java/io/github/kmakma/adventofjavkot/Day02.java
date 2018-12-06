package io.github.kmakma.adventofjavkot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Day02 extends Day {


    public static void main(String[] args) {
        new Day02().executeParts();
    }

    @Override
    void partOne() {
        int twoLetterLines = 0;
        int threeLetterLines = 0;
        for (String line : inputLines) {
            Collection<Integer> numbers = getNumbersOfLetters(line);
            if (numbers.contains(2)) {
                twoLetterLines++;
            }
            if (numbers.contains(3)) {
                threeLetterLines++;
            }
        }

        int checksum = twoLetterLines * threeLetterLines;

        System.out.println("=== DAY 02 - STAR 1 ===");
        System.out.println("Checksum is: " + checksum);
    }

    private Collection<Integer> getNumbersOfLetters(String line) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            letterCounter.merge(line.charAt(i), 1, Integer::sum);
        }
        return letterCounter.values();
    }

    @Override
    void partTwo() {
        String commonLetters = "";// getCommonLettersOf(x, y);

        for (int firstLine = 0; firstLine < inputLines.size() - 1; firstLine++) {
            for (int secondLine = firstLine + 1; secondLine < inputLines.size(); secondLine++) {
                if (linesHaveOneDifference(inputLines.get(firstLine), inputLines.get(secondLine))) {
                    commonLetters = getCommonLetters(inputLines.get(firstLine), inputLines.get(secondLine));
                }
            }
        }

        System.out.println("=== DAY 02 - STAR 2 ===");
        System.out.println("Sequence of common letters: " + commonLetters);
    }

    private boolean linesHaveOneDifference(String fLine, String sLine) {
        int differences = 0;
        for (int i = 0; i < fLine.length(); i++) {
            if (fLine.charAt(i) != sLine.charAt(i)) {
                differences++;
            }
        }
        return differences <= 1;
    }

    private String getCommonLetters(String firstLine, String secondLine) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstLine.length(); i++) {
            if (firstLine.charAt(i) == secondLine.charAt(i)) {
                sb.append(firstLine.charAt(i));
            }
        }
        return sb.toString();
    }
}
