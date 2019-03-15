import java.net.*;
import java.io.*;
public class simpleServer{
 public static void main(String[] args) throws IOException {
     int numRequests = 0;
     ServerSocket serverSocket = null;
     try {
         serverSocket = new ServerSocket(8081);
     } catch (IOException e) {
         System.err.println("Could not listen on port: 1234");
         System.exit(1);
     }

     Socket clientSocket = null;
     try {
         clientSocket = serverSocket.accept();
     } catch (IOException e) {
         System.err.println("Was not Accepted!");
         System.exit(1);
     }

     try {
         BufferedReader brIn = new BufferedReader(new InputStreamReader(
                 clientSocket.getInputStream()
         ));
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);


     } catch (IOException e){
           System.out.println(" Failure, We Suck Again!");
           System.exit(1);

     }

  while(true){
      try{
          String line = brIn.readLine
      }
  }







 }

}
