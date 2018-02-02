// generated with ast extension for cup
// version 0.8
// 2/1/2018 16:25:2


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclVar extends ProgramDecl {

    private VarDecl varDecl;

    public ProgramDeclVar (VarDecl varDecl) {
        this.varDecl=varDecl;
        if(varDecl!=null) varDecl.setParent(this);
    }

    public VarDecl getVarDecl() {
        return varDecl;
    }

    public void setVarDecl(VarDecl varDecl) {
        this.varDecl=varDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(varDecl!=null) varDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(varDecl!=null) varDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(varDecl!=null) varDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclVar(\n");

        if(varDecl!=null)
            buffer.append(varDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclVar]");
        return buffer.toString();
    }
}
