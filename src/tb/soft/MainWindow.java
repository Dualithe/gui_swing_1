package tb.soft;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainWindow extends JFrame implements ActionListener {


    Container container = getContentPane();
    JLabel login = new JLabel("login");
    JLabel password = new JLabel("hasło");
    JTextField loginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton button = new JButton("Zaloguj");
    JButton button2 = new JButton("Załaduj  bazę danych");
    JFileChooser fc = new JFileChooser();
    File file = null;


    public MainWindow() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        login.setBounds(50, 120, 100, 30);
        password.setBounds(50, 150, 100, 30);
        loginField.setBounds(90, 120, 170, 30);
        passwordField.setBounds(90, 150, 170, 30);
        button.setBounds(90, 180, 170, 30);
        button2.setBounds(90, 210, 170, 30);
    }

    public void addComponentsToContainer() {
        container.add(login);
        container.add(password);
        container.add(button);
        container.add(passwordField);
        container.add(loginField);
        container.add(button2);
    }

    public void addActionEvent() {
        button.addActionListener(this);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            int returnVal = fc.showOpenDialog(MainWindow.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
            }
        }

        if (e.getSource() == button && file != null) {
            String userLogin;
            String userPassword;
            userLogin = loginField.getText();
            userPassword = String.valueOf(passwordField.getPassword());
            int isCorrect = 0;
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.err.println(line);
                    List<String> substrings = Stream.of(line.split(" ")).collect(Collectors.toList());
                    String databaseLogin = substrings.get(0).trim();
                    String databasePassword = substrings.get(1).trim();
                    if (databaseLogin.equals(userLogin) && databasePassword.equals(userPassword)) {
                        isCorrect = 1;
                        break;
                    }
                }
            } catch (FileNotFoundException f) {
                System.err.println("Nie istnieje baza danych");
            }
            ChangeFrameColor(isCorrect);
        }else{
            System.err.println("Nie istnieje baza danych");
        }
    }


    public void ChangeFrameColor(int isCorrect) {
        if (isCorrect == 1) {
            container.setBackground(Color.GREEN);
        } else {
            container.setBackground(Color.RED);
        }
    }

}


