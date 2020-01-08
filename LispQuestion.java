/*
 * Student First Name: Chase
 * Student Last Name: Almy
 * Student BU Number: U64493103
 * Honor Code: Honor Code: I pledge that this program represents my own program code and that I have coded on my own. 
 * I have also read the collaboration policy on the course syllabus for
 * CS 112 and my program adheres and is consistent with the course syllabus.
 */
package highlights;
import java.util.Scanner;
import java.util.Stack;

public class LispQuestion
{
	
	public static double evaluate(String lispExp)
	{
	Stack<LispToken> s1 = new Stack<LispToken>();
	Stack<LispToken> s2 = new Stack<LispToken>();
	for(int i = 0; i < lispExp.length(); i++) {
		
		char newValue = lispExp.charAt(i);
		if(newValue == '(') {
			LispToken newToken = new LispToken(lispExp.charAt(i + 1));
			s1.push(newToken);
		}
		else if(Character.isDigit(newValue)  == true) {
			int j = i;
			String num = new String();
			while(Character.isDigit(lispExp.charAt(j))== true) {
				num = num + lispExp.charAt(j);
				j++;
			}
			int temp = Integer.valueOf(num);
			double newOperand = temp;
			LispToken newToken = new LispToken(newOperand);
			s1.push(newToken);
			i = i + (j - i) - 1;
		}
		else if(newValue == ')') {
			while(s1.peek().isOperator() == false) {
				LispToken nextPush = s1.pop();
				s2.push(nextPush);
			}
			LispToken nextOperator = s1.pop();
			if(s2.isEmpty() == true) {
				LispToken identity = new LispToken(nextOperator.getIdentity());
				s1.push(identity);
			}
			else if(s2.size() == 1) {
				LispToken identity = new LispToken(nextOperator.getIdentity());
				double single = s2.pop().getValue();
				single = nextOperator.applyOperator(identity.getValue(), single);
				LispToken nextRet = new LispToken(single);
				s1.push(nextRet);
			}
			else {
				double nextExec = s2.pop().getValue();
				while(s2.size() > 0) {
					nextExec = nextOperator.applyOperator(nextExec, s2.pop().getValue());
				}
				LispToken nextRet = new LispToken(nextExec);
				s1.push(nextRet);
			}
		}
	}
	double ret = s1.pop().getValue();
	return ret;
	} 

	public static void main (String args[])
	{
		Double result;
		String test1 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))";
		result = evaluate(test1);
		System.out.println("Expression " + test1 + " evaluates to " + result);

		String test2 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (*) (- 21 3 1)))";
		result = evaluate(test2);
		System.out.println("Expression " + test2 + " evaluates to " + result);

		String test3 = "(+ (/ 2) (* 2) (/ (+ 1) (+) (- 2 1 )))";
		result = evaluate(test3);
		System.out.println("Expression " + test3 + " evaluates to " + result);
		
		String test4 = "(+ 1 2 3)";
		result = evaluate(test4);
		System.out.println("Expression " + test4 + " evaluates to " + result);
	} 
} 

/*
 Expression (+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1))) evaluates to 16.5
 Expression (+ (- 632) (* 21 3 4) (/ (+ 32) (*) (- 21 3 1))) evaluates to -378.11764705882354
 Expression (+ (/ 2) (* 2) (/ (+ 1) (+) (- 2 1 ))) evaluates to Infinity
*/

