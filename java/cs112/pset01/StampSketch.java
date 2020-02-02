/*
 * TODO - make header
 * 
 */
public class StampSketch {
    public static void main(String[] args) {
        // is this the first time through the animation loop?
        boolean firstTime = true;

        while (firstTime) {
            // redraw background both when it's the first time through loop and
            // when a key is pressed
            if (PennDraw.hasNextKeyTyped()) {
                // TODO - draw a random background/
                // some aspect of the background must involve a loop.
                drawBackGround();
                PennDraw.nextKeyTyped();
            }
        
            // if the mouse is clicked
            if (PennDraw.mousePressed()) {
                // get the coordinates of the mouse cursor
                double x = PennDraw.mouseX();
                double y = PennDraw.mouseY();
        
                // TODO - check which region the mouse click was in
                // draw a scaled shape
                PennDraw.setPenColor(200, 170, 0);
                if (y <= 1.0 && y > 0.8)
                {
                    PennDraw.filledSquare(x, y, .06);
                }
                else if (y <= 0.8 && y > 0.6)
                {
                    PennDraw.filledSquare(x, y, .02);
                }
                else if (y <= 0.6 && y > 0.4)
                {
                    PennDraw.square(x, y, .02, 90);
                }
                else if (y <= 0.4 && y > 0.2)
                {
                    PennDraw.square(x, y, .06, 90);
                }
                else
                {
                    PennDraw.square(x, y, .1, 90);
                }
            }
        }
    }
    public static void drawBackGround()
    {
         PennDraw.clear(PennDraw.BLACK);
         PennDraw.setPenColor(0,0,170);
         PennDraw.filledRectangle(0.5, 0.30, 0.6, 0.3);
         PennDraw.setPenColor(PennDraw.WHITE);
         int i =  (int)(Math.random() * 10);
         for ( int k = 0; k < i; k++)
         {
            double ynum = Math.random();
            double xnum = Math.random();
            while (ynum >= 0.54)
               ynum = Math.random();
            double rnum = Math.random();
            while (rnum > .06)
            {
               rnum = Math.random();
            }
            PennDraw.arc(xnum, ynum, rnum, 0, 180); 
         }
    }
}