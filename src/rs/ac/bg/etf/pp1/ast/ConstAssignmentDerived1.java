// generated with ast extension for cup
// version 0.8
// 31/0/2018 23:14:13


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignmentDerived1 extends ConstAssignment {

    private String I1;
    private Constant constant;

    public ConstAssignmentDerived1 (String I1, Constant constant) {
        this.I1=I1;
        this.constant=constant;
        if(constant!=null) constant.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Constant getConstant() {
        return constant;
    }

    public void setConstant(Constant constant) {
        this.constant=constant;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(constant!=null) constant.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(constant!=null) constant.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(constant!=null) constant.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstAssignmentDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(constant!=null)
            buffer.append(constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignmentDerived1]");
        return buffer.toString();
    }
}
