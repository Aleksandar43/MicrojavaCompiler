// generated with ast extension for cup
// version 0.8
// 31/0/2018 18:43:29


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDerived1 extends VarDecl {

    private Type type;
    private VarList varList;

    public VarDeclDerived1 (Type type, VarList varList) {
        this.type=type;
        if(type!=null) type.setParent(this);
        this.varList=varList;
        if(varList!=null) varList.setParent(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type=type;
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
        if(type!=null) type.accept(visitor);
        if(varList!=null) varList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(type!=null) type.traverseTopDown(visitor);
        if(varList!=null) varList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(type!=null) type.traverseBottomUp(visitor);
        if(varList!=null) varList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclDerived1(\n");

        if(type!=null)
            buffer.append(type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(varList!=null)
            buffer.append(varList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDerived1]");
        return buffer.toString();
    }
}
