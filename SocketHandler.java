import java.io.*;
import java.net.Socket;
import java.util.*;

public class SocketHandler extends Thread{
    Scanner s1 = new Scanner(System.in);
    InputStreamReader inputStreamReader;
    OutputStreamWriter outputStreamWriter;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public SocketHandler(Socket socket){
        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);
    }
    public void run(){
        super.run();
        String messaggio;
        String risposta;
        while (true){
            try {
                messaggio=bufferedReader.readLine();
                System.out.println("Domanda:" + messaggio);
                risposta = s1.nextLine();
                bufferedWriter.write("Risposta: " + risposta);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
