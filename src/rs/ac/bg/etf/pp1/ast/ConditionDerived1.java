// generated with ast extension for cup
// version 0.8
// 31/0/2018 2:6:38


package rs.ac.bg.etf.pp1.ast;

public class ConditionDerived1 extends Condition {

    private CondTerm condTerm;

    public ConditionDerived1 (CondTerm condTerm) {
        this.condTerm=condTerm;
        if(condTerm!=null) condTerm.setParent(this);
    }

    public CondTerm getCondTerm() {
        return condTerm;
    }

    public void setCondTerm(CondTerm condTerm) {
        this.condTerm=condTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condTerm!=null) condTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condTerm!=null) condTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condTerm!=null) condTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConditionDerived1(\n");

        if(condTerm!=null)
            buffer.append(condTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConditionDerived1]");
        return buffer.toString();
    }
}