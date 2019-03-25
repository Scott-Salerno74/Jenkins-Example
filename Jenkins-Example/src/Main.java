import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

// https://javarevisited.blogspot.com/2015/06/how-to-create-http-server-in-java-serversocket-example.html
public class Main {

    public static void main(String[] args) throws Exception {

        int totalRequests = 0;

        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ...");


        while(true) {

            final Socket client = server.accept();
            //totalRequests++;
            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String number = br.readLine();
            System.out.println("Message received from client is " + number);


            //send the message to the client
            OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            String backToClient = Integer.toString(totalRequests++);
            bw.write(backToClient);

            bw.flush();
        }

    }
}