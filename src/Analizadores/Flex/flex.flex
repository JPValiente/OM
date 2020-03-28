/* codigo de usuario */
package Analizadores.Flex;

import java.util.ArrayList;
import java_cup.runtime.Symbol;
import Analizadores.Cup.sym;
//import Objetos.Logica;
import javax.swing.JTextArea;


%% //separador de area


 /* opciones y declaraciones de jflex */

%class Lexer
%public
%cup
%cupdebug
%line
%column

%state STRING
%state COMENTARIO_LINEA
%state COMENTARIO_BLOQUE


WhiteSpace = [\r|\n|\r\n] | [ \t\f]
SaltoLinea = [\n]
Numero = [0-9]

Numeros = {Numero}+

moverA = "moverA"
moverB = "moverB"
moverC = "moverC"
moverD = "moverD"

moverAdelante = "moverAdelante"
moverAtras = "moverAtras"
moverDerecha = "moverDerecha"
moverIzquierda = "moverIzquierda"
moverArribaDerecha = "moverArribaDerecha"
moverArribaIzquierda = "moverArribaIzquierda"
moverAbajoDerecha = "moverAbajoDerecha"
moverAbajoIzquierda = "moverAbajoIzquierda"
girarIzquierda = "girarIzquierda"
girarDerecha = "girarDerecha"



ini = "ini"
fin = "fin"

initrayecto = "initrayecto"
fintrayecto = "fintrayecto"

par_abierto = "("
par_cerrado = ")"
coma = ","








%{

	String lexema = "";
	String lexemaError = "";
	String lexemaMandar = "";

	

	public void crearLexemaError(String mandar){
		lexemaError = lexemaError+ mandar;
	}

	private void error(String message) {
	     System.out.println("\nError Lexico en Fila: " + (yyline + 1) + ", columna " + (yycolumn + 1) + " : " + message + "\n");
	}

	public void verificarError(){
		if(!lexemaError.equals("")){
			error(lexemaError);
		}
		lexemaError="";
	}
	private Symbol symbol(int type, String lexeme) {
		String lexema = lexeme;
		this.lexema="";
	        return new Symbol(type, lexema);
	}

	private Symbol symbol(int type) {
        String lexeme = yytext();

        return new Symbol(type, lexeme);
    }

%}



%% /* separador de areas*/

/* reglas lexicas */
<YYINITIAL> {
{WhiteSpace} {verificarError();}
{SaltoLinea} {verificarError();}

{moverA} {verificarError();return symbol(sym.MOVERA);}
{moverB} {verificarError();return symbol(sym.MOVERB);}
{moverC} {verificarError();return symbol(sym.MOVERC);}
{moverD} {verificarError();return symbol(sym.MOVERD);}


{moverAdelante} {verificarError();return symbol(sym.MOVERADELANTE);}
{moverAtras} {verificarError();return symbol(sym.MOVERATRAS);}
{moverDerecha} {verificarError();return symbol(sym.MOVERDERECHA);}
{moverIzquierda} {verificarError();return symbol(sym.MOVERIZQUIERDA);}
{moverArribaDerecha} {verificarError();return symbol(sym.MOVERARRIBADERECHA);}
{moverArribaIzquierda} {verificarError();return symbol(sym.MOVERARRIBAIZQUIERDA);}
{moverAbajoDerecha} {verificarError();return symbol(sym.MOVERABAJODERECHA);}
{moverAbajoIzquierda} {verificarError();return symbol(sym.MOVERABAJOIZQUIERDA);}
{girarIzquierda} {verificarError();return symbol(sym.GIRARIZQUIERDA);}
{girarDerecha} {verificarError();return symbol(sym.GIRARDERECHA);}




{ini} {verificarError();return symbol(sym.INI);}
{fin} {verificarError();return symbol(sym.FIN);}
{initrayecto} {verificarError();return symbol(sym.INITRAYECTO);}
{fintrayecto} {verificarError();return symbol(sym.FINTRAYECTO);}
{Numeros} {verificarError();return symbol(sym.NUMEROS);}

{par_abierto} {verificarError();return symbol(sym.PAR_ABIERTO);}
{par_cerrado} {verificarError();return symbol(sym.PAR_CERRADO);}
{coma} {verificarError();return symbol(sym.COMA);}
}

[^]                     {crearLexemaError(yytext());}
<<EOF>>                 {return symbol(sym.EOF);}

/*



*/


