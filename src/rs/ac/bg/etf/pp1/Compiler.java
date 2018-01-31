/* */
package rs.ac.bg.etf.pp1;

import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Compiler {
    public static void main(String args[]){
        try {
            Lexer lexer=new Lexer(new FileReader(args[0]));
            MJParser parser=new MJParser(lexer);
            Symbol rootSymbol = parser.parse();
            Object rootValue = rootSymbol.value;
            System.out.println(rootValue);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
