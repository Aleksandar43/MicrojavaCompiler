/* */
package rs.ac.bg.etf.pp1;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.symboltable.Tab;

public class Compiler {
    private static FileWriter logFile;
    private static PrintWriter printWriter;
    public static void tsdump(){
        Tab.dump();
    }
    public static void main(String args[]){
        try {
            Lexer lexer=new Lexer(new FileReader(args[0]));
            logFile=new FileWriter("logs/mjlog.txt");
            printWriter=new PrintWriter(new BufferedWriter(logFile));
            MJParser parser=new MJParser(lexer);
            Symbol rootSymbol = parser.parse();
            Program rootValue = (Program) rootSymbol.value;
            if(parser.getSyntaxErrors()!=0){
                System.out.println(parser.getSyntaxErrors()+" syntax error"+(parser.getSyntaxErrors()>1?"s":"")+" detected\n");
                printWriter.write("---- Syntax errors ----\n"+parser.getSyntaxErrorMessages());
            }
            System.out.println("---- Syntax tree ----");
            System.out.println(rootValue.toString(""));
            Tab.init();
            System.out.println("---- Semantic analysis ----");
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            rootValue.traverseBottomUp(semanticAnalyzer);
            System.out.println(semanticAnalyzer.getSemanticUsageDetections());
            if(!semanticAnalyzer.getSemanticErrors().equals("")){
                System.err.println(semanticAnalyzer.getSemanticErrors());
                printWriter.write("---- Semantic errors ----\n"+semanticAnalyzer.getSemanticErrors());
            }
            tsdump();
            printWriter.close();
            logFile.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
