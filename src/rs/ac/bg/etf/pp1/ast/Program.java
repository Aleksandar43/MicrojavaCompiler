// generated with ast extension for cup
// version 0.8
// 4/1/2018 20:15:36


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgramName programName;
    private ProgramDeclList programDeclList;
    private MethodDecl methodDecl;

    public Program (ProgramName programName, ProgramDeclList programDeclList, MethodDecl methodDecl) {
        this.programName=programName;
        if(programName!=null) programName.setParent(this);
        this.programDeclList=programDeclList;
        if(programDeclList!=null) programDeclList.setParent(this);
        this.methodDecl=methodDecl;
        if(methodDecl!=null) methodDecl.setParent(this);
    }

    public ProgramName getProgramName() {
        return programName;
    }

    public void setProgramName(ProgramName programName) {
        this.programName=programName;
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
        if(programName!=null) programName.accept(visitor);
        if(programDeclList!=null) programDeclList.accept(visitor);
        if(methodDecl!=null) methodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(programName!=null) programName.traverseTopDown(visitor);
        if(programDeclList!=null) programDeclList.traverseTopDown(visitor);
        if(methodDecl!=null) methodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(programName!=null) programName.traverseBottomUp(visitor);
        if(programDeclList!=null) programDeclList.traverseBottomUp(visitor);
        if(methodDecl!=null) methodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(programName!=null)
            buffer.append(programName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
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
