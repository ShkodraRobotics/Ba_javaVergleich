/*
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.util.ArrayList;

public class Controller_Con {

    private final String xBox ="Controller (GC100)";
    private Controller controller = null;



    Controller_Con(){
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for(int i = 0 ; i<controllers.length;i++){
            if(controllers[i].getName().equals(this.xBox)){
                this.controller = controllers[i];
            }
        }
    }


    public int controllerSteam(){
        this.controller.poll();
        Component[] components = this.controller.getComponents();
        ArrayList<String> servoListe =new ArrayList<>();
        ArrayList<Integer> controllerDaten =new ArrayList<>();
        for (int i = 0 ; i<11;i++){
            controllerDaten.add((int)components[i].getPollData());
        }
        servoListe.add(A1());
        servoListe.add(A2());
        servoListe.add(A3(controllerDaten.get(3)));
        servoListe.add(Base(controllerDaten.get(1)));
        servoListe.add(Klaue(controllerDaten.get(9)));








    }

    public String A1(int a1 ){
        StringBuffer A1 = new StringBuffer();
        A1.append("D");
        A1.append(a1);
        A1.append(";");
        String a= A1.toString();
        return a;
    }
    public String A2(int a2 ){
        StringBuffer A2 = new StringBuffer();
        A2.append("C");
        A2.append(a2);
        A2.append(";");
        String b= A2.toString();
        return b;
    }
    public String A3(int a3 ){
        StringBuffer A3 = new StringBuffer();
        A3.append("B");
        A3.append(a3);
        A3.append(";");
        String c= A3.toString();
        return c;
    }
    public String Base(int base ){
        StringBuffer Base = new StringBuffer();
        Base.append("A");
        Base.append(base);
        Base.append(";");
        String d = Base.toString();
        return d;
    }
    public String Klaue(int kl ){
        StringBuffer klaue = new StringBuffer();
        klaue.append("E");
        klaue.append(kl);
        klaue.append(";");
        String e= klaue.toString();
        return e;
    }



}
*/