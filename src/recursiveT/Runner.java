package recursiveT;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sierpinski triangle = new Sierpinski(1000);
        frame.add(triangle);
        frame.pack();
        frame.setVisible(true);
        
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newSize = frame.getContentPane().getSize();
                int minSize = Math.min(newSize.width, newSize.height);
                triangle.setSideLength(minSize);
                triangle.setPreferredSize(new Dimension(minSize, minSize));
                triangle.repaint();
            }
        });
    }
}
