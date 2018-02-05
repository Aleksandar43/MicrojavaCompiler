// generated with ast extension for cup
// version 0.8
// 5/1/2018 2:20:45


package rs.ac.bg.etf.pp1.ast;

public class StatementBlock extends OtherStatements {

    private StatementList statementList;

    public StatementBlock (StatementList statementList) {
        this.statementList=statementList;
        if(statementList!=null) statementList.setParent(this);
    }

    public StatementList getStatementList() {
        return statementList;
    }

    public void setStatementList(StatementList statementList) {
        this.statementList=statementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(statementList!=null) statementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(statementList!=null) statementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(statementList!=null) statementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementBlock(\n");

        if(statementList!=null)
            buffer.append(statementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementBlock]");
        return buffer.toString();
    }
}
