// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:6


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived1 extends Statement {

    private IfChainWithUnmatched ifChainWithUnmatched;

    public StatementDerived1 (IfChainWithUnmatched ifChainWithUnmatched) {
        this.ifChainWithUnmatched=ifChainWithUnmatched;
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.setParent(this);
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
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ifChainWithUnmatched!=null) ifChainWithUnmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived1(\n");

        if(ifChainWithUnmatched!=null)
            buffer.append(ifChainWithUnmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived1]");
        return buffer.toString();
    }
}
