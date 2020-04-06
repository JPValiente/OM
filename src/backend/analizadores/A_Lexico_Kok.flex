/*------------  1ra Area: Codigo de Usuario ---------*/
//------> Paquetes, Importaciones
package backend.analizadores;
import java_cup.runtime.*;

/*------------  2da Area: Opciones y Declaraciones ---------*/
%%
%{

public String extraerInfo (String token){
    int longitud = token.length();
    String tokenSinCorchetes = token.substring(1, longitud-1);
    System.out.println("El token a enviar es: "+tokenSinCorchetes);
    return tokenSinCorchetes;
}

%}

//-------> Directivas
%public 
%class Analizador_Lexico_Kok
%cupsym Simbolos_Kok
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//--------> Expresiones Regulares
D = [0-9]
LINETERMINATOR = \r|\n|\r\n
LineTerminator = \r|\n|\r\n
WHITE=[ \t\f]+
NAMEFILE = ([:jletterdigit:] | [-] | [_] | [$] )+
InputCharacter = [^\r\n]
Comment = {EndOfLineComment} 
EndOfLineComment     = "#" {InputCharacter}* {LineTerminator}?

//------> Estados

%%
/*------------  3raa Area: Reglas Lexicas ---------*/

//-----> Simbolos  y Expresiones Regulares

<YYINITIAL> {

        
        
        (("adelante")|("ae")) { System.out.println("Se reconocio "+yytext()+" de tipo Forward"); return new Symbol(Simbolos_Kok.Forward, yycolumn, yyline, yytext()); }

        (("atras")|("as")) { System.out.println("Se reconocio "+yytext()+" de tipo Backward"); return new Symbol(Simbolos_Kok.Backward, yycolumn, yyline, yytext()); }

        (("derecha")|("da")) { System.out.println("Se reconocio "+yytext()+" de tipo Right"); return new Symbol(Simbolos_Kok.Right, yycolumn, yyline, yytext()); }

        (("izquierda")|("ia")) { System.out.println("Se reconocio "+yytext()+" de tipo Left"); return new Symbol(Simbolos_Kok.Left, yycolumn, yyline, yytext()); }

        (("limpiar")|("lr")) { System.out.println("Se reconocio "+yytext()+" de tipo Clears"); return new Symbol(Simbolos_Kok.Clears, yycolumn, yyline, yytext()); }

        (("centro")|("co")) { System.out.println("Se reconocio "+yytext()+" de tipo ToCenter"); return new Symbol(Simbolos_Kok.ToCenter, yycolumn, yyline, yytext()); }

        (("posicionxy")|("posxy")) { System.out.println("Se reconocio "+yytext()+" de tipo PositionXY"); return new Symbol(Simbolos_Kok.PositionXY, yycolumn, yyline, yytext()); }

        (("posicionx")|("posx")) { System.out.println("Se reconocio "+yytext()+" de tipo PositionX"); return new Symbol(Simbolos_Kok.PositionX, yycolumn, yyline, yytext()); }

        (("posiciony")|("posy")) { System.out.println("Se reconocio "+yytext()+" de tipo PositionY"); return new Symbol(Simbolos_Kok.PositionY, yycolumn, yyline, yytext()); }

        ("repeat") { System.out.println("Se reconocio "+yytext()+" de tipo Repeat"); return new Symbol(Simbolos_Kok.Repeat, yycolumn, yyline, yytext()); }

         "["    { System.out.println("Se reconocio "+yytext()+" de tipo Abrir Corchetes"); return new Symbol(Simbolos_Kok.AbrirCorchetes, yycolumn, yyline, yytext()); }

         "]"    { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar Corchetes"); return new Symbol(Simbolos_Kok.CerrarCorchetes, yycolumn, yyline, yytext()); }

         "("    { System.out.println("Se reconocio "+yytext()+" de tipo Abrir Parentesis"); return new Symbol(Simbolos_Kok.AbrirParentesis, yycolumn, yyline, yytext()); }

         ")"    { System.out.println("Se reconocio "+yytext()+" de tipo Cerrar Parentesis"); return new Symbol(Simbolos_Kok.CerrarParentesis, yycolumn, yyline, yytext()); }

         ","    { System.out.println("Se reconocio "+yytext()+" de tipo Coma"); return new Symbol(Simbolos_Kok.Coma, yycolumn, yyline, yytext()); }

         "="    { System.out.println("Se reconocio "+yytext()+" de tipo Igual"); return new Symbol(Simbolos_Kok.Igual, yycolumn, yyline, yytext()); }

         "+"    { System.out.println("Se reconocio "+yytext()+" de tipo Suma"); return new Symbol(Simbolos_Kok.Mas, yycolumn, yyline, yytext()); }

         "-"    { System.out.println("Se reconocio "+yytext()+" de tipo Resta"); return new Symbol(Simbolos_Kok.Menos, yycolumn, yyline, yytext()); }

         "/"    { System.out.println("Se reconocio "+yytext()+" de tipo Division"); return new Symbol(Simbolos_Kok.Diagonal, yycolumn, yyline, yytext()); }

         "*"    { System.out.println("Se reconocio "+yytext()+" de tipo Multiplicacion"); return new Symbol(Simbolos_Kok.Asterisco, yycolumn, yyline, yytext()); }

         (":"){NAMEFILE}+    { System.out.println("Se reconocio "+yytext()+" de tipo Variable"); return new Symbol(Simbolos_Kok.Variable, yycolumn, yyline, yytext()); }

        {WHITE} { /*Se ignora*/}
        
        {LINETERMINATOR} {/*Se Ingnora*/}

        ("#")(([a-fA-F]|[0-9]){6}) { System.out.println("Se reconocio "+yytext()+" de tipo Hexadecimal"); return new Symbol(Simbolos_Kok.Hexa, yycolumn, yyline, yytext()); }

        {Comment} { System.out.println("Se reconocio "+yytext()+" de tipo Comentario"); return new Symbol(Simbolos_Kok.Comentario, yycolumn, yyline, yytext()); }

        {D}+    { System.out.println("Se reconocio "+yytext()+" de tipo Numero"); return new Symbol(Simbolos_Kok.Numero, yycolumn, yyline, yytext()); }
         
}

. {System.out.println("Se reconocio el error lexico: "+yytext()+"."); return new Symbol(Simbolos_Kok.ErrorLexico, yycolumn, yyline, yytext()); }


