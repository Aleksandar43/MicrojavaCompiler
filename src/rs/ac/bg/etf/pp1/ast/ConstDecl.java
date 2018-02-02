// generated with ast extension for cup
// version 0.8
// 2/1/2018 16:25:2


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type type;
    private ConstAssignmentList constAssignmentList;

    public ConstDecl (Type type, ConstAssignmentList constAssignmentList) {
        this.type=type;
        if(type!=null) type.setParent(this);
        this.constAssignmentList=constAssignmentList;
        if(constAssignmentList!=null) constAssignmentList.setParent(this);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type=type;
    }

    public ConstAssignmentList getConstAssignmentList() {
        return constAssignmentList;
    }

    public void setConstAssignmentList(ConstAssignmentList constAssignmentList) {
        this.constAssignmentList=constAssignmentList;
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
        if(type!=null) type.accept(visitor);
        if(constAssignmentList!=null) constAssignmentList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(type!=null) type.traverseTopDown(visitor);
        if(constAssignmentList!=null) constAssignmentList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(type!=null) type.traverseBottomUp(visitor);
        if(constAssignmentList!=null) constAssignmentList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(type!=null)
            buffer.append(type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(constAssignmentList!=null)
            buffer.append(constAssignmentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
