package tc.dec;

import java.util.*;

public class Optimizador {
    public  List<String> optimizarCodigo(List<String> codigo) {
        List<String> codigoOptimizado = new ArrayList<>(codigo);

        // Optimización: Propagación de constantes y eliminación de código muerto
        Map<String, String> constantes = new HashMap<>();
        Set<String> variablesDefinidas = new HashSet<>();

        for (int i = 0; i < codigoOptimizado.size(); i++) {
            String linea = codigoOptimizado.get(i);
            if (linea.contains("=")) {
                String[] partes = linea.split("=");
                String var = partes[0].trim();
                String valor = partes[1].trim();
                
                // Verificar si la asignación es de una constante
                if (esConstante(valor)) {
                    constantes.put(var, valor);
                }
                variablesDefinidas.add(var);
            }

            // Reemplazar variables por sus valores constantes
            for (Map.Entry<String, String> entrada : constantes.entrySet()) {
                if (linea.contains(entrada.getKey() + " = ")) {
                    continue;  // No reemplazar la línea de definición
                }
                linea = linea.replace(entrada.getKey(), entrada.getValue());
            }
            codigoOptimizado.set(i, linea);
        }

        // Eliminar las líneas de código muerto
        codigoOptimizado.removeIf(linea -> {
            if (linea.contains("=")) {
                String var = linea.split("=")[0].trim();
                return !variablesDefinidas.contains(var);
            }
            return false;
        });

        return codigoOptimizado;
    }

    private static boolean esConstante(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
