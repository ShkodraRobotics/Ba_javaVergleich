import com.fazecast.jSerialComm.*;
import java.util.ArrayList;


public class Kommunikation {

    private String ser_port;
    private SerialPort port;


    public void setVerbingung(){
        this.port = SerialPort.getCommPorts()[1];
        this.port.openPort();
    }


    public void ports(){
        SerialPort[] Port;
        Port = SerialPort.getCommPorts();

        for (SerialPort p : Port) {
            System.out.println(p);
        }
        ;


    }


    public void writter(String b) {
        b += ";";
        this.port.writeBytes(b.getBytes(),b.length());

    }
}
















