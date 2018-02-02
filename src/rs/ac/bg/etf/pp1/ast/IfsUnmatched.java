// generated with ast extension for cup
// version 0.8
// 2/1/2018 16:25:3


package rs.ac.bg.etf.pp1.ast;

public class IfsUnmatched extends Statement {

    private IfChainWithUnmatched ifChainWithUnmatched;

    public IfsUnmatched (IfChainWithUnmatched ifChainWithUnmatched) {
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
        buffer.append("IfsUnmatched(\n");

        if(ifChainWithUnmatched!=null)
            buffer.append(ifChainWithUnmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfsUnmatched]");
        return buffer.toString();
    }
}
