// generated with ast extension for cup
// version 0.8
// 31/0/2018 2:6:37


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived1 extends Statement {

    private DesignatorStatement designatorStatement;

    public StatementDerived1 (DesignatorStatement designatorStatement) {
        this.designatorStatement=designatorStatement;
        if(designatorStatement!=null) designatorStatement.setParent(this);
    }

    public DesignatorStatement getDesignatorStatement() {
        return designatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement designatorStatement) {
        this.designatorStatement=designatorStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(designatorStatement!=null) designatorStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(designatorStatement!=null) designatorStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(designatorStatement!=null) designatorStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived1(\n");

        if(designatorStatement!=null)
            buffer.append(designatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived1]");
        return buffer.toString();
    }
}
