// generated with ast extension for cup
// version 0.8
// 2/1/2018 3:14:36


package rs.ac.bg.etf.pp1.ast;

public class NotIfsUnmatched extends Statement {

    private OtherStatements otherStatements;

    public NotIfsUnmatched (OtherStatements otherStatements) {
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
        buffer.append("NotIfsUnmatched(\n");

        if(otherStatements!=null)
            buffer.append(otherStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NotIfsUnmatched]");
        return buffer.toString();
    }
}
