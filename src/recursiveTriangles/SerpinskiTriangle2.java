package recursiveTriangles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SerpinskiTriangle2 extends JPanel {
	private static final long serialVersionUID  = 1L ; 
	private int length; //LENGTH of each of the side of the triangle 
	
	//constructor 
	public SerpinskiTriangle2(int length) {
		this.length = length; 
		setPreferredSize(new Dimension(length, length)); //sets the preferred size of the Panel 
	}
	
	

	public void setLength(int length) {
		this.length = length; 
		setPreferredSize(new Dimension(length, length));
		repaint(); 
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        //center (x,y) of the panel 
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        
        //triangle height is calculated
        int triangleHeight = (int) (length * Math.sqrt(3) / 2);
        
        //main triangles vertices coordinates are calculated 
        int[] xPoints = { x, x - length / 2, x + length / 2 };
        int[] yPoints = { y - triangleHeight / 2, y + triangleHeight / 2, y + triangleHeight / 2 };

        //method to recursively draw the serpinski triangle 
        recursiveTriangles(g, 6, x, y - triangleHeight / 2, x - length / 2, y + triangleHeight / 2,
                x + length / 2, y + triangleHeight / 2);

      //draw the equilateral triangle 
       g.drawPolygon(xPoints, yPoints, 3);
        
        
    }

	
	
	private void recursiveTriangles(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
		if (depth == 0) { //draws the triangle by connecting the given points 
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x3, y3);
            g.drawLine(x3, y3, x1, y1);
        } else { //divide the triangle into smaller triangles
        	
        	//calculates the middle points of the sides 
            int midX1 = (x1 + x2) / 2;
            int midY1 = (y1 + y2) / 2;
            int midX2 = (x2 + x3) / 2;
            int midY2 = (y2 + y3) / 2;
            int midX3 = (x3 + x1) / 2;
            int midY3 = (y3 + y1) / 2;

            //recursively draws its self with smaller triangles
            recursiveTriangles(g, depth - 1, x1, y1, midX1, midY1, midX3, midY3);
            recursiveTriangles(g, depth - 1, midX1, midY1, x2, y2, midX2, midY2);
            recursiveTriangles(g, depth - 1, midX3, midY3, midX2, midY2, x3, y3);
            
    
        }
		
		
	}



}
