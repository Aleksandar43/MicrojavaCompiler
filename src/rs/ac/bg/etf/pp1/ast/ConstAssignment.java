// generated with ast extension for cup
// version 0.8
// 4/1/2018 17:40:4


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignment implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ConstName constName;
    private Constant constant;

    public ConstAssignment (ConstName constName, Constant constant) {
        this.constName=constName;
        if(constName!=null) constName.setParent(this);
        this.constant=constant;
        if(constant!=null) constant.setParent(this);
    }

    public ConstName getConstName() {
        return constName;
    }

    public void setConstName(ConstName constName) {
        this.constName=constName;
    }

    public Constant getConstant() {
        return constant;
    }

    public void setConstant(Constant constant) {
        this.constant=constant;
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
        if(constName!=null) constName.accept(visitor);
        if(constant!=null) constant.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(constName!=null) constName.traverseTopDown(visitor);
        if(constant!=null) constant.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(constName!=null) constName.traverseBottomUp(visitor);
        if(constant!=null) constant.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstAssignment(\n");

        if(constName!=null)
            buffer.append(constName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(constant!=null)
            buffer.append(constant.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignment]");
        return buffer.toString();
    }
}
