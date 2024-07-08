import javax.swing.*;

import java.awt.*;

import java.awt.event.*;
 
class MyFrame

    extends JFrame

    implements ActionListener {

    private Container c;

    private JLabel title;

    private JLabel name;

    private JTextField tname;

    private JLabel rno;

    private JTextField trno;

    private JButton sub;

    private JButton reset;

    private JTextArea tout;

    private JLabel res;

    private JTextArea resadd;
  
    public MyFrame()

    {

        setTitle("Login Form");

        setBounds(300, 90, 500, 350);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);
 

        c = getContentPane();

        c.setLayout(null);
 

        title = new JLabel("QuizeGame");

        title.setFont(new Font("Arial", Font.PLAIN, 30));

        title.setSize(300, 30);

        title.setLocation(70, 30);

        c.add(title);
name = new JLabel("Name");

        name.setFont(new Font("Arial", Font.PLAIN, 20));

        name.setSize(100, 20);

        name.setLocation(100, 100);

        c.add(name);
 

        tname = new JTextField();

        tname.setFont(new Font("Arial", Font.PLAIN, 15));

        tname.setSize(190, 20);

        tname.setLocation(200, 100);

        c.add(tname);
 

        rno = new JLabel("Roll No.");

        rno.setFont(new Font("Arial", Font.PLAIN, 20));

        rno.setSize(100, 20);

        rno.setLocation(100, 150);

        c.add(rno);
 

        trno = new JTextField();

        trno.setFont(new Font("Arial", Font.PLAIN, 15));

        trno.setSize(150, 20);

        trno.setLocation(200, 150);

        c.add(trno);

        sub = new JButton("Submit");

        sub.setFont(new Font("Arial", Font.PLAIN, 15));

        sub.setSize(100, 20);

        sub.setLocation(50, 250);

        sub.addActionListener(this);

        c.add(sub);
 

        reset = new JButton("Reset");

        reset.setFont(new Font("Arial", Font.PLAIN, 15));

        reset.setSize(100, 20);

        reset.setLocation(170, 250);

        reset.addActionListener(this);

        c.add(reset);
 

        tout = new JTextArea();

        tout.setFont(new Font("Arial", Font.PLAIN, 15));

        tout.setSize(300, 400);

        tout.setLocation(500, 100);

        tout.setLineWrap(true);

        tout.setEditable(false);

        c.add(tout);
 

        res = new JLabel("");

        res.setFont(new Font("Arial", Font.PLAIN, 20));

        res.setSize(500, 25);

        res.setLocation(100, 500);

        c.add(res);
 

        resadd = new JTextArea();

        resadd.setFont(new Font("Arial", Font.PLAIN, 15));

        resadd.setSize(200, 75);

        resadd.setLocation(580, 175);

        resadd.setLineWrap(true);

        c.add(resadd);
 

        setVisible(true);

    }
public void actionPerformed(ActionEvent e)

    {

        if (e.getSource() == sub) {

            dispose();
            OnlineTest ot=new OnlineTest("Online Quiz");
                ot.setVisible(true);
             }

        else if (e.getSource() == reset) {

            String def = "";

            tname.setText(def);

            trno.setText(def);

            res.setText(def);

            tout.setText(def);
            
            resadd.setText(def);

        }

    }
}
class Registration {
 

    public static void main(String[] args) throws Exception

    {

        MyFrame f = new MyFrame();

    }
}