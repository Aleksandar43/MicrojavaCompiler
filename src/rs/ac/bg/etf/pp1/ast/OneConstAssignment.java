// generated with ast extension for cup
// version 0.8
// 4/1/2018 1:37:50


package rs.ac.bg.etf.pp1.ast;

public class OneConstAssignment extends ConstAssignmentList {

    private ConstAssignment constAssignment;

    public OneConstAssignment (ConstAssignment constAssignment) {
        this.constAssignment=constAssignment;
        if(constAssignment!=null) constAssignment.setParent(this);
    }

    public ConstAssignment getConstAssignment() {
        return constAssignment;
    }

    public void setConstAssignment(ConstAssignment constAssignment) {
        this.constAssignment=constAssignment;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(constAssignment!=null) constAssignment.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(constAssignment!=null) constAssignment.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(constAssignment!=null) constAssignment.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OneConstAssignment(\n");

        if(constAssignment!=null)
            buffer.append(constAssignment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OneConstAssignment]");
        return buffer.toString();
    }
}
