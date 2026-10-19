# Práctica: Métodos Iterativos de Jacobi y Gauss-Seidel

**Instituto Tecnológico Superior de Xalapa**  
**Materia:** Métodos Numéricos (Grupo A)  
**Docente:** Mtro. Víctor Hugo Vásquez Herrera  

## Descripción
Este proyecto implementa una arquitectura modular en Java para la resolución de sistemas de ecuaciones lineales mediante los métodos iterativos de **Jacobi** y **Gauss-Seidel**.

## Arquitectura del Proyecto
- **Definición del Sistema:** Declaración de la matriz $A$ y del vector independiente $b$.
- **Método de Jacobi:** Cálculo iterativo utilizando los valores respaldados de la iteración previa.
- **Método de Gauss-Seidel:** Evolución instantánea del vector de soluciones en el mismo ciclo de iteración.
- **Clase Principal (Main):** Inicialización de datos, tolerancia $\epsilon = 0.0001$, vector inicial $X^{(0)} = [0, 0, 0]^T$ y despliegue de resultados.

## Sistema Resuelto
$$\begin{cases}5x + y + z = 7\\ x + 4y + z = 6\\ x + 2y + 5z = 8\end{cases}$$

## Resultados
Ambos métodos convergen a la solución exacta del sistema $X = [1, 1, 1]^T$:
- **Jacobi:** Converge en 7 iteraciones.
- **Gauss-Seidel:** Converge en 6 iteraciones.
