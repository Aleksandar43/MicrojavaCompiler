// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:8


package rs.ac.bg.etf.pp1.ast;

public class ActParsDerived1 extends ActPars {

    private Expr expr;
    private ActPars actPars;

    public ActParsDerived1 (Expr expr, ActPars actPars) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
        this.actPars=actPars;
        if(actPars!=null) actPars.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public ActPars getActPars() {
        return actPars;
    }

    public void setActPars(ActPars actPars) {
        this.actPars=actPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
        if(actPars!=null) actPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
        if(actPars!=null) actPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        if(actPars!=null) actPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsDerived1(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(actPars!=null)
            buffer.append(actPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsDerived1]");
        return buffer.toString();
    }
}
