package setfinalcalculatorversion;


public class HexCalcEngine extends CalcEngine{
	
	String hexDisplayValue;

	public HexCalcEngine() {
		super();
		
	}
	
    public void numberPressed(int number) {
    	//update the infix string input
    	int value = number;
    	number = number + 55;
    	if(isHexaLetters(number)) {
    		infixDisplayValue = infixDisplayValue + (char) number;    		
    	}
    	else {
	    	infixDisplayValue += value;
    	}
    	if(buildingDisplayValue) {
            // Incorporate this digit.
            displayValue = displayValue*16 + value;
            String hex = Integer.toHexString(displayValue);
            hexDisplayValue = hex;
            
        }
        else {
            // Start building a new number.
        	displayValue = value;
            hexDisplayValue = Integer.toHexString(value);
            buildingDisplayValue = true;
        }
    }
    
    private boolean isHexaLetters(int c) {
        return Character.toUpperCase(c) == 'A' ||
        	   Character.toUpperCase(c) == 'B' ||
        	   Character.toUpperCase(c) == 'C' ||
        	   Character.toUpperCase(c) == 'D' ||
        	   Character.toUpperCase(c) == 'E' ||
        	   Character.toUpperCase(c) == 'F';
	}
    
    public void decimal_numberPressed(int number)
    {
        super.numberPressed(number);
    }
    
    public String getHexDisplayValue() {
    	return super.getDisplayValue();
    }
    
    /**
     * The '=' button was pressed.
     */
    public void hex_equals()
    {
    	//update the infix to postfix and evaluate the postfix expression
    	Postfix pf = new Postfix();
    	infixDisplayValue = pf.infixToPostfix(infixDisplayValue);
    	infixDisplayValue = Integer.toHexString(pf.evaluate(infixDisplayValue)).toUpperCase();
    	// This should completes the building of a second operand,
    	// so ensure that we really have a left operand, an operator
    	// and a right operand.
    	
        if(haveLeftOperand &&
                lastOperator != '?' &&
                buildingDisplayValue) {
            calculateResult();
            lastOperator = '?';
            buildingDisplayValue = false;
        }
        else {
            keySequenceError();
        }
    }
    
    public void calculateResult()
    {
        switch(lastOperator) {
            case '+':
                displayValue = leftOperand + displayValue;
                hexDisplayValue = Integer.toHexString(displayValue);
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '-':
                displayValue = leftOperand - displayValue;
                hexDisplayValue = Integer.toHexString(displayValue);
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '*':
            	displayValue = leftOperand * displayValue;
                hexDisplayValue = Integer.toHexString(displayValue);
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '/':
            	displayValue = leftOperand / displayValue;
                hexDisplayValue = Integer.toHexString(displayValue);
                haveLeftOperand = true;
                leftOperand = displayValue;	
                break;
            default:
                keySequenceError();
                break;
        }
    }
    
    public void clear()
    {
        super.clear();
        hexDisplayValue = "";
    }


}
