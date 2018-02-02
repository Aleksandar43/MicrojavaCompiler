// generated with ast extension for cup
// version 0.8
// 2/1/2018 14:59:9


package rs.ac.bg.etf.pp1.ast;

public class DivisionOp extends Mulop {

    public DivisionOp () {
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
        buffer.append("DivisionOp(\n");

        buffer.append(tab);
        buffer.append(") [DivisionOp]");
        return buffer.toString();
    }
}
