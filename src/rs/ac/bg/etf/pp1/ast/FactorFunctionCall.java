// generated with ast extension for cup
// version 0.8
// 2/1/2018 22:45:56


package rs.ac.bg.etf.pp1.ast;

public class FactorFunctionCall extends Factor {

    private Designator designator;
    private ActPars actPars;

    public FactorFunctionCall (Designator designator, ActPars actPars) {
        this.designator=designator;
        if(designator!=null) designator.setParent(this);
        this.actPars=actPars;
        if(actPars!=null) actPars.setParent(this);
    }

    public Designator getDesignator() {
        return designator;
    }

    public void setDesignator(Designator designator) {
        this.designator=designator;
    }

    public ActPars getActPars() {
        return actPars;
    }

    public void setActPars(ActPars actPars) {
        this.actPars=actPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(designator!=null) designator.accept(visitor);
        if(actPars!=null) actPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(designator!=null) designator.traverseTopDown(visitor);
        if(actPars!=null) actPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(designator!=null) designator.traverseBottomUp(visitor);
        if(actPars!=null) actPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorFunctionCall(\n");

        if(designator!=null)
            buffer.append(designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(actPars!=null)
            buffer.append(actPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorFunctionCall]");
        return buffer.toString();
    }
}
