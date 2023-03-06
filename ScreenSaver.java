//Resources in shape class

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// The ScreenSaver class sets up the GUI and controls the animation.


public class ScreenSaver extends JPanel 
{
  //a DefaultListModel used to display information about the program's operation
    static DefaultListModel<String> l1 = new DefaultListModel<>();
    //: a JList that displays the contents of l1
    JList<String> list1 = new JList<>(l1);
    //the JFrame used to display the program
    JFrame frame = new JFrame();
    //the number of shapes currently on the screen
    int count;
    //a Timer object used to control the animation
    Timer timer;
    //an array of Shape objects representing the shapes currently on the screen
    Shape[] shapes = new Shape[20];

//Sets up the GUI and initializes the timer.
    public ScreenSaver() 
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(list1);
        drawingPanel drawPanel = new drawingPanel();
        add(drawPanel);
       
        timer = new Timer(20, new ActionListener() 
        {
          public void actionPerformed(ActionEvent ae) 
          {
            for (int i = 1; i < shapes.length; i++) 
            {
              if (shapes[i] != null) 
              {
                  shapes[i].move();
              }
              repaint();
            }
          }
        });
      }
    //main method
    //Creates a new instance of the ScreenSaver class and adds 20 shapes to the screen.
    public static void main(String[] args) 
    {
      //cretes frame
      JFrame frame = new JFrame ();
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  
      //creates screensaver
      ScreenSaver screensaver = new ScreenSaver();
      frame.getContentPane().add (screensaver);

      for (int i = 0; i < 20; i++) 
      {
        screensaver.addShape(i);
      }
      screensaver.start();
      frame.pack();
      frame.setVisible(true);
    }

    //adds a new shape if the amount of shapes on screensaver is less than shapes.length
    public  void addShape(int i) 
    {
      if (count < shapes.length) 
      {
        shapes[i] = new Shape();
      }
    }
//Starts the animation timer.
    public  void start() 
    {
      timer.start();    
    }

   //A nested JPanel class used for drawing the shapes on the screen 
  private class drawingPanel extends JPanel 
  {
    public drawingPanel() 
    {
      setPreferredSize (new Dimension(600, 600));
      setBackground (Color.blue);
    }

    //Overrides the paintComponent method of JPanel and 
    //calls the display method of each shape to draw it on the screen. 
    //The method alternates between using the display and display2 
    //methods of the Shape class to draw the shapes as ovals and rectangles, respectively.
    public void paintComponent (Graphics g) 
    {
      super.paintComponent(g);
      for (int i = 0; i < shapes.length; i++) 
      {
        if (shapes[i] != null) 
        {
          if(i % 2 == 0)
          shapes[i].display(g);
          else 
          {
          shapes[i].display2(g);
          }
        }
      }
    }
  }
}