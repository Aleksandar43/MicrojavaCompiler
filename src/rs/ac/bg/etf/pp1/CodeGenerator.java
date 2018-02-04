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
        designatorStack.push(SimpleDesignator.obj);
    }

    @Override
    public void visit(NumberConstant NumberConstant) {
        Obj o=new Obj(Obj.Con, "", tableBoolType);
        o.setAdr(NumberConstant.getN1());
        NumberConstant.obj=o;
    }
    
    @Override
    public void visit(CharacterConstant CharacterConstant) {
        Obj o=new Obj(Obj.Con, "", tableBoolType);
        o.setAdr(CharacterConstant.getC1());
        CharacterConstant.obj=o;
    }
    
    @Override
    public void visit(BooleanConstant BooleanConstant) {
        Obj o=new Obj(Obj.Con, "", tableBoolType);
        Boolean b = BooleanConstant.getB1();
        if(b) o.setAdr(1);
        else o.setAdr(0);
        BooleanConstant.obj=o;
    }

    @Override
    public void visit(FactorConstant FactorConstant) {
        Code.loadConst(FactorConstant.getConstant().obj.getAdr());
    }
}
