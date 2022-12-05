package logicSolver;
import java.util.*;

public class Formula {
    public String expr;
    public char[] atoms;
    public List<HashMap<Character, Boolean>> assignments;

    private char[] consideredAtom = new char[] {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
        's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
        'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' 
    };

    public Formula(String expr){
        this.expr = expr;
        initialiseFormula();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("<Formula Information>\n");
        sb.append("Expression:  " + expr + "\n");
        sb.append("Atoms:  { ");
        for (char c : atoms)
            sb.append(c + " ");
        sb.append("}\n");
        return sb.toString();
    }

    public void initialiseFormula(){
        expr = removeWhitespaces(expr);
        expr = addOuterMostParenthesis(expr);
        atoms = listAllAtoms(expr);
    }

    public String removeWhitespaces(String formula){
        StringBuilder stripped = new StringBuilder("");
        for (int i=0; i<formula.length(); i++){
            String s = formula.substring(i, i+1);
            if (s.equals(" ") == false)
                stripped.append(s);
        }
        return stripped.toString();
    }

    public String addOuterMostParenthesis(String formula){
        String origF = formula;
        if (formula.startsWith("¬"))
            formula = formula.substring(2);

        boolean start = formula.startsWith("(");
        boolean end = formula.endsWith(")");
        if (start && end)
            return origF;
        else
            return "(" + origF + ")"; 
    }

    public boolean isAtom(char str){
        for (char c : consideredAtom){
            if (c == str)
                return true;
        }
        return false;
    }

    public char[] listAllAtoms(String formula){
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < formula.length(); i++){
            Character chr = formula.charAt(i);
            characters.add(chr);
        }
        List<Character> atoms = new ArrayList<>();
        for (Character c : characters){
            if (isAtom(c))
                atoms.add(c);
        }
        char[] Atoms = new char[atoms.size()];
        for (int i = 0; i < atoms.size(); i++)
            Atoms[i] = atoms.get(i);
        
        return Atoms;
    } 

    public List<HashMap<Character, Boolean>> listAssignments(){
        int n = atoms.length;
        int m = (int)Math.pow(2, n);
        System.err.println(m);
        for (int i=0; i < m; i++){
            int a = 1+1;
        }
        return null;
    }

}
