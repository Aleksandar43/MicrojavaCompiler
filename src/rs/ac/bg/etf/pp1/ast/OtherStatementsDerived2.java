// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:7


package rs.ac.bg.etf.pp1.ast;

public class OtherStatementsDerived2 extends OtherStatements {

    public OtherStatementsDerived2 () {
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
        buffer.append("OtherStatementsDerived2(\n");

        buffer.append(tab);
        buffer.append(") [OtherStatementsDerived2]");
        return buffer.toString();
    }
}
