// TODO - make file header
public class Race {    
    public static void main(String[] args) {
        boolean yaleWins = false;       // has Yale won the race?
        boolean harvardWins = false;    // has Harvard won the race?
        
              
        // the width of 1 pixel in window coordinates,
        // assuming you do NOT call PennDraw.setXscale()
        double ONE_PIXEL = 1.0 / 512;  

        // TODO - define any variables you need here
        double xYale = 0.2;
        double xHarvard = 0.2;
        String win = "Yale";
        // TODO - set the pennant locations before the starting line

        // enable animation at 10 frames/second
        // TODO - you may change the frame rate to be any speed you like
        PennDraw.enableAnimation(10);

        while (!yaleWins && !harvardWins) {
            /* TODO the following
            * 1. clear the screen
            * 2. draw the Yale and Harvard pennants
            * 3. draw the start line
            * 4. draw the finish line
            * 5. based on current positions, determine if anyone has won. 
            * 6. determine whether the Yale pennant position changes 
            * 7. determine whether the Harvard pennant position changes 
            */
            PennDraw.clear();
            PennDraw.picture(xYale,0.8, "yale.gif");
            PennDraw.picture(xHarvard,0.2, "harvard.gif");
            PennDraw.line(0.2,0,0.2,1);
            PennDraw.line(0.9,0,0.9,1);
            if ( xYale >= 0.9 )
            { 
               win = "Yale";
               yaleWins = true;
            }
            else if ( xHarvard >= 0.9 )
            {
               win = "Harvard";
               harvardWins = true;
            }
            else
            {
               if ( diceRoll(.505) ) xYale += ONE_PIXEL;
               if ( diceRoll(.5) ) xHarvard += ONE_PIXEL;
            }
            
            
            PennDraw.advance(); // show this frame and go on to the next one
        }
        
        PennDraw.disableAnimation(); // the race is over so turn off animation
        // TODO - draw text containing a victory message in the sketch
        String winner = win + " Wins! ";
        PennDraw.setFontBold();
        PennDraw.setFontSize(42.0);
        PennDraw.setPenColor(PennDraw.BLUE);
        PennDraw.text(0.5,0.5,winner);
    }
    public static boolean diceRoll(double probability)
    {
         double num = Math.random();
         num = (num * probability) / 0.5;
         if (num > 0.5)
            return true;
         return false;
    }
}