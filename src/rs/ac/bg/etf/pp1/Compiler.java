/* */
package rs.ac.bg.etf.pp1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class Compiler {
    private static FileWriter logFile;
    private static PrintWriter logPrintWriter;
    public static void tsdump(){
        Tab.dump();
    }
    public static void main(String args[]){
        try {
            Lexer lexer=new Lexer(new FileReader(args[0]));
            logFile=new FileWriter("logs/mjlog.txt");
            logPrintWriter=new PrintWriter(new BufferedWriter(logFile));
            MJParser parser=new MJParser(lexer);
            Symbol rootSymbol = parser.parse();
            Program rootValue = (Program) rootSymbol.value;
            if(parser.getSyntaxErrors()!=0){
                System.out.println(parser.getSyntaxErrors()+" syntax error"+(parser.getSyntaxErrors()>1?"s":"")+" detected\n");
                logPrintWriter.write("---- Syntax errors ----\n"+parser.getSyntaxErrorMessages());
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
                logPrintWriter.write("---- Semantic errors ----\n"+semanticAnalyzer.getSemanticErrors());
            }
            tsdump();
            if(parser.syntaxErrors==0 && semanticAnalyzer.getSemanticErrors().equals("")){
                CodeGenerator codeGenerator=new CodeGenerator();
                rootValue.accept(codeGenerator);
                FileOutputStream objectFile = new FileOutputStream("test/program.obj");
                BufferedOutputStream objectStream=new BufferedOutputStream(objectFile);
                Code.write(objectStream);
                objectStream.close();
                System.out.println("File compiled sucessfully");
            }
            logPrintWriter.close();
            logFile.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
