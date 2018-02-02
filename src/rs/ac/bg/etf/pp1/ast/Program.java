// generated with ast extension for cup
// version 0.8
// 2/1/2018 3:14:35


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private ProgramDeclList programDeclList;
    private MethodDecl methodDecl;

    public Program (String I1, ProgramDeclList programDeclList, MethodDecl methodDecl) {
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

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("Program(\n");

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
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
