// generated with ast extension for cup
// version 0.8
// 4/1/2018 20:15:37


package rs.ac.bg.etf.pp1.ast;

public class ActualParameters extends ActPars {

    private ActParsList actParsList;

    public ActualParameters (ActParsList actParsList) {
        this.actParsList=actParsList;
        if(actParsList!=null) actParsList.setParent(this);
    }

    public ActParsList getActParsList() {
        return actParsList;
    }

    public void setActParsList(ActParsList actParsList) {
        this.actParsList=actParsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(actParsList!=null) actParsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(actParsList!=null) actParsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(actParsList!=null) actParsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParameters(\n");

        if(actParsList!=null)
            buffer.append(actParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParameters]");
        return buffer.toString();
    }
}
