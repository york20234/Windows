import javax.swing.*;
import java.awt.*;

public class MouseGame extends JInternalFrame {
    private Container cp;
    private int num=0;
    private JLabel back=new JLabel();
    private JLabel [] mouse;
    private ImageIcon imgMouse;
    private JLabel jtf;


    public MouseGame(String title) {
        super(title, true, true, true, true);
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setBounds(5,5,600,400);
        ImageIcon imgMouseHole=new ImageIcon("MouseHole.jpg");
        back.setIcon(imgMouseHole);
        Image image = imgMouseHole.getImage();
        cp.add(back);


    }
}
