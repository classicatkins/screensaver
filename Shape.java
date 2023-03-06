//Resourced: https://www.daniweb.com/programming/software-development/threads/435387/changing-size-of-shape-over-time
// Resourced: https://stackoverflow.com/questions/65255851/how-to-make-shapes-be-random-colors-in-java

import java.awt.*;
import javax.swing.*;
import java.util.Random;

//The Shape class contains the data and methods for creating and moving the shapes.
public class Shape 
{
  // the x-coordinate of the top-left corner of the shape
  int x;
  //the y-coordinate of the top-left corner of the shape
  int y;
  int width;
  int height;
  //the amount to move the shape horizontally each time step
  int moveX = 1;
  //the amount to move the shape vertically each time step
  int moveY = 1;
  // a Graphics2D object used for drawing the shape
  private Graphics2D g;
  //a Random object used for generating random values for the shape's color and size
  Random random = new Random();

//Initializes the shape's size and position randomly.
  public Shape() 
  {
    Random random = new Random();
    width = random.nextInt (21) + 10;
    height = width;
    x = random.nextInt (600 - width);
    y = random.nextInt (600 - height);
  }

  //randomly generates color for shape by picking a random value for each RGB value
    Color getColor()
  {
      return new Color(random.nextFloat(),random.nextFloat(),random.nextFloat());
  }

  //Returns a random integer within a specified range.
  public int randomRange (int low, int high) 
  {
    Random Random = new Random();
    return Random.nextInt (high - low + 1) + low;
  }

  //Updates the shape's position and direction of movement. 
  //If the shape hits the edge of the screen, it bounces off. 
  //If the shape is tall (i.e. its height is greater than 20), 
  //it moves up and down; otherwise, it moves left and right.
  // moves shape by 1 both right and down
  public void move() 
  {
    x += moveX;
    y += moveY;

    if (x <= 0 || x >= 600 - width) 
    {
      moveX = moveX * -1;
    }
    if (y <= 0 || y >= 600 - height) 
    {
      moveY = moveY * -1;
    }

    //shapes that measure more than 15 move up/down
    if (height > 20) 
    {
      y += moveY;
    } 
    //all other shapes move sidways
    else 
    {
      x += moveX;
    }
  }
   
  //Draws the shape on a graphics object using the getColor method to set its color.
  public void display (Graphics g) 
  {
    //pulls from getColor method and sets the oval that color
    g.setColor(getColor());
    //draws/fills the oval
    g.drawOval(x, y, width, height);
    g.fillOval (x, y, width, height);
  }

  //same thing as display but with rectangles
  public void display2 (Graphics g) 
  {
    g.setColor(getColor());
    g.drawRect(x, y, width, height);
    g.fillRect(x, y, width, height);
  }
}