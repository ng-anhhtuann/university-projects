package Move;

public class TestMove {
	public static void main(String[] args) {
		Movable m1 = new MovablePoint(5, 6, 10, 15);
	    System.out.println(m1);
	    
	    m1.moveLeft();
	    System.out.println("___________________AFTER MOVE LEFT");
	    System.out.println(m1);
	    
	    System.out.println();
	    Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
	    System.out.println(m2);
	    
	    m2.moveRight();
	    System.out.println("___________________AFTER MOVE RIGHT");
	    System.out.println(m2);
		
	}
}
