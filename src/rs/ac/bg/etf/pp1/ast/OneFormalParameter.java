// generated with ast extension for cup
// version 0.8
// 4/1/2018 1:37:50


package rs.ac.bg.etf.pp1.ast;

public class OneFormalParameter extends FormParsList {

    private Type type;
    private Var var;

    public OneFormalParameter (Type type, Var var) {
        this.type=type;
        if(type!=null) type.setParent(this);
        this.var=var;
        if(var!=null) var.setParent(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type=type;
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var=var;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(type!=null) type.accept(visitor);
        if(var!=null) var.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(type!=null) type.traverseTopDown(visitor);
        if(var!=null) var.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(type!=null) type.traverseBottomUp(visitor);
        if(var!=null) var.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneFormalParameter(\n");

        if(type!=null)
            buffer.append(type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(var!=null)
            buffer.append(var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneFormalParameter]");
        return buffer.toString();
    }
}
