// generated with ast extension for cup
// version 0.8
// 2/1/2018 16:25:3


package rs.ac.bg.etf.pp1.ast;

public class OneVarDecl extends VarList {

    private Var var;

    public OneVarDecl (Var var) {
        this.var=var;
        if(var!=null) var.setParent(this);
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
        if(var!=null) var.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(var!=null) var.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(var!=null) var.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneVarDecl(\n");

        if(var!=null)
            buffer.append(var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneVarDecl]");
        return buffer.toString();
    }
}
