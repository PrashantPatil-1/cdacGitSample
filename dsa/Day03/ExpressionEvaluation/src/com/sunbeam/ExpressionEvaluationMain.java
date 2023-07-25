package com.sunbeam;

public class ExpressionEvaluationMain {
	public static int calculate(int op1, int op2, char opr) {
		switch(opr) {
		case '+': return op1 + op2;
		case '-': return op1 - op2;
		case '/': return op1 / op2;
		case '*': return op1 * op2;
		case '%': return op1 % op2;
		case '$': return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int postfixEvaluation(String postfix) {
		// create statck to store operands
		int result = 0;
		Stack st = new Stack(16);
		//1. check postfix expression from left to right
		for(int i = 0 ; i < postfix.length() ; i++) {
			// 2. read character from ith index
			char ch = postfix.charAt(i);
			//3. if character is operand, push it on stack
			if(Character.isDigit(ch))
				st.push(ch - 48);
			//4. if charcter is operator
			else {
				//5. pop two elements from stack in such way that
				int op2 = st.pop();// first poped will become second operand
				int op1 = st.pop();// second poped will become first operand
				//6. find the result of current operation
				result = calculate(op1, op2, ch);
				//7. push result on stack 
				st.push(result);
			}
		}
		//8. pop final result from stack and return it
		if(!st.isEmpty())
			result = st.pop();
		return result;
	}
	
	public static int prefixEvaluation(String prefix) {
		// create statck to store operands
		int result = 0;
		Stack st = new Stack(16);
		//1. check prefix expression from right to left
		for(int i = prefix.length()-1  ; i >= 0 ; i--) {
			// 2. read character from ith index
			char ch = prefix.charAt(i);
			//3. if character is operand, push it on stack
			if(Character.isDigit(ch))
				st.push(ch - 48);
			//4. if charcter is operator
			else {
				//5. pop two elements from stack in such way that
				int op1 = st.pop();// first poped will become first operand
				int op2 = st.pop();// second poped will become second operand
				//6. find the result of current operation
				result = calculate(op1, op2, ch);
				//7. push result on stack 
				st.push(result);
			}
		}
		//8. pop final result from stack and return it
		if(!st.isEmpty())
			result = st.pop();
		return result;
	}

	public static void main(String[] args) {
		String postfix = "456*3/+9+7-";
		//String postfix = "56 + 28 - 64"
		
		System.out.println("Postfix Expression : " + postfix);
		int result = postfixEvaluation(postfix);
		System.out.println("Postfix Result : " + result);
		
		String prefix = "-++4/*56397";
		
		System.out.println("Prefix Expression : " + prefix);
		result = prefixEvaluation(prefix);
		System.out.println("Prefix Result : " + result);

	}

}
