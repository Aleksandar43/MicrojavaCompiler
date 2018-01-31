// generated with ast extension for cup
// version 0.8
// 31/0/2018 18:43:29


package rs.ac.bg.etf.pp1.ast;

public class ConstAssignmentListDerived1 extends ConstAssignmentList {

    private ConstAssignment constAssignment;
    private ConstAssignmentList constAssignmentList;

    public ConstAssignmentListDerived1 (ConstAssignment constAssignment, ConstAssignmentList constAssignmentList) {
        this.constAssignment=constAssignment;
        if(constAssignment!=null) constAssignment.setParent(this);
        this.constAssignmentList=constAssignmentList;
        if(constAssignmentList!=null) constAssignmentList.setParent(this);
    }

    public ConstAssignment getConstAssignment() {
        return constAssignment;
    }

    public void setConstAssignment(ConstAssignment constAssignment) {
        this.constAssignment=constAssignment;
    }

    public ConstAssignmentList getConstAssignmentList() {
        return constAssignmentList;
    }

    public void setConstAssignmentList(ConstAssignmentList constAssignmentList) {
        this.constAssignmentList=constAssignmentList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(constAssignment!=null) constAssignment.accept(visitor);
        if(constAssignmentList!=null) constAssignmentList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(constAssignment!=null) constAssignment.traverseTopDown(visitor);
        if(constAssignmentList!=null) constAssignmentList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(constAssignment!=null) constAssignment.traverseBottomUp(visitor);
        if(constAssignmentList!=null) constAssignmentList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstAssignmentListDerived1(\n");

        if(constAssignment!=null)
            buffer.append(constAssignment.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(constAssignmentList!=null)
            buffer.append(constAssignmentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstAssignmentListDerived1]");
        return buffer.toString();
    }
}
