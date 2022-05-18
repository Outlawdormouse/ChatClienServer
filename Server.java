import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        Socket socket;
        serverSocket = new ServerSocket(1234);

        while(true){
            socket = serverSocket.accept();
            SocketHandler thread = new SocketHandler(socket);
            thread.start();
        }
    }
}

