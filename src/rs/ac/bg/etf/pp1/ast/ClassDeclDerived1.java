// generated with ast extension for cup
// version 0.8
// 1/1/2018 4:18:5


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclDerived1 extends ClassDecl {

    private String I1;
    private ClassExtension classExtension;
    private LocalVarDecl localVarDecl;
    private ClassMethodDecl classMethodDecl;

    public ClassDeclDerived1 (String I1, ClassExtension classExtension, LocalVarDecl localVarDecl, ClassMethodDecl classMethodDecl) {
        this.I1=I1;
        this.classExtension=classExtension;
        if(classExtension!=null) classExtension.setParent(this);
        this.localVarDecl=localVarDecl;
        if(localVarDecl!=null) localVarDecl.setParent(this);
        this.classMethodDecl=classMethodDecl;
        if(classMethodDecl!=null) classMethodDecl.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ClassExtension getClassExtension() {
        return classExtension;
    }

    public void setClassExtension(ClassExtension classExtension) {
        this.classExtension=classExtension;
    }

    public LocalVarDecl getLocalVarDecl() {
        return localVarDecl;
    }

    public void setLocalVarDecl(LocalVarDecl localVarDecl) {
        this.localVarDecl=localVarDecl;
    }

    public ClassMethodDecl getClassMethodDecl() {
        return classMethodDecl;
    }

    public void setClassMethodDecl(ClassMethodDecl classMethodDecl) {
        this.classMethodDecl=classMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(classExtension!=null) classExtension.accept(visitor);
        if(localVarDecl!=null) localVarDecl.accept(visitor);
        if(classMethodDecl!=null) classMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(classExtension!=null) classExtension.traverseTopDown(visitor);
        if(localVarDecl!=null) localVarDecl.traverseTopDown(visitor);
        if(classMethodDecl!=null) classMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(classExtension!=null) classExtension.traverseBottomUp(visitor);
        if(localVarDecl!=null) localVarDecl.traverseBottomUp(visitor);
        if(classMethodDecl!=null) classMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(classExtension!=null)
            buffer.append(classExtension.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(localVarDecl!=null)
            buffer.append(localVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(classMethodDecl!=null)
            buffer.append(classMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclDerived1]");
        return buffer.toString();
    }
}
