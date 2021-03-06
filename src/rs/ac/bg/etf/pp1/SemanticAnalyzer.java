/* */
package rs.ac.bg.etf.pp1;

import java.util.Stack;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class SemanticAnalyzer extends VisitorAdaptor{
    //struct==type
    Struct tableBoolType=Tab.find("bool").getType();
    private Struct currentType;
    Stack<Character> opStack=new Stack<>();
    private int methodFormalParameters=0,methodActualParameters=0;
    private Struct currentMethodType;
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
        Obj o = new Obj(Obj.Con, "", Tab.intType);
        o.setAdr(NumberConstant.getN1());
        NumberConstant.obj=o;
    }

    @Override
    public void visit(CharacterConstant CharacterConstant) {
        Obj o = new Obj(Obj.Con, "", Tab.charType);
        o.setAdr(CharacterConstant.getC1());
        CharacterConstant.obj=o;
    }

    @Override
    public void visit(BooleanConstant BooleanConstant) {
        Obj boolObj = Tab.find("bool");
        Obj o = new Obj(Obj.Con, "", boolObj.getType());
        o.setAdr(BooleanConstant.getB1() ? 1 : 0);
        BooleanConstant.obj=o;
    }

    @Override
    public void visit(FactorConstant FactorConstant) {
        FactorConstant.struct=FactorConstant.getConstant().obj.getType();
    }

    @Override
    public void visit(FactorDesignator FactorDesignator) {
        FactorDesignator.struct=FactorDesignator.getDesignator().obj.getType();
    }

    @Override
    public void visit(TermFactor TermFactor) {
        TermFactor.struct=TermFactor.getFactor().struct;
    }
    
    @Override
    public void visit(MultiplicationOp MultiplicationOp) {
        opStack.push('*');
    }

    @Override
    public void visit(DivisionOp DivisionOp) {
        opStack.push('/');
    }

    @Override
    public void visit(ModuleOp ModuleOp) {
        opStack.push('/');
    }

    @Override
    public void visit(TermMulOp TermMulOp) {
        Character op = opStack.pop();
        if(!TermMulOp.getTerm().struct.equals(Tab.intType)){
            reportError(TermMulOp.getLine(), "type of left operand of "+op+" is not int");
        }
        if(!TermMulOp.getFactor().struct.equals(Tab.intType)){
            reportError(TermMulOp.getLine(), "type of right operand of "+op+" is not int");
        }
        TermMulOp.struct=Tab.intType; //eliminate multiple errors
    }

    @Override
    public void visit(ExpressionTerm ExpressionTerm) {
        ExpressionTerm.struct=ExpressionTerm.getTerm().struct;
    }
    
    @Override
    public void visit(AdditionOp AdditionOp) {
        opStack.push('+');
    }

    @Override
    public void visit(SubtractionOp SubtractionOp) {
        opStack.push('-');
    }

    @Override
    public void visit(ExpressionAddOp ExpressionAddOp) {
        Character op = opStack.pop();
        if(!ExpressionAddOp.getExpr().struct.equals(Tab.intType)){
            reportError(ExpressionAddOp.getLine(), "type of left operand of "+op+" is not int");
        }
        if(!ExpressionAddOp.getTerm().struct.equals(Tab.intType)){
            reportError(ExpressionAddOp.getLine(), "type of right operand of "+op+" is not int");
        }
        ExpressionAddOp.struct=Tab.intType; //eliminate multiple errors
    }

    @Override
    public void visit(ConstAssignment ConstAssignment) {
        String constName = ConstAssignment.getConstName().getName();
        Obj constObj = Tab.currentScope.findSymbol(constName);
        if(constObj == null){
            Obj newObj=ConstAssignment.getConstName().obj=Tab.insert(Obj.Con, constName, currentType);
            newObj.setAdr(ConstAssignment.getConstant().obj.getAdr());
        } else{
            reportError(ConstAssignment.getLine(), "'"+constName+"' is already defined in the current scope");
        }
        currentType=Tab.noType;
    }

    @Override
    public void visit(SimpleDesignator SimpleDesignator) {
        String designatorName = SimpleDesignator.getI1();
        Obj designatorObj = Tab.find(designatorName);
        if(!designatorObj.equals(Tab.noObj)){
            reportUsage(SimpleDesignator.getLine(), designatorObj);
            SimpleDesignator.obj=designatorObj;
        }
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
        currentMethodType=Tab.noType;
    }

    @Override
    public void visit(ReturnTypeNonVoid ReturnTypeNonVoid) {
        methodFormalParameters=0;
        String typeName = ReturnTypeNonVoid.getType().getName();
        Obj typeObj = Tab.find(typeName);
        if(typeObj.equals(Tab.noObj)){
            reportError(ReturnTypeNonVoid.getLine(), "unknown type '"+typeName+"'");
            ReturnTypeNonVoid.struct=Tab.noType;
            currentMethodType=Tab.noType;
        } else{
            ReturnTypeNonVoid.struct=typeObj.getType();
            currentMethodType=typeObj.getType();
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
        //check return
        Tab.chainLocalSymbols(MethodDeclarations.getMethodHeader().getMethodName().obj);
        Tab.closeScope();
    }

    @Override
    public void visit(Assignment Assignment) {
        if(!Assignment.getExpr().struct.assignableTo(Assignment.getDesignator().obj.getType())){
            SymbolTableVisitor stv1=new DumpSymbolTableVisitor();
            stv1.visitStructNode(Assignment.getExpr().struct);
            SymbolTableVisitor stv2=new DumpSymbolTableVisitor();
            stv2.visitStructNode(Assignment.getDesignator().obj.getType());
            reportError(Assignment.getLine(), "cannot assign "+stv1.getOutput()+" to "+stv2.getOutput());
        }
    }

    @Override
    public void visit(Increment Increment) {
        if(Increment.getDesignator().obj.getKind()!=Obj.Var
                && Increment.getDesignator().obj.getKind()!=Obj.Elem){
            reportError(Increment.getLine(), "trying to increment a non-variable '"+Increment.getDesignator().obj.getName()+"'");
        }
        else if(!Increment.getDesignator().obj.getType().equals(Tab.intType)){
            reportError(Increment.getLine(), "incrementing value type must be int");
        }
    }
    
    @Override
    public void visit(Decrement Decrement) {
        if(Decrement.getDesignator().obj.getKind()!=Obj.Var
                && Decrement.getDesignator().obj.getKind()!=Obj.Elem){
            reportError(Decrement.getLine(), "trying to decrement a non-variable '"+Decrement.getDesignator().obj.getName()+"'");
        }
        else if(!Decrement.getDesignator().obj.getType().equals(Tab.intType)){
            reportError(Decrement.getLine(), "decrementing value type must be int");
        }
    }

    @Override
    public void visit(PrintSimple PrintSimple) {
        Struct exprStruct = PrintSimple.getExpr().struct;
        if(!exprStruct.equals(Tab.intType) && !exprStruct.equals(Tab.charType) && !exprStruct.equals(tableBoolType)){
            reportError(PrintSimple.getLine(), "only expressions of int, char or bool can be printed");
        }
    }
    
    @Override
    public void visit(PrintWithWidth PrintWithWidth) {
        Struct exprStruct = PrintWithWidth.getExpr().struct;
        if(!exprStruct.equals(Tab.intType) && !exprStruct.equals(Tab.charType) && !exprStruct.equals(tableBoolType)){
            reportError(PrintWithWidth.getLine(), "only expressions of int, char or bool can be printed");
        }
    }

    @Override
    public void visit(FactorNewArrayAllocation FactorNewArrayAllocation) {
        if(!FactorNewArrayAllocation.getExpr().struct.equals(Tab.intType)){
            reportError(FactorNewArrayAllocation.getLine(), "number of elements must be int type");
        }
        FactorNewArrayAllocation.struct=new Struct(Struct.Array, FactorNewArrayAllocation.getType().struct);
    }

    @Override
    public void visit(ArrayDesignator ArrayDesignator) {
        ArrayDesignator.obj=ArrayDesignator.getDesignator().obj;
    }

    @Override
    public void visit(ArrayElementDesignator ArrayElementDesignator) {
        if(!ArrayElementDesignator.getExpr().struct.equals(Tab.intType)){
            reportError(ArrayElementDesignator.getLine(), "number of elements must be int type");
        }
        if(ArrayElementDesignator.getArrayDesignator().obj.getType().getKind()!=Struct.Array){
            reportError(ArrayElementDesignator.getLine(), "'"+ArrayElementDesignator.getArrayDesignator().obj.getName()+"' is not an array variable");
            ArrayElementDesignator.obj=new Obj(Obj.Elem, "", Tab.noType);
        } else{
            ArrayElementDesignator.obj=new Obj(Obj.Elem, "", ArrayElementDesignator.getArrayDesignator().obj.getType().getElemType());
        }
    }

    @Override
    public void visit(FactorExpressionInParentheses FactorExpressionInParentheses) {
        FactorExpressionInParentheses.struct=FactorExpressionInParentheses.getExpr().struct;
    }

    @Override
    public void visit(Read Read) {
        Struct exprStruct = Read.getDesignator().obj.getType();
        if(!exprStruct.equals(Tab.intType) && !exprStruct.equals(Tab.charType) && !exprStruct.equals(tableBoolType)){
            reportError(Read.getLine(), "values can be read only into int, char and bool variables");
        }
    }

    @Override
    public void visit(ReturnNonVoid ReturnNonVoid) {
        if(currentMethodType==Tab.noType){
            reportError(ReturnNonVoid.getLine(), "method does not return a value");
        } else if(!ReturnNonVoid.getExpr().struct.assignableTo(currentMethodType)){
            SymbolTableVisitor stv1=new DumpSymbolTableVisitor();
            stv1.visitStructNode(ReturnNonVoid.getExpr().struct);
            SymbolTableVisitor stv2=new DumpSymbolTableVisitor();
            stv2.visitStructNode(currentMethodType);
            reportError(ReturnNonVoid.getLine(), "cannot return value of type '"+stv1.getOutput()+"', return type of method is '"+stv2.getOutput()+"'");
        }
    }

    @Override
    public void visit(ReturnVoid ReturnVoid) {
        if(currentMethodType!=Tab.noType){
            reportError(ReturnVoid.getLine(), "a value must be returned");
        }
    }

    @Override
    public void visit(FactorFunctionCall FactorFunctionCall) {
        Obj methodObj = Tab.find(FactorFunctionCall.getDesignator().obj.getName());
        if(methodObj.equals(Tab.noObj) || methodObj.getKind()!=Obj.Meth){
            reportError(FactorFunctionCall.getLine(), "undefined method '"+FactorFunctionCall.getDesignator().obj.getName()+"'");
            FactorFunctionCall.struct=Tab.noType;
        } else{
            FactorFunctionCall.struct=FactorFunctionCall.getDesignator().obj.getType();
            if(methodActualParameters!=methodObj.getLevel()){
                reportError(FactorFunctionCall.getLine(), "wrong number of parameters");
            }
        }
        methodActualParameters=0;
    }

    @Override
    public void visit(OneActualParameter OneActualParameter) {
        methodActualParameters++;
    }

    @Override
    public void visit(MultipleActualParameters MultipleActualParameters) {
        methodActualParameters++;
    }

    @Override
    public void visit(FunctionCall FunctionCall) {
        Obj methodObj = Tab.find(FunctionCall.getDesignator().obj.getName());
        if(methodObj.equals(Tab.noObj) || methodObj.getKind()!=Obj.Meth){
            reportError(FunctionCall.getLine(), "undefined method '"+FunctionCall.getDesignator().obj.getName()+"'");
        } else{
            if(methodActualParameters!=methodObj.getLevel()){
                reportError(FunctionCall.getLine(), "wrong number of parameters");
            }
        }
        methodActualParameters=0;
    }
}
