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
        // System.err.println(F);
        assertEquals(F.expr, "(p∧q)");
        assertArrayEquals(F.atoms, new char[] {'p', 'q'});
    }

    @Test
    public void case2(){
        Formula F = new Formula("¬(p ∧ p) ∨ ¬p ");
        // System.err.println(F);
        assertEquals(F.expr, "(¬(p∧p)∨¬p)");
        assertArrayEquals(F.atoms, new char[] {'p'});
    }
    
    @Test
    public void case3(){
        Formula F = new Formula(" ¬( p ∧  q)");
        // System.err.println(F);
        assertEquals(F.expr, "¬(p∧q)");
        assertArrayEquals(F.atoms, new char[] {'p', 'q'});
    }

    @Test
    public void case4(){
        Formula F = new Formula("¬r ∨ ¬(q ∨ p)");
        // System.err.println(F);
        assertEquals(F.expr, "(¬r∨¬(q∨p))");
        assertArrayEquals(F.atoms, new char[] {'p', 'q', 'r'});
    }

    @Test
    public void assignmentCheck(){
        Formula F = new Formula("p");
        F.listAllAtoms(F.expr);
    }

    // @Test
    // public void tv1(){
    //     Formula F = new Formula("p");
    //     boolean a = F.truthVal(0);
    //     System.err.println(a);
    // }

    // @Test
    // public void parsing1A(){
    //     String f = "p";
    //     String[] test = Formula.nextLvlParenthesis(f);
    //     assertArrayEquals(test, new String[] {"("});
    // }
    // @Test
    // public void parsing1B(){
    //     String f1 = " ¬( p ∧  q)";
    //     String[] test1 = Formula.nextLvlParenthesis(f1);
    //     assertArrayEquals(test1, new String[] {"(p∧q)"});
    // }
    // @Test
    // public void parsing1C(){
    //     String f1 = " ¬( p ∧  q)";
    //     String[] test1 = Formula.nextLvlParenthesis(f1);
    //     assertArrayEquals(test1, new String[] {"(p∧q)"});
    // }
}