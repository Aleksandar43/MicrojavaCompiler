// generated with ast extension for cup
// version 0.8
// 5/1/2018 2:20:45


package rs.ac.bg.etf.pp1.ast;

public class LogicalOr extends Condition {

    private CondTerm condTerm;
    private CondTerm condTerm1;

    public LogicalOr (CondTerm condTerm, CondTerm condTerm1) {
        this.condTerm=condTerm;
        if(condTerm!=null) condTerm.setParent(this);
        this.condTerm1=condTerm1;
        if(condTerm1!=null) condTerm1.setParent(this);
    }

    public CondTerm getCondTerm() {
        return condTerm;
    }

    public void setCondTerm(CondTerm condTerm) {
        this.condTerm=condTerm;
    }

    public CondTerm getCondTerm1() {
        return condTerm1;
    }

    public void setCondTerm1(CondTerm condTerm1) {
        this.condTerm1=condTerm1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condTerm!=null) condTerm.accept(visitor);
        if(condTerm1!=null) condTerm1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condTerm!=null) condTerm.traverseTopDown(visitor);
        if(condTerm1!=null) condTerm1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condTerm!=null) condTerm.traverseBottomUp(visitor);
        if(condTerm1!=null) condTerm1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LogicalOr(\n");

        if(condTerm!=null)
            buffer.append(condTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(condTerm1!=null)
            buffer.append(condTerm1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LogicalOr]");
        return buffer.toString();
    }
}
