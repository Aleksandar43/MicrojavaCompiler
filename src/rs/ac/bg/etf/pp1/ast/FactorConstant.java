// generated with ast extension for cup
// version 0.8
// 3/1/2018 17:26:15


package rs.ac.bg.etf.pp1.ast;

public class FactorConstant extends Factor {

    private Constant constant;

    public FactorConstant (Constant constant) {
        this.constant=constant;
        if(constant!=null) constant.setParent(this);
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
        buffer.append("FactorConstant(\n");

        if(constant!=null)
            buffer.append(constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorConstant]");
        return buffer.toString();
    }
}
