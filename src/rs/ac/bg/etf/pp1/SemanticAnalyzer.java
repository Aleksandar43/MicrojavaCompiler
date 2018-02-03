/* */
package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor{
    //struct==type
    private Obj programObj;
    private Struct currentType;
    private int constantValue;
    private String semanticErrors="",semanticUsageDetections="";
    private DumpSymbolTableVisitor localVisitor;
    
    public void reportError(int line, String message){
        semanticErrors+=("Error at line "+line+": "+message+"\n");
    }

    public void reportUsage(int line, Obj obj){
        semanticUsageDetections+=(obj.getName()+" used at line "+line);
        localVisitor=new DumpSymbolTableVisitor();
        obj.accept(localVisitor);
        
        semanticUsageDetections+=(" ("+localVisitor.getOutput()+")\n");
    }

    public String getSemanticErrors() {
        return semanticErrors;
    }

    public String getSemanticUsageDetections() {
        return semanticUsageDetections;
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
    public void visit(NumberConstant NumberConstant) {
        constantValue=NumberConstant.getN1();
    }

    @Override
    public void visit(CharacterConstant CharacterConstant) {
        constantValue=CharacterConstant.getC1();
    }

    @Override
    public void visit(BooleanConstant BooleanConstant) {
        Boolean b = BooleanConstant.getB1();
        if(b) constantValue=1;
        else constantValue=0;
    }

    @Override
    public void visit(ConstAssignment ConstAssignment) {
        String constName = ConstAssignment.getConstName().getName();
        Obj constObj = Tab.find(constName);
        if(constObj.equals(Tab.noObj)){
            Obj newObj=Tab.insert(Obj.Con, constName, currentType);
            newObj.setAdr(constantValue);
        } else{
            reportError(ConstAssignment.getLine(), "'"+constName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }

    @Override
    public void visit(SimpleDesignator SimpleDesignator) {
        String designatorName = SimpleDesignator.getI1();
        Obj designatorObj = Tab.find(designatorName);
        if(!designatorObj.equals(Tab.noObj))
            reportUsage(SimpleDesignator.getLine(), designatorObj);
        else{
            reportError(SimpleDesignator.getLine(), "undeclared variable "+designatorName);
        }
    }

    @Override
    public void visit(ScalarVar ScalarVar) {
        String varName = ScalarVar.getName();
        Obj varObj = Tab.find(varName);
        if(varObj.equals(Tab.noObj)){
            Tab.insert(Obj.Var, varName, currentType);
        } else{
            reportError(ScalarVar.getLine(), "'"+varName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }
    
    @Override
    public void visit(ArrayVar ArrayVar) {
        String varName = ArrayVar.getName();
        Obj varObj = Tab.find(varName);
        if(varObj.equals(Tab.noObj)){
            Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
        } else{
            reportError(ArrayVar.getLine(), "'"+varName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }
}
