package dsa.stack;

/**
 * Balanced Parentheses Checker
 * <p>
 * Given an expression string, write a Java program to check whether the parentheses in the expression are balanced or not.
 * The types of parentheses to consider are curly {}, square [], and round ().
 * <p>
 * Hint: Using stacks for parsing and balancing symbols.
 */
public class QuestionBalancedParenthesesCheckerStack {

	public static void main(String[] args) {


		QuestionBalancedParenthesesCheckerStack questionPartitionRearangeSingly = new QuestionBalancedParenthesesCheckerStack();
		final String stringFalse = "xclcdc{{}d;cmdcdslkcm[[]]cjncdkdsjcnksdjcn0(csdcdsc)";
		final String stringTrue = "xclcdc{{}d;cmdcdslkcm[[]]cjncdkdsj}cnksdjcn0(csdcdsc)";
		final boolean balancedNot = questionPartitionRearangeSingly.isBalanced(stringFalse);
		final boolean balanced = questionPartitionRearangeSingly.isBalanced(stringTrue);
		System.out.println("True=" + balanced);
		System.out.println("False=" + balancedNot);
	}

	public boolean isBalanced(String expression) { //time O(n) Space O(n) -> n length of string
		//fill stack
		MyStackLinkedListImpl<Character> stack = new MyStackLinkedListImpl<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

}




