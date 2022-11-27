import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.EventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Color;

public class PrincipalPage implements ActionListener {

    JFrame frame = new JFrame();

    JButton login;
    JButton guest;
    JButton create = new JButton("Create an account");

    PrincipalPage (){
        ImageIcon image = new ImageIcon("src/loginbutt.png");
        login = new JButton(image);
        ImageIcon image2 = new ImageIcon("src/guestbutt.png");
        guest = new JButton(image2);

        login.setBounds(830,550,250,100);
        guest.setBounds(830,700,250,100);
        create.setBounds( 862,790,250,50);

        Font fn = new Font("Arial",Font.ITALIC,20);
        create.setFont(fn);

        create.setBorderPainted(false);
        create.setContentAreaFilled(false);

        create.setForeground(Color.WHITE);

        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/princip.png")))));
        } catch (IOException x) {
            x.printStackTrace();}

        login.addActionListener(this);
        guest.addActionListener(this);
        create.addActionListener(this);

        frame.getContentPane().setBackground(new java.awt.Color(255,255,225));

        frame.add(login);
        frame.add(guest);
        frame.add(create);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent x) {
        IDPasswords idpass = new IDPasswords();

        idpass.getlogininfo();
        if (x.getSource() == login)
        {
            LoginPage loginpage = new LoginPage(idpass.getlogininfo());
        }
        if (x.getSource() == create)
        {
            CreateAccount createaccount = new CreateAccount(idpass.getlogininfo());
        }
         if ( x.getSource() == guest)
         {
             try {
                 File htmlfile = new File("src/index.html");
                 Desktop.getDesktop().open(htmlfile);
             } catch (Exception e) {}
         }
    }
}
