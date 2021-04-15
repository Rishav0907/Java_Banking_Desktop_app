package bankingsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
public class Registrationwindow implements ActionListener {
    private JFrame registerFrame;
    private JPanel textPanel;
    JTextField firstNameField=null;
    JTextField lastNameField=null;
    JTextField phoneNumberField=null;
    JPasswordField passwordField=null;

    enum FieldName{
        FIRST_NAME,
        LAST_NAME,
        PHONE_NUMBER,
        PASSWORD
    };

    public void actionPerformed(ActionEvent e){
        System.out.println("Test");
        registerFrame=new JFrame("Register");
        registerFrame.setSize(300,350);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setResizable(false);
        registerFrame.setVisible(true);
        textPanel=new JPanel();
//        textPanel.setLayout();
        textPanel.setBounds(100,200,300,350);

        JLabel firstNameLabel=new JLabel("First Name:");
        JLabel lastNameLabel=new JLabel("Last Name:");
        JLabel phoneNumberLabel=new JLabel("Phone No:");
        JLabel passwordLabel=new JLabel("Password:");


        showTextFields(firstNameLabel,textPanel,FieldName.FIRST_NAME);
        showTextFields(lastNameLabel,textPanel,FieldName.LAST_NAME);
        showTextFields(phoneNumberLabel,textPanel,FieldName.PHONE_NUMBER);
        showTextFields(passwordLabel,textPanel,FieldName.PASSWORD);
        submit();
    }
    public void showTextFields(JLabel labelName,JPanel panelName,FieldName fieldName)
    {
        if(fieldName==FieldName.FIRST_NAME)
        {
            firstNameField=new JTextField(20) ;
            labelName.setLabelFor(firstNameField);
            panelName.add(labelName);
            panelName.add(firstNameField);
        }
        if (fieldName==FieldName.LAST_NAME)
        {
            lastNameField=new JTextField(20) ;
            labelName.setLabelFor(lastNameField);
            panelName.add(labelName);
            panelName.add(lastNameField);
        }
        if (fieldName==FieldName.PHONE_NUMBER)
        {
            phoneNumberField=new JTextField(20) ;
            labelName.setLabelFor(phoneNumberField);
            panelName.add(labelName);
            panelName.add(phoneNumberField);
        }
        else if(fieldName==FieldName.PASSWORD)
        {
            passwordField=new JPasswordField(20);
            labelName.setLabelFor(passwordField);
            panelName.add(labelName);
            panelName.add(passwordField);
        }

        registerFrame.add(panelName);
        registerFrame.setVisible(true);

    }
    public void submit(){
        JButton submitButton=new JButton("Register");
        submitButton.setPreferredSize(new Dimension(100,30));
        textPanel.add(submitButton);
        registerFrame.add(textPanel);
        registerFrame.setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String first_name=firstNameField.getText();
                String last_name=lastNameField.getText();
                String phone_Number=phoneNumberField.getText();
                String password=passwordField.getPassword().toString();
                boolean registerAction=new databaseRegister().userRegistration(first_name,last_name,phone_Number,password);
                if(registerAction==true)
                {
//                    new alertBox.showMessage(registerFrame,"User Regisstration Successfull");
                    new alertBox().showMessage(registerFrame,"User Registration Successfull");
                }
                else if (registerAction=false)
                {
                    new alertBox().showMessage(registerFrame,"Error occured");
                }
            }
        });
    }
}