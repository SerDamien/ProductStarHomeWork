package Homework.WorkWithFile.Practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Локальный адрес сервера
        int port = 12345; // Порт сервера

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Подключение к серверу...");

            // Потоки ввода/вывода
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Отправка сообщения серверу
            String message = "Привет, сервер!";
            output.println(message);
            System.out.println("Отправлено сообщение: " + message);

            // Получение ответа от сервера
            String response = input.readLine();
            System.out.println("Ответ от сервера: " + response);
        } catch (IOException e) {
            System.err.println("Ошибка клиента: " + e.getMessage());
        }
    }
}
