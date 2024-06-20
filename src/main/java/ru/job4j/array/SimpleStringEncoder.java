package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        if (input.length() == 1) {
            return input;
        }
        StringBuilder builder = new StringBuilder();
        char symbol = input.charAt(0);
        int counter = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == symbol) {
                counter++;
            } else {
                appendEncoderChar(builder, symbol, counter);
                symbol = input.charAt(i);
                counter = 1;
            }

        }
        appendEncoderChar(builder, symbol, counter);
        return builder.toString();
    }

    private static void appendEncoderChar(StringBuilder builder, char symbol, int counter) {
        builder.append(symbol);
        if (counter > 1) {
            builder.append(counter);
        }
    }
}
