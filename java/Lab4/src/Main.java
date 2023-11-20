public class Main {
	public static void main(String[] args) {
//		Movable m1 = new MovablePoint(5, 6, 10, 15);
//	    System.out.println(m1);
//	    
//	    m1.moveLeft();
//	    System.out.println(m1);
//	    
//	    Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
//	    System.out.println(m2);
//	    
//	    m2.moveRight();
//	    System.out.println(m2);
		
		Circle circle = new Circle(5.0);
        System.out.println("Circle - Radius: " + circle.radius);
        System.out.println("Circle - Perimeter: " + circle.getPerimeter());
        System.out.println("Circle - Area: " + circle.getArea());

        // Creating a ResizableCircle object and testing the resizing functionality
        ResizeableCircle resizableCircle = new ResizeableCircle(7.0);
        System.out.println("\nResizableCircle - Radius before resizing: " + resizableCircle.radius);
        
        int resizePercent = 50; // Example resize percentage
        double resizedRadius = resizableCircle.resize(resizePercent);
        System.out.println("ResizableCircle - Radius after resizing by " + resizePercent + "%: " + resizedRadius);

        // Performing geometric calculations on the resized circle
        System.out.println("ResizableCircle - Perimeter: " + resizableCircle.getPerimeter());
        System.out.println("ResizableCircle - Area: " + resizableCircle.getArea());
	}
}
