import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
public class Tour
{
   private static Node head;
   private static Node lastNode;
   private static int sequenceCounter = 0;
   private static double totalDistance = 0.0;
   private static double lastDelta = 0.0;
   public Tour()
   {
      head = null;
      lastNode = null;
   }
   public void draw(Point p)
   {
      //Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
      //Color startColor = colors[(int)(Math.random() * (11 + 1))];
      Color startColor = Color.BLACK;
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
         //if (linesDrawn == 2)
         //{
         //   PennDraw.setPenColor(colors[(int)(Math.random() * (11 + 1))]);
         //   linesDrawn -= 2;
         //}
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
            totalDist += x.point.distanceTo(head.point);
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
         lastDelta = 0.0;
      }
      else
      {
         // lastDelta keeps track of last distance from the last node back to the head
         lastNode.next = new Node(p);

         // before updating the total distance with the last node to the new node, roll
         //     back the lastDelta first from the total distance
         totalDistance -= lastDelta;

         // update total distance with the new distance to the new node
         totalDistance += lastNode.point.distanceTo(lastNode.next.point);

         // move lastNode pointer to the new node
         lastNode = lastNode.next;

         // calculate the new lastDelta with the distance from the new last node back to head
         lastDelta = lastNode.point.distanceTo(head.point);

         // update the totalDistance with new lastDelta
         totalDistance += lastDelta;
      }  
      sequenceCounter++;
   }
   public static void insertNearest(Point p)
   {
      Node x = null;
      Node savedX = null;
      double minDist = -1.0;
      //find the Node with the point that p is closest to
      //
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
      //For an empty list
      //
      if (head == null)
      {
         head = new Node(p);
         lastNode = head;
         lastDelta = 0.0;
      }
      else {
         //create the node after savedX
	      Node currNode = null;
	      Node nextNode = null;

	      currNode = savedX;
	      nextNode = savedX.next;

          currNode.next = new Node(p);
          currNode.next.next = nextNode;
          //track distance
          //
          totalDistance -= lastDelta;

	      if (nextNode != null)
	      {
             totalDistance -= currNode.point.distanceTo(nextNode.point);
             totalDistance += currNode.next.point.distanceTo(nextNode.point);
	      }
         if (nextNode == null)
         {
            lastNode = currNode.next;
         }
          totalDistance += currNode.point.distanceTo(currNode.next.point);
          lastDelta = lastNode.point.distanceTo(head.point);
          totalDistance += lastDelta;
      }
      sequenceCounter++;
   }
   public static void shortestDetour(Point p)
   {
      double lastMiniDist = -1.0;
      Node lastMiniNode = null;
      Node x = null;
      double distVal = 0.0;
      //Make sure an empty list will become a new Node
      //
      if (head == null)
      {
         head = new Node(new Node(p), p);
         lastNode = head;
         totalDistance = 0.0;
         lastDelta = 0.0;
         lastMiniNode = head;
         lastMiniDist = -1.0;
      }
      else
      {
         //calculate the spot where p would cause the least change in the incremental distance
         //
         for (x = head; x != null; x = x.next)
         {
            if (x.next != null)
            {
               distVal = (x.point.distanceTo(p) + p.distanceTo(x.next.point)) - x.point.distanceTo(x.next.point);
            }
            else
            {
               distVal = (x.point.distanceTo(p) + p.distanceTo(head.point)) - x.point.distanceTo(head.point);
            }
            if (lastMiniDist < 0.0 || distVal < lastMiniDist) 
            {
               lastMiniDist = distVal;
               lastMiniNode = x;
            }
         }
      
         // insert new node after lastMiniNode
         //
         x  = lastMiniNode;
         Node nextNode = lastMiniNode.next;
         x.next = new Node(nextNode, p);
         //tracks distance
         //
         totalDistance -= lastDelta;
         if (nextNode != null)
         {
            totalDistance -= x.point.distanceTo(nextNode.point);
            totalDistance += x.next.point.distanceTo(nextNode.point);
         }
         if (nextNode == null)
         {
            lastNode = x.next;
         }
         totalDistance += x.point.distanceTo(x.next.point);
         lastDelta = lastNode.point.distanceTo(head.point);
         totalDistance += lastDelta;         
      }
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
      //System.out.println(points);
      int num = tour.size();
      //System.out.println(num);
      double dist = tour.distance();
      //System.out.println(dist);
   }
   
}
