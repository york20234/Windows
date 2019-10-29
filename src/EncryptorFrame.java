import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EncryptorFrame extends JInternalFrame {
    private Container cp;
    private JPanel jpnE=new JPanel(new GridLayout(10,1,3,3));
    private JPanel jpnN=new JPanel(new GridLayout(1,3,3,3));
    private JLabel jlb1=new JLabel("Flie");
    private JTextField jtf1=new JTextField();
    private JButton jpt1=new JButton("Browse");

    private JTextArea jta=new JTextArea();
    private JScrollPane jsp=new JScrollPane(jta);

    private JLabel jlb2=new JLabel("key");
    private JTextField jtfKey=new JTextField("3");

    private JLabel jlb3=new JLabel("Algorithm");
    private JComboBox<String> jcb=new JComboBox<String>();

    private ButtonGroup bg=new ButtonGroup();
    private JRadioButton jrb1=new JRadioButton("Encrypt");
    private JRadioButton jrb2=new JRadioButton("Dcerypt");
    private JButton start=new JButton("Start");
    private JButton clean=new JButton("Clean");
    private JButton save=new JButton("Save");
    private JButton exit=new JButton("Exit");

    public EncryptorFrame(String title){
        super(title,true,true,true,true);
        init();
    }
    private void init(){
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        this.setBounds(5,5,600,400);

        cp.add(jpnE,BorderLayout.EAST);
        cp.add(jsp,BorderLayout.CENTER);
        cp.add(jpnN,BorderLayout.NORTH);

        jpnE.add(jlb2);
        jpnE.add(jtfKey);
        jpnE.add(jlb3);
        jpnE.add(jcb);
        bg.add(jrb1);
        bg.add(jrb1);
        bg.add(jrb2);
        jcb.addItem("Caesar");
        jcb.addItem("XOR");
        jpnE.add(jrb1);
        jpnE.add(jrb2);
        jpnE.add(start);
        jpnE.add(clean);
        jpnE.add(save);
        jpnE.add(exit);

        jpnN.add(jlb1);
        jpnN.add(jtf1);
        jpnN.add(jpt1);


        jlb1.setBounds(50,50,200,200);


        jpt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc= new JFileChooser();
                int fileState=jfc.showOpenDialog(null);
                jfc.setCurrentDirectory(new File("./"));
                if (fileState==JFileChooser.APPROVE_OPTION){
                    try {
                        File selectFile= jfc.getSelectedFile();
                        jlb1.setText(selectFile.getPath());
                        FileInputStream fis=new FileInputStream(selectFile.getPath());
                        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
                        BufferedReader buf=new BufferedReader(isr);
                        String line;
                        while ((line=buf.readLine())!=null){
                            jta.append(line+"\n");
                        }
                        buf.close();
                        isr.close();
                        fis.close();
                    }catch (IOException ioe){
                        JOptionPane.showMessageDialog(EncryptorFrame.this,ioe.toString());
                    }catch (Exception err){
                        JOptionPane.showMessageDialog(EncryptorFrame.this,err.toString());
                    }
                }
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrb1.isSelected()){
                    switch (jcb.getSelectedIndex()){
                        case 0:
                            char data[]=jta.getText().toCharArray();
                            int key=Integer.parseInt(jtfKey.getText());
                            for (int i=0;i<data.length;i++){
                                data[i]=(char)(data[i]+key);
                            }
                            jta.setText(new String(data));
                            break;
                        case 1:
                            char data1[]=jta.getText().toCharArray();
                            char key1[]=jtfKey.getText().toCharArray();
                            for (int i=0;i<data1.length;i++){
                                data1[i]=(char)(data1[i]^key1[i%key1.length]);
                            }
                            jta.setText(new String(data1));

                    }
                }else {
                    switch (jcb.getSelectedIndex()) {
                        case 0:
                            char data[] = jta.getText().toCharArray();
                            int key = Integer.parseInt(jtfKey.getText());
                            for (int i = 0; i < data.length; i++) {
                                data[i] = (char) (data[i] - key);
                            }
                            jta.setText(new String(data));
                            break;
                        case 1:
                            char data1[]=jta.getText().toCharArray();
                            char key1[]=jtfKey.getText().toCharArray();
                            for (int i=0;i<data1.length;i++){
                                data1[i]=(char)(data1[i]^key1[i%key1.length]);
                            }
                            jta.setText(new String(data1));
                    }
                }
            }
        });

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
                jtf1.setText("");
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int fileState = jfc.showSaveDialog(EncryptorFrame.this);
                jfc.setCurrentDirectory(new File("./"));
                if (fileState == JFileChooser.APPROVE_OPTION) {
                    try {
                        File outFile = jfc.getSelectedFile();
                        if (!outFile.exists()){
                            outFile.createNewFile();
                        }
                        FileWriter fw=new FileWriter(outFile);
                        BufferedWriter bw=new BufferedWriter(fw);
                        bw.write(jta.getText());
                        bw.close();
                        fw.close();
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(EncryptorFrame.this, ioe.toString());
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(EncryptorFrame.this, err.toString());
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncryptorFrame.this.setVisible(false);
            }
        });


    }
}
