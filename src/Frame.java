import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.border.Border;
public class Frame {
    private final JFrame frame;
    private Kommunikation com;
    private SerialPort port;

    private  Controller_Con Kontroller = null;
    private Thread konThread;
    private Thread stopThread = new Thread();
    private boolean State = false;

    Frame() {

        this.frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Roboter-Controller");
        frame.setLayout(new GridLayout(0, 3));
        this.com = new Kommunikation();

        widget();


    }
        public void setPort(SerialPort p ){
            this.port = p;
        }




        public void widget() {
            JPanel panel1 = new JPanel();
            //frame.add(panel1);
            //____________________________________________________________________
            JSlider base_slide = new JSlider(0, 180);
            base_slide.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    com.writter("A" +base_slide.getValue()+";",port);
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
                    //System.out.println("A" + A3.getValue() + ";");
                    com.writter("B" +A3.getValue()+";",port);
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
                    com.writter("AC" +A2.getValue()+";",port);
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
                    com.writter("D" +A1.getValue()+";",port);
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
                    com.writter("E" +Klaue.getValue()+";",port);
                }
            });
            panel1.add(Klaue, BorderLayout.WEST);
            JLabel KLabel = new JLabel("Klaue");
            panel1.add(KLabel);

            //_________________________________________________________________


            JButton Con = new JButton("Connect");
            Con.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Con.setEnabled(false);
                    SerialPort[] Port = com.ports();
                    for(SerialPort p : Port){
                        JButton button = new JButton("" + p);
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println(button.getText());
                                setPort(com.setVerbingung(p));

                            }
                        });

                        panel1.add(button);
                        panel1.revalidate();
                    }



                }
            });

            panel1.add(Con);



            JPanel Controller = new JPanel();
            JPanel Bild  = new JPanel();

            JTabbedPane Menu = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );
            Menu.addTab("panel1",panel1);
            Menu.addTab("Controller",Controller);
            Menu.addTab("Bild",Bild);
            JButton conectioButton = new JButton("Kontrollerverbindung");
            conectioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Kontroller == null) {
                        Kontroller = new Controller_Con();
                    }
                    if(konThread == null){
                        konThread = new Thread(() -> {
                            while (!State) {
                                ArrayList<String> a = Kontroller.controllerSteam();

                                writer(a);

                            }
                        });
                        konThread.setDaemon(true);
                        konThread.start();
                    }else {
                        konThread = null;
                        State = false;
                        actionPerformed(e);


                    }
                }
            });




            JButton disconButton = new JButton("Kontroller trennen");

            disconButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    State = true;

                }
            });

            Controller.add(conectioButton);
            Controller.add(disconButton);







            frame.add(Menu);
            frame.setVisible(true);
        }

        public void writer(ArrayList<String> x){

        for(int i= 0;i<x.size();i++){
            com.writter(x.get(i),port);
        }

        }













    }
