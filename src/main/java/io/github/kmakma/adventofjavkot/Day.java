package io.github.kmakma.adventofjavkot;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

abstract class Day {

    List<String> inputLines = getInputLines();

    @Nullable
    private List<String> getInputLines() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL dayInputURL = classloader.getResource(getClass().getSimpleName().toLowerCase());
        if (dayInputURL == null) {
            return null;
        }
        try {
            File inputFile = new File(dayInputURL.toURI());
            return Files.readAllLines(inputFile.toPath());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();

        }
        return null;
    }

    List<Integer> parseInt() {
        List<Integer> intList = new ArrayList<>();
        for (String s : inputLines) {
            intList.add(Integer.parseInt(s));
        }
        return intList;
    }

    void executeParts() {
        partOne();
        partTwo();
    }

    abstract void partOne();

    abstract void partTwo();
}
