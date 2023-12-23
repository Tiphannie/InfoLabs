package funwithcalculators3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HexUserInterface extends UserInterface {
    
	private static JCheckBox checkBox;
	private JPanel buttonPanel;
	
	public HexUserInterface(CalcEngine engine) {
		super(engine);
	}
	
	//override makeFrame()
	public void makeFrame() {
		 frame = new JFrame(calc.getTitle());
	        
	        JPanel contentPane = (JPanel)frame.getContentPane();
	        contentPane.setLayout(new BorderLayout(8, 8));
	        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

	        display = new JTextField();
	        contentPane.add(display, BorderLayout.NORTH);

	        buttonPanel = new JPanel(new GridLayout(6, 5));
	        
		        addButton(buttonPanel, "F");
	        	addButton(buttonPanel, "E");
	        	addButton(buttonPanel, "D");
	        	addButton(buttonPanel, "C");
	        	addButton(buttonPanel, "Del");
	        	
	        	addButton(buttonPanel, "B");
	        	addButton(buttonPanel, "A");
	        	addButton(buttonPanel, "9");
	        	addButton(buttonPanel, "8");
	        	addButton(buttonPanel, "?");
	      
	        	

	            addButton(buttonPanel, "7");
	            addButton(buttonPanel, "6");
	            addButton(buttonPanel, "5");
	            addButton(buttonPanel, "4");
	            addButton(buttonPanel, "+");
	            
	            addButton(buttonPanel, "3");
	            addButton(buttonPanel, "2");
	            addButton(buttonPanel, "1");
	            addButton(buttonPanel, "0");
	            addButton(buttonPanel, "-");
	          
	     
	            checkBox = new JCheckBox("Heximal");
	            buttonPanel.add(checkBox);
	            checkBox.setSelected(true);
                updateButtonVisibility();

	            
	            addButton(buttonPanel, "NumOfElement");
	            addButton(buttonPanel, ",");

	            
	            checkBox.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    updateButtonVisibility();
	                }
	            });
	            
	            addButton(buttonPanel, "\u2229");
	            addButton(buttonPanel, "*");
	            addButton(buttonPanel, "/");
	            addButton(buttonPanel, "{");
	            addButton(buttonPanel, "}");
	            addButton(buttonPanel, "=");
	            
	        contentPane.add(buttonPanel, BorderLayout.CENTER);

	        status = new JLabel(calc.getAuthor());
	        contentPane.add(status, BorderLayout.SOUTH);

	        frame.pack();
	        
	        
	}
	
	//override actionPerformed
	public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        hexActionPerformed(command);
        
        if(command.equals("0") ||
           command.equals("1") ||
           command.equals("2") ||
           command.equals("3") ||
           command.equals("4") ||
           command.equals("5") ||
           command.equals("6") ||
           command.equals("7") ||
           command.equals("8") ||
           command.equals("9")) {
            int number = Integer.parseInt(command);
      
            if(checkBox.isSelected()) {
            	((HexCalcEngine) calc).decimal_numberPressed(number);
            }
            else {
            	calc.numberPressed(number);            	
            }
        }
        else if(command.equals("+")) {
        		 calc.plus();        		 
        }
        else if(command.equals("-")) {
        		calc.minus();        		
        }
        else if(command.equals("*")) {
        		calc.multiply();        		
        }
        else if(command.equals("/")) {
        		calc.divide();        		
        }
        
        else if(command.equals("{")) {
        	calc.addOpenBrackets();
        }
        
        else if(command.equals("}")) {
        	calc.addCloseBrackets();
        }
        
        else if(command.equals(",")) {
        	calc.addComma();
        }
        
        else if(command.equals("\u2229")) {
        	calc.addIntersection();
        }
        
        else if(command.equals("NumOfElement")) {
        	calc.numberOfElements();
        	redisplay();
        }
        
        
        else if(command.equals("=")) {
        		if(isSelected()) {
        			((CalcEngine) calc).equals(); 
        		}
        		else {
        			((HexCalcEngine) calc).hex_equals();        				
        		}
        }
        else if(command.equals("Del")) {
            calc.clear();
        }
        else if(command.equals("?")) {
            showInfo();
        }
        // else unknown command.

        redisplay();
    }
	
	private void hexActionPerformed(String command) {
		switch(command) {
		case "A":
			calc.numberPressed(10);
			break;
		case "B":
			calc.numberPressed(11);
			break;
		case "C":
			calc.numberPressed(12);
			break;
		case "D":
			calc.numberPressed(13);
			break;
		case "E":
			calc.numberPressed(14);
			break;
		case "F":
			calc.numberPressed(15);
			break;	
		
		}
	}
	
	//override redisplay
    protected void redisplay()
    {   
    	if(checkBox.isSelected()) {
        	display.setText("" + ((CalcEngine) calc).getDisplayValue());	
         }
    	else {
    		display.setText("" + ((HexCalcEngine) calc).getHexDisplayValue());	    		
    	}
    }
    
    public static boolean isSelected() {
    	if(checkBox.isSelected()) {
    		return true;
    	}
    	return false;
    }
    
    private void updateButtonVisibility() {
        boolean isHexadecimal = checkBox.isSelected();
        if(isSelected()) {
        	checkBox.setText("Decimal");
        }
        else {
        	checkBox.setText("Heximal");
        }
        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                String buttonText = button.getText();
                if (isHexadecimal) {
                    // Hide letters A-F
                    if (buttonText.equals("A") || buttonText.equals("B") || buttonText.equals("C") ||
                            buttonText.equals("D") || buttonText.equals("E") || buttonText.equals("F")) {
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                    }
                } else {
                    // Show all letters
                    button.setEnabled(true);
                }
            }
        }
        frame.revalidate();
        frame.repaint();
    }
   




    
    
	
	
}
