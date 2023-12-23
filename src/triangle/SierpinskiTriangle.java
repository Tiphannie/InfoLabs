package triangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SierpinskiTriangle extends JPanel {
	private static final long serialVersionUID  = 1L ; 
	private int length; //LENGTH of each of the side of the triangle 
	private Color[] colors = { Color.RED, Color.BLACK, Color.BLUE, Color.GREEN, Color.YELLOW, Color.LIGHT_GRAY}; 
	
	//constructor 
	public SierpinskiTriangle (int length) {
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
	    int[] xPoints = {x, x - length / 2, x + length / 2};
	    int[] yPoints = {y - triangleHeight / 2, y + triangleHeight / 2, y + triangleHeight / 2};
	    g.setColor(Color.cyan);
	    g.fillPolygon(xPoints, yPoints,3);
	    
	    // Draw the recursively generated triangles with different colors 
	   recursiveTriangles(g, 6, xPoints, yPoints, 0);
	   
	   
	}

	private void recursiveTriangles(Graphics g, int depth, int[] xPoints, int[] yPoints, int level) {
	    if (depth == 0) {
	        return; // Termination condition for recursion
	    }

	    //divide the triangle into smaller triangles
	    
	    
	    //calculates the middle points of the sides
	    int midX1 = (xPoints[0] + xPoints[1]) / 2;
	    int midY1 = (yPoints[0] + yPoints[1]) / 2;
	    int midX2 = (xPoints[1] + xPoints[2]) / 2;
	    int midY2 = (yPoints[1] + yPoints[2]) / 2;
	    int midX3 = (xPoints[2] + xPoints[0]) / 2;
	    int midY3 = (yPoints[2] + yPoints[0]) / 2;

	    // calculates the coordinates of the triangles connecting the midpoints
	    int[] xPoints1 = {xPoints[0], midX1, midX3};
	    int[] yPoints1 = {yPoints[0], midY1, midY3};
	    int[] xPoints2 = {midX1, xPoints[1], midX2};
	    int[] yPoints2 = {midY1, yPoints[1], midY2};
	    int[] xPoints3 = {midX3, midX2, xPoints[2]};
	    int[] yPoints3 = {midY3, midY2, yPoints[2]};
	    
	    //set the color based on the level
	    g.setColor(colors[level % colors.length]); 

	    // draw the triangles connecting the midpoints
	   // g.drawPolygon(xPoints1, yPoints1, 3);
	    //g.drawPolygon(xPoints2, yPoints2, 3);
	    //g.drawPolygon(xPoints3, yPoints3, 3);
	  
	    // fill the triangles connecting the midpoints
	    g.fillPolygon(xPoints1, yPoints1, 3);
	    g.fillPolygon(xPoints2, yPoints2, 3);
	    g.fillPolygon(xPoints3, yPoints3, 3);

	  //recursively draws its self with smaller triangles with the next color
	    recursiveTriangles(g, depth - 1, xPoints1, yPoints1, level + 1);
	    recursiveTriangles(g, depth - 1, xPoints2, yPoints2, level + 1);
	    recursiveTriangles(g, depth - 1, xPoints3, yPoints3, level + 1);
	}

}