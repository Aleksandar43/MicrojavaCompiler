/* */
package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor{
    //struct==type
    private Struct currentType;
    private int constantValue;
    private int methodFormalParameters=0;
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
        ProgramName.obj = Tab.insert(Obj.Prog, ProgramName.getName(), Tab.noType);
        Tab.openScope();
    }

    @Override
    public void visit(Program Program) {
        Obj main = Tab.find("main");
        if(main==Tab.noObj || main.getKind()!=Obj.Meth){
            reportError(Program.getLine(), "main method is not defined");
        }
        Tab.chainLocalSymbols(Program.getProgramName().obj);
        Tab.closeScope();
    }

    @Override
    public void visit(Type Type) {
        String name = Type.getName();
        Obj typeObj = Tab.find(name);
        if(typeObj.equals(Tab.noObj)){
            reportError(Type.getLine(), "unknown type '"+name+"'");
        }
        currentType=Type.struct=typeObj.getType();
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
        Obj constObj = Tab.currentScope.findSymbol(constName);
        if(constObj == null){
            Obj newObj=ConstAssignment.getConstName().obj=Tab.insert(Obj.Con, constName, currentType);
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
        Obj varObj = Tab.currentScope.findSymbol(varName);
        if(varObj == null){
            ScalarVar.obj=Tab.insert(Obj.Var, varName, currentType);
        } else{
            reportError(ScalarVar.getLine(), "'"+varName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }
    
    @Override
    public void visit(ArrayVar ArrayVar) {
        String varName = ArrayVar.getName();
        Obj varObj = Tab.currentScope.findSymbol(varName);
        if(varObj == null){
            ArrayVar.obj=Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
        } else{
            reportError(ArrayVar.getLine(), "'"+varName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }

    @Override
    public void visit(ReturnTypeVoid ReturnTypeVoid) {
        methodFormalParameters=0;
        ReturnTypeVoid.struct=Tab.noType;
    }

    @Override
    public void visit(ReturnTypeNonVoid ReturnTypeNonVoid) {
        methodFormalParameters=0;
        String typeName = ReturnTypeNonVoid.getType().getName();
        Obj typeObj = Tab.find(typeName);
        if(typeObj.equals(Tab.noObj)){
            reportError(ReturnTypeNonVoid.getLine(), "unknown type '"+typeName+"'");
            ReturnTypeNonVoid.struct=Tab.noType;
        } else{
            ReturnTypeNonVoid.struct=typeObj.getType();
        }
    }

    @Override
    public void visit(OneFormalParameter OneFormalParameter) {
        methodFormalParameters++;
        //Tab.insert(Obj.Var, OneFormalParameter.getType().getName(), OneFormalParameter.getType().struct);
    }

    @Override
    public void visit(MultipleFormalParameters MultipleFormalParameters) {
        methodFormalParameters++;
        //Tab.insert(Obj.Var, MultipleFormalParameters.getType().getName(), MultipleFormalParameters.getType().struct);
    }

    @Override
    public void visit(MethodName MethodName) {
        String methodName = MethodName.getName();
        Obj methodObj = Tab.currentScope.findSymbol(methodName);
        ReturnType rType = ((MethodHeader)MethodName.getParent()).getReturnType();
        if(methodObj == null){
            MethodName.obj=Tab.insert(Obj.Meth, methodName, rType.struct);
        } else{
            reportError(MethodName.getLine(), "'"+methodName+"' is already defined in the current scope");
            MethodName.obj=Tab.insert(Obj.Meth, methodName, rType.struct);
        }
        Tab.openScope();
    }

    @Override
    public void visit(MethodHeader MethodHeader) {
        Obj methodObj = MethodHeader.getMethodName().obj;
        methodObj.setLevel(methodFormalParameters);
    }

    @Override
    public void visit(MethodDeclarations MethodDeclarations) {
        Tab.chainLocalSymbols(MethodDeclarations.getMethodHeader().getMethodName().obj);
        Tab.closeScope();
    }
}
