// generated with ast extension for cup
// version 0.8
// 31/0/2018 2:6:38


package rs.ac.bg.etf.pp1.ast;

public class CondTermDerived1 extends CondTerm {

    private CondFact condFact;

    public CondTermDerived1 (CondFact condFact) {
        this.condFact=condFact;
        if(condFact!=null) condFact.setParent(this);
    }

    public CondFact getCondFact() {
        return condFact;
    }

    public void setCondFact(CondFact condFact) {
        this.condFact=condFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condFact!=null) condFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condFact!=null) condFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condFact!=null) condFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermDerived1(\n");

        if(condFact!=null)
            buffer.append(condFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermDerived1]");
        return buffer.toString();
    }
}
