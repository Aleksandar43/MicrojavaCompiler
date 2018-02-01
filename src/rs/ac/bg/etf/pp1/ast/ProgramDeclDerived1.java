// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:5


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclDerived1 extends ProgramDecl {

    private ConstDecl constDecl;

    public ProgramDeclDerived1 (ConstDecl constDecl) {
        this.constDecl=constDecl;
        if(constDecl!=null) constDecl.setParent(this);
    }

    public ConstDecl getConstDecl() {
        return constDecl;
    }

    public void setConstDecl(ConstDecl constDecl) {
        this.constDecl=constDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(constDecl!=null) constDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(constDecl!=null) constDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(constDecl!=null) constDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclDerived1(\n");

        if(constDecl!=null)
            buffer.append(constDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclDerived1]");
        return buffer.toString();
    }
}
