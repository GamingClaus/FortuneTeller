package gamingclaus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DataFrame extends JFrame  {
    
    JLabel label1;
    JPanel topPanel;
    
    
    DataFrame(){
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(650,650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        label1 = new JLabel();
        topPanel = new JPanel();
       //setting the toppanel with label1 to give a topic to the program.
        topPanel.setPreferredSize(new Dimension(0,45));
        topPanel.setBackground(Color.BLACK);
        topPanel.setOpaque(true);
        
        label1.setFont(new Font("Helvetica",Font.BOLD,25));
        label1.setText("FORTUNE TELLER");
        label1.setForeground(Color.MAGENTA);
        topPanel.add(label1);
        
        this.add(topPanel,BorderLayout.NORTH);
        this.setVisible(true);
    }
}
