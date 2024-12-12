// Generated from c:/Users/Marcos/Desktop/TC_Dec/tcfinal/src/main/java/tc/dec/compilador.g4 by ANTLR 4.13.1

package tc.dec;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link compiladorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface compiladorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link compiladorParser#operador_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperador_relacional(compiladorParser.Operador_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(compiladorParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#instrucciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrucciones(compiladorParser.InstruccionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(compiladorParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#incluir_libreria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncluir_libreria(compiladorParser.Incluir_libreriaContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#definicion_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicion_funcion(compiladorParser.Definicion_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(compiladorParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(compiladorParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(compiladorParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(compiladorParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(compiladorParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(compiladorParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(compiladorParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#estructura_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructura_control(compiladorParser.Estructura_controlContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#if_estructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_estructura(compiladorParser.If_estructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#for_estructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_estructura(compiladorParser.For_estructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#while_estructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_estructura(compiladorParser.While_estructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#llamada_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamada_funcion(compiladorParser.Llamada_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(compiladorParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#printf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintf(compiladorParser.PrintfContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(compiladorParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(compiladorParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link compiladorParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(compiladorParser.ExpresionContext ctx);
}