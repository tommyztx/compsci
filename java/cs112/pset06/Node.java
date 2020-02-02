public class Node
{
   public String item;
   public Node next;
   public Point point;
   public Node()
   {
      this.item = "";
      this.next = null;
      this.point = null;
   }
   public Node(Point p)
   {
      this.item = p.toString();
      this.next = null;
      this.point = p;
   }
   public Node(Node n, Point p)
   {
      this.item = p.toString();
      this.next = n; 
      this.point = p;  
   }
   public static void main(String[] args)
   {
      Point firs = new Point(5.0, 8.0);
      Node first = new Node(firs);
      
   }
}