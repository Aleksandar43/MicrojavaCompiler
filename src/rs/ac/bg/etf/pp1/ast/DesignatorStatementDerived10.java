// generated with ast extension for cup
// version 0.8
// 31/0/2018 23:14:15


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementDerived10 extends DesignatorStatement {

    public DesignatorStatementDerived10 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementDerived10(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementDerived10]");
        return buffer.toString();
    }
}
