package tc.dec;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //System.out.println( "Hello World!" );

        String inputFile = "C:/Users/Marcos/Desktop/TC_Dec/tcfinal/src/codigo.txt"; // Cambia esto a la ruta de tu archivo de prueba

        // Leer el archivo de entrada
        String input = new String(Files.readAllBytes(Paths.get(inputFile)));

        // Crear un lexer y un parser para el contenido
        compiladorLexer lexer = new compiladorLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        compiladorParser parser = new compiladorParser(tokens);

        // create Listener
        compiladorBaseListener escucha = new Escucha();                     // Para ver todos los pasos del nodo

        //Conecto el objeto con Listeners al parser 
        parser.addParseListener(escucha);                                     //abrir el escucha

        // Solicito al parser que comience indicando una regla gramatical
        // En este caso la regla es el simbolo inicial
        //parser.programa();
        
        // Añadir el CustomErrorListener
        parser.removeErrorListeners(); // Elimina los listeners predeterminados
        parser.addErrorListener(new CustomErrorListener());

        // Iniciar el parsing desde la regla 'programa'
        //ParseTree tree = parser.programa();

        //TablaSimbolos tabla = TablaSimbolos.obtenerInstancia();

        // Imprimir toda la tabla de símbolos
        //tabla.imprimirTablaSimbolos();

        parser.programa();

        // Mostrar el árbol sintáctico
        //System.out.println("Árbol sintáctico:");
        //System.out.println(tree.toStringTree(parser));
        /* 
        Caminante caminante = new Caminante();
        caminante.visit(tree);

        List<String> codigoTresDirecciones = caminante.getCodigoTresDirecciones();

        System.out.println("-----------------------------------------------------");
        System.out.println("Código sin optimizar:");
        for (String linea : codigoTresDirecciones) {
            System.out.println(linea);
        }
        System.out.println("-----------------------------------------------------");
        // Crear instancia del optimizador y optimizar
        Optimizador optimizador = new Optimizador();
         List<String> codigoOptimizado = optimizador.optimizarCodigo(codigoTresDirecciones);

        System.out.println("Código optimizado:");
        for (String linea : codigoOptimizado) {
            System.out.println(linea);
        }*/
    }
}
