package tb.soft;

<<<<<<< Updated upstream
/**
 * klasa główna zawierająca metodę statyczną main
 */
public class MainWindow {
    public static void main(String[] args) {
        System.out.println("Program konsolowy");
        System.exit(0);
    }
=======
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainWindow extends JFrame implements ActionListener, MouseListener {

    Canvas canvas = new Canvas();
    Container container = getContentPane();
    JLabel login = new JLabel("login");
    JLabel password = new JLabel("hasło");
    JTextField loginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    //JButton button = new JButton("Zaloguj");
    //JButton button2 = new JButton("Załaduj  bazę danych");
    JButton button3 = new JButton("Run");
    JButton button4 = new JButton("Cancel");
    JFileChooser fc = new JFileChooser();
    File file = null;


    public MainWindow() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_O) {
                    //drawOval();
                }
                if (e.getKeyCode() == KeyEvent.VK_K) {
                    //drawSquare();
                }

            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    /*public void paint(Graphics g) {
        g.fillOval(100, 100, 200, 200);
    }*/


    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //login.setBounds(50, 120, 100, 30);
        //password.setBounds(50, 150, 100, 30);
        //loginField.setBounds(90, 120, 170, 30);
        //passwordField.setBounds(90, 150, 170, 30);
        //button.setBounds(90, 180, 170, 30);
        //button2.setBounds(90, 210, 170, 30);
        button3.setBounds(90, 180, 170, 30);
        button4.setBounds(90, 210, 170, 30);
        canvas.setBounds(0, 0, 200, 150);

    }

    public void addComponentsToContainer() {
        container.add(login);
        container.add(password);
        //container.add(button);
        container.add(passwordField);
        container.add(loginField);
        //container.add(button2);
        container.add(button3);
        container.add(button4);
        container.add(canvas);

    }

    public void addActionEvent() {
        //button.addActionListener(this);
        //button2.addActionListener(this);
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (getMousePosition().getX() < button3.getLocation().getX() + button3.getWidth() - 10) {
                    if (button3.getLocation().y == 180)
                        button3.setLocation(90, 150);
                    else if (button3.getLocation().y == 150) {
                        button3.setLocation(90, 180);
                    }
                }
            }
        });
        button3.addActionListener(this);
        button4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == button2) {
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
*/
    }

    public class Drawing extends Canvas {
        public void drawOval(Graphics g) {
            g.fillOval(100, 100, 200, 200);

        }

        public void drawSquare(Graphics g) {
            g.fillRect(100, 100, 200, 200);


        }
    }

    public void ChangeFrameColor(int isCorrect) {
        if (isCorrect == 1) {
            container.setBackground(Color.GREEN);
        } else {
            container.setBackground(Color.RED);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (MouseInfo.getPointerInfo().getLocation().getX() < button3.getWidth() - 30) {
            if (button3.getLocation().y == 180)
                button3.setLocation(90, 150);
            else if (button3.getLocation().y == 150) {
                button3.setLocation(90, 180);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void setShape(int shape) {

    }
>>>>>>> Stashed changes
}
