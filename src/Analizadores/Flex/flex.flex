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


A_ = "a"|"A"
B_ = "b"|"B"
C_ = "c"|"C"
D_ = "d"|"D"
E_ = "e"|"E"
F_ = "f"|"F"
G_ = "g"|"G"
H_ = "h"|"H"
I_ = "i"|"I"
J_ = "j"|"J"
K_ = "k"|"K"
L_ = "l"|"L"
M_ = "m"|"M"
N_ = "n"|"N"
Ñ_ = "ñ"|"Ñ"
O_ = "o"|"O"
P_ = "p"|"P"
Q_ = "q"|"Q"
R_ = "r"|"R"
S_ = "s"|"S"
T_ = "t"|"T"
U_ = "u"|"U"
V_ = "v"|"V"
W_ = "w"|"W"
X_ = "x"|"X"
Y_ = "y"|"Y"
Z_ = "z"|"Z"

Numeros = {Numero}+

moverA = {M_}{O_}{V_}{E_}{R_}{A_}
moverB = {M_}{O_}{V_}{E_}{R_}{B_}
moverC = {M_}{O_}{V_}{E_}{R_}{C_}
moverD = {M_}{O_}{V_}{E_}{R_}{D_}

moverAdelante = {M_}{O_}{V_}{E_}{R_}{A_}{D_}{E_}{L_}{A_}{N_}{T_}{E_} 
moverAtras = {M_}{O_}{V_}{E_}{R_}{A_}{T_}{R_}{A_}{S_} 
moverDerecha = {M_}{O_}{V_}{E_}{R_}{D_}{E_}{R_}{E_}{C_}{H_}{A_} 
moverIzquierda = {M_}{O_}{V_}{E_}{R_}{I_}{Z_}{Q_}{U_}{I_}{E_}{R_}{D_}{A_} 
moverArribaDerecha = {M_}{O_}{V_}{E_}{R_}{A_}{R_}{R_}{I_}{B_}{A_}{D_}{E_}{R_}{E_}{C_}{H_}{A_} 
moverArribaIzquierda = {M_}{O_}{V_}{E_}{R_}{A_}{R_}{R_}{I_}{B_}{A_}{I_}{Z_}{Q_}{U_}{I_}{E_}{R_}{D_}{A_} 
moverAbajoDerecha = {M_}{O_}{V_}{E_}{R_}{A_}{B_}{A_}{J_}{O_}{D_}{E_}{R_}{E_}{C_}{H_}{A_} 
moverAbajoIzquierda = {M_}{O_}{V_}{E_}{R_}{A_}{B_}{A_}{J_}{O_}{I_}{Z_}{Q_}{U_}{I_}{E_}{R_}{D_}{A_} 
girarIzquierda = {G_}{I_}{R_}{A_}{R_}{I_}{Z_}{Q_}{U_}{I_}{E_}{R_}{D_}{A_} 
girarDerecha = {G_}{I_}{R_}{A_}{R_}{D_}{E_}{R_}{E_}{C_}{H_}{A_} 


ini = {I_}{N_}{I_}
fin = {F_}{I_}{N_}

initrayecto = {I_}{N_}{I_}{T_}{R_}{A_}{Y_}{E_}{C_}{T_}{O_}
fintrayecto = {F_}{I_}{N_}{T_}{R_}{A_}{Y_}{E_}{C_}{T_}{O_}


par_abierto = "("
par_cerrado = ")"
coma = ","



adelante = {A_}{D_}{E_}{L_}{A_}{N_}{T_}{E_}
atras = {A_}{T_}{R_}{A_}{S_}



mili = {M_}{I_}{L_}{I_}{S_}{E_}{G_}
cm = {C_}{M_}
grados = {G_}{R_}{A_}{D_}{O_}{S_}





%{

	String lexema = "";
	String lexemaError = "";
	String lexemaMandar = "";

	JTextArea areaError;

	public Lexer(java.io.Reader in,JTextArea area) {
    		this.zzReader = in;
		this.areaError=area;
  	}

	public void crearLexemaError(String mandar){
		lexemaError = lexemaError+ mandar;
	}

	private void error(String message) {
	     System.out.println("\nNo entiendo esto: "+message+", fila" + (yyline + 1) + ", columna " + (yycolumn + 1) +  "\n");
	     areaError.append("\nNo entiendo esto: "+message+", fila" + (yyline + 1) + ", columna " + (yycolumn + 1) +  "\n");
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



{adelante} {verificarError();return symbol(sym.ADELANTE);}
{atras} {verificarError();return symbol(sym.ATRAS);}

{mili} {verificarError();return symbol(sym.MILI);}
{cm} {verificarError();return symbol(sym.CM);}
{grados} {verificarError();return symbol(sym.GRADOS);}

}

[^]                     {crearLexemaError(yytext());}
<<EOF>>                 {return symbol(sym.EOF);}

/*



*/


