import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JPanel heading;
    JPanel login;
    JLabel name;

    JTextField username;
    JPasswordField password;

    JButton signin;
    JButton signup;

    Login() {
        Font f = new Font("Times New Roman", Font.BOLD, 30);

        /**
         * Heading Panel having "Login Page" Label with 80% Transparency
         */
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80)); //80%
        heading.setBounds(0, 0, 900, 100);

        name = new JLabel("iUnify Login Page");
        name.setLayout(null);
        name.setBounds(200, 100, 400, 400);
        name.setFont(f);
        name.setForeground(Color.WHITE);
        heading.add(name);

        /**
         * Login Panel
         */
        login = new JPanel();
        login.setLayout(null);
        login.setSize(400, 350);
        login.setBackground(new Color(0, 0, 0, 60));
        login.setBounds(250, 175, 400, 350);

        /**
         * Username Field
         */
        username = new JTextField("Enter Username: ");
        username.setBounds(50, 50, 300, 50);
        username.setBackground(new Color(188, 255, 152));
        login.add(username);

        /**
         * Password Field
         */
        password = new JPasswordField("Enter Password: ");
        password.setBounds(50, 150, 300, 50);
        password.setBackground(new Color(186, 220, 255));
        login.add(password);

        /**
         * Sign In Button
         */
        signin = new JButton("Sign In");
        signin.setBounds(50, 250, 100, 50);
        signin.setBackground(new Color(243, 152, 74));
        signin.addActionListener(this);
        login.add(signin);


        /**
         * Sign Up Button
         */
        signup = new JButton("Sign Up");
        signup.setBounds(250, 250, 100, 50);
        signup.setBackground(new Color(251, 255, 142));
        signup.addActionListener(this);
        login.add(signup);

        /**
         * Frame
         */
        setSize(900, 600);
        setLayout(null);

        /**
         * Background
         */
        ImageIcon background_image = new ImageIcon("/home/kamadhenu/Documents/LoginPage/src/1.jpeg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.add(heading);
        background.add(login);
        background.setBounds(0, 0, 900, 600);
        add(background);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String uname = username.getText();
        String pass = password.getText();
        if(ae.getSource()==this.signin)
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/dbname", "darpan", "kama@123");


                Statement stmt = con.createStatement();
                String sql = ("SELECT * FROM details;");

                ResultSet rs = stmt.executeQuery(sql);

                int i=1;
                int found=0;

                while(rs.next())
                {
                    String un = rs.getString(1);
                    String ps = rs.getString(2);
                    i++;

                    if (uname.equals(un) && pass.equals(ps))
                    {
                        found=1;
                        break;
                    }
                }

                if(found==1)
                {
                    Welcome wel = new Welcome();
                        dispose();
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Incorrect Username or Password");
                }

                con.close();
            }

            catch (Exception e)
            {
                System.out.println(e);
            }
        }

        else if(ae.getSource()==this.signup)
        {
            SignUp su = new SignUp();
            su.dataRead();
            dispose();
        }
    }
}

