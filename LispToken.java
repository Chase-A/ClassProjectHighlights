/*
 * Student First Name: Chase
 * Student Last Name: Almy
 * Student BU Number: U64493103
 * Honor Code: Honor Code: I pledge that this program represents my own program code and that I have coded on my own. 
 * I have also read the collaboration policy on the course syllabus for
 * CS 112 and my program adheres and is consistent with the course syllabus.
 */
package highlights;
public class LispToken
{
	private Character operator;
	private Double    operand;
	private boolean   isOperator;

	/** Constructors for objects of class LispToken. */
	public LispToken(Character anOperator)
	{
		operator = anOperator;
		isOperator = true;
		operand = 0.0;
	} 

	public LispToken(Double value)
	{
		operand = value;
		isOperator = false;
		operator = ' ';
	} 


	public Double applyOperator(Double value1, Double value2)
	{
		char givenOperator = this.operator;
		if(givenOperator == '+') {
			return value1 + value2;
		}
		else if (givenOperator == '-') {
			return value1 - value2;
		}
		else if (givenOperator == '*') {
			return value1 * value2;
		}
		else {
			return value1 / value2;
		}
	}

	/** Gets the identity value of this operator.
		 For example, x + 0 = x,  so 0 is the identity for +
		 and will be the value associated with the expression (+).
		 @return  The identity value of the operator. */
	public Double getIdentity()
	{
		Double result = 0.0;

		switch (operator)
		{
		case '+':
			result = 0.0;
			break;
		case '-':
			result = 0.0;
			break;
		case '*':
			result = 1.0;
			break;
		case '/':
			result = 1.0;
			break;            
		} 

		return result;
	} 

	/** Detects whether this operator returns a value when it has no operands.
		@return  True if the operator returns a value when it has no operands,
	 			   or false if not. */
	public boolean takesZeroOperands()
	{
		boolean result = false;

		switch (operator)
		{
		case '+':
			result = true;
			break;
		case '-':
			result = false;
			break;
		case '*':
			result = true;
			break;
		case '/':
			result = false;
			break;            
		} 

		return result;
	} 

	/** Gets the value of this operand.
		 @return  The real value of the operand. */   
	public Double getValue()
	{
		return operand;
	} 

	/** Returns true if the object is an operator.
		 @return  True is this object is an operator. */
	public boolean isOperator()
	{
		return isOperator;
	} 

	public String toString()
	{
		String result = null;

		if (isOperator)
			result = operator.toString();
		else
			result = operand.toString();

		return result;
	} 
} 
