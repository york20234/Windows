import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MouseGame extends JInternalFrame {
    private Container cp;
    private JLabel jlb=new JLabel();
    private Timer t1,t2;
    private ImageIcon icon=new ImageIcon("mon.png");
    private ImageIcon icon2=new ImageIcon("explostion.png");
    private JLabel score=new JLabel("分數:");
    private JLabel num=new JLabel("0");
    private JButton start=new JButton("Start");
    private JButton exit=new JButton("Exit");
    private JButton add=new JButton("Add Object");
    private JPanel jpnN=new JPanel(new GridLayout(1,4,3,3));
    private JPanel jpnS=new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpnC=new JPanel();
    private Random rand=new Random();
    private int labX=0;
    private int labY=0;

    public MouseGame(String title) {
        super(title, true, true, true, true);
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setBounds(5,5,600,400);
        labX=rand.nextInt(MouseGame.this.getHeight());
        labY=rand.nextInt(MouseGame.this.getWidth());
        Image img=icon.getImage();
        Image newing=img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
        icon=new ImageIcon(newing);

//        img=icon2.getImage();
//        Image newing1=img.getScaledInstance(120,120, Image.SCALE_SMOOTH);
//        icon=new ImageIcon(newing1);

        jlb.setIcon(icon);
        jlb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                t1.stop();
                t2.start();
                jlb.setIcon(icon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }


        });
        t1=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             labX=rand.nextInt(MouseGame.this.getHeight()-10) ;
             labY=rand.nextInt(MouseGame.this.getWidth()-10) ;
             jlb.setLocation(labX,labY);
            }
        });


        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpnN,BorderLayout.NORTH);
        cp.add(jpnS,BorderLayout.SOUTH);
        cp.add(jpnC,BorderLayout.CENTER);
        jpnN.add(score);
        jpnN.add(num);
        jpnN.add(start);
        jpnN.add(exit);
        jpnC.add(jlb);

        jpnS.add(add);

        cp.add(jlb);

        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        start.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
                cp.repaint();
            }
        });
    }
}
