// generated with ast extension for cup
// version 0.8
// 31/0/2018 18:43:30


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementDerived5 extends DesignatorStatement {

    public DesignatorStatementDerived5 () {
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
        buffer.append("DesignatorStatementDerived5(\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementDerived5]");
        return buffer.toString();
    }
}
