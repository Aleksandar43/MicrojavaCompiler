// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:6


package rs.ac.bg.etf.pp1.ast;

public class ClassMethodDeclDerived1 extends ClassMethodDecl {

    private MethodDecl methodDecl;

    public ClassMethodDeclDerived1 (MethodDecl methodDecl) {
        this.methodDecl=methodDecl;
        if(methodDecl!=null) methodDecl.setParent(this);
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
        if(methodDecl!=null) methodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(methodDecl!=null) methodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(methodDecl!=null) methodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassMethodDeclDerived1(\n");

        if(methodDecl!=null)
            buffer.append(methodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassMethodDeclDerived1]");
        return buffer.toString();
    }
}
