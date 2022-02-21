package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Artem.polschak@gmail.com on 20.02.2022.
 * @project job4j_design
 * 6. Кодировка. [#862]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.1. Ввод-вывод
 */

public class ConsoleChat {
    private final String path;
    private final String botAnswer;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE =  "продолжить";



    public String getPath() {
        return path;
    }

    public String getBotAnswer() {
        return botAnswer;
    }

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswer = botAnswers;
    }

    /**
     * Метод считывает файл с ответами бота и ведет диалог с пользователем случайными фразами
     * пока пользователь не прекратит диалог
     *
     */
    public void run() {
        List<String> list = readPhrases();
        List<String> save = new ArrayList<>();
        boolean permissionToReply = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();

            loop: while (line != null) {
                save.add(line);
                switch (line) {
                    case (STOP):
                        permissionToReply = false;
                        break;
                    case (CONTINUE):
                        permissionToReply = true;
                        break;
                    case(OUT):
                        break loop;
                    default: break;
                }

                if (permissionToReply) {
                    int index = (int) (Math.random() * list.size());
                    System.out.println(list.get(index));
                    save.add(list.get(index));
                }

                line = reader.readLine();
            }

            saveLog(save);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод читает фразы из файла.
     * @return list с фразами из файла
     */
    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
       try (BufferedReader br = new BufferedReader(new FileReader(getBotAnswer()))) {
           br.lines().forEach(list::add);
       } catch (IOException e) {
           e.printStackTrace();
       }
        return list;
    }

    /**
     * Метод сохраняет переписку с ботом в файл path
     * @param log коллекция с перепиской, которую необходимо сохранить.
     */
    private void saveLog(List<String> log) {
       try (PrintWriter pw = new PrintWriter(
               new FileWriter(getPath(), StandardCharsets.UTF_8, true))) {
           log.forEach(pw::println);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConsoleChat)) {
            return false;
        }
        ConsoleChat that = (ConsoleChat) o;
        return Objects.equals(getPath(), that.getPath()) && Objects.equals(getBotAnswer(), that.getBotAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath(), getBotAnswer());
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("d:/2.txt", "d:/1.txt");
        cc.run();
    }
}
