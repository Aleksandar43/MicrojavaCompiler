// generated with ast extension for cup
// version 0.8
// 31/0/2018 23:14:14


package rs.ac.bg.etf.pp1.ast;

public class LocalVarDeclDerived1 extends LocalVarDecl {

    private VarDecl varDecl;
    private LocalVarDecl localVarDecl;

    public LocalVarDeclDerived1 (VarDecl varDecl, LocalVarDecl localVarDecl) {
        this.varDecl=varDecl;
        if(varDecl!=null) varDecl.setParent(this);
        this.localVarDecl=localVarDecl;
        if(localVarDecl!=null) localVarDecl.setParent(this);
    }

    public VarDecl getVarDecl() {
        return varDecl;
    }

    public void setVarDecl(VarDecl varDecl) {
        this.varDecl=varDecl;
    }

    public LocalVarDecl getLocalVarDecl() {
        return localVarDecl;
    }

    public void setLocalVarDecl(LocalVarDecl localVarDecl) {
        this.localVarDecl=localVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(varDecl!=null) varDecl.accept(visitor);
        if(localVarDecl!=null) localVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(varDecl!=null) varDecl.traverseTopDown(visitor);
        if(localVarDecl!=null) localVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(varDecl!=null) varDecl.traverseBottomUp(visitor);
        if(localVarDecl!=null) localVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVarDeclDerived1(\n");

        if(varDecl!=null)
            buffer.append(varDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(localVarDecl!=null)
            buffer.append(localVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVarDeclDerived1]");
        return buffer.toString();
    }
}
