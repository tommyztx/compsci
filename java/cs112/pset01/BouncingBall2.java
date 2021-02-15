/*********************************************
 * Bouncing Ball
 * Author:  Eric Eaton, Benedict Brown
 * 
 * Description:
 * Simulates two balls bouncing off the walls
 * and floor with acceleration due to gravity
 * 
 * Compilation:  javac BouncingBall2.java
 * Execution:    java BouncingBall2
 * 
 * Program Arguments:  none
 * 
 *********************************************/

public class BouncingBall2 {
   public static void main(String[] args) {
      // setup the window
      PennDraw.setXscale(0, 100);
      PennDraw.setYscale(0, 100);
    
      // set up the balls' initial parameters
      double x0 = 100 * Math.random();          // random x from 0 to 100
      double x1 = 100 * Math.random();          // random x from 0 to 100
      double y0 = 50 + 50 * Math.random();      // y from 50 to 100
      double y1 = 50 + 50 * Math.random();      // y from 50 to 100
      double ballRadius = 2;
      double dx0 = Math.random();               // dx from 0 and 1
      double dx1 = Math.random();               // dx from 0 and 1
      double dy0 = .5 + .5 * Math.random();     // dy from .5 and 1
      double dy1 = .5 + .5 * Math.random();     // dy from .5 and 1
      double accel0 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
      double accel1 = .05 + .3 * Math.random(); // accel from 0.05 and 0.35
    
      PennDraw.enableAnimation(30);
      while (true) {
         PennDraw.clear(PennDraw.WHITE);
         PennDraw.setPenColor(PennDraw.RED);
         PennDraw.filledCircle(x0, y0, ballRadius);
         PennDraw.filledCircle(x1, y1, ballRadius);
         PennDraw.setPenColor(PennDraw.BLACK);
         PennDraw.square(50,50,50);
       
         // simulate motion
         x0 = x0 + dx0;
         x1 = x1 + dx1;
         y0 = y0 - dy0;
         y1 = y1 - dy1;
         dy0 = dy0 + accel0;
         dy1 = dy1 + accel1;
      
         // bounce off floor
         if (y0 <= ballRadius) { dy0 = -0.9 * dy0; }
         if (y1 <= ballRadius) { dy1 = -0.9 * dy1; }
      
         // bounce off walls
         if (x0 <= ballRadius || x0 >= (100 - ballRadius) ) { dx0 = -dx0; }
         if (x1 <= ballRadius || x1 >= (100 - ballRadius) ) { dx1 = -dx1; }
      
         // animate
         PennDraw.advance();
      }
   }
}