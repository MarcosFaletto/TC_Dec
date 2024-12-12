package tc.dec;

import org.antlr.v4.runtime.*;

public class CustomErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        String errorMessage;

        if (msg.contains("missing ';'")) {
            errorMessage = String.format("Error sintáctico en línea %d:%d - Falta un punto y coma.", line, charPositionInLine);
        } else if (msg.contains("missing '('")) {
            errorMessage = String.format("Error sintáctico en línea %d:%d - Falta un paréntesis de apertura '('.", line, charPositionInLine);
        } else if (msg.contains("missing ')'")) {
            errorMessage = String.format("Error sintáctico en línea %d:%d - Falta un paréntesis de cierre ')'.", line, charPositionInLine);
        } else if (msg.contains("missing ID")) {
            errorMessage = String.format("Error sintáctico en línea %d:%d - Se esperaba un identificador en la lista de declaración de variables.", line, charPositionInLine);
        } else if (msg.contains("extraneous input")) {
            String offendingText = offendingSymbol instanceof Token ? ((Token) offendingSymbol).getText() : offendingSymbol.toString();
            errorMessage = String.format("Error sintáctico en línea %d:%d - Entrada extraña o mal colocada: '%s'.", line, charPositionInLine, offendingText);
        } else {
            errorMessage = String.format("Error sintáctico en línea %d:%d - %s", line, charPositionInLine, msg);
        }

        System.err.println(errorMessage);
    }
}