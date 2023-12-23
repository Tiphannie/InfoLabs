package calculator2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackAsListTest {

	private Postfix pf = new Postfix();
	@Test
	void testEvaluate() {
		String fpx1 = "12*3+";
		String fpx2 = "123*+";
		String fpx3 = "34^";
		String fpx4 = "12^34*-";
		String fpx5 = "123*+45^-6+";
		String fpx6 = "12+34/+5678+*++";

		assertEquals(5, pf.evaluate(fpx1));
		assertEquals(7, pf.evaluate(fpx2));
		assertEquals(81, pf.evaluate(fpx3));
		assertEquals(-11, pf.evaluate(fpx4));
		assertEquals(-1011, pf.evaluate(fpx5));
		assertEquals(98, pf.evaluate(fpx6));


		
	}

}
