// generated with ast extension for cup
// version 0.8
// 2/1/2018 16:25:3


package rs.ac.bg.etf.pp1.ast;

public class MultipleVarDecls extends VarList {

    private Var var;
    private VarList varList;

    public MultipleVarDecls (Var var, VarList varList) {
        this.var=var;
        if(var!=null) var.setParent(this);
        this.varList=varList;
        if(varList!=null) varList.setParent(this);
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var=var;
    }

    public VarList getVarList() {
        return varList;
    }

    public void setVarList(VarList varList) {
        this.varList=varList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(var!=null) var.accept(visitor);
        if(varList!=null) varList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(var!=null) var.traverseTopDown(visitor);
        if(varList!=null) varList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(var!=null) var.traverseBottomUp(visitor);
        if(varList!=null) varList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleVarDecls(\n");

        if(var!=null)
            buffer.append(var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(varList!=null)
            buffer.append(varList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleVarDecls]");
        return buffer.toString();
    }
}
