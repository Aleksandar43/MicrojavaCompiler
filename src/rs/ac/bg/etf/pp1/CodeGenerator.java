/* */
package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor{
    char currentMulOp,currentAddOp;
    @Override
    public void visit(Program Program) {
        Code.dataSize=Program.getProgramName().obj.getLocalSymbols().size();
    }

    @Override
    public void visit(MultiplicationOp MultiplicationOp) {
        currentMulOp='*';
    }

    @Override
    public void visit(DivisionOp DivisionOp) {
        currentMulOp='/';
    }

    @Override
    public void visit(ModuleOp ModuleOp) {
        currentMulOp='%';
    }

    @Override
    public void visit(TermMulOp TermMulOp) {
        switch(currentMulOp){
            case '*': Code.put(Code.mul); break;
            case '/': Code.put(Code.div); break;
            case '%': Code.put(Code.rem); break;
            default: Code.put(0);
        }
    }

    @Override
    public void visit(AdditionOp AdditionOp) {
        currentAddOp='+';
    }

    @Override
    public void visit(SubtractionOp SubtractionOp) {
        currentAddOp='-';
    }

    @Override
    public void visit(ExpressionAddOp ExpressionAddOp) {
        switch(currentAddOp){
            //extra sub?
            case '+': Code.put(Code.add); break;
            case '-': Code.put(Code.sub); break;
            default: Code.put(0);
        }
    }
}
