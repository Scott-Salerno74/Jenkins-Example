import org.eclipse.jetty.server.Server;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class simpleServer {
    public static void main(String[] args) throws IOException {
        int numRequests = 0;
        final ServerSocket server = new ServerSocket(8081);
        System.out.println("Listening for connection on port 8080");
        Server server1 = new Server(8080);
        server1.setHandler(simpleHandler);
        server1.start();
        server1.join();

        while (true){
            final Socket clientSocket = server.accept();
            InputStream inputStream = clientSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String num = br.readLine();
            System.out.println("Client: " + num +" "+ "Message Received");

            //client message
            OutputStream outputStream = clientSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);
            String returnClient = Integer.toString(numRequests++);
            bw.write(returnClient);
            bw.flush();
        }
    }
}