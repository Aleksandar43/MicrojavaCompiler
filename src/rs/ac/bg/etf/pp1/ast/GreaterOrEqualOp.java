// generated with ast extension for cup
// version 0.8
// 2/1/2018 22:45:56


package rs.ac.bg.etf.pp1.ast;

public class GreaterOrEqualOp extends Relop {

    public GreaterOrEqualOp () {
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
        buffer.append("GreaterOrEqualOp(\n");

        buffer.append(tab);
        buffer.append(") [GreaterOrEqualOp]");
        return buffer.toString();
    }
}
