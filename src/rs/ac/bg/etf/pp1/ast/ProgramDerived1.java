// generated with ast extension for cup
// version 0.8
// 31/0/2018 23:14:13


package rs.ac.bg.etf.pp1.ast;

public class ProgramDerived1 extends Program {

    private String I1;
    private ProgramDeclList programDeclList;
    private MethodDecl methodDecl;

    public ProgramDerived1 (String I1, ProgramDeclList programDeclList, MethodDecl methodDecl) {
        this.I1=I1;
        this.programDeclList=programDeclList;
        if(programDeclList!=null) programDeclList.setParent(this);
        this.methodDecl=methodDecl;
        if(methodDecl!=null) methodDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ProgramDeclList getProgramDeclList() {
        return programDeclList;
    }

    public void setProgramDeclList(ProgramDeclList programDeclList) {
        this.programDeclList=programDeclList;
    }

    public MethodDecl getMethodDecl() {
        return methodDecl;
    }

    public void setMethodDecl(MethodDecl methodDecl) {
        this.methodDecl=methodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(programDeclList!=null) programDeclList.accept(visitor);
        if(methodDecl!=null) methodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(programDeclList!=null) programDeclList.traverseTopDown(visitor);
        if(methodDecl!=null) methodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(programDeclList!=null) programDeclList.traverseBottomUp(visitor);
        if(methodDecl!=null) methodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(programDeclList!=null)
            buffer.append(programDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(methodDecl!=null)
            buffer.append(methodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDerived1]");
        return buffer.toString();
    }
}
