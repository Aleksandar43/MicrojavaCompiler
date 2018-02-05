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
    @Override
    public void visit(Program Program) {
        Code.dataSize=Program.getProgramName().obj.getLocalSymbols().size();
        Code.mainPc=0; //***temp
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
        Code.put(Code.print);
    }

    @Override
    public void visit(PrintSimple PrintSimple) {
        Code.loadConst(0);
        Code.put(Code.print);
    }

    @Override
    public void visit(FactorNewArrayAllocation FactorNewArrayAllocation) {
        Code.put(Code.newarray);
        if(FactorNewArrayAllocation.struct.equals(Tab.charType)) Code.put(0);
        else Code.put(1);
    }
}
