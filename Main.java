import java.util.Arrays;

public class Main {

    public static class JacobiMetodo {
        public static double calcularError(double[] xAnt, double[] xAct) {
            double maxError = 0.0;
            for (int i = 0; i < xAnt.length; i++) {
                double errorActual = Math.abs(xAct[i] - xAnt[i]);
                if (errorActual > maxError) {
                    maxError = errorActual;
                }
            }
            return maxError;
        }

        public static double[] jacobi(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
            int n = xInicial.length;
            double[] x = xInicial.clone();
            
            System.out.println("\n--- Ejecutando Método de Jacobi ---");
            for (int iter = 0; iter < maxIter; iter++) {
                double[] xAnt = x.clone();
                double[] xNuevo = new double[n];

                for (int i = 0; i < n; i++) {
                    double suma = b[i];
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            suma -= A[i][j] * xAnt[j];
                        }
                    }
                    xNuevo[i] = suma / A[i][i];
                }

                x = xNuevo;
                double error = calcularError(xAnt, x);
                System.out.println("Iteración " + (iter + 1) + ": " + Arrays.toString(x) + " | Error: " + error);

                if (error < tol) {
                    System.out.println("Jacobi convergió en la iteración: " + (iter + 1));
                    return x;
                }
            }
            return x;
        }
    }

    public static class GaussSeidelMetodo {
        public static double[] gaussSeidel(double[][] A, double[] b, double[] xInicial, double tol, int maxIter) {
            int n = xInicial.length;
            double[] x = xInicial.clone();
            
            System.out.println("\n--- Ejecutando Método de Gauss-Seidel ---");
            for (int iter = 0; iter < maxIter; iter++) {
                double[] xAnt = x.clone();
                
                for (int i = 0; i < n; i++) {
                    double suma = b[i];
                    
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            suma -= A[i][j] * x[j];
                        }
                    }
                    x[i] = suma / A[i][i];
                }
                
                double error = JacobiMetodo.calcularError(xAnt, x);
                System.out.println("Iteración " + (iter + 1) + ": " + Arrays.toString(x) + " | Error: " + error);
                
                if (error < tol) { 
                    System.out.println("Gauss-Seidel convergió en la iteración: " + (iter + 1));
                    return x; 
                }
            }
            return x;
        }
    }

    public static void main(String[] args) {
        double[][] A = {
            {5.0, 1.0, 1.0},
            {1.0, 4.0, 1.0},
            {1.0, 2.0, 5.0}
        };

        double[] b = {7.0, 6.0, 8.0};
        double[] xInicial = {0.0, 0.0, 0.0};
        double tol = 0.0001;
        int maxIter = 100;

        System.out.println("=== PRÁCTICA DE MÉTODOS NUMÉRICOS: JACOBI Y GAUSS-SEIDEL ===");
        System.out.println("Instituto Tecnológico Superior de Xalapa");

        double[] resultadoJacobi = JacobiMetodo.jacobi(A, b, xInicial, tol, maxIter);
        double[] resultadoGaussSeidel = GaussSeidelMetodo.gaussSeidel(A, b, xInicial, tol, maxIter);

        System.out.println("\n========================================================");
        System.out.println("RESUMEN DE RESULTADOS FINALES:");
        System.out.println("Solución por Jacobi       : " + Arrays.toString(resultadoJacobi));
        System.out.println("Solución por Gauss-Seidel : " + Arrays.toString(resultadoGaussSeidel));
        System.out.println("========================================================");
    }
}