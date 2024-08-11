package Notepad;

import javax.swing.*;                                         //it import used subclasses of swing package not import sub-packages of swing. //use classes - JFileChooser
//import javax.swing.filechooser.*;                           //subPackage of swing

import java.awt.*;
import java.awt.event.*;                                    //use classes - 
import java.io.*;

public class Notepad extends JFrame implements ActionListener{

    JTextArea area;
    String text;

    public Notepad(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Notepad/icons/notepad.png"));
        Image i2 = i1.getImage();
        setIconImage(i2);

        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.WHITE);

        setJMenuBar(menubar);

        JMenu file = new JMenu("File");
        file.setFont(new Font("AERIAL" , Font.PLAIN , 15));
        menubar.add(file);

        JMenuItem newdoc = new JMenuItem("New");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);
        file.add(newdoc);

        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        file.add(open);

        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        file.add(save);

        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        file.add(print);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E , ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("AERIAL" , Font.PLAIN , 15));
        menubar.add(edit);

        JMenuItem select = new JMenuItem("Select All");
        select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
        select.addActionListener(this);
        edit.add(select);

        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        edit.add(copy);

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        edit.add(paste);

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        edit.add(cut);

        JMenu helpmenu = new JMenu("Help");
        helpmenu.setFont(new Font("AERIAL" , Font.PLAIN , 15));
        menubar.add(helpmenu);

        JMenuItem help  = new JMenuItem("About Notepad");
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L , ActionEvent.CTRL_MASK));
        help.addActionListener(this);
        helpmenu.add(help);
 
        area = new JTextArea();
        area.setFont(new Font("Railway" , Font.PLAIN , 15));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);

        setTitle("Notepad");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("New")){
            area.setText("");
        }else if(ae.getActionCommand().equals("Open")){
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(true);
            // FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files",".txt");
            // chooser.addChoosableFileFilter(restrict);

            int action = chooser.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader, null);
                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getActionCommand().equals("Save")){
            JFileChooser saveas = new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action = saveas.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            File filename = new File(saveas.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(filename));
                area.write(outFile);
                area.setText("");
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getActionCommand().equals("Print")){
            try {
                area.print();
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getActionCommand().equals("Exit")){
            System.exit(0);
        }else if(ae.getActionCommand().equals("Copy")){
            text = area.getSelectedText();
        }else if(ae.getActionCommand().equals("Paste")){
            area.insert(text, area.getCaretPosition());
        }else if(ae.getActionCommand().equals("Cut")){
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        }else  if(ae.getActionCommand().equals("Select All")){
            area.selectAll();
        }else if(ae.getActionCommand().equals("About Notepad")){
            new About().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Notepad();
    }
}
