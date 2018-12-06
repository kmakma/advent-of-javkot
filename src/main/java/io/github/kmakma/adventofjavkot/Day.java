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

    @Nullable
    List<String> getInputLines() {
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

    List<Integer> parseInt(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            intList.add(Integer.parseInt(s));
        }
        return intList;
    }

    abstract void partOne();

    abstract void partTwo();
}
