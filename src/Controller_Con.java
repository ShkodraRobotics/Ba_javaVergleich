
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.ArrayList;

public class Controller_Con {

    private final String xBox ="Controller (GC100)";
    private Controller controller = null;
    private final int sleep = 80;



    private float A1 = 12;
    private float A2 = 100;
    private float A3 =  40;
    private float Klaue = 0;
    private float Base = 90;

    private final int MAX = 180;
    private final int MIN = 0;

    Controller_Con(){
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for(int i = 0 ; i<controllers.length;i++){
            if(controllers[i].getName().equals(this.xBox)){
                this.controller = controllers[i];
            }
        }
    }


    public ArrayList<String> controllerSteam(){
        this.controller.poll();
        Component[] components = this.controller.getComponents();
        ArrayList<String> servoListe =new ArrayList<>();



        if((float) (Math.round(components[7].getPollData()*1000.0)/1000.0)>0) {
            servoListe.add(A1((float) (Math.round(components[7].getPollData() * 1000.0) / 1000.0)));
        } else{
            servoListe.add(A1((float) (Math.round(-components[5].getPollData() * 1000.0) / 1000.0)));
        }
        if((float) (Math.round(components[8].getPollData()*1000.0)/1000.0)>0) {
            servoListe.add(A2((float) (Math.round(components[8].getPollData() * 1000.0) / 1000.0)));
        } else{
            servoListe.add(A2((float) (Math.round(-components[6].getPollData() * 1000.0) / 1000.0)));
        }
        if((float) (Math.round(components[10].getPollData()*1000.0)/1000.0)>0) {
            servoListe.add(Klaue((float) (Math.round(components[10].getPollData() * 1000.0) / 1000.0)));
        } else{
            servoListe.add(Klaue((float) (Math.round(-components[9].getPollData() * 1000.0) / 1000.0)));
        }





        servoListe.add(A3((float) (Math.round(components[0].getPollData()*1000.0)/1000.0)));
        servoListe.add(Base((float) (Math.round(components[1].getPollData()*1000.0)/1000.0)));
        try {
            Thread.sleep(sleep);
        }catch (Exception ignored){

        }

        return servoListe;
    }

    public String A1(float a1 ){
        this.A1 += a1;
        if(this.A1>MAX){
            this.A1=MAX;
        } else if (this.A1<MIN) {
            this.A1=MIN;
        }

        StringBuffer A1 = new StringBuffer();
        A1.append("D");
        A1.append((int) this.A1);
        A1.append(";");
        String a= A1.toString();
        return a;
    }
    public String A2(float a2 ){
        this.A2 += a2;
        if(this.A2>MAX){
            this.A2=MAX;
        } else if (this.A2<MIN) {
            this.A2=MIN;
        }

        StringBuffer A2 = new StringBuffer();
        A2.append("C");
        A2.append((int) this.A2);
        A2.append(";");
        String b= A2.toString();
        return b;
    }
    public String A3(float a3 ){
        //System.out.println(a3);
        this.A3 += a3;
        //System.out.println(this.A3);
        if(this.A3>MAX){
            this.A3=MAX;
        } else if (this.A3<MIN) {
            this.A3=MIN;
        }

        StringBuffer A3 = new StringBuffer();
        A3.append("B");
        A3.append((int) this.A3);
        A3.append(";");
        String c= A3.toString();
        return c;
    }
    public String Base(float base ){
        this.Base += base;
        if(this.Base>MAX){
            this.Base=MAX;
        } else if (this.Base<MIN) {
            this.Base=MIN;
        }
        StringBuffer b_Base = new StringBuffer();
        b_Base.append("A");
        b_Base.append((int) this.Base);
        b_Base.append(";");
        String d = b_Base.toString();
        return d;
    }


    public String Klaue(float kl ){

        this.Klaue += kl;
        if(this.Klaue>MAX){
            this.Klaue=MAX;
        } else if (this.Klaue<MIN) {
            this.Klaue=MIN;
        }
        StringBuffer klaue = new StringBuffer();
        klaue.append("E");
        klaue.append((int) this.Klaue);
        klaue.append(";");
        String e= klaue.toString();
        return e;
    }



}
