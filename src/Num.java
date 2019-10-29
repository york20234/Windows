import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Num extends JFrame {
    private Container cp;
    private Random rand = new Random();
    private String str[] = new String[10];
    private String str2[] = {"submit", "exit"};
    private JButton jbtns[] = new JButton[10];
    private JButton jbtns2[] = new JButton[2];
    //private JLabel jlb = new JLabel("0");
    private JTextField jpf1 = new JTextField("");
    private JPanel jpl = new JPanel(new GridLayout(3, 4, 3, 3));
    private JPanel jpl2 = new JPanel(new GridLayout(2, 1, 3, 3));
    private Window num;
    private String str3="";


    public Num(Window nu1) {
        num = nu1;
        init();
    }

    private void init() {

        cp = this.getContentPane();
        this.setLayout(new BorderLayout(3, 3));
        this.setSize(400, 400);
        jpf1.setFont(new Font(null, Font.PLAIN, 30));
        cp.add(jpf1, BorderLayout.NORTH);
        cp.add(jpl, BorderLayout.CENTER);
        cp.add(jpl2, BorderLayout.EAST);

        for (int i = 0; i < 2; i++) {
            jbtns2[i] = new JButton(str2[i]);
            jpl2.add(jbtns2[i]);
            jbtns2[i].setFont(new Font(null, Font.PLAIN, 30));
            jbtns2[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    num.setJPF(new String(jpf1.getText()));
                }
            });
            jbtns2[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Num.this.setVisible(false);
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            str[i] = Integer.toString(rand.nextInt(10));
            for (int j = 0; j < i; j++) {
                if (str[i].equals(str[j])) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            jbtns[i] = new JButton(str[i]);
            jpl.add(jbtns[i]);
            jbtns[i].setFont(new Font(null, Font.PLAIN, 30));
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbtn = (JButton) e.getSource();
                    str3=str3+jbtn.getText();
                    jpf1.setText(str3);


                }
            });
        }
    }
}

