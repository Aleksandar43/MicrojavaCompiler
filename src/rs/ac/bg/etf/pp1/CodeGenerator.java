/* */
package rs.ac.bg.etf.pp1;

import java.util.Stack;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor{
    Struct tableBoolType=new Struct(Struct.Bool);
    Stack<Character> opStack=new Stack<>();
    Stack<Obj> designatorStack=new Stack<>();
    private int methodFormalParameters=0;
    private int localVariables=0; //for methods, includes formal parameters
    @Override
    public void visit(Program Program) {
        Code.dataSize=Program.getProgramName().obj.getLocalSymbols().size();
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
        opStack.push('%');
    }

    @Override
    public void visit(TermMulOp TermMulOp) {
        Character op = opStack.pop();
        switch(op){
            case '*': Code.put(Code.mul); break;
            case '/': Code.put(Code.div); break;
            case '%': Code.put(Code.rem); break;
            default: Code.put(0);
        }
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
        switch(op){
            case '+': Code.put(Code.add); break;
            case '-': Code.put(Code.sub); break;
            default: Code.put(0);
        }
    }

    @Override
    public void visit(SimpleDesignator SimpleDesignator) {
        //String designatorName = SimpleDesignator.getI1();
        //designatorStack.push(SimpleDesignator.obj);
    }

    @Override
    public void visit(NumberConstant NumberConstant) {
        //Code.load(NumberConstant.obj);
    }
    
    @Override
    public void visit(CharacterConstant CharacterConstant) {
        //Code.load(CharacterConstant.obj);
    }
    
    @Override
    public void visit(BooleanConstant BooleanConstant) {
        //Code.load(BooleanConstant.obj);
    }

    @Override
    public void visit(FactorConstant FactorConstant) {
        Code.loadConst(FactorConstant.getConstant().obj.getAdr());
    }

    @Override
    public void visit(FactorDesignator FactorDesignator) {
        Code.load(FactorDesignator.getDesignator().obj);
    }

    @Override
    public void visit(Assignment Assignment) {
        Code.store(Assignment.getDesignator().obj);
    }

    @Override
    public void visit(Increment Increment) {
        Obj o = Increment.getDesignator().obj;
        Code.load(o);
        Code.loadConst(1);
        Code.put(Code.add);
        Code.store(o);
    }

    @Override
    public void visit(Decrement Decrement) {
        Obj o = Decrement.getDesignator().obj;
        Code.load(o);
        Code.loadConst(1);
        Code.put(Code.sub);
        Code.store(o);
    }

    @Override
    public void visit(PrintWithWidth PrintWithWidth) {
        Code.loadConst(PrintWithWidth.getN2());
        if(PrintWithWidth.getExpr().struct.equals(Tab.charType)) Code.put(Code.bprint);
        else Code.put(Code.print);
    }

    @Override
    public void visit(PrintSimple PrintSimple) {
        Code.loadConst(0);
        if(PrintSimple.getExpr().struct.equals(Tab.charType)) Code.put(Code.bprint);
        else Code.put(Code.print);
    }

    @Override
    public void visit(FactorNewArrayAllocation FactorNewArrayAllocation) {
        Code.put(Code.newarray);
        if(FactorNewArrayAllocation.struct.equals(new Struct(Struct.Array, Tab.charType))) Code.put(0);
        else Code.put(1);
    }

    @Override
    public void visit(ArrayDesignator ArrayDesignator) {
        Code.load(ArrayDesignator.obj);
    }

    @Override
    public void visit(Read Read) {
        if(Read.getDesignator().obj.getType().equals(Tab.charType)) Code.put(Code.bread);
        else Code.put(Code.read);
        Code.store(Read.getDesignator().obj);
    }

    @Override
    public void visit(ReturnTypeVoid ReturnTypeVoid) {
        methodFormalParameters=0;
        localVariables=0;
    }

    @Override
    public void visit(ReturnTypeNonVoid ReturnTypeNonVoid) {
        methodFormalParameters=0;
        localVariables=0;
    }
    
    @Override
    public void visit(OneFormalParameter OneFormalParameter) {
        methodFormalParameters++;
    }

    @Override
    public void visit(MultipleFormalParameters MultipleFormalParameters) {
        methodFormalParameters++;
    }

    @Override
    public void visit(ScalarVar ScalarVar) {
        localVariables++;
    }

    @Override
    public void visit(ArrayVar ArrayVar) {
        localVariables++;
    }
    
    @Override
    public void visit(MethodName MethodName) {
        Obj methodObj = MethodName.obj;
        if(methodObj.getName().equals("main")) Code.mainPc=Code.pc;
        methodObj.setAdr(Code.pc);
    }
    
    @Override
    public void visit(MethodHeader MethodHeader) {
        //MethodHeader.getMethodName().obj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(methodFormalParameters);
        Code.put(localVariables);
    }

    @Override
    public void visit(MethodDeclarations MethodDeclarations) {
        if(MethodDeclarations.getMethodHeader().getReturnType().struct==Tab.noType){
            Code.put(Code.exit);
            Code.put(Code.return_);
        }
    }

    @Override
    public void visit(ReturnNonVoid ReturnNonVoid) {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    @Override
    public void visit(ReturnVoid ReturnVoid) {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    @Override
    public void visit(FactorFunctionCall FactorFunctionCall) {
        int jumpAddress = FactorFunctionCall.getDesignator().obj.getAdr()-Code.pc;
        Code.put(Code.call);
        Code.put2(jumpAddress);
    }
}
