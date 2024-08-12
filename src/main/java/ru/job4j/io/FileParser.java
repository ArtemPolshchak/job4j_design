package ru.job4j.io;

import java.io.*;
import java.util.function.Predicate;

public final class FileParser {
    private final File file;

    public FileParser(File file) {
        this.file = file;
    }

    public String getContent(Predicate<Character> filter) throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int data;
            while ((data = reader.read()) != -1) {
                char ch = (char) data;
                if (filter.test(ch)) {
                    output.append(ch);
                }
            }
        }
        return output.toString();
    }

    public String getContent() throws IOException {
        return getContent(ch -> true);
    }

    public String getContentWithoutUnicode() throws IOException {
        return getContent(ch -> ch < 0x80);
    }
}
