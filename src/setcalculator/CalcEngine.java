package setcalculator;

	/**
	 * The main part of the calculator doing the calculations.
	 *
	 */
	public class CalcEngine
	{
	    protected String setDisplayValue;
	    /**
	     * Create a CalcEngine.
	     */
	    public CalcEngine()
	    {
	        clear();
	        setDisplayValue= "";
	    }
	
	    /**
	     * @return The value that should currently be displayed
	     * on the calculator display.
	     */
	    public String getDisplayValue()
	    {
	        return setDisplayValue; //we want to see the infix so we return the string
	    }
	
	    /**
	     * A number button was pressed.
	     * Either start a new operand, or incorporate this number as
	     * the least significant digit of an existing one.
	     * @param number The number pressed on the calculator.
	     */
	    public void numberPressed(int number)
	    {
	    	//update the string
	    	setDisplayValue += number;
	    }
	    
	    /**
	     * The 'plus' button was pressed. 
	     */
	    public void plus()
	    {
	    	//update the string
	    	setDisplayValue += "+";
	    }
	

	    public void substract() {
	    	setDisplayValue += "/";
	    }
	    
	    public void addOpenBrackets() {
			setDisplayValue += "{";
		}
		
		public void addCloseBrackets() {
			setDisplayValue += "}";
		}
		
		public void addComma() {
			setDisplayValue += ",";
		}		
		
		public void addIntersection() {
			setDisplayValue += "\u2229";
		}
		
		//return number of elements of set
		public void numberOfElements() {
			Set set = new Set();
			if(set.isSetString(setDisplayValue)) {
				setDisplayValue = Integer.toString(set.getArray().size());
			}
			else {
				System.out.println("Invalid set");
			}
		}

	    
	    /**
	     * The '=' button was pressed.
	     */
	    public void equals()
	    {	    	
	    	SetCalculator sc = new SetCalculator();
	    	if(!sc.isValid(setDisplayValue)){
				System.out.println("Invalid input");
				return;
			}
	    	setDisplayValue = sc.calculateSet(setDisplayValue);
	    	
	    }
	
	    /**
	     * The 'C' (clear) button was pressed.
	     * Reset everything to a starting state.
	     */
	    public void clear()
	    {
        	setDisplayValue = "";
	    }
	
	    /**
	     * @return The title of this calculation engine.
	     */
	    protected String getTitle()
	    {
	        return "Java Calculator";
	    }
	
	    /**
	     * @return The author of this engine.
	     */
	    public String getAuthor()
	    {
	        return "Luong Hoang and Tiphannie Byakuleka ";
	    }
	
	    /**
	     * @return The version number of this engine.
	     */
	    public String getVersion()
	    {
	       return "Version 2.0";
	    }
	
	}
