// generated with ast extension for cup
// version 0.8
// 3/1/2018 17:26:15


package rs.ac.bg.etf.pp1.ast;

public class ExpressionAddOp extends Expr {

    private Expr expr;
    private Addop addop;
    private Term term;

    public ExpressionAddOp (Expr expr, Addop addop, Term term) {
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
        this.addop=addop;
        if(addop!=null) addop.setParent(this);
        this.term=term;
        if(term!=null) term.setParent(this);
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public Addop getAddop() {
        return addop;
    }

    public void setAddop(Addop addop) {
        this.addop=addop;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term=term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(expr!=null) expr.accept(visitor);
        if(addop!=null) addop.accept(visitor);
        if(term!=null) term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
        if(addop!=null) addop.traverseTopDown(visitor);
        if(term!=null) term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(expr!=null) expr.traverseBottomUp(visitor);
        if(addop!=null) addop.traverseBottomUp(visitor);
        if(term!=null) term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionAddOp(\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(addop!=null)
            buffer.append(addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(term!=null)
            buffer.append(term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionAddOp]");
        return buffer.toString();
    }
}
