/*********************************************
 * Bouncing Ball
 * Author:  Eric Eaton, Benedict Brown
 * 
 * Description:
 * Simulates a ball bouncing off the walls
 * and floor with acceleration due to gravity
 * 
 * Compilation:  javac BouncingBall.java
 * Execution:    java BouncingBall
 * 
 * Program Arguments:  none
 * 
 *********************************************/

public class BouncingBall1 {
   public static void main(String[] args) {
      // setup the window
      PennDraw.setXscale(0, 100);
      PennDraw.setYscale(0, 100);
    
      // set up the balls' initial parameters
      double x0 = 100 * Math.random();          // random x from 0 to 100
      double y0 = 50 + 50 * Math.random();      // y from 50 to 100
      double ballRadius = 2;
      double dx0 = Math.random();               // dx from 0 and 1
      double dy0 = .25 + .25 * Math.random();     // dy from .5 and 1
      double accel0 = .025 + .15 * Math.random(); // accel from 0.05 and 0.35
    
      PennDraw.enableAnimation(60);
      while (true) {
         PennDraw.clear(PennDraw.WHITE);
         PennDraw.setPenColor(PennDraw.RED);
         PennDraw.filledCircle(x0, y0, ballRadius);
         PennDraw.setPenColor(PennDraw.BLACK);
         PennDraw.square(50, 50, 50);
       
         // simulate motion
         x0 = x0 + dx0;
         y0 = y0 - dy0;
         dy0 = dy0 + accel0;
      
         // bounce off floor
         if (y0 <= ballRadius) { dy0 = -0.9 * dy0; }
      
         // bounce off walls
         if (x0 <= ballRadius || x0 >= (100 - ballRadius) ) { dx0 = -dx0; }
      
         // animate
         PennDraw.advance();
      }
   }
}