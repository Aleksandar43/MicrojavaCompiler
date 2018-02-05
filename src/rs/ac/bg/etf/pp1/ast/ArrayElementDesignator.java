// generated with ast extension for cup
// version 0.8
// 5/1/2018 2:20:46


package rs.ac.bg.etf.pp1.ast;

public class ArrayElementDesignator extends Designator {

    private ArrayDesignator arrayDesignator;
    private Expr expr;

    public ArrayElementDesignator (ArrayDesignator arrayDesignator, Expr expr) {
        this.arrayDesignator=arrayDesignator;
        if(arrayDesignator!=null) arrayDesignator.setParent(this);
        this.expr=expr;
        if(expr!=null) expr.setParent(this);
    }

    public ArrayDesignator getArrayDesignator() {
        return arrayDesignator;
    }

    public void setArrayDesignator(ArrayDesignator arrayDesignator) {
        this.arrayDesignator=arrayDesignator;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr=expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(arrayDesignator!=null) arrayDesignator.accept(visitor);
        if(expr!=null) expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(arrayDesignator!=null) arrayDesignator.traverseTopDown(visitor);
        if(expr!=null) expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(arrayDesignator!=null) arrayDesignator.traverseBottomUp(visitor);
        if(expr!=null) expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ArrayElementDesignator(\n");

        if(arrayDesignator!=null)
            buffer.append(arrayDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(expr!=null)
            buffer.append(expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ArrayElementDesignator]");
        return buffer.toString();
    }
}
