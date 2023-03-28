import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("Roboter-Controller");
        frame.setLayout(new java.awt.GridLayout(4,4));
        JSlider base_slide = new JSlider(0,180);
        base_slide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(base_slide.getValue());
            }
        });
        frame.add(base_slide,);

        JSlider A3 = new JSlider(0,180);
        A3.hor
        A3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(A3.getValue());
            }
        });
        frame.add(A3, BorderLayout.WEST);







        //new Thread(()->{while(true) System.out.println(base_slide.getValue());}).start();
        //System.out.print(base_slide.getValue());

























    }
}