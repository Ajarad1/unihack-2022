
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;


public class LoginPage implements ActionListener{

    JFrame frame = new JFrame();
    JButton loginbutton = new JButton("Login");
    JButton createaccount = new JButton("Create");
    JTextField userIDfield = new JTextField();
    JPasswordField userPassfield = new JPasswordField();
    JLabel userIDlabel = new JLabel("userID:");
    JLabel userPasslabel = new JLabel("password:");

    JLabel messageLabel = new JLabel(" Where");
    JLabel messageLabel2 = new JLabel("2Go");
    JLabel confirmmessage = new JLabel("");

    JLabel backgr = new JLabel(new ImageIcon("back.jpg"));





    HashMap<String,String> logininf = new HashMap<String,String>();


    LoginPage(HashMap<String,String> logininforg)
    {
        logininf = logininforg;

        backgr.setBounds(10,10,1920,1080);
        userIDlabel.setBounds(50,200,125,75);
        userPasslabel.setBounds(50,300,175,75);
        messageLabel.setBounds(50,50,375,75);
        messageLabel2.setBounds(257,50,375,75);
        userIDfield.setBounds(50,270,205,45);
        userPassfield.setBounds(50,370,205,45);
        loginbutton.setBounds(50,470,205,45);
        createaccount.setBounds(50,425,205,45);
        confirmmessage.setBounds( 300, 270 ,700 ,45);


        loginbutton.addActionListener(this);
        createaccount.addActionListener(this);

        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/back.png")))));
        } catch (IOException x) {
            x.printStackTrace();}


        messageLabel.setFont( new Font(null, Font.ITALIC, 50));
        Font scris = new Font("Arial",Font.BOLD, 32);
        Font fn1 = new Font("Arial", Font.PLAIN, 32);
        Font fn2 = new Font("Arial", Font.PLAIN, 64);
        userIDlabel.setFont(scris);
        userPasslabel.setFont(scris);
        messageLabel.setFont(fn2);
        messageLabel2.setFont(fn2);
        userIDfield.setFont(fn1);
        userPassfield.setFont(fn1);
        confirmmessage.setFont(fn1);
        createaccount.setFont(fn1);
        loginbutton.setFont(fn1);


        messageLabel.setForeground(Color.white);
        messageLabel2.setForeground(new java.awt.Color(70,208,125));

        userPasslabel.setForeground(Color.WHITE);
        userIDlabel.setForeground(Color.WHITE);

        frame.setTitle("Login your account");

        frame.add(userIDlabel);
        frame.add(userPasslabel);
        frame.add(userIDfield);
        frame.add(userPassfield);
        frame.add(loginbutton);
        frame.add(confirmmessage);
        frame.add(backgr);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent x) {
        IDPasswords idpass = new IDPasswords();

        idpass.getlogininfo();
        if (x.getSource() == loginbutton) {
            String userID = userIDfield.getText();
            String password = String.valueOf(userPassfield.getPassword());

            if (logininf.containsKey(userID)) {
                if (logininf.get(userID).equals(password)) {
                    confirmmessage.setForeground(Color.green);
                    confirmmessage.setText("Login succesful");
                    try {
                        File htmlfile = new File("src/index.html");
                        Desktop.getDesktop().open(htmlfile);
                    } catch (Exception e) {}
                    frame.dispose();

                } else {

                    userPassfield.setText("");
                    confirmmessage.setForeground(Color.red);
                    confirmmessage.setText("Wrong password");
                }
            }
            else {
                userIDfield.setText("");
                userPassfield.setText("");
                confirmmessage.setForeground(Color.red);
                confirmmessage.setText("Wrong username");
            }
        }
        else
        {
            if ( x.getSource() == createaccount)
            {
                CreateAccount create = new CreateAccount(idpass.getlogininfo());

            }
        }
    }

}
