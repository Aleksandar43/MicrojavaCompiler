// generated with ast extension for cup
// version 0.8
// 2/1/2018 22:45:55


package rs.ac.bg.etf.pp1.ast;

public class MultipleActualParameters extends ActParsList {

    private Expr expr;
    private ActParsList actParsList;

    public MultipleActualParameters (Expr expr, ActParsList actParsList) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
        this.actParsList=actParsList;
        if(actParsList!=null) actParsList.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public ActParsList getActParsList() {
        return actParsList;
    }

    public void setActParsList(ActParsList actParsList) {
        this.actParsList=actParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
        if(actParsList!=null) actParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
        if(actParsList!=null) actParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        if(actParsList!=null) actParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleActualParameters(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(actParsList!=null)
            buffer.append(actParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleActualParameters]");
        return buffer.toString();
    }
}
