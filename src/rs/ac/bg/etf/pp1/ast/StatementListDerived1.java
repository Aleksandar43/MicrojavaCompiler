// generated with ast extension for cup
// version 0.8
// 31/0/2018 2:6:37


package rs.ac.bg.etf.pp1.ast;

public class StatementListDerived1 extends StatementList {

    private Statement statement;
    private StatementList statementList;

    public StatementListDerived1 (Statement statement, StatementList statementList) {
        this.statement=statement;
        if(statement!=null) statement.setParent(this);
        this.statementList=statementList;
        if(statementList!=null) statementList.setParent(this);
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement=statement;
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
        if(statement!=null) statement.accept(visitor);
        if(statementList!=null) statementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(statement!=null) statement.traverseTopDown(visitor);
        if(statementList!=null) statementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(statement!=null) statement.traverseBottomUp(visitor);
        if(statementList!=null) statementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementListDerived1(\n");

        if(statement!=null)
            buffer.append(statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statementList!=null)
            buffer.append(statementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementListDerived1]");
        return buffer.toString();
    }
}
