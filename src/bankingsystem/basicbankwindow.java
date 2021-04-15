package bankingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class basicbankwindow {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JPanel controlPanel;
    private JPanel mainOptionsPanel;
    private JPanel buttonPanel;
    public basicbankwindow()
    {
        prepareGUI();
    }
    public static void main(String[] args) {
        basicbankwindow basicbankwindow=new basicbankwindow();
        basicbankwindow.showPicture();
        basicbankwindow.showButtons();
    }
    private void prepareGUI() {
        mainFrame=new JFrame("Simple Java Banking System");
        mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(3, 3));
        mainFrame.setResizable(false);
        headerLabel = new JLabel("",JLabel.LEFT);
        headerLabel.setVerticalAlignment(JLabel.TOP);
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        mainFrame.add(headerLabel);
        headerLabel.setText("SIMPLE JAVA BANKING SYSTEM");
        headerLabel.setFont(new Font("Calibri",Font.PLAIN,26));
        headerLabel.setForeground(Color.black);
        controlPanel=new JPanel();
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);

    }
    public void showPicture() {
        mainOptionsPanel=new JPanel();
        ImageIcon icon=null;
        try{
            icon = new ImageIcon("/home/rishav/Desktop/bank/src/bankingsystem/bank.png");
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel pictureLabel = new JLabel();
        pictureLabel.setIcon(icon);
        pictureLabel.setVerticalAlignment(JLabel.TOP);
        // pictureLabel.setSize(new Dimension(10,10));
        mainOptionsPanel.add(pictureLabel);
        controlPanel.add(mainOptionsPanel);
        mainFrame.setVisible(true);
    }
    public void showButtons(){

        buttonPanel=new JPanel();
        JButton registerbutton = new JButton("Create Account");
        JButton loginbutton = new JButton("Login");
        loginbutton.addActionListener(new Registrationwindow());
        buttonPanel.add(registerbutton);
        buttonPanel.add(loginbutton);
        controlPanel.add(buttonPanel);
        mainFrame.setVisible(true);
    }
}
