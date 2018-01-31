// generated with ast extension for cup
// version 0.8
// 31/0/2018 18:43:29


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclDerived1 extends MethodDecl {

    private ReturnType returnType;
    private String I2;
    private FormPars formPars;
    private LocalVarDecl localVarDecl;
    private StatementList statementList;
    private MethodDecl methodDecl;

    public MethodDeclDerived1 (ReturnType returnType, String I2, FormPars formPars, LocalVarDecl localVarDecl, StatementList statementList, MethodDecl methodDecl) {
        this.returnType=returnType;
        if(returnType!=null) returnType.setParent(this);
        this.I2=I2;
        this.formPars=formPars;
        if(formPars!=null) formPars.setParent(this);
        this.localVarDecl=localVarDecl;
        if(localVarDecl!=null) localVarDecl.setParent(this);
        this.statementList=statementList;
        if(statementList!=null) statementList.setParent(this);
        this.methodDecl=methodDecl;
        if(methodDecl!=null) methodDecl.setParent(this);
    }

    public ReturnType getReturnType() {
        return returnType;
    }

    public void setReturnType(ReturnType returnType) {
        this.returnType=returnType;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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

    public StatementList getStatementList() {
        return statementList;
    }

    public void setStatementList(StatementList statementList) {
        this.statementList=statementList;
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
        if(returnType!=null) returnType.accept(visitor);
        if(formPars!=null) formPars.accept(visitor);
        if(localVarDecl!=null) localVarDecl.accept(visitor);
        if(statementList!=null) statementList.accept(visitor);
        if(methodDecl!=null) methodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(returnType!=null) returnType.traverseTopDown(visitor);
        if(formPars!=null) formPars.traverseTopDown(visitor);
        if(localVarDecl!=null) localVarDecl.traverseTopDown(visitor);
        if(statementList!=null) statementList.traverseTopDown(visitor);
        if(methodDecl!=null) methodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(returnType!=null) returnType.traverseBottomUp(visitor);
        if(formPars!=null) formPars.traverseBottomUp(visitor);
        if(localVarDecl!=null) localVarDecl.traverseBottomUp(visitor);
        if(statementList!=null) statementList.traverseBottomUp(visitor);
        if(methodDecl!=null) methodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclDerived1(\n");

        if(returnType!=null)
            buffer.append(returnType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
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

        if(statementList!=null)
            buffer.append(statementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(methodDecl!=null)
            buffer.append(methodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclDerived1]");
        return buffer.toString();
    }
}
