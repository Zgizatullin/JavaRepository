package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.*;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        int clients=0;
        ServerSocket serverSocket = new ServerSocket(8000);
        while(true) {
            Socket clientSocket = serverSocket.accept();
            OutputStreamWriter osWriter = new OutputStreamWriter(clientSocket.getOutputStream());
            osWriter.write("HTTP/1.0 200 OK\n"+
                            "Content-type: text/html\n"+
                            "\n");
            osWriter.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<title>Title of the document</title>\n" +
                    "</head>\n" +
                    "\n" +
                    "<body>\n" +
                    "Content of the document......\n"+clients +
                    "</body>\n" +
                    "\n" +
                    "</html>");

            osWriter.flush();
            osWriter.close();
            clients++;
            System.out.println(clients);
            System.out.println("Server is down;");
            clientSocket.close();
        }
    }
}
