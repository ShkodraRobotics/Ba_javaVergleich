import com.fazecast.jSerialComm.*;
import java.util.ArrayList;


public class Kommunikation {

    private String ser_port;
    private SerialPort port;

    Kommunikation(){
        //setVerbingung();
    }


    public SerialPort setVerbingung(SerialPort port){
        this.port = port;
        System.out.println(this.port);
        this.port.openPort();
        return this.port;
    }


    public SerialPort[] ports(){
        SerialPort[] Port;
        Port = SerialPort.getCommPorts();

        return Port;


    }


    public void writter(String b,SerialPort p) {

        p.writeBytes(b.getBytes(),b.length());

    }
}
















