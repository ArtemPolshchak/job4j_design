package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author artem.polschak@gmail.com on 19.03.2022.
 * @project job4j_design
 * 2.Socket [#4850]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.2. Socket
 */
public class EchoServer {

    private static String exit = "?msg=Exit ";
    private static String hello = "Hello";

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(9000)) {

            while (!server.isClosed()) {

                Socket socket = server.accept();

                try (OutputStream out = socket.getOutputStream();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                    String str = in.readLine();

                    if (!str.isEmpty()) {
                       System.out.println(str);
                        if (str.contains(exit)) {
                                server.close();
                        } else if (str.contains("?msg=Hello ")) {
                                out.write(hello.getBytes());
                        } else {
                            if (str.contains("=")) {
                                String[] strings = str.split("=");
                                out.write(strings[1].getBytes());
                            }
                        }
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log", e);
        }
    }
}
