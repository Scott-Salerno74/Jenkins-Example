import java.net.*;
import java.io.*;
public class simpleServer{
 public static void main(String[] args) throws IOException{
     ServerSocket serverSocket = null;
     try{
         serverSocket = new ServerSocket(1234);
     } catch (IOException e){
         System.err.println("Could not listen on port: 1234");
         System.exit(1);
     }

     Socket clientSocket = null;
     try{
         clientSocket = serverSocket.accept();
     } catch(IOException e){
         System.err.println("Was not Accepted!");
         System.exit(1);
     }


 }

}
