package finalcalculatorversion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcEngineTestPrecedence {
	
	@Test 
	public void testPrecedence1() {
		  CalcEngine calcEngine = new CalcEngine();
	        calcEngine.numberPressed(2);
	        calcEngine.multiply();
	        calcEngine.numberPressed(3);
	        calcEngine.plus();
	        calcEngine.numberPressed(4);
	        calcEngine.equals();
	        assertEquals("10", calcEngine.getDisplayValue()); // (2 * 3) + 4 = 10
	        
	}

	@Test 
	public void testPrecedence2() {
    CalcEngine calcEngine = new CalcEngine();
	calcEngine.clear();
    calcEngine.numberPressed(4);
    calcEngine.plus();
    calcEngine.numberPressed(2);
    calcEngine.multiply();
    calcEngine.numberPressed(3);
    calcEngine.equals();
    assertEquals("10", calcEngine.getDisplayValue());
	}
	
	@Test 
	public void testPrecedence3() {
    CalcEngine calcEngine = new CalcEngine();
    // Test case 3: 8 * 9 + 2 = 74
	calcEngine.clear();
    calcEngine.numberPressed(8);
    calcEngine.multiply();
    calcEngine.numberPressed(9);
    calcEngine.plus();
    calcEngine.numberPressed(2);
    calcEngine.equals();
    assertEquals("74", calcEngine.getDisplayValue()); 
	}
	
	@Test
	public void testPrecedence4() {
	    CalcEngine calcEngine = new CalcEngine();
	     // Test case 4: 3 + 4 * 5 = 23
		calcEngine.clear();
	    calcEngine.numberPressed(3);
	    calcEngine.plus();
	    calcEngine.numberPressed(4);
	    calcEngine.multiply();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("23", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence5() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 5: 2 * 3 + 4 * 5 = 26
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.multiply();
	    calcEngine.numberPressed(3);
	    calcEngine.plus();
	    calcEngine.numberPressed(4);
	    calcEngine.multiply();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("26", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence6() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 6: 2 + 3 * 4 + 5 = 19
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.plus();
	    calcEngine.numberPressed(3);
	    calcEngine.multiply();
	    calcEngine.numberPressed(4);
	    calcEngine.plus();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("19", calcEngine.getDisplayValue()); 
		}

	@Test
	public void testPrecedence7() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 7: 2 * 3 * 4 + 5 = 29
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.multiply();
	    calcEngine.numberPressed(3);
	    calcEngine.multiply();
	    calcEngine.numberPressed(4);
	    calcEngine.plus();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("29", calcEngine.getDisplayValue()); 
		}
   
	@Test
	public void testPrecedence8() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 8: 2 + 3 * 4 * 5 = 62
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.plus();
	    calcEngine.numberPressed(3);
	    calcEngine.multiply();
	    calcEngine.numberPressed(4);
	    calcEngine.multiply();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("62", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence9() {
	    CalcEngine calcEngine = new CalcEngine();
	 // Test case 9: 2 + 3 + 4 * 5 = 25
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.plus();
	    calcEngine.numberPressed(3);
	    calcEngine.plus();
	    calcEngine.numberPressed(4);
	    calcEngine.multiply();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("25", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence10() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 10: 2 * 3 + 4 + 5 = 15
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.multiply();
	    calcEngine.numberPressed(3);
	    calcEngine.plus();
	    calcEngine.numberPressed(4);
	    calcEngine.plus();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("15", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence11() {
	    CalcEngine calcEngine = new CalcEngine();
	 // Test case 11: 2 * 3 * 4 * 5 = 120
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.multiply();
	    calcEngine.numberPressed(3);
	    calcEngine.multiply();
	    calcEngine.numberPressed(4);
	    calcEngine.multiply();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("120", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence12() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 12: 2 + 3 + 4 + 5 = 14
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.plus();
	    calcEngine.numberPressed(3);
	    calcEngine.plus();
	    calcEngine.numberPressed(4);
	    calcEngine.plus();
	    calcEngine.numberPressed(5);
	    calcEngine.equals();
	    assertEquals("14", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence13() {
	    CalcEngine calcEngine = new CalcEngine();
        // Test case 13: 2 * 3 * 4 + 5 + 6 = 35
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.multiply();
	    calcEngine.numberPressed(3);
	    calcEngine.multiply();
	    calcEngine.numberPressed(4);
	    calcEngine.plus();
	    calcEngine.numberPressed(5);
	    calcEngine.plus();
	    calcEngine.numberPressed(6);
	    calcEngine.equals();
	    assertEquals("35", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence14() {
	    CalcEngine calcEngine = new CalcEngine();
	 // Test case 14: 2 + 3 + 4 * 5 + 6 = 25
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.plus();
	    calcEngine.numberPressed(3);
	    calcEngine.plus();
	    calcEngine.numberPressed(4);
	    calcEngine.multiply();
	    calcEngine.numberPressed(5);
	    calcEngine.plus();
	    calcEngine.numberPressed(6);
	    calcEngine.equals();
	    assertEquals("31", calcEngine.getDisplayValue()); 
		}
	
	@Test
	public void testPrecedence15() {
	    CalcEngine calcEngine = new CalcEngine();
	    // Test case 15: 2 + 3 * 4 + 5 + 6 = 25
		calcEngine.clear();
	    calcEngine.numberPressed(2);
	    calcEngine.plus();
	    calcEngine.numberPressed(3);
	    calcEngine.multiply();
	    calcEngine.numberPressed(4);
	    calcEngine.plus();
	    calcEngine.numberPressed(5);
	    calcEngine.plus();
	    calcEngine.numberPressed(6);
	    calcEngine.equals();
	    assertEquals("25", calcEngine.getDisplayValue()); 
		}
	
}
