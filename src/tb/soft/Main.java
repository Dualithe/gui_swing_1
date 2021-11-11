package tb.soft;

import tb.soft.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] a){
        MainWindow frame = new MainWindow();
        frame.setTitle("Logowanie");
        frame.setVisible(true);
        frame.setBounds(10,10,370,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        }

    }

