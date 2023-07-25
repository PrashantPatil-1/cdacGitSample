package com.sunbeam;

public class ExpressionConversionMain {
	public static int priority(char opr) {
		switch(opr) {
		case '$': return 10;
		case '/': return 9;
		case '*': return 9;
		case '%': return 9;
		case '+': return 8;
		case '-': return 8;
		case '(': return 7;
		case ')': return 7;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		// create stack to store operators
		Stack st = new Stack(10);
		// create string to store postfix expression
		StringBuilder postfix = new StringBuilder();
		//1. check infix expression from left to right
		for(int i = 0 ; i < infix.length() ; i++) {
			//2. read character from infix expression
			char ch = infix.charAt(i);
			//3. if charcter is operand/digit, append into postfix expression
			if(Character.isDigit(ch))
				postfix.append(ch);
			//4. if character is '('
			else if(ch == '(')
				st.push(ch);
			//5. if character is ')'
			else if(ch == ')') {
				// pop element from stack and append into postfix till '('
				while(st.peek() != '(')
					postfix.append(st.pop());
				st.pop();		// to discard '('
			}
			//6. if character is operator
			else {
				// check if prio of topmost element is greater or equal to current element
				while(!st.isEmpty() && priority(st.peek()) >= priority(ch)) {
						postfix.append(st.pop());// pop element from stack and append it into postfix
				}// repeat above two steps till stack is not empty and condition is false
				//push current operator on stack
				st.push(ch);
			}
		}
		// pop all elements from stack and append into postfix expression one by one
		while(!st.isEmpty())
			postfix.append(st.pop());
		return postfix.toString();
	}
	
	public static String infixToPrefix(String infix) {
		// create stack to store operators
		Stack st = new Stack(10);
		// create string to store prefix expression
		StringBuilder prefix = new StringBuilder();
		//1. check infix expression from left to right
		for(int i = infix.length() - 1 ; i >= 0 ; i--) {
			//2. read character from infix expression
			char ch = infix.charAt(i);
			//3. if charcter is operand/digit, append into postfix expression
			if(Character.isDigit(ch))
				prefix.append(ch);
			//4. if character is '('
			else if(ch == ')')
				st.push(ch);
			//5. if character is ')'
			else if(ch == '(') {
				// pop element from stack and append into postfix till '('
				while(st.peek() != ')')
					prefix.append(st.pop());
				st.pop();		// to discard ')'
			}
			//6. if character is operator
			else {
				// check if prio of topmost element is greater or equal to current element
				while(!st.isEmpty() && priority(st.peek()) > priority(ch)) {
						prefix.append(st.pop());// pop element from stack and append it into postfix
				}// repeat above two steps till stack is not empty and condition is false
				//push current operator on stack
				st.push(ch);
			}
		}
		// pop all elements from stack and append into postfix expression one by one
		while(!st.isEmpty())
			prefix.append(st.pop());
		prefix.reverse();
		return prefix.toString();
	}

	public static void main(String[] args) {
		String infix = "1$9+3*4-(6+8/2)+7";
		
		System.out.println("Infix Expression : " + infix);
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix Expression : " + postfix);
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix Expression : " + prefix);
		
	}

}
