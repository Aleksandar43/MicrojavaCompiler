package rs.ac.bg.etf.pp1;
import java_cup.runtime.*;

%%

%class Lexer
%unicode
%cup
%line
%column

%{
StringBuffer string = new StringBuffer();
private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn);
}
private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value);
}
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f\b]
Comment = "//" {InputCharacter}* {LineTerminator}
Identifier = [:jletter:] ([:jletterdigit:]|_)*
NumConst = [0-9]+
Character = [ -~]
BoolConst = "true" | "false"
%state STRING

%%

/* keywords */
"program" {return symbol(sym.PROGRAM);}
"break" {return symbol(sym.BREAK);}
"class" {return symbol(sym.CLASS);}
"else" {return symbol(sym.ELSE);}
"const" {return symbol(sym.CONST);}
"if" {return symbol(sym.IF);}
"new" {return symbol(sym.NEW);}
"print" {return symbol(sym.PRINT);}
"read" {return symbol(sym.READ);}
"return" {return symbol(sym.RETURN);}
"void" {return symbol(sym.VOID);}
"extends" {return symbol(sym.EXTENDS);}
"continue" {return symbol(sym.CONTINUE);}
/* "for" {return symbol(sym.FOR);}
"static" {return symbol(sym.STATIC);}
"int" {return symbol(sym.INT);}
"char" {return symbol(sym.CHAR);}
"bool" {return symbol(sym.BOOL);}
"null" {return symbol(sym.NULL);}
"eol" {return symbol(sym.EOL);}
"chr" {return symbol(sym.CHR);}
"ord" {return symbol(sym.ORD);}*/

"+" {return symbol(sym.PLUS);}
"-" {return symbol(sym.MINUS);}
"*" {return symbol(sym.ASTERISK);}
"/" {return symbol(sym.SLASH);}
"%" {return symbol(sym.PERCENT);}
"==" {return symbol(sym.EQUALEQUAL);}
"!=" {return symbol(sym.NOTEQUAL);}
">" {return symbol(sym.GREATER);}
">=" {return symbol(sym.GREATEREQUAL);}
"<" {return symbol(sym.LESS);}
"<=" {return symbol(sym.LESSEQUAL);}
"&&" {return symbol(sym.AND);}
"||" {return symbol(sym.OR);}
"=" {return symbol(sym.EQUAL);}
"++" {return symbol(sym.PLUSPLUS);}
"--" {return symbol(sym.MINUSMINUS);}
";" {return symbol(sym.SEMICOLON);}
"," {return symbol(sym.COMMA);}
"." {return symbol(sym.DOT);}
"(" {return symbol(sym.LPAREN);}
")" {return symbol(sym.RPAREN);}
"[" {return symbol(sym.LSQUARE);}
"]" {return symbol(sym.RSQUARE);}
"{" {return symbol(sym.LBRACE);}
"}" {return symbol(sym.RBRACE);}
/* "+=" {return symbol(sym.PLUS_JEDNAKO);}
"-=" {return symbol(sym.MINUS_JEDNAKO);}
"*=" {return symbol(sym.PUTA_JEDNAKO);}
"/=" {return symbol(sym.PODELJENO_JEDNAKO);}
"%=" {return symbol(sym.PROCENAT_JEDNAKO);}
"..." {return symbol(sym.TRI_TACKE);}
*/

{NumConst} { return symbol(sym.NUMCONST, Integer.parseInt(yytext()));}
"'"{Character}"'" {return symbol(sym.CHARCONST, yycharat(1));}
{BoolConst} {return symbol(sym.BOOLCONST, yytext());}
{Identifier} { return symbol(sym.IDENTIFIER, yytext());}
{Comment} {}
/* Comment na kraju fajla */
"//".* {}
{WhiteSpace} { /* nothing */ }
/* error fallback */
. {System.out.println("Unrecognized character "+yytext()+" at line "+(yyline+1)+", column "+yycolumn);}