import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame
{
    JLabel label;

    public Welcome()
    {
        setTitle("Welcome");
        setSize(900, 600);

        setVisible(true);

        ImageIcon background_image = new ImageIcon("/home/kamadhenu/Documents/LoginPage/src/1.jpeg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);
        add(background);
    }
}
