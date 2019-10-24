import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener
{
    JFrame jf;

    JPanel heading;
    JPanel login;

    JLabel name;
    JLabel lblusername;
    JLabel lblpassword;
    JLabel lblconfirmpassword;
    JLabel lblgender;
    JLabel lblemail;
    JLabel lblmobile;
    JLabel success;
    JLabel checkusername;
    JLabel checkpassword;
    JLabel checkemail;
    JLabel checkmobile;

    boolean ch1=false, ch2=false, ch3=false, ch4=false;

    JRadioButton smale;
    JRadioButton sothers;
    JRadioButton sfemale;

    JTextField susername;
    JTextField semail;
    JTextField smobile;

    JPasswordField spassword;
    JPasswordField sconfirmpassword;

    JButton signup;
    JButton back;

    ButtonGroup bg;

    Font f;
    Font lblf;
    Font small;

    EmailValidator emailValidator;

    public SignUp()
    {
        f = new Font("Times New Roman", Font.BOLD, 30);
        lblf = new Font("Times New Roman", Font.BOLD, 15);
        small = new Font("Times New Roman", Font.BOLD, 10);

        setTitle("Sign Up Form");
        setSize(900, 600);
        setVisible(true);

        /**
         * Heading Panel having "Sign Up Page" Label with 80% Transparency
         */

        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80)); //80%
        heading.setBounds(0,0,900,50);

        name = new JLabel("iUnify Sign Up Page");
        name.setLayout(null);
        name.setBounds(200, 100, 400, 400);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);

        /**
         * Login Panel
         */
        login = new JPanel();
        login.setLayout(null);
        login.setSize(400,350);
        login.setBackground(new Color(0,0,0,100));
        login.setBounds(75, 100,750,450);

        /**
         * Username Label
         */
        lblusername = new JLabel("Username");
        lblusername.setLayout(null);
        lblusername.setBounds(50,25,200,30);
        lblusername.setForeground(Color.WHITE);
        lblusername.setFont(lblf);
        login.add(lblusername);


        /**
         * Username Field
         */
        susername = new JTextField();
        susername.setBounds(220, 25, 300, 30);
        susername.setBackground(new Color(188, 255, 152));
        login.add(susername);

        /**
         * Username Check Label
         */
        checkusername = new JLabel("Username already exists");
        checkusername.setLayout(null);
        checkusername.setBounds(550,25,150,30);
        checkusername.setForeground(Color.WHITE);
        checkusername.setFont(small);
        checkusername.setVisible(false);
        login.add(checkusername);


        /**
         * Password Label
         */
        lblpassword = new JLabel("Password");
        lblpassword.setLayout(null);
        lblpassword.setBounds(50,75,400,30);
        lblpassword.setForeground(Color.WHITE);
        lblpassword.setFont(lblf);
        login.add(lblpassword);


        /**
         * Password Field
         */
        spassword = new JPasswordField();
        spassword.setBounds(220, 75, 300, 30);
        spassword.setBackground(new Color(188, 255, 152));
        login.add(spassword);

        /**
         * Password Check Label
         */
        checkpassword = new JLabel("Password and Confirmed Password not matching");
        checkpassword.setLayout(null);
        checkpassword.setBounds(550,75,150,30);
        checkpassword.setForeground(Color.WHITE);
        checkpassword.setFont(small);
        checkpassword.setVisible(false);
        login.add(checkpassword);


        /**
         * Confirm Password Label
         */
        lblconfirmpassword = new JLabel("Confirm Password");
        lblconfirmpassword.setLayout(null);
        lblconfirmpassword.setBounds(50,125,400,30);
        lblconfirmpassword.setForeground(Color.WHITE);
        lblconfirmpassword.setFont(lblf);
        login.add(lblconfirmpassword);


        /**
         * Confirm Password Field
         */
        sconfirmpassword = new JPasswordField();
        sconfirmpassword.setBounds(220, 125, 300, 30);
        sconfirmpassword.setBackground(new Color(188, 255, 152));
        login.add(sconfirmpassword);

        /**
         * Gender Label
         */
        lblgender = new JLabel("Gender");
        lblgender.setLayout(null);
        lblgender.setBounds(50,175,400,30);
        lblgender.setForeground(Color.WHITE);
        lblgender.setFont(lblf);
        login.add(lblgender);

        /**
         * Gender RadioButton Fields
         */
        smale = new JRadioButton("Male");
        smale.setActionCommand("Male");
        smale.setSelected(true);

        sfemale = new JRadioButton("Female");
        sfemale.setActionCommand("Female");

        sothers = new JRadioButton("Others");
        sothers.setActionCommand("Others");

        smale.setBounds(220, 175, 80, 40);
        smale.setBackground(new Color(0,0,0,0));
        smale.setForeground(Color.WHITE);

        sfemale.setBounds(320, 175, 80, 40);
        sfemale.setBackground(new Color(0,0,0,0));
        sfemale.setForeground(Color.WHITE);

        sothers.setBounds(420, 175, 80, 40);
        sothers.setBackground(new Color(0,0,0,0));
        sothers.setForeground(Color.WHITE);

        bg = new ButtonGroup();

        bg.add(smale);
        bg.add(sfemale);
        bg.add(sothers);

        login.add(smale);
        login.add(sfemale);
        login.add(sothers);

        /**
         * Email ID Label
         */
        lblemail = new JLabel("Email ID");
        lblemail.setLayout(null);
        lblemail.setBounds(50,225,400,30);
        lblemail.setForeground(Color.WHITE);
        lblemail.setFont(lblf);
        login.add(lblemail);


        /**
         * Email ID Field
         */
        semail = new JTextField();
        semail.setBounds(220, 225, 300, 30);
        semail.setBackground(new Color(188, 255, 152));
        login.add(semail);

        /**
         * Email ID Check Label
         */
        checkemail = new JLabel("Password and Confirmed Password not matching");
        checkemail.setLayout(null);
        checkemail.setBounds(550,225,150,30);
        checkemail.setForeground(Color.WHITE);
        checkemail.setFont(small);
        checkemail.setVisible(false);
        login.add(checkemail);

        /**
         * Mobile Number Label
         */
        lblmobile = new JLabel("Mobile Number");
        lblmobile.setLayout(null);
        lblmobile.setBounds(50,275,400,30);
        lblmobile.setForeground(Color.WHITE);
        lblmobile.setFont(lblf);
        login.add(lblmobile);


        /**
         * Mobile Number Field
         */
        smobile = new JTextField();
        smobile.setBounds(220, 275, 300, 30);
        smobile.setBackground(new Color(188, 255, 152));
        login.add(smobile);

        /**
         * Mobile Number Check Label
         */
        checkmobile = new JLabel("Password and Confirmed Password not matching");
        checkmobile.setLayout(null);
        checkmobile.setBounds(550,225,150,30);
        checkmobile.setForeground(Color.WHITE);
        checkmobile.setFont(small);
        checkmobile.setVisible(false);
        login.add(checkmobile);

        /**
         * Sign Up Button
         */
        signup = new JButton("Sign Up");
        signup.setBounds(420, 350, 100, 50);
        signup.setBackground(new Color(251, 255, 142));
        signup.addActionListener(this);
        login.add(signup);

        /**
         * Back Button
         */
        back = new JButton("Back");
        back.setBounds(50, 350, 100, 50);
        back.setBackground(new Color(251, 255, 142));
        back.addActionListener(this);
        login.add(back);

        /**
         * Success Result if successfully Signed Up
         */
        success = new JLabel("Success!");
        success.setLayout(null);
        success.setBounds(550,350,300,50);
        success.setForeground(Color.GREEN);
        success.setFont(lblf);
        //success.setBackground(new Color(0,0,0, 0));
        success.setVisible(false);
        login.add(success);

        /**
         * Same Background Image
         */
        ImageIcon background_image = new ImageIcon("/home/kamadhenu/Documents/LoginPage/src/1.jpeg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);
        add(background);
        background.add(heading);
        background.add(login);
    }

    public int dataRead()
    {
        int found = -1;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbname", "darpan", "kama@123");

            Statement stmt = con.createStatement();
            String sql = ("SELECT * FROM details;");
            ResultSet rs = stmt.executeQuery(sql);

            int i = 1;

            emailValidator = new EmailValidator();

            while (rs.next())
            {
                String un = rs.getString(1);
                String em = rs.getString(3);

                if (((susername.getText()).equals(un)) == true) {
                    found = 1;
                    ch1 = true;
                    break;
                }

                if (((semail.getText()).equals(em)) == true) {
                    found = 4;
                    ch2=true;
                    break;
                }

                if (spassword.getText().equals(sconfirmpassword.getText())) {
                    found = 0;
                } else {
                    found = 2;
                    break;
                }

                if (!emailValidator.validate(semail.getText().trim())) {
                    found = 3;
                    break;
                }

            }
            con.close();
        }

        catch (Exception e)
        {
            System.out.println(e);
        }

        return found;
    }



    public void dataCreate(int found)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbname", "darpan", "kama@123");

            if (found == 0) {
                Statement stmt2 = con.createStatement();

                String a = susername.getText();
                String b = spassword.getText();
                String ca = semail.getText();
                String d = bg.getSelection().getActionCommand();
                String e = smobile.getText();

                PreparedStatement ps = con.prepareStatement
                        ("insert into details values(?,?,?,?,?)");

                ps.setString(1, a);
                ps.setString(2, b);
                ps.setString(3, ca);
                ps.setString(4, d);
                ps.setString(5, e);


                int j = ps.executeUpdate();

                success.setVisible(true);

            } else if (found == 1)
            {
                JOptionPane.showMessageDialog(jf, "Username already exists");
                checkusername.setVisible(true);
            }
            else if (found == 2) {
                JOptionPane.showMessageDialog(jf, "Confirmed password does not match with password");
            } else if (found == 3) {
                JOptionPane.showMessageDialog(jf, "Email ID not valid");
            } else if (found == 4) {
                JOptionPane.showMessageDialog(jf, "Email ID already exists");
            }
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==this.signup)
        {
            dataCreate(dataRead());
        }


        else if(ae.getSource()==this.back)
        {
            Login l1 = new Login();
            dispose();
        }
    }
}
