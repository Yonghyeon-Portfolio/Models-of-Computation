package logicSolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FormulaTest {
    /*
     * When a formula is initialised,
     * - whitespaces are removed.
     * - outermost parenthesis is added if necessary.
     * - atomic formulas are identified.
     */
    @Test
    public void case1(){
        Formula F = new Formula("p  ∧ q");
        System.err.println(F);
        assertEquals(F.expr, "(p∧q)");
        assertArrayEquals(F.atoms, new char[] {'p', 'q'});
    }

    @Test
    public void case2(){
        Formula F = new Formula("¬(p ∧ p) ∨ ¬p ");
        System.err.println(F);
        assertEquals(F.expr, "(¬(p∧p)∨¬p)");
    }
    
    // String[] testcases = {
    //     "p ∧ q",
    //     "(p ∧ q)",
    //     "¬(p ∧ q)",
    //     "¬p ∨ ¬(q ∨ r)",
    //     "(¬p ∨ q) ∨ r",
    //     "¬(p ∧ p) ∨ ¬p "
    // };

    // @Test
    // public void addingOuterMostParenthesis(){
    //     String[] expected = {
    //         "(p ∧ q)",
    //         "(p ∧ q)",
    //         "¬(p ∧ q)",
    //         "(¬p ∨ ¬(q ∨ r))",
    //         "((¬p ∨ q) ∨ r)",
    //         "(¬(p ∧ p) ∨ ¬p)"
    //     };

    //     for (int i = 0; i < testcases.length; i++){
    //         Formula F = new Formula(testcases[i]);
    //         assertEquals(F.expr, expected[i]);
    //     }
    // }

    // @Test
    // public void checkAtomicFormulas(){
        
    // List<char[]> expected = new ArrayList<>();
    // expected.add(new char[] {'p', 'q'});
    // expected.add(new char[] {'p', 'q'});
    // expected.add(new char[] {'p', 'q'});
    // expected.add(new char[] {'p', 'q', 'r'});
    // expected.add(new char[] {'p', 'q', 'r'});

    // for (int i = 0; i < expected.size(); i++){
    //     Formula F = new Formula(testcases[i]);
    //     assertArrayEquals(expected.get(i), F.atoms);
    // }
    // }
}
