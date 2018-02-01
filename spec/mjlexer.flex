package rs.ac.bg.etf.pp1;
import java_cup.runtime.*;

%%

%class Lexer
%unicode
%cup
%line
%column
%standalone

%{
StringBuffer string = new StringBuffer();
private Symbol symbol(int type) {
	return new Symbol(type, yyline+1, yycolumn);
}
private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline+1, yycolumn, value);
}
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f\b]
Comment = "//" {InputCharacter}*
Identifier = [:jletter:] ([:jletterdigit:]|_)*
NumConst = [0-9]+
Character = [ -~]
BoolConst = "true" | "false"
%state STRING

%%

/* keywords */
"program" {return symbol(sym.PROGRAM , yytext());}
"break" {return symbol(sym.BREAK , yytext());}
"class" {return symbol(sym.CLASS , yytext());}
"else" {return symbol(sym.ELSE , yytext());}
"if" {return symbol(sym.IF , yytext());}
"new" {return symbol(sym.NEW , yytext());}
"print" {return symbol(sym.PRINT , yytext());}
"read" {return symbol(sym.READ , yytext());}
"return" {return symbol(sym.RETURN , yytext());}
"void" {return symbol(sym.VOID , yytext());}
"do" {return symbol(sym.DO , yytext());}
"while" {return symbol(sym.WHILE , yytext());}
"extends" {return symbol(sym.EXTENDS , yytext());}
"continue" {return symbol(sym.CONTINUE , yytext());}
"const" {return symbol(sym.CONST , yytext());}

/* "for" {return symbol(sym.FOR);}
"static" {return symbol(sym.STATIC);}
"int" {return symbol(sym.INT);}
"char" {return symbol(sym.CHAR);}
"bool" {return symbol(sym.BOOL);}
"null" {return symbol(sym.NULL);}
"eol" {return symbol(sym.EOL);}
"chr" {return symbol(sym.CHR);}
"ord" {return symbol(sym.ORD);}*/

"+" {return symbol(sym.PLUS , yytext());}
"-" {return symbol(sym.MINUS , yytext());}
"*" {return symbol(sym.ASTERISK , yytext());}
"/" {return symbol(sym.SLASH , yytext());}
"%" {return symbol(sym.PERCENT , yytext());}
"==" {return symbol(sym.EQUALEQUAL , yytext());}
"!=" {return symbol(sym.NOTEQUAL , yytext());}
">" {return symbol(sym.GREATER , yytext());}
">=" {return symbol(sym.GREATEREQUAL , yytext());}
"<" {return symbol(sym.LESS , yytext());}
"<=" {return symbol(sym.LESSEQUAL , yytext());}
"&&" {return symbol(sym.AND , yytext());}
"||" {return symbol(sym.OR , yytext());}
"=" {return symbol(sym.EQUAL , yytext());}
"++" {return symbol(sym.PLUSPLUS , yytext());}
"--" {return symbol(sym.MINUSMINUS , yytext());}
";" {return symbol(sym.SEMICOLON , yytext());}
"," {return symbol(sym.COMMA , yytext());}
"." {return symbol(sym.DOT , yytext());}
"(" {return symbol(sym.LPAREN , yytext());}
")" {return symbol(sym.RPAREN , yytext());}
"[" {return symbol(sym.LSQUARE , yytext());}
"]" {return symbol(sym.RSQUARE , yytext());}
"{" {return symbol(sym.LBRACE , yytext());}
"}" {return symbol(sym.RBRACE , yytext());}
/* "+=" {return symbol(sym.PLUS_JEDNAKO);}
"-=" {return symbol(sym.MINUS_JEDNAKO);}
"*=" {return symbol(sym.PUTA_JEDNAKO);}
"/=" {return symbol(sym.PODELJENO_JEDNAKO);}
"%=" {return symbol(sym.PROCENAT_JEDNAKO);}
"..." {return symbol(sym.TRI_TACKE);}
*/

{NumConst} { return symbol(sym.NUMCONST, Integer.parseInt(yytext()));}
"'"{Character}"'" {return symbol(sym.CHARCONST, yycharat(1));}
{BoolConst} {return symbol(sym.BOOLCONST, Boolean.parseBoolean(yytext()));}
{Identifier} { return symbol(sym.IDENTIFIER, yytext());}
{Comment} { /* comment */ }
{WhiteSpace} { /* nothing */ }
/* error fallback */
. {System.out.println("Unrecognized character "+yytext()+" at line "+(yyline+1)+", column "+yycolumn);}