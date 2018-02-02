/* */
package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.Tab;

public class SemanticAnalyzer extends VisitorAdaptor{
    Obj programObj;
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
}
