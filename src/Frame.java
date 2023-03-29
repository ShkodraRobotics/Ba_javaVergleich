import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Scanner;
import javax.swing.border.Border;
public class Frame {
    private final JFrame frame;
    Frame() {

         this.frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Roboter-Controller");
        frame.setLayout(new GridLayout(0, 3));
        widget();

    }





        public void widget(){
            JPanel panel1 = new JPanel();
            frame.add(panel1);
            //____________________________________________________________________
            JSlider base_slide = new JSlider(0, 180);
            base_slide.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println("A" + base_slide.getValue() + ";");
                }
            });
            panel1.add(base_slide, BorderLayout.WEST);
            JLabel baseLabel = new JLabel("Base");
            panel1.add(baseLabel);
//_____________________________________________________________________
            JSlider A3 = new JSlider(0, 180);
            A3.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println("A" + A3.getValue() + ";");
                }
            });
            panel1.add(A3, BorderLayout.WEST);
            Border green = BorderFactory.createLineBorder(Color.black);
            panel1.setBorder(green);

            panel1.add(A3, BorderLayout.WEST);
            JLabel A3Label = new JLabel("A3");
            panel1.add(A3Label);
//_______________________________________________________________________
            JSlider A2 = new JSlider(0, 180);
            A2.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println("C" + A2.getValue() + ";");
                }
            });
            panel1.add(A2, BorderLayout.WEST);
            JLabel A2Label = new JLabel("A2");
            panel1.add(A2Label);
//_______________________________________________________________________
            JSlider A1 = new JSlider(0, 180);
            A1.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println("D" + A1.getValue() + ";");
                }
            });
            panel1.add(A1, BorderLayout.WEST);
            JLabel A1Label = new JLabel("A1");
            panel1.add(A1Label);
//________________________________________________________________________
            JSlider Klaue = new JSlider(0, 180);
            Klaue.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println("E" + Klaue.getValue() + ";");
                }
            });
            panel1.add(Klaue, BorderLayout.WEST);
            JLabel KLabel = new JLabel("Klaue");
            panel1.add(KLabel);

        }


        //new Thread(()->{while(true) System.out.println(base_slide.getValue());}).start();
        //System.out.print(base_slide.getValue());

























    }
