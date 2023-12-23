package triangle;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("The Sierpinski Trangle"); 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        SierpinskiTriangle triangle = new SierpinskiTriangle(1000);
	        frame.add(triangle);
	        frame.pack();
	        frame.setVisible(true);

	        frame.addComponentListener(new ComponentAdapter() {
	            @Override
	            public void componentResized(ComponentEvent e) {
	                // Update the side length based on the minimum dimension
	                Dimension newSize = frame.getContentPane().getSize();
	                int minSize = Math.min(newSize.width, newSize.height);
	                triangle.setLength(minSize);
	                triangle.setPreferredSize(new Dimension(minSize, minSize));
	                triangle.repaint();
	            }
	        });	
	   }

}