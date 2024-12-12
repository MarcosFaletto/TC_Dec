// Generated from c:/Users/Marcos/Desktop/TC_Dec/tcfinal/src/main/java/tc/dec/compilador.g4 by ANTLR 4.13.1

package tc.dec;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link compiladorParser}.
 */
public interface compiladorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link compiladorParser#operador_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOperador_relacional(compiladorParser.Operador_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#operador_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOperador_relacional(compiladorParser.Operador_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(compiladorParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(compiladorParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#incluir_libreria}.
	 * @param ctx the parse tree
	 */
	void enterIncluir_libreria(compiladorParser.Incluir_libreriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#incluir_libreria}.
	 * @param ctx the parse tree
	 */
	void exitIncluir_libreria(compiladorParser.Incluir_libreriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#definicion_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDefinicion_funcion(compiladorParser.Definicion_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#definicion_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDefinicion_funcion(compiladorParser.Definicion_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(compiladorParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(compiladorParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(compiladorParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(compiladorParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(compiladorParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(compiladorParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(compiladorParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(compiladorParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(compiladorParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(compiladorParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(compiladorParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(compiladorParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(compiladorParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(compiladorParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#estructura_control}.
	 * @param ctx the parse tree
	 */
	void enterEstructura_control(compiladorParser.Estructura_controlContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#estructura_control}.
	 * @param ctx the parse tree
	 */
	void exitEstructura_control(compiladorParser.Estructura_controlContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#if_estructura}.
	 * @param ctx the parse tree
	 */
	void enterIf_estructura(compiladorParser.If_estructuraContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#if_estructura}.
	 * @param ctx the parse tree
	 */
	void exitIf_estructura(compiladorParser.If_estructuraContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#for_estructura}.
	 * @param ctx the parse tree
	 */
	void enterFor_estructura(compiladorParser.For_estructuraContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#for_estructura}.
	 * @param ctx the parse tree
	 */
	void exitFor_estructura(compiladorParser.For_estructuraContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#while_estructura}.
	 * @param ctx the parse tree
	 */
	void enterWhile_estructura(compiladorParser.While_estructuraContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#while_estructura}.
	 * @param ctx the parse tree
	 */
	void exitWhile_estructura(compiladorParser.While_estructuraContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#llamada_funcion}.
	 * @param ctx the parse tree
	 */
	void enterLlamada_funcion(compiladorParser.Llamada_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#llamada_funcion}.
	 * @param ctx the parse tree
	 */
	void exitLlamada_funcion(compiladorParser.Llamada_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(compiladorParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(compiladorParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#printf}.
	 * @param ctx the parse tree
	 */
	void enterPrintf(compiladorParser.PrintfContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#printf}.
	 * @param ctx the parse tree
	 */
	void exitPrintf(compiladorParser.PrintfContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(compiladorParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(compiladorParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(compiladorParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(compiladorParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compiladorParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(compiladorParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compiladorParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(compiladorParser.ExpresionContext ctx);
}