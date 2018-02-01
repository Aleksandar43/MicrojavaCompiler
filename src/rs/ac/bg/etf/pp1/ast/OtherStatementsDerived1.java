// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:7


package rs.ac.bg.etf.pp1.ast;

public class OtherStatementsDerived1 extends OtherStatements {

    private DesignatorStatement designatorStatement;

    public OtherStatementsDerived1 (DesignatorStatement designatorStatement) {
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
        buffer.append("OtherStatementsDerived1(\n");

        if(designatorStatement!=null)
            buffer.append(designatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OtherStatementsDerived1]");
        return buffer.toString();
    }
}
