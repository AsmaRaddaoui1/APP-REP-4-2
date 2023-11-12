package activite2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Server {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];
    public static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Démarrage du serveur");
            while(true){
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String time = getCurrentTime();
            DatagramPacket msgToSend = new DatagramPacket(time.getBytes(), time.length(), packet.getAddress(), packet.getPort());
            socket.send(msgToSend);
            }
        }
        catch(SocketException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static String getCurrentTime()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYY MM DD HH:mm:ss");
        Date date=new Date();
        return dateFormat.format(date);
    }
}