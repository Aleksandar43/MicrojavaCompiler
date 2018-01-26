package rs.ac.bg.etf.pp1;
import java_cup.runtime.*;

%%

%class Lekser
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
WhiteSpace = {LineTerminator} | [ \t\f\b\f]
Komentar = "//" {InputCharacter}* {LineTerminator}
Identifikator = [:jletter:] ([:jletterdigit:]|_)*
BrojKonstanta = [0-9]+
Karakter = [ -~]
BoolKonstanta = "true" | "false"
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
"for" {return symbol(sym.FOR);}
"extends" {return symbol(sym.EXTENDS);}
"continue" {return symbol(sym.CONTINUE);}
"static" {return symbol(sym.STATIC);}
/*"int" {return symbol(sym.INT);}
"char" {return symbol(sym.CHAR);}
"bool" {return symbol(sym.BOOL);}
"null" {return symbol(sym.NULL);}
"eol" {return symbol(sym.EOL);}
"chr" {return symbol(sym.CHR);}
"ord" {return symbol(sym.ORD);}*/

"+" {return symbol(sym.PLUS);}
"-" {return symbol(sym.MINUS);}
"*" {return symbol(sym.PUTA);}
"/" {return symbol(sym.PODELJENO);}
"%" {return symbol(sym.PROCENAT);}
"==" {return symbol(sym.JEDNAKO_JEDNAKO);}
"!=" {return symbol(sym.NIJE_JEDNAKO);}
">" {return symbol(sym.VECE);}
">=" {return symbol(sym.VECE_JEDNAKO);}
"<" {return symbol(sym.MANJE);}
"<=" {return symbol(sym.MANJE_JEDNAKO);}
"&&" {return symbol(sym.LOGICKO_I);}
"||" {return symbol(sym.LOGICKO_ILI);}
"=" {return symbol(sym.JEDNAKO);}
"+=" {return symbol(sym.PLUS_JEDNAKO);}
"-=" {return symbol(sym.MINUS_JEDNAKO);}
"*=" {return symbol(sym.PUTA_JEDNAKO);}
"/=" {return symbol(sym.PODELJENO_JEDNAKO);}
"%=" {return symbol(sym.PROCENAT_JEDNAKO);}
"++" {return symbol(sym.PLUS_PLUS);}
"--" {return symbol(sym.MINUS_MINUS);}
";" {return symbol(sym.TACKA_ZAREZ);}
"," {return symbol(sym.ZAREZ);}
"." {return symbol(sym.TACKA);}
"(" {return symbol(sym.LMALA);}
")" {return symbol(sym.DMALA);}
"[" {return symbol(sym.LUGLASTA);}
"]" {return symbol(sym.DUGLASTA);}
"{" {return symbol(sym.LVITICASTA);}
"}" {return symbol(sym.DVITICASTA);}
"..." {return symbol(sym.TRI_TACKE);}

{BrojKonstanta} { return symbol(sym.BROJ_KONSTANTA);}
"'"{Karakter}"'" {return symbol(sym.KARAKTER_KONSTANTA, yycharat(1));}
{BoolKonstanta} {return symbol(sym.BOOL_KONSTANTA, yytext());}
{Identifikator} { return symbol(sym.IDENTIFIKATOR, yytext());}
{Komentar} {}
/* komentar na kraju fajla */
"//".* {}
{WhiteSpace} { /* nista */ }
/* error fallback */
. {System.out.println("Nepoznati znak "+yytext()+", linija "+(yyline+1)+", kolona "+yycolumn);}