// generated with ast extension for cup
// version 0.8
// 4/1/2018 1:37:49


package rs.ac.bg.etf.pp1.ast;

public class ProgramDeclarations extends ProgramDeclList {

    private ProgramDecl programDecl;
    private ProgramDeclList programDeclList;

    public ProgramDeclarations (ProgramDecl programDecl, ProgramDeclList programDeclList) {
        this.programDecl=programDecl;
        if(programDecl!=null) programDecl.setParent(this);
        this.programDeclList=programDeclList;
        if(programDeclList!=null) programDeclList.setParent(this);
    }

    public ProgramDecl getProgramDecl() {
        return programDecl;
    }

    public void setProgramDecl(ProgramDecl programDecl) {
        this.programDecl=programDecl;
    }

    public ProgramDeclList getProgramDeclList() {
        return programDeclList;
    }

    public void setProgramDeclList(ProgramDeclList programDeclList) {
        this.programDeclList=programDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(programDecl!=null) programDecl.accept(visitor);
        if(programDeclList!=null) programDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(programDecl!=null) programDecl.traverseTopDown(visitor);
        if(programDeclList!=null) programDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(programDecl!=null) programDecl.traverseBottomUp(visitor);
        if(programDeclList!=null) programDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDeclarations(\n");

        if(programDecl!=null)
            buffer.append(programDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(programDeclList!=null)
            buffer.append(programDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDeclarations]");
        return buffer.toString();
    }
}
