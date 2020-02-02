import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
public class Tour
{
   private static Node head;
   private static Node lastNode;
   private static int sequenceCounter = 0;
   private static double totalDistance = 0.0;
   public Tour()
   {
      head = null;
      lastNode = null;
   }
   public void draw(Point p)
   {
      Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
      Color startColor = colors[(int)(Math.random() * (11 + 1))];
      PennDraw.setPenColor(startColor);
      int linesDrawn = 1;
      for (Node x = head; x != null; x = x.next)
      {
         if (x.next == null)
         {
            PennDraw.setPenColor(startColor);
            x.point.drawTo(head.point);
            break;
         }
         x.point.drawTo(x.next.point);
         linesDrawn++;
         if (linesDrawn == 2)
         {
            PennDraw.setPenColor(colors[(int)(Math.random() * (11 + 1))]);
            linesDrawn -= 2;
         }
      }         
   }
   public int size() 
   {
      return sequenceCounter;
   }
   public double calDistance()
   {
      double totalDist = 0.0;
      Node x = null;
      for (x = head; x != null; x = x.next)
      {
         if (x.next == null)
         {
            break;
         }
         totalDist += x.point.distanceTo(x.next.point);
      }
      if (head == null)
      {
         totalDist = 0.0;
      }
      return totalDist;
   }
   public double distance()
   {
      return totalDistance;
   }
   public static void insertInOrder(Point p)
   {
      if (head == null)
      {
         head = new Node(p);
         lastNode = head;
         totalDistance = 0.0;
      }
      else
      {
         lastNode.next = new Node(p);
         totalDistance += lastNode.point.distanceTo(lastNode.next.point);
         lastNode = lastNode.next;
      }  
      sequenceCounter++;
   }
   public static void insertNearest(Point p)
   {
      Node x = null;
      Node savedX = null;
      double minDist = -1.0;

      for (x = head; x != null; x = x.next)
      {
	      double dist=0.0;
         dist = p.distanceTo(x.point);
 	      if (dist < minDist || minDist < 0.0)
	      {
	         minDist = dist;
	         savedX = x;
	      }
      }
      if (head == null)
      {
         head = new Node(p);
         lastNode = head;
         totalDistance = 0.0;
      }
      //else if (lastNode == savedX)
      //
         //lastNode.next = new Node(p);
         //totalDistance += lastNode.point.distanceTo(lastNode.next.point);
         //lastNode = lastNode.next; 

      //}
      else {
	      Node currNode = null;
	      Node nextNode = null;

	      currNode = savedX;
	      nextNode = savedX.next;

         currNode.next = new Node(p);
         currNode.next.next = nextNode;

	      if (nextNode != null)
	      {
             totalDistance -= currNode.point.distanceTo(nextNode.point);
             totalDistance += currNode.next.point.distanceTo(nextNode.point);
	      }
         totalDistance += currNode.point.distanceTo(currNode.next.point);

         lastNode = nextNode; 
      }
      sequenceCounter++;
   }
   public static void shortestDetour(Point p)
   {
      sequenceCounter++;
   }
   public String toString()
   {
      String str = "";
      if (head == null && lastNode == null)
      {
         str = "";
      }
      else
      {
         for (Node x = head; x != null; x = x.next)
         {
            str += x.item + "\n";
         }
      }
      return str;
   }
   public static void main(String[] args)
   {
      Tour tour = new Tour();
      Point a = new Point(0.0, 0.0);
      Point b = new Point(1.0, 0.0);
      Point c = new Point(1.0, 1.0);
      Point d = new Point(0.0, 1.0);
      tour.insertInOrder(a);
      tour.insertInOrder(b);
      tour.insertInOrder(c);
      tour.insertInOrder(d);
      String points = tour.toString();
      System.out.println(points);
      int num = tour.size();
      System.out.println(num);
      double dist = tour.distance();
      System.out.println(dist);
   }
   
}
