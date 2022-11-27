import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class CreateAccount implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginbutton = new JButton("Create");
    JTextField userIDfield = new JTextField();
    JTextField fnamefield = new JTextField();
    JTextField lnamefield = new JTextField();
    JTextField userPassfield = new JTextField();
    JLabel userIDlabel = new JLabel("userID:");
    JLabel fnamelabel = new JLabel("First name:");
    JLabel lnamelabel = new JLabel("Last name:");
    JLabel userPasslabel = new JLabel("password:");

    JLabel messageLabel = new JLabel(" Where");
    JLabel messageLabel2 = new JLabel("2Go");
    JLabel confirmmessage = new JLabel("");





    HashMap<String,String> logininf = new HashMap<String,String>();


    CreateAccount(HashMap<String,String> logininforg)
    {
        logininf = logininforg;

        userIDlabel.setBounds(50,400,125,75);
        userPasslabel.setBounds(50,500,175,75);
        messageLabel.setBounds(50,50,375,75);
        messageLabel2.setBounds(257,50,375,75);
        userIDfield.setBounds(50,470,205,45);
        userPassfield.setBounds(50,570,205,45);
        loginbutton.setBounds(50,670,205,45);
        confirmmessage.setBounds( 300, 270 ,905 ,45);
        fnamelabel.setBounds(50,200, 175,75);
        lnamelabel.setBounds( 50, 300 ,175, 75);
        fnamefield.setBounds( 50, 270, 205, 45);
        lnamefield.setBounds( 50,370,205,45);

        loginbutton.addActionListener(this);

        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/back.png")))));
        } catch (IOException x) {
            x.printStackTrace();}


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
        fnamefield.setFont(scris);
        fnamelabel.setFont(fn1);
        lnamefield.setFont(scris);
        lnamelabel.setFont(fn1);

        messageLabel.setForeground(Color.white);
        messageLabel2.setForeground(new java.awt.Color(70,208,125));


        userPasslabel.setForeground(Color.WHITE);
        userIDlabel.setForeground(Color.WHITE);
        fnamelabel.setForeground(Color.WHITE);
        lnamelabel.setForeground(Color.WHITE);

        frame.setTitle("Login your account");
        frame.getContentPane().setBackground(new java.awt.Color(59,147,225));

        frame.add(userIDlabel);
        frame.add(userPasslabel);
        frame.add(userIDfield);
        frame.add(userPassfield);
        frame.add(loginbutton);
        frame.add(confirmmessage);
        frame.add(fnamefield);
        frame.add(lnamefield);
        frame.add(fnamelabel);
        frame.add(lnamelabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(Color.blue);
    }

    public void actionPerformed(ActionEvent x) {
        IDPasswords idpass = new IDPasswords();

        idpass.getlogininfo();
        if (x.getSource() == loginbutton && !userIDfield.getText().equals("") && !userPassfield.getText().equals("") && !fnamefield.getText().equals("") && !lnamefield.getText().equals("")) {
            String userID = userIDfield.getText();

            if ( logininf.containsKey(userID) ){
                confirmmessage.setText("This name is already taken! Try another one.");
                confirmmessage.setForeground(Color.red);
            }
            else {
                idpass.setaccount(userID,userPassfield.getText());
                confirmmessage.setText("You have signed up");
                confirmmessage.setForeground(Color.green );
                LoginPage login = new LoginPage(idpass.getlogininfo());
                frame.dispose();
            }
        }
    }
}
