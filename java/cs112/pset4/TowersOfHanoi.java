public class TowersOfHanoi 
{
   public static void moves(int n, String side) 
   {
      if (n == 0) return;
      moves(n-1, "right");
      if (side.equals("left")) System.out.println(n + " left");
      else System.out.println(n + " right");
      moves(n-1, "right");
   }
   public static void main(String[] args) 
   {
      int N = Integer.parseInt(args[0]);
      moves(N, "left");
   }
}