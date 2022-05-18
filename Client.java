import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        Scanner tastiera = new Scanner(System.in);
        String messaggio = "";
        {
            try {
                socket = new Socket("localhost", 1234);
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connessione stabilita: \n");
            while (true) {
                System.out.println("inserire messaggio: ");
                messaggio = tastiera.nextLine();
                try {
                    bufferedWriter.write(messaggio);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    messaggio=bufferedReader.readLine();
                    System.out.println(messaggio);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
