class Sierpinski 
{
   public static void main(String[] args)
   {
      double numLevels = Integer.parseInt(args[0]);
      triangle(0.5, 0.5, Math.sqrt(3)/2);
      sierpinski(numLevels, 0.5, Math.sqrt(3)/2, 0.5);
   }
   public static void triangle(double side, double vertexX, double vertexY)
   {
      PennDraw.filledPolygon(vertexX, vertexY, vertexX - (side/2), vertexY - ((Math.sqrt(3)/2)*side), vertexX + (side/2), vertexY - ((Math.sqrt(3)/2)*side));
   }
   public static void sierpinski(double numLevels, double x, double y, double size)
   {
      if(numLevels < 1) return;
      triangle(size, x, y);
      numLevels -= 1;
      size /= 2;
      sierpinski(numLevels, x - ((size*2)/2), y, size);
      sierpinski(numLevels, x, y - ((Math.sqrt(3)/2)*(size*2)), size);
      sierpinski(numLevels, x + ((size*2)/2), y, size);
   }
}