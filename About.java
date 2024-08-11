package Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton ok ;

    public About(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Notepad/icons/notepad.png"));
        Image i2 = i1.getImage();
        setIconImage(i2);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Notepad/icons/windows.png"));
        Image i4 = i3.getImage().getScaledInstance(300, 70, Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel i6 = new JLabel(i5);
        i6.setBounds(150, 0,300,70);
        add(i6);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Notepad/icons/notepad.png"));
        Image i8 = i7.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel i10 = new JLabel(i9);
        i10.setBounds(50, 120,100,100);
        add(i10);

        JLabel text = new JLabel("<html>Create By Tanish<br>Version 0.1.0(OS Build Using JAVA)<br>Tanish.All rights reserved</html>");
        text.setBounds(180 , 100 , 500 , 100);
        text.setFont(new Font("Railway" , Font.PLAIN , 16));
        add(text);

        ok = new JButton("OK");
        ok.setBounds(450 , 400 , 100 , 30);
        ok.setBackground(Color.WHITE);
        ok.addActionListener(this);
        add(ok);

        setSize(600,500);
        setLocation(400,100);
        setTitle("About Notepad");
        setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new About();
    }    
}
