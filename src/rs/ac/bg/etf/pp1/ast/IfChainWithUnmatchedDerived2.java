// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:7


package rs.ac.bg.etf.pp1.ast;

public class IfChainWithUnmatchedDerived2 extends IfChainWithUnmatched {

    private Condition condition;
    private OtherStatements otherStatements;
    private IfChainWithUnmatched ifChainWithUnmatched;

    public IfChainWithUnmatchedDerived2 (Condition condition, OtherStatements otherStatements, IfChainWithUnmatched ifChainWithUnmatched) {
        this.condition=condition;
        if(condition!=null) condition.setParent(this);
        this.otherStatements=otherStatements;
        if(otherStatements!=null) otherStatements.setParent(this);
        this.ifChainWithUnmatched=ifChainWithUnmatched;
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.setParent(this);
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

    public IfChainWithUnmatched getIfChainWithUnmatched() {
        return ifChainWithUnmatched;
    }

    public void setIfChainWithUnmatched(IfChainWithUnmatched ifChainWithUnmatched) {
        this.ifChainWithUnmatched=ifChainWithUnmatched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condition!=null) condition.accept(visitor);
        if(otherStatements!=null) otherStatements.accept(visitor);
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condition!=null) condition.traverseTopDown(visitor);
        if(otherStatements!=null) otherStatements.traverseTopDown(visitor);
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condition!=null) condition.traverseBottomUp(visitor);
        if(otherStatements!=null) otherStatements.traverseBottomUp(visitor);
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfChainWithUnmatchedDerived2(\n");

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

        if(ifChainWithUnmatched!=null)
            buffer.append(ifChainWithUnmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfChainWithUnmatchedDerived2]");
        return buffer.toString();
    }
}
