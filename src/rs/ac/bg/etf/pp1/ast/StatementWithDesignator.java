// generated with ast extension for cup
// version 0.8
// 2/1/2018 14:59:8


package rs.ac.bg.etf.pp1.ast;

public class StatementWithDesignator extends OtherStatements {

    private DesignatorStatement designatorStatement;

    public StatementWithDesignator (DesignatorStatement designatorStatement) {
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
        buffer.append("StatementWithDesignator(\n");

        if(designatorStatement!=null)
            buffer.append(designatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementWithDesignator]");
        return buffer.toString();
    }
}
