// generated with ast extension for cup
// version 0.8
// 31/0/2018 18:43:29


package rs.ac.bg.etf.pp1.ast;

public class FormParsListDerived1 extends FormParsList {

    private Type type;
    private Var var;
    private FormParsList formParsList;

    public FormParsListDerived1 (Type type, Var var, FormParsList formParsList) {
        this.type=type;
        if(type!=null) type.setParent(this);
        this.var=var;
        if(var!=null) var.setParent(this);
        this.formParsList=formParsList;
        if(formParsList!=null) formParsList.setParent(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type=type;
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var=var;
    }

    public FormParsList getFormParsList() {
        return formParsList;
    }

    public void setFormParsList(FormParsList formParsList) {
        this.formParsList=formParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(type!=null) type.accept(visitor);
        if(var!=null) var.accept(visitor);
        if(formParsList!=null) formParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(type!=null) type.traverseTopDown(visitor);
        if(var!=null) var.traverseTopDown(visitor);
        if(formParsList!=null) formParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(type!=null) type.traverseBottomUp(visitor);
        if(var!=null) var.traverseBottomUp(visitor);
        if(formParsList!=null) formParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsListDerived1(\n");

        if(type!=null)
            buffer.append(type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(var!=null)
            buffer.append(var.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(formParsList!=null)
            buffer.append(formParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsListDerived1]");
        return buffer.toString();
    }
}
