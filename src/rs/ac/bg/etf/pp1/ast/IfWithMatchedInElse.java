// generated with ast extension for cup
// version 0.8
// 5/1/2018 2:20:45


package rs.ac.bg.etf.pp1.ast;

public class IfWithMatchedInElse extends OtherStatements {

    private Condition condition;
    private OtherStatements otherStatements;
    private OtherStatements otherStatements1;

    public IfWithMatchedInElse (Condition condition, OtherStatements otherStatements, OtherStatements otherStatements1) {
        this.condition=condition;
        if(condition!=null) condition.setParent(this);
        this.otherStatements=otherStatements;
        if(otherStatements!=null) otherStatements.setParent(this);
        this.otherStatements1=otherStatements1;
        if(otherStatements1!=null) otherStatements1.setParent(this);
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition=condition;
    }

    public OtherStatements getOtherStatements() {
        return otherStatements;
    }

    public void setOtherStatements(OtherStatements otherStatements) {
        this.otherStatements=otherStatements;
    }

    public OtherStatements getOtherStatements1() {
        return otherStatements1;
    }

    public void setOtherStatements1(OtherStatements otherStatements1) {
        this.otherStatements1=otherStatements1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condition!=null) condition.accept(visitor);
        if(otherStatements!=null) otherStatements.accept(visitor);
        if(otherStatements1!=null) otherStatements1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condition!=null) condition.traverseTopDown(visitor);
        if(otherStatements!=null) otherStatements.traverseTopDown(visitor);
        if(otherStatements1!=null) otherStatements1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condition!=null) condition.traverseBottomUp(visitor);
        if(otherStatements!=null) otherStatements.traverseBottomUp(visitor);
        if(otherStatements1!=null) otherStatements1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfWithMatchedInElse(\n");

        if(condition!=null)
            buffer.append(condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(otherStatements!=null)
            buffer.append(otherStatements.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(otherStatements1!=null)
            buffer.append(otherStatements1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfWithMatchedInElse]");
        return buffer.toString();
    }
}
