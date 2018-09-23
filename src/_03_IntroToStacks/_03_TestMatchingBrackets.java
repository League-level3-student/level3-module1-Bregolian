package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> bracketStack = new Stack<Character>();
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '{') {
				bracketStack.push('{');
			}
			if (b.charAt(i) == '}') {
				if (bracketStack.isEmpty()) {
					return false;
				}
				bracketStack.pop();
			}
		}
		if (bracketStack.isEmpty()) {
			return true;
		}
		return false;
	}

}