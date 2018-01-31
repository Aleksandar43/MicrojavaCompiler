// generated with ast extension for cup
// version 0.8
// 31/0/2018 18:43:29


package rs.ac.bg.etf.pp1.ast;

public class ReturnTypeDerived2 extends ReturnType {

    public ReturnTypeDerived2 () {
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
        buffer.append("ReturnTypeDerived2(\n");

        buffer.append(tab);
        buffer.append(") [ReturnTypeDerived2]");
        return buffer.toString();
    }
}
