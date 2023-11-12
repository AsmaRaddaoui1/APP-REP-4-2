package activie_2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Client {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];
    public static void main(String[] args) throws Exception{
       DatagramSocket socket =new DatagramSocket();
       String msg="";
       DatagramPacket dataTosend=new DatagramPacket(msg.getBytes(),0, InetAddress.getByName("localhost"),PORT);
       socket.send(dataTosend);
       DatagramPacket receivedPacket=new DatagramPacket(buffer,buffer.length);
       socket.receive(receivedPacket);
       System.out.print("Server:"+new String(receivedPacket.getData(),0,receivedPacket.getLength()));
}}
