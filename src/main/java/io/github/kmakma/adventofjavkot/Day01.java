package io.github.kmakma.adventofjavkot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day01 extends Day {


    private final List<Integer> frequencyChanges = parseInt();

    public static void main(String[] args) {
        new Day01().executeParts();
    }

    /**
     * input equals changes in frequency. Answer is resulting frequency after all changes have been applied.
     */
    @Override
    void partOne() {
        int sum = frequencyChanges.stream().mapToInt(Integer::intValue).sum();
        System.out.println("=== DAY 01 - STAR 1 ===");
        System.out.println("Frequency after all changes have been applied: " + sum);
    }

    @Override
    void partTwo() {
        int twiceReachedFrequency = findFirstFrequencyDuplicate();

        System.out.println("=== DAY 02 - STAR 2 ===");
        System.out.println("First frequency reached twice: " + twiceReachedFrequency);
    }

    private int findFirstFrequencyDuplicate() {
        Set<Integer> reachedFrequencies = new HashSet<>();
        int frequency = 0;
        reachedFrequencies.add(frequency);
        while (true) {
            for (int frequencyChange : frequencyChanges) {
                frequency += frequencyChange;
                if (!reachedFrequencies.add(frequency)) {
                    return frequency;
                }
            }
        }
    }
}
