import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client extends Thread {
    Socket socketC;
    ObjectOutputStream out;
    ObjectInputStream in;

    private Consumer<Serializable> callback;

    Client(Consumer<Serializable> call) {
        callback = call;
    }

    public void run() {
        try {
            socketC = new Socket("127.0.0.1", 1234); //Change this later
            out = new ObjectOutputStream(socketC.getOutputStream());
            in = new ObjectInputStream(socketC.getInputStream());
            socketC.setTcpNoDelay(true);
        }catch (Exception e){
            System.out.println("ERROR: Stream did not open!");
        }

        while(true) {
            try {
                String m = in.readObject().toString();
                callback.accept(m);
            }catch (Exception e) {
                System.out.println("ERROR: Did not get message!");
            }
        }
    }

    public void send(String data) {
        try {
            out.writeObject(data);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
