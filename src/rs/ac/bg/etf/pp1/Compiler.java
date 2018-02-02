/* */
package rs.ac.bg.etf.pp1;

import java.io.FileReader;
import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.symboltable.Tab;

public class Compiler {
    public static void tsdump(){
        Tab.dump();
    }
    public static void main(String args[]){
        try {
            Lexer lexer=new Lexer(new FileReader(args[0]));
            MJParser parser=new MJParser(lexer);
            Symbol rootSymbol = parser.parse();
            Program rootValue = (Program) rootSymbol.value;
            if(parser.getSyntaxErrors()!=0)
                System.out.println(parser.getSyntaxErrors()+" syntax error"+(parser.getSyntaxErrors()>1?"s":"")+" detected");
            System.out.println("---- Syntax tree ----");
            System.out.println(rootValue.toString(""));
            Tab.init();
            System.out.println("---- Semantic analysis ----");
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            rootValue.traverseBottomUp(semanticAnalyzer);
            System.err.println(semanticAnalyzer.semanticErrors);
            tsdump();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
