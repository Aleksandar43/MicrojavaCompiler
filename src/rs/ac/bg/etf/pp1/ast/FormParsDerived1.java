// generated with ast extension for cup
// version 0.8
// 31/0/2018 2:6:37


package rs.ac.bg.etf.pp1.ast;

public class FormParsDerived1 extends FormPars {

    private FormParsList formParsList;

    public FormParsDerived1 (FormParsList formParsList) {
        this.formParsList=formParsList;
        if(formParsList!=null) formParsList.setParent(this);
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
        if(formParsList!=null) formParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(formParsList!=null) formParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(formParsList!=null) formParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsDerived1(\n");

        if(formParsList!=null)
            buffer.append(formParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsDerived1]");
        return buffer.toString();
    }
}
