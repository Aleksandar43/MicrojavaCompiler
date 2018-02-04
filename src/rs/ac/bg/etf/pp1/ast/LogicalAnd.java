// generated with ast extension for cup
// version 0.8
// 4/1/2018 17:40:6


package rs.ac.bg.etf.pp1.ast;

public class LogicalAnd extends CondTerm {

    private CondFact condFact;
    private CondFact condFact1;

    public LogicalAnd (CondFact condFact, CondFact condFact1) {
        this.condFact=condFact;
        if(condFact!=null) condFact.setParent(this);
        this.condFact1=condFact1;
        if(condFact1!=null) condFact1.setParent(this);
    }

    public CondFact getCondFact() {
        return condFact;
    }

    public void setCondFact(CondFact condFact) {
        this.condFact=condFact;
    }

    public CondFact getCondFact1() {
        return condFact1;
    }

    public void setCondFact1(CondFact condFact1) {
        this.condFact1=condFact1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condFact!=null) condFact.accept(visitor);
        if(condFact1!=null) condFact1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condFact!=null) condFact.traverseTopDown(visitor);
        if(condFact1!=null) condFact1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condFact!=null) condFact.traverseBottomUp(visitor);
        if(condFact1!=null) condFact1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LogicalAnd(\n");

        if(condFact!=null)
            buffer.append(condFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(condFact1!=null)
            buffer.append(condFact1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LogicalAnd]");
        return buffer.toString();
    }
}
