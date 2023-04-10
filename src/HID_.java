import net.java.games.input.*;

import java.text.DecimalFormat;
import java.util.Arrays;

public class HID_ {
    public static void main(String[]args){
        String xBox ="Controller (GC100)";
        String pcCon = "GC100";


        //System.setProperty("net.java.games.input.useDefaultPlugin", "false");
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        Controller gc = null;
        for(int i = 0; i< controllers.length;i++){
            //System.out.println(controllers[i].getName());


            if(controllers[i].getName().equals(xBox)){
                gc = controllers[i];
            }

        }
        DecimalFormat df = new DecimalFormat("#.000");

        while (true){

            gc.poll();
            Component[] components = gc.getComponents();
            StringBuffer buffer = new StringBuffer();
            /*
            for(int i = 0; i<components.length;i++){
                System.out.print("---->    " + i );
                System.out.print(components[i].getName());
                System.out.println("---> "+ components[i].getPollData());
            }

            */


            float i= (float) (Math.round(components[0].getPollData()*1000.0)/1000.0);


            i*=10;

            System.out.println(i);
            try {
                Thread.sleep(1);
            }catch (Exception e){

            }

        }

    }


}