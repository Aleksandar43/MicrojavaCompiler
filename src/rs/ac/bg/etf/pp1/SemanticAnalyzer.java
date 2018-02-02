/* */
package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.Tab;

public class SemanticAnalyzer extends VisitorAdaptor{
    //struct==type
    Obj programObj;
    Struct currentType;
    String semanticErrors="";
    
    public void reportError(int line, String message){
        semanticErrors+=("Error at line "+line+": "+message+"\n");
    }

    public String getSemanticErrors() {
        return semanticErrors;
    }
    
    @Override
    public void visit(ProgramName ProgramName) {
        programObj = Tab.insert(Obj.Prog, ProgramName.getName(), Tab.noType);
        Tab.openScope();
    }

    @Override
    public void visit(Program Program) {
        Tab.chainLocalSymbols(programObj);
        Tab.closeScope();
    }

    @Override
    public void visit(Type Type) {
        String name = Type.getName();
        Obj typeObj = Tab.find(name);
        if(typeObj.equals(Tab.noObj)){
            reportError(Type.getLine(), "unknown type '"+name+"'");
        }
        currentType=typeObj.getType();
    }

    @Override
    public void visit(ConstAssignment ConstAssignment) {
        String constName = ConstAssignment.getConstName().getName();
        Obj constObj = Tab.find(constName);
        if(constObj.equals(Tab.noObj)){
            Tab.insert(Obj.Con, constName, currentType);
        } else{
            reportError(ConstAssignment.getLine(), "'"+constName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }
}
