package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author artem.polschak@gmail.com on 19.03.2022.
 * @project job4j_design
 * 2.Socket [#4850]
 * Уровень : 2. ДжуниорКатегория : 2.2. Ввод-выводТопик : 2.2.2. Socket
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()))) {

                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String bye = "Bye";
                    String str = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains(bye)) {
                            String[] strings = str.split("=");
                            String[] secondStrings = strings[1].split(" ");
                            if (secondStrings[0].equals(bye)) {
                                server.close();
                            }
                        }
                    }
                    out.flush();
                }
            }
        }
    }
}
