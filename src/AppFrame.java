import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {
    private Container cp;
    private JMenuBar jmbar= new JMenuBar();
    private JMenu jmFile= new JMenu("File");
    private JMenuItem exit =new JMenuItem("Exit");
    private JMenuItem jmiLogout=new JMenuItem("Logout");
    private JMenu jmTool= new JMenu("Tool");
    private JMenuItem jmiCalculator=new JMenuItem("Calculator");
    private JMenuItem jmiEncryptor=new JMenuItem("Encryptor");
    private JMenu jmGame= new JMenu("Game");
    private JMenuItem jmiMouse=new JMenuItem("MouseGame");
    private JMenu jmHelp=new JMenu("Help");


    private Window loginFrame;
    private JDesktopPane desktop=new JDesktopPane();
    private EncryptorFrame internalFrame1=new EncryptorFrame("Encrptor");
    private MouseGame internalFrame2=new MouseGame("MouseGame");



    public AppFrame(Window login){
        loginFrame=login;
        init();
    }
    private void init(){
        cp=this.getContentPane();
        this.setSize(650,500);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.setJMenuBar(jmbar);
        jmbar.add(jmFile);
        jmFile.add(exit);
        jmFile.add(jmiLogout);
        jmbar.add(jmTool);
        jmTool.add(jmiCalculator);
        jmTool.add(jmiEncryptor);
        jmbar.add(jmGame);
        jmGame.add(jmiMouse);
        jmbar.add(jmHelp);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        jmiLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppFrame.this.setVisible(false);
                AppFrame.this.dispose();
                loginFrame.resetData();
                loginFrame.setVisible(true);
            }
        });
        jmiCalculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jmiEncryptor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame1.setVisible(true);
            }
        });
        jmiMouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                internalFrame2.setVisible(true);
            }
        });

        this.add(desktop);
        desktop.add(internalFrame1);
        desktop.add(internalFrame2);
    }
}