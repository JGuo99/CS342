import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Server {
    int count = 1;
    ArrayList<CThread> clients = new ArrayList<CThread>();
    InnerServer server;
    private Consumer<Serializable> callback;

    Server(Consumer<Serializable> call) {
        callback = call;
        server = new InnerServer();
        server.start();
    }
    public class InnerServer extends Thread{
        public void run(){
            try (ServerSocket socket = new ServerSocket(1234)){ //Need To be Changed later!!
                System.out.println("Waiting for Clients");
                while(true){
                    CThread c = new CThread(socket.accept(), count);
                    callback.accept("Client is connected to server: "+"client #"+count);
                    clients.add(c);
                    c.start();
                    count++;
                }
            }catch (Exception e){
                callback.accept("Server Failed to Launch!");
            }
        }
    }
    public class CThread extends Thread {
        Socket connect;
        int count;
        ObjectInputStream in;
        ObjectOutputStream out;

        CThread(Socket s, int count) {
            this.connect = s;
            this.count = count;
        }

        public void updateC(String m) {
            for (int i = 0; i < clients.size(); i++) {
                CThread t = clients.get(i);
                try {
                    t.out.writeObject(m);
                } catch (Exception e) {
                    System.out.println("ERROR: Did not write message!");
                }
            }
        }

        public void run(){
            try {
                in = new ObjectInputStream(connect.getInputStream());
                out = new ObjectOutputStream(connect.getOutputStream());
                connect.setTcpNoDelay(true);
            }catch (Exception e){
                System.out.println("ERROR: Stream did not open");
            }
            updateC("New Client entered the server: client # "+count);
            while(true){
                try {
                    String data = in.readObject().toString();
                    callback.accept("Client: "+count+" sent: "+data);
                    updateC("client # "+count+" said: "+data);
                }catch (Exception e){
                    callback.accept("Connection Failed, error with socket from client: "+count+"...closing");
                    updateC("Client # "+count+" left the server!");
                    clients.remove(this);
                    break;
                }
            }
        }
    }
}
