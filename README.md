# Java Screen Saver Application

This repository contains a Java-based screen saver application. The program creates a dynamic display of moving shapes, demonstrating the use of Java Swing, graphics, and action listeners.

## Features

- A GUI application that randomly generates shapes on a panel.
- Shapes include both ovals and rectangles, each with random sizes and colors.
- Shapes bounce off the edges of the window and move in different directions based on their size.
- A timer is used to control the animation speed.

## Components

- `ScreenSaver.java`: The main class that sets up the GUI and controls the animation.
- `Shape.java`: A class that defines the properties and behaviors of the shapes.
- `drawingPanel`: A nested class within `ScreenSaver` for drawing shapes.

## Setup and Execution

1. **Clone or Download**
   Download the `ScreenSaver.java` and `Shape.java` files or clone this repository to your local machine.

2. **Compile the Program**
   Navigate to the directory containing the Java files. Compile the files using the Java compiler:
   ```bash
   javac ScreenSaver.java Shape.java
