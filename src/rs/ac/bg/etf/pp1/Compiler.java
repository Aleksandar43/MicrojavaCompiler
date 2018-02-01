/* */
package rs.ac.bg.etf.pp1;

import java.io.FileReader;
import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;

public class Compiler {
    public static void main(String args[]){
        try {
            Lexer lexer=new Lexer(new FileReader(args[0]));
            MJParser parser=new MJParser(lexer);
            Symbol rootSymbol = parser.parse();
            Program rootValue = (Program) rootSymbol.value;
            System.out.println(rootValue.toString(""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
