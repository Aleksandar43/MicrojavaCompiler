// generated with ast extension for cup
// version 0.8
// 4/1/2018 1:37:50


package rs.ac.bg.etf.pp1.ast;

public class MethodHeader implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ReturnType returnType;
    private MethodName methodName;
    private FormPars formPars;
    private LocalVarDecl localVarDecl;

    public MethodHeader (ReturnType returnType, MethodName methodName, FormPars formPars, LocalVarDecl localVarDecl) {
        this.returnType=returnType;
        if(returnType!=null) returnType.setParent(this);
        this.methodName=methodName;
        if(methodName!=null) methodName.setParent(this);
        this.formPars=formPars;
        if(formPars!=null) formPars.setParent(this);
        this.localVarDecl=localVarDecl;
        if(localVarDecl!=null) localVarDecl.setParent(this);
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType=returnType;
    }

    public MethodName getMethodName() {
        return methodName;
    }

    public void setMethodName(MethodName methodName) {
        this.methodName=methodName;
    }

    public FormPars getFormPars() {
        return formPars;
    }

    public void setFormPars(FormPars formPars) {
        this.formPars=formPars;
    }

    public LocalVarDecl getLocalVarDecl() {
        return localVarDecl;
    }

    public void setLocalVarDecl(LocalVarDecl localVarDecl) {
        this.localVarDecl=localVarDecl;
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
        if(returnType!=null) returnType.accept(visitor);
        if(methodName!=null) methodName.accept(visitor);
        if(formPars!=null) formPars.accept(visitor);
        if(localVarDecl!=null) localVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(returnType!=null) returnType.traverseTopDown(visitor);
        if(methodName!=null) methodName.traverseTopDown(visitor);
        if(formPars!=null) formPars.traverseTopDown(visitor);
        if(localVarDecl!=null) localVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(returnType!=null) returnType.traverseBottomUp(visitor);
        if(methodName!=null) methodName.traverseBottomUp(visitor);
        if(formPars!=null) formPars.traverseBottomUp(visitor);
        if(localVarDecl!=null) localVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodHeader(\n");

        if(returnType!=null)
            buffer.append(returnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(methodName!=null)
            buffer.append(methodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(formPars!=null)
            buffer.append(formPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(localVarDecl!=null)
            buffer.append(localVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodHeader]");
        return buffer.toString();
    }
}
