// generated with ast extension for cup
// version 0.8
// 3/1/2018 17:26:16


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ClassExtension classExtension);
    public void visit(Designator designator);
    public void visit(OtherStatements otherStatements);
    public void visit(ConstAssignmentList constAssignmentList);
    public void visit(Condition condition);
    public void visit(DesignatorStatement designatorStatement);
    public void visit(ProgramDecl programDecl);
    public void visit(Mulop mulop);
    public void visit(Relop relop);
    public void visit(CondFact condFact);
    public void visit(VarList varList);
    public void visit(FormPars formPars);
    public void visit(Var var);
    public void visit(ActParsList actParsList);
    public void visit(Statement statement);
    public void visit(Addop addop);
    public void visit(ClassMethodDecl classMethodDecl);
    public void visit(Term term);
    public void visit(Constant constant);
    public void visit(ReturnType returnType);
    public void visit(MethodDecl methodDecl);
    public void visit(StatementList statementList);
    public void visit(FormParsList formParsList);
    public void visit(ProgramDeclList programDeclList);
    public void visit(ActPars actPars);
    public void visit(Expr expr);
    public void visit(LocalVarDecl localVarDecl);
    public void visit(CondTerm condTerm);
    public void visit(Factor factor);
    public void visit(VarDecl varDecl);
    public void visit(IfChainWithUnmatched ifChainWithUnmatched);
    public void visit(ModuleOp ModuleOp);
    public void visit(DivisionOp DivisionOp);
    public void visit(MultiplicationOp MultiplicationOp);
    public void visit(SubtractionOp SubtractionOp);
    public void visit(AdditionOp AdditionOp);
    public void visit(ArrayElementDesignator ArrayElementDesignator);
    public void visit(ClassField ClassField);
    public void visit(SimpleDesignator SimpleDesignator);
    public void visit(FactorNewArrayAllocation FactorNewArrayAllocation);
    public void visit(FactorNewClassInstance FactorNewClassInstance);
    public void visit(FactorFunctionCall FactorFunctionCall);
    public void visit(FactorExpressionInParentheses FactorExpressionInParentheses);
    public void visit(FactorConstant FactorConstant);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(TermMulOp TermMulOp);
    public void visit(TermFactor TermFactor);
    public void visit(ExpressionAddOp ExpressionAddOp);
    public void visit(ExpressionNegation ExpressionNegation);
    public void visit(ExpressionTerm ExpressionTerm);
    public void visit(LessOrEqualOp LessOrEqualOp);
    public void visit(LessOp LessOp);
    public void visit(GreaterOrEqualOp GreaterOrEqualOp);
    public void visit(GreaterOp GreaterOp);
    public void visit(NotEqualOp NotEqualOp);
    public void visit(EqualOp EqualOp);
    public void visit(ConditionExpression ConditionExpression);
    public void visit(ConditionRelation ConditionRelation);
    public void visit(LogicalAnd LogicalAnd);
    public void visit(ConditionFact ConditionFact);
    public void visit(LogicalOr LogicalOr);
    public void visit(ConditionTerm ConditionTerm);
    public void visit(OneActualParameter OneActualParameter);
    public void visit(MultipleActualParameters MultipleActualParameters);
    public void visit(NoActualParameters NoActualParameters);
    public void visit(ActualParameters ActualParameters);
    public void visit(FunctionCall FunctionCall);
    public void visit(Decrement Decrement);
    public void visit(Increment Increment);
    public void visit(Assignment Assignment);
    public void visit(StatementBlock StatementBlock);
    public void visit(DoWhileLoop DoWhileLoop);
    public void visit(IfWithMatchedInElse IfWithMatchedInElse);
    public void visit(ReturnNonVoid ReturnNonVoid);
    public void visit(ReturnVoid ReturnVoid);
    public void visit(PrintSimple PrintSimple);
    public void visit(PrintWithWidth PrintWithWidth);
    public void visit(Read Read);
    public void visit(Continue Continue);
    public void visit(Break Break);
    public void visit(StatementWithDesignator StatementWithDesignator);
    public void visit(IfWithUnmatchedInElse IfWithUnmatchedInElse);
    public void visit(IfWithoutElse IfWithoutElse);
    public void visit(ErrorStatement ErrorStatement);
    public void visit(NotIfsUnmatched NotIfsUnmatched);
    public void visit(IfsUnmatched IfsUnmatched);
    public void visit(NoStatements NoStatements);
    public void visit(Statements Statements);
    public void visit(OneFormalParameter OneFormalParameter);
    public void visit(MultipleFormalParameters MultipleFormalParameters);
    public void visit(NoFormalParameters NoFormalParameters);
    public void visit(FormalParameters FormalParameters);
    public void visit(ReturnTypeVoid ReturnTypeVoid);
    public void visit(ReturnTypeNonVoid ReturnTypeNonVoid);
    public void visit(NoMethodDeclarations NoMethodDeclarations);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(NoClassMethods NoClassMethods);
    public void visit(ClassMethods ClassMethods);
    public void visit(NoLocalVarDeclarations NoLocalVarDeclarations);
    public void visit(LocalVarDeclarations LocalVarDeclarations);
    public void visit(NoExtension NoExtension);
    public void visit(Extension Extension);
    public void visit(ClassDecl ClassDecl);
    public void visit(ErrorVar ErrorVar);
    public void visit(ArrayVar ArrayVar);
    public void visit(ScalarVar ScalarVar);
    public void visit(OneVarDecl OneVarDecl);
    public void visit(MultipleVarDecls MultipleVarDecls);
    public void visit(ErrorVarDecl ErrorVarDecl);
    public void visit(VarDeclNoError VarDeclNoError);
    public void visit(BooleanConstant BooleanConstant);
    public void visit(CharacterConstant CharacterConstant);
    public void visit(NumberConstant NumberConstant);
    public void visit(Type Type);
    public void visit(ConstName ConstName);
    public void visit(ConstAssignment ConstAssignment);
    public void visit(OneConstAssignment OneConstAssignment);
    public void visit(MultipleConstAssignments MultipleConstAssignments);
    public void visit(ConstDecl ConstDecl);
    public void visit(ProgramDeclClass ProgramDeclClass);
    public void visit(ProgramDeclVar ProgramDeclVar);
    public void visit(ProgramDeclConstant ProgramDeclConstant);
    public void visit(NoProgramDeclarations NoProgramDeclarations);
    public void visit(ProgramDeclarations ProgramDeclarations);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
