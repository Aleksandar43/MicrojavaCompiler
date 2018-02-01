// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:6


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived2 extends Statement {

    private OtherStatements otherStatements;

    public StatementDerived2 (OtherStatements otherStatements) {
        this.otherStatements=otherStatements;
        if(otherStatements!=null) otherStatements.setParent(this);
    }

    public OtherStatements getOtherStatements() {
        return otherStatements;
    }

    public void setOtherStatements(OtherStatements otherStatements) {
        this.otherStatements=otherStatements;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(otherStatements!=null) otherStatements.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(otherStatements!=null) otherStatements.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(otherStatements!=null) otherStatements.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived2(\n");

        if(otherStatements!=null)
            buffer.append(otherStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived2]");
        return buffer.toString();
    }
}
