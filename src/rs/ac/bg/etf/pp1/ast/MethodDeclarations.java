// generated with ast extension for cup
// version 0.8
// 4/1/2018 20:15:37


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclarations extends MethodDecl {

    private MethodDecl methodDecl;
    private MethodHeader methodHeader;
    private StatementList statementList;

    public MethodDeclarations (MethodDecl methodDecl, MethodHeader methodHeader, StatementList statementList) {
        this.methodDecl=methodDecl;
        if(methodDecl!=null) methodDecl.setParent(this);
        this.methodHeader=methodHeader;
        if(methodHeader!=null) methodHeader.setParent(this);
        this.statementList=statementList;
        if(statementList!=null) statementList.setParent(this);
    }

    public MethodDecl getMethodDecl() {
        return methodDecl;
    }

    public void setMethodDecl(MethodDecl methodDecl) {
        this.methodDecl=methodDecl;
    }

    public MethodHeader getMethodHeader() {
        return methodHeader;
    }

    public void setMethodHeader(MethodHeader methodHeader) {
        this.methodHeader=methodHeader;
    }

    public StatementList getStatementList() {
        return statementList;
    }

    public void setStatementList(StatementList statementList) {
        this.statementList=statementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(methodDecl!=null) methodDecl.accept(visitor);
        if(methodHeader!=null) methodHeader.accept(visitor);
        if(statementList!=null) statementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(methodDecl!=null) methodDecl.traverseTopDown(visitor);
        if(methodHeader!=null) methodHeader.traverseTopDown(visitor);
        if(statementList!=null) statementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(methodDecl!=null) methodDecl.traverseBottomUp(visitor);
        if(methodHeader!=null) methodHeader.traverseBottomUp(visitor);
        if(statementList!=null) statementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclarations(\n");

        if(methodDecl!=null)
            buffer.append(methodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(methodHeader!=null)
            buffer.append(methodHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(statementList!=null)
            buffer.append(statementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclarations]");
        return buffer.toString();
    }
}
