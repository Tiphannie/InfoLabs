package finalcalculatorversion;


public class HexCalculator {
	
	public HexCalcEngine hexEngine;
//	public CalcEngine engine;

	public HexUserInterface gui;

	public HexCalculator()
    {
        hexEngine = new HexCalcEngine();
//        engine = new CalcEngine();
        gui = new HexUserInterface(hexEngine);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexCalculator cal = new HexCalculator();
    	cal.show();
    }
	
	
	public void show()
    {
        gui.setVisible(true);
    }

}
