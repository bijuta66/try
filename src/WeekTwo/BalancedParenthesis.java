package WeekTwo;


public class BalancedParenthesis {
	
	boolean checkBalanced(String input) {
		// defining open and closed brackets
		String openBraces = "[{(";
		String closedBraces = "]})";
		int lngth = input.length();
		
		Stack char_stk = new Stack(lngth);

		for(int i=0; i<lngth; i++) {
			// getting a bracket at index i
			char braces = input.charAt(i);
			
			// checking if the bracket is open bracket or closed bracket
			if(openBraces.indexOf(braces) != -1) {
				// if the bracket is open, push it to stack
				char_stk.push(braces);
				
			} else {
				// if the bracket is closed, pop from stack 
				// and check if it is the corresponding opening bracket
				int closed_indx = closedBraces.indexOf(braces);
				char similar_to_open = openBraces.charAt(closed_indx);
				if(char_stk.pop() != similar_to_open) {
					return false;
				}
			}
			
		}
		
		// check if there are elements present in stack or not
		if(char_stk.peak() == -1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		String braces_input = "{()}{}";
		BalancedParenthesis bp = new BalancedParenthesis();
		boolean final_output = bp.checkBalanced(braces_input);
		
		System.out.println("Result: " + final_output);
	}
}
