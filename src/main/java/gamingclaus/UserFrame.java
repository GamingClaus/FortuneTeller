package gamingclaus;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserFrame extends JFrame implements ActionListener,KeyListener {
    //for the api thingy
    String sign;
    String day;
    String horoscope_data;

    JLabel label1;
    JPanel topPanel;
    JPanel centerPanel;
    JPanel signPanel;
    JPanel timePanel;
    JLabel timeLabel;
    JLabel signLabel;
    JComboBox<String> comboBox;
    TextField textField;
    JButton submit;


    UserFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(650,650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //------------------------Setting up the TopBar--------------------
        label1 = new JLabel();
        label1.setFont(new Font("Helvetica",Font.BOLD,25));
        label1.setText("FORTUNE TELLER");
        label1.setForeground(Color.MAGENTA);

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(0,45));
        topPanel.setBackground(Color.BLACK);
        topPanel.setOpaque(true);

        topPanel.add(label1);
        //-----------------------------------------------------------------


        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));


        //----Creating a Sub panel to add to the Centerpanel----
        signPanel = new JPanel();
        signPanel.setLayout(new BoxLayout(signPanel,BoxLayout.X_AXIS));
        signPanel.setBorder(new EmptyBorder(50, 20, 20, 20)); // Add padding
        signPanel.setMaximumSize(new Dimension(500,100));
        // signPanel.setBackground(Color.BLACK);
        //signPanel.setOpaque(true);

        signLabel = new JLabel();
        signLabel.setText("Enter Your Zodiac Sign:");
        signLabel.setFont(new Font("Calibri",Font.BOLD,18));


        textField = new TextField();
        textField.setMaximumSize(new Dimension(200, 20));
        //textField.addKeyListener(this);


        
        signPanel.add(signLabel);
        signPanel.add(textField);
        //--------------------------------------------------------




        //----------------setting up the combo box and centerlabel for timepanel-----
        timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel,BoxLayout.X_AXIS));
        timePanel.setMaximumSize(new Dimension(460,50));
        // timePanel.setBackground(Color.BLACK);
        //timePanel.setOpaque(true);

        timeLabel = new JLabel();
        timeLabel.setText("Time:");
        timeLabel.setFont(new Font("Calibri",Font.BOLD,18));

        String[] day = {"Today","Tomorrow","Yesterday"};
        comboBox = new JComboBox<String>(day);
        comboBox.setFocusable(false);
        comboBox.setMaximumSize(new Dimension(100,30));
        comboBox.addActionListener(this);



        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setMaximumSize(new Dimension(100,30));
        

        
        timePanel.add(timeLabel);
        timePanel.add(comboBox);
        timePanel.add(submit);


      
    
        /////---------------------------------------------------------

        

        //adding these to the centerpanel
        centerPanel.add(signPanel);
        centerPanel.add(timePanel);

        this.add(centerPanel,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);
        this.addKeyListener(this);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //later on editing this with api
        if(e.getSource()==submit){
            String sign = textField.getText();
            String day = (String) comboBox.getSelectedItem();
            //fetching the api
            horoscopeapi horoscopeApi = new horoscopeapi();
           
            try {
                JTextArea resultarea = new JTextArea();
                String horoscopeData = horoscopeApi.horoscopefetcher(sign, day);
                resultarea.setText( sign + " " + day +"'s Horoscope: \n>" +horoscopeData);
                resultarea.setFont(new Font("Arial",Font.PLAIN,20));
                resultarea.setOpaque(true);
                resultarea.setEditable(false);
                resultarea.setLineWrap(true);
                resultarea.setWrapStyleWord(true);
                resultarea.setOpaque(false);
                

                centerPanel.removeAll();

                //adds the result area to the centerpanel and revalidates if anything is added which is true and repaints it to the screen
                centerPanel.add(resultarea);
                JLabel retry = new JLabel("Press 'BackSpace Key' to Start again......");
                centerPanel.add(retry);
                centerPanel.revalidate();
                centerPanel.repaint();

            } catch (IOException e1) {
                //IO EXCEPTION
            } catch (InterruptedException e1) {
                // InterruptedException
            }
           
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
       
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            new InfoFrame();
            

        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}