// generated with ast extension for cup
// version 0.8
// 31/0/2018 2:6:38


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementDerived13 extends DesignatorStatement {

    private Condition condition;
    private Statement statement;
    private Statement statement1;

    public DesignatorStatementDerived13 (Condition condition, Statement statement, Statement statement1) {
        this.condition=condition;
        if(condition!=null) condition.setParent(this);
        this.statement=statement;
        if(statement!=null) statement.setParent(this);
        this.statement1=statement1;
        if(statement1!=null) statement1.setParent(this);
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition=condition;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement=statement;
    }

    public Statement getStatement1() {
        return statement1;
    }

    public void setStatement1(Statement statement1) {
        this.statement1=statement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(condition!=null) condition.accept(visitor);
        if(statement!=null) statement.accept(visitor);
        if(statement1!=null) statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(condition!=null) condition.traverseTopDown(visitor);
        if(statement!=null) statement.traverseTopDown(visitor);
        if(statement1!=null) statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(condition!=null) condition.traverseBottomUp(visitor);
        if(statement!=null) statement.traverseBottomUp(visitor);
        if(statement1!=null) statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementDerived13(\n");

        if(condition!=null)
            buffer.append(condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement!=null)
            buffer.append(statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statement1!=null)
            buffer.append(statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementDerived13]");
        return buffer.toString();
    }
}
