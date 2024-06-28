package gamingclaus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoFrame extends JFrame implements KeyListener,FocusListener{
    JLabel label1;
    JLabel centerinfo;
    JLabel botLabel;
    JPanel topPanel;
    JPanel centerPanel;
    JPanel botPanel;
    JTextArea centertextArea;



    InfoFrame(){
        //Settings up the basics for JFrame
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

        //adding centerpanel to add all the needed info in there
        centerPanel = new JPanel();
        centerinfo = new JLabel();

        centerinfo.setText("Know your Zodiac Sign By Your Birth Month.");
        centerinfo.setFont(new Font("Calibiri",Font.ITALIC,25));
        centertextArea = new JTextArea("1. Aries (March 21-April 19)\r\n" + //
                        "2. Taurus (April 20-May 20)\r\n" + //
                        "3. Gemini (May 21-June 20)\r\n" + //
                        "4. Cancer (June 21-July 22)\r\n" + //
                        "5. Leo (July 23-August 22)\r\n" + //
                        "6. Virgo (August 23-September 22)\r\n" + //
                        "7. Libra (September 23-October 22)\r\n" + //
                        "8. Scorpio (October 23-November 21)\r\n" + //
                        "9. Sagittarius (November 22-December 21)\r\n" + //
                        "10. Capricorn (December 22-January 19)\r\n" + //
                        "11. Aquarius (January 20-February 18)\r\n" + //
                        "12. Pisces (February 19-March 20)");
        centertextArea.setFont(new Font("Calibri",Font.PLAIN,18));
        centertextArea.setForeground(Color.BLACK);
        centertextArea.setEditable(false); //makes the textarea non-editable
        centertextArea.setOpaque(false);//removes the white background in the textarea
        centerPanel.add(centerinfo);
        centerPanel.add(centertextArea);


        botPanel = new JPanel();
        botLabel = new JLabel();

        botLabel.setText("Press Enter Key To Continue......");
        botLabel.setFont(new Font("Calibri",Font.BOLD,15));


        botPanel.add(botLabel);

        this.addFocusListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
        this.add(botPanel,BorderLayout.SOUTH);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);
        this.setVisible(true);
    }
    
    
    
    
    
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        //we dont need any keytyped in this
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            new UserFrame();
            dispose(); //disposes of the current jframe to mve onto the next frame
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
       //we dont need released too
    }



    @Override
    public void focusGained(FocusEvent e) {
        //dont need this in the program
    }


    @Override
    public void focusLost(FocusEvent e) {
        this.requestFocusInWindow(true);
    }
}
