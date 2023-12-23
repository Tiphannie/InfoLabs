package recursiveT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Sierpinski extends JPanel {
	private static final long serialVersionUID = 1L;
	// length of each side of the triangle
	protected int sideLength;

	public Sierpinski(int sideLength) {
		this.sideLength = sideLength;
		setPreferredSize(new Dimension(sideLength, sideLength));
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Center of the frame and the position of the triangle
		int x = getWidth() / 2;
		int y = getHeight() / 2;
		// Height of the triangle
		int triangleHeight = (int) (sideLength * Math.sqrt(3) / 2);
		// Draw the main triangle
		// x is for the center of the triangle, x - sideLength / 2 is for the left point
		// and x + sideLength / 2 is for the right point
		int[] xpoints1 = { x, x - sideLength / 2, x + sideLength / 2 };
		// y - triangleHeight / 2 is the tip/north Point, y + triangleHeight / 2 for the
		// right and left corner,
		// 2, y + triangleHeight / 2 center of the triangle
		int[] ypoints1 = { y - triangleHeight / 2, y + triangleHeight / 2, y + triangleHeight / 2 };
		// for exercise 1-->
//        g.drawPolygon(xpoints1, ypoints1, 3);

		recursiveTriangles(g, 6, x, y - triangleHeight / 2, x - sideLength / 2, y + triangleHeight / 2,
				x + sideLength / 2, y + triangleHeight / 2);
//        g.setColor(Color.green);
//        g.fillPolygon(xpoints1, ypoints1, 3);
	}

	public void recursiveTriangles(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
		if (depth == 0) {
			// is drawing the lines between the points of x1,x2,x3 and y1,y2,y3
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x2, y2, x3, y3);
			g.drawLine(x3, y3, x1, y1);
		} else {
			// if depth is not 0 then it is divided
			// the middle points of the are calculated
			int midX1 = (x1 + x2) / 2;
			int midY1 = (y1 + y2) / 2;
			int midX2 = (x2 + x3) / 2;
			int midY2 = (y2 + y3) / 2;
			int midX3 = (x3 + x1) / 2;
			int midY3 = (y3 + y1) / 2;

			// for recursive--> the first triangle gets divided
			recursiveTriangles(g, depth - 1, x1, y1, midX1, midY1, midX3, midY3);
			// the second triangle gets divided
			recursiveTriangles(g, depth - 1, midX1, midY1, x2, y2, midX2, midY2);
			// the third triangle gets divided
			recursiveTriangles(g, depth - 1, midX3, midY3, midX2, midY2, x3, y3);

			Color triangleColor = getColorForDepth(depth);
			g.setColor(triangleColor);
			g.fillPolygon(new int[] { midX1, midX2, midX3 }, new int[] { midY1, midY2, midY3 }, 3);

		}
	}

	private Color getColorForDepth(int depth) {
		// Definiere eine Farbpalette für die verschiedenen Tiefen
		Color[] colors = { Color.black, Color.cyan, Color.blue, Color.lightGray, Color.gray, Color.darkGray };
		// Wiederhole die Farbpalette, falls die Tiefe größer ist als die Anzahl der
		// definierten Farben
		Color color = colors[depth % colors.length];
		return color;

	}
}

//@Override
//protected void paintComponent(Graphics g) {
//	super.paintComponent(g);
//
//	// Center of the frame and the position of the triangle
//	int x = getWidth() / 2;
//	int y = getHeight() / 2;
//	// Height of the triangle
//	int triangleHeight = (int) (sideLength * Math.sqrt(3) / 2);
//
//	// Draw the main triangle
//	int[] xpoints1 = { x, x - sideLength / 2, x + sideLength / 2 };
//	int[] ypoints1 = { y - triangleHeight / 2, y + triangleHeight / 2, y + triangleHeight / 2 };
//	g.drawPolygon(xpoints1, ypoints1, 3);
//
////    // Zweites Dreieck
////    int[] xpoints2 = {250, 200, 300 };
////    int[] ypoints2 = {337, 250, 250};	   
////    g.drawPolygon(xpoints2, ypoints2, 3);
//	
//	 recursive(g, 4, x - sideLength / 2, y + triangleHeight / 2, x + sideLength / 2, y + triangleHeight / 2);
//}

//Color triangleColor = getColorForDepth(depth);
//g.setColor(triangleColor);
//g.fillPolygon(new int[]{midX1, midX2, midX3}, new int[]{midY1, midY2, midY3}, 3);
//  
//}
//}  
//
//private Color getColorForDepth(int depth) {
//// Definiere eine Farbpalette für die verschiedenen Tiefen
//Color[] colors = {Color.blue, Color.cyan, Color.blue, Color.cyan, Color.blue, Color.cyan};
//// Wiederhole die Farbpalette, falls die Tiefe größer ist als die Anzahl der definierten Farben
//Color color = colors[depth % colors.length];
//return color;
//
//}