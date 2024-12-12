grammar compilador;

@header {
package tc.dec;
}

fragment LETRA : [A-Za-z] ;
fragment DIGITO : [0-9] ;

ID       : [a-zA-Z_][a-zA-Z0-9_]* ;
ENTERO   : [0-9]+ ;
FLOTANTE : [0-9]+ '.' [0-9]+ ;
CARACTER : '\'' . '\'' ;
CADENA   : '"' .*? '"' ;
PUNTO_Y_COMA : ';' ;
LLAVE_IZQ : '{' ;
LLAVE_DER : '}' ;
PARENTESIS_IZQ : '(' ;
PARENTESIS_DER : ')' ;
ESPACIOS : [ \t\r\n]+ -> skip ;
PUNTO: '.';

operador_relacional
    : '>' | '<' | '>=' | '<=' | '==' | '!='
    ;

OPERADORES
    : '+' | '-' | '*' | '/'
    ;

INCREMENTO
    : '++'
    ;

DECREMENTO
    : '--'
    ;

COMENTARIO : '//' ~[\r\n]* -> skip ;

programa: instrucciones EOF;

instrucciones : instruccion instrucciones
              |
              ;

instruccion : incluir_libreria
            | definicion_funcion
            | bloque 
            | declaracion
            | asignacion
            | estructura_control
            | llamada_funcion
            | expresion
            | retorno
            | printf
            ;

incluir_libreria
    : '#' 'include' '<' ID PUNTO ID '>'
    ;

definicion_funcion
    : tipo ID PARENTESIS_IZQ parametros? PARENTESIS_DER bloque
    ;

bloque
    : LLAVE_IZQ instruccion* LLAVE_DER
    ;

parametros
    : parametro (',' parametro)*
    ;

parametro
    : tipo ID
    ;

param : tipo ID ;

tipo
    : 'int' | 'float' | 'char' | 'void' | 'string' | 'double'
    ;

declaracion
    : param (('=' expresion) | ('=' llamada_funcion))? PUNTO_Y_COMA
    ;

asignacion
    : ID '=' (expresion | llamada_funcion) PUNTO_Y_COMA
    ;

estructura_control
    : if_estructura
    | for_estructura
    | while_estructura
    ;

if_estructura
    : 'if' PARENTESIS_IZQ condicion PARENTESIS_DER bloque ('else' bloque)?
    ;

for_estructura
    : 'for' PARENTESIS_IZQ (declaracion | asignacion) condicion PUNTO_Y_COMA (ID INCREMENTO | ID DECREMENTO | asignacion) PARENTESIS_DER bloque
    ;

while_estructura
    : 'while' PARENTESIS_IZQ condicion PARENTESIS_DER bloque
    ;

llamada_funcion
    : ID PARENTESIS_IZQ argumentos? PARENTESIS_DER
    ;

retorno
    : 'return' (expresion | llamada_funcion)? PUNTO_Y_COMA
    ;

printf
    : 'printf' PARENTESIS_IZQ CADENA (',' argumentos)? PARENTESIS_DER PUNTO_Y_COMA
    ;

argumentos
    : expresion (',' expresion)*
    ;

condicion
    : expresion operador_relacional expresion
    ;

expresion
    : ID
    | ENTERO
    | FLOTANTE
    | CARACTER
    | CADENA
    | PARENTESIS_IZQ expresion PARENTESIS_DER
    | expresion OPERADORES expresion
    | ID INCREMENTO PUNTO_Y_COMA
    | ID DECREMENTO PUNTO_Y_COMA
    ;
