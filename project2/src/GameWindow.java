
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class GameWindow implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_Panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfeild = new JLabel();
    JButton buttons[] = new JButton[9];
    boolean player1_turn;
     

    GameWindow()
    {     // initialize the game look over view and font
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(800, 800);  // width of the game
           frame.getContentPane().setBackground(Color.DARK_GRAY);   // defines the background
           frame.setLayout(new BorderLayout());
           frame.setVisible(true);  // makes the vissibility true

           // define the title of the game
           textfeild.setBackground(Color.white);
           textfeild.setForeground(Color.BLUE);
           textfeild.setFont(new Font("Times new Roman",Font.BOLD , 75)); // set font
           textfeild.setHorizontalAlignment(JLabel.CENTER);  //align it to centre of sreen
           textfeild.setText("X O game");  // display title of the game
           textfeild.setOpaque(true);


         // define buttons in the panel for the xo game
           title_Panel.setLayout(new BorderLayout());
           title_Panel.setBounds(0, 0, 800, 100);
              // define the position to display the title
              
              
              // set buttons
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150, 150, 150));
           for(int i = 0 ; i < 9 ; i ++)
           {  
              buttons[i] = new JButton();
              button_panel.add(buttons[i]);
              buttons[i].setFont(new Font("Mv Boli",Font.BOLD,120));
              buttons[i].setFocusable(false);
              // add actionlistener
              buttons[i].addActionListener(this);
           }
        
        // add title to your overall frame
           title_Panel.add(textfeild);
           frame.add(title_Panel,BorderLayout.NORTH);
           // add button panel
           frame.add(button_panel);

           // start the game
           firstTurn();

    }
    public void firstTurn()
    {    

        // if still not started assign value randomly
        if(random.nextInt(2)==0)
          {
            player1_turn=true;
            textfeild.setText("X TURN");
          }
          else{
              player1_turn = false;
              textfeild.setText("O turn");
          }

    }
    // check the wins of the player every time
    public  void check()
    {
          if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
          {
            xWins(0,1, 2);
          }
          if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
          {
            xWins(3,4, 5);
          }
          if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
          {
            xWins(6,7,8);
          }
          if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
          {
            xWins(0,3,6);
          }
          if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
          {
            xWins(1,4,7);
          }
          if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
          {
            xWins(2,5,8);
          }
          if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
          {
            xWins(0,4,8);
          }
          if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
          {
            xWins(2,4,6);
          }



          // check winning combination for O
          if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
          {
            oWins(0,1, 2);
          }
          if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
          {
            oWins(3,4, 5);
          }
          if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
          {
            oWins(6,7,8);
          }
          if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
          {
            oWins(0,3,6);
          }
          if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
          {
            oWins(1,4,7);
          }
          if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
          }
          if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
          {
            oWins(0,4,8);
          }
          if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O"))
          {
            oWins(2,4,6);
          }

    }
    public void xWins(int a , int b , int c)
    {
         buttons[a].setBackground(Color.green);
         buttons[b].setBackground(Color.green);
         buttons[c].setBackground(Color.green);
         for(int i = 0 ; i <9 ; i ++)
         {
            buttons[i].setEnabled(false);
         }
         textfeild.setText("X wins");
    }
    public void oWins(int a , int b , int c)
    {
       buttons[a].setBackground(Color.green);
         buttons[b].setBackground(Color.green);
         buttons[c].setBackground(Color.green);
         for(int i = 0 ; i <9 ; i ++)
         {
            buttons[i].setEnabled(false);
         }
         textfeild.setText("O wins");   
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {   // check for all buttons
        for(int i = 0 ; i < 9 ; i ++)
        {   // if any of the button is pressed
            if(e.getSource()==buttons[i])
            {   // check whose turn it is and assign 
                if(player1_turn)
                {   // if no text already present set the text
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                         player1_turn = false;
                    textfeild.setText("O turn");
                    check();
                    }
                }
                else{
                   if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                         player1_turn = true;
                    textfeild.setText("X turn");
                    check();
                    }

                }
            }
        }

    }
   
}