package Homework.WorkWithFile.Practice2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        int port = 12345; // Порт для прослушивания

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание подключения...");

            while (true) { // Бесконечный цикл для обработки подключений
                Socket clientSocket = serverSocket.accept(); // Принять подключение
                System.out.println("Клиент подключился: " + clientSocket.getInetAddress());

                // Потоки ввода/вывода
                BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

                // Чтение сообщения от клиента
                String clientMessage = input.readLine();
                System.out.println("Получено сообщение: " + clientMessage);

                // Отправка сообщения обратно
                output.println("Эхо: " + clientMessage);

                // Закрытие подключения
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }
}
