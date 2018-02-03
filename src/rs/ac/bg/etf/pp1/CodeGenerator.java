/* */
package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor{

    @Override
    public void visit(Program Program) {
        Code.dataSize=Program.getProgramName().obj.getLocalSymbols().size();
    }
    
}
