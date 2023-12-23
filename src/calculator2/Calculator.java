package calculator2;

/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 *
 */
public class Calculator
{
    protected CalcEngine engine;
    protected UserInterface gui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator()
    {
        engine = new CalcEngine();
        gui = new UserInterface(engine);
    }
    
    public static void main(String[] args) {
    	Calculator cal = new Calculator();
    	cal.show();
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
