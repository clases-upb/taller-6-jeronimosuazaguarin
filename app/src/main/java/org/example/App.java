/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

public class App {

    public static void main(String[] args) {
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /*
     * 1. Implemente un programa en java donde inserte elementos en dos vectores
     * globales de tamaños aleatorios y de contenido aleatorio (uno numérico y otro
     * de Strings). Considere dejar espacios libres en los vectores.
     * 
     * Desde un menú en el programa principal debe considerar cada opción para
     * llamar las siguientes funciones que también debe programar:
     * 
     * a. Recorrer secuencialmente (recibe un true cuando va del primero al último y
     * un false cuando va del último al primero)
     * • De primer elemento a último elemento: Imprime desde el primer elemento
     * hasta el último del vector dado en el parámetro de entrada.
     * • De último elemento al primer elemento: Imprime desde el último elemento
     * hasta el primero del vector dado en el parámetro de entrada.
     * 
     * b. Actualizar: recibe la posición que va a actualizar y el elemento. Al final
     * imprime el vector actualizado.
     * 
     * c. Añadir: después del último: recibe el elemento que va a añadir. Al final
     * imprime el vector actualizado.
     * 
     * d. Borrar: Recibe la posición donde del elemento que va a borrar.
     * 
     * e. Ordenar el vector:
     * • Ascendentemente.
     * • Descendentemente.
     * 
     * f. Búsqueda: Recibe como parámetro el elemento a buscar y devuelve un String
     * separado por el carácter '-', mostrando las posiciones donde se encuentra el
     * elemento.
     */

    /*
     * 2. Escriba un algoritmo que calcule aleatoriamente N temperaturas, las lleve
     * a un vector y luego calcule su media, cuántas temperaturas están por encima
     * de la media y cuántas por debajo.
     */
    import java.util.Random;
import java.util.Scanner;

public class Temperaturas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese la cantidad de temperaturas a generar: ");
        int N = scanner.nextInt();
        
        double[] temperaturas = new double[N];
        double suma = 0;

        for (int i = 0; i < N; i++) {
            temperaturas[i] = 15 + (35 - 15) * random.nextDouble();
            suma += temperaturas[i];
        }

        double media = suma / N;
        int encimaMedia = 0;
        int debajoMedia = 0;

        for (double temp : temperaturas) {
            if (temp > media) {
                encimaMedia++;
            } else if (temp < media) {
                debajoMedia++;
            }
        }

        System.out.printf("Media de temperaturas: %.2f\n", media);
        System.out.println("Temperaturas por encima de la media: " + encimaMedia);
        System.out.println("Temperaturas por debajo de la media: " + debajoMedia);
    }
}

    /*
     * 3. Cargue un vector a partir de un archivo de palabras, con mínimo 10
     * palabras. Ordene el vector de manera ascendente y luego de forma descendente.
     * 
     * Escriba el vector inicial sin ordenar, los vectores ordenados.
     */
    
    /*
     * 4. Escriba un algoritmo que cree un vector de N elementos (el N es dado por
     * el usuario) de números short aleatorios positivos mayores que cero, y luego
     * le pregunte al usuario qué posición quiere eliminar. Luego por un menú
     * presente las opciones: Dejar la casilla en 0 o desplazar los elementos de
     * manera que el cero quede en la última posición del vector. Después de la
     * operación mostrará el vector cómo va quedando y volverá a preguntar qué
     * posición quiere borrar y mostrará nuevamente el menú. En el menú aparecerá la
     * opción para terminar el programa.
     */
    import java.util.Random;
import java.util.Scanner;

public class VectorManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese el tamaño del vector (N): ");
        int N = scanner.nextInt();
        short[] vector = new short[N];

        for (int i = 0; i < N; i++) {
            vector[i] = (short) (random.nextInt(Short.MAX_VALUE) + 1);
        }

        while (true) {
            System.out.println("Vector actual: ");
            for (short num : vector) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.print("Ingrese la posición que desea eliminar (0 a " + (N - 1) + "): ");
            int posicion = scanner.nextInt();

            if (posicion < 0 || posicion >= N) {
                System.out.println("Posición no válida. Intente de nuevo.");
                continue;
            }

            System.out.println("Seleccione una opción:");
            System.out.println("1. Dejar la casilla en 0");
            System.out.println("2. Desplazar elementos para que el cero quede al final");
            System.out.println("3. Terminar el programa");
            int opcion = scanner.nextInt();

            if (opcion == 3) {
                break;
            }

            switch (opcion) {
                case 1:
                    vector[posicion] = 0;
                    break;
                case 2:
                    for (int i = posicion; i < N - 1; i++) {
                        vector[i] = vector[i + 1];
                    }
                    vector[N - 1] = 0;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }
        }
        scanner.close();
    }
}

    /*
     * 5. Escriba un algoritmo para convertir un número decimal en un número
     * hexadecimal, apoyado en vectores.
     */
    import java.util.Scanner;

public class DecimalAHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número decimal: ");
        int decimal = scanner.nextInt();

        char[] hex = new char[50];
        int index = 0;

        while (decimal > 0) {
            int remainder = decimal % 16;
            hex[index++] = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            decimal /= 16;
        }

        System.out.print("El número hexadecimal es: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(hex[i]);
        }
    }
}

    */
    import java.util.Scanner;

public class DecimalAHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número decimal: ");
        int decimal = scanner.nextInt();

        char[] hex = new char[50];
        int index = 0;

        while (decimal > 0) {
            int remainder = decimal % 16;
            hex[index++] = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            decimal /= 16;
        }

        System.out.print("El número hexadecimal es: ");
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(hex[i]);
        }
    }
}


    
     * 6. Escriba un algoritmo que solicite al usuario el orden de una matriz
     * cuadrática, implemente su matriz transpuesta (investiga qué es) y la imprima.
     */
    import java.util.Scanner;

public class MatrizTranspuesta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el orden de la matriz cuadrática: ");
        int n = scanner.nextInt();

        int[][] matriz = new int[n][n];
        int[][] transpuesta = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Ingrese el elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz original:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Matriz transpuesta:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(transpuesta[i][j] + " ");
            }
            System.out.println();
        }
    }
}

    /*
     * 7. Escriba un algoritmo que calcule el producto y la división. Los operandos
     * serán la suma de elementos de la diagonal principal y la suma de los
     * elementos de la diagonal secundaria. Los elementos de la matriz deben ser
     * llenados usando la función random para calcular números aleatorios entre 10 y
     * 100.
     */
    import java.util.Random;

public class MatrizDiagonales {
    public static void main(String[] args) {
        final int TAMANO = 5;
        int[][] matriz = new int[TAMANO][TAMANO];
        Random random = new Random();
        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;

        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                matriz[i][j] = random.nextInt(91) + 10;
            }
        }

        for (int i = 0; i < TAMANO; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
            sumaDiagonalSecundaria += matriz[i][TAMANO - 1 - i];
        }

        int producto = sumaDiagonalPrincipal * sumaDiagonalSecundaria;
        double division = (double) sumaDiagonalPrincipal / sumaDiagonalSecundaria;

        System.out.println("Suma Diagonal Principal: " + sumaDiagonalPrincipal);
        System.out.println("Suma Diagonal Secundaria: " + sumaDiagonalSecundaria);
        System.out.println("Producto: " + producto);
        System.out.println("División: " + division);
    }
}

    
    /*
     * 8. Escriba un algoritmo que llene de manera aleatoria una matriz de 100 filas
     * por 3 columnas con Xs y Os. Y mediante un vector cuente el número de Xs y Os
     * en cada fila. Imprima la matriz antes de llenarla, luego de llenarla y el
     * vector con el resultado.
     */
    import java.util.Random;

public class MatrizXO {
    public static void main(String[] args) {
        final int FILAS = 100;
        final int COLUMNAS = 3;
        char[][] matriz = new char[FILAS][COLUMNAS];
        int[][] conteo = new int[FILAS][2];

        Random random = new Random();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = random.nextBoolean() ? 'X' : 'O';
            }
        }

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
                if (matriz[i][j] == 'X') {
                    conteo[i][0]++;
                } else {
                    conteo[i][1]++;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < FILAS; i++) {
            System.out.println("Fila " + (i + 1) + ": Xs = " + conteo[i][0] + ", Os = " + conteo[i][1]);
        }
    }
}

    /*
     * 9. Llene una matriz de 5x5 con números aleatorios entre 1 y 9. En un vector
     * adicional, calcule la cantidad de números repetidos por cada fila y en otro
     * vector la cantidad de números repetidos de cada columna.
     */
import java.util.Random;

public class MatrizRepetidos {
    public static void main(String[] args) {
        final int FILAS = 5;
        final int COLUMNAS = 5;
        final int MIN = 1;
        final int MAX = 9;

        int[][] matriz = new int[FILAS][COLUMNAS];
        int[] repetidosPorFila = new int[FILAS];
        int[] repetidosPorColumna = new int[COLUMNAS];

        Random random = new Random();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matriz[i][j] = random.nextInt(MAX - MIN + 1) + MIN;
            }
        }

        System.out.println("Matriz:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < FILAS; i++) {
            int[] conteoFila = new int[MAX + 1];
            for (int j = 0; j < COLUMNAS; j++) {
                conteoFila[matriz[i][j]]++;
            }
            int repeticiones = 0;
            for (int k = 1; k <= MAX; k++) {
                if (conteoFila[k] > 1) {
                    repeticiones += (conteoFila[k] - 1);
                }
            }
            repetidosPorFila[i] = repeticiones;
        }

        for (int j = 0; j < COLUMNAS; j++) {
            int[] conteoColumna = new int[MAX + 1];
            for (int i = 0; i < FILAS; i++) {
                conteoColumna[matriz[i][j]]++;
            }
            int repeticiones = 0;
            for (int k = 1; k <= MAX; k++) {
                if (conteoColumna[k] > 1) {
                    repeticiones += (conteoColumna[k] - 1);
                }
            }
            repetidosPorColumna[j] = repeticiones;
        }

        System.out.println("\nCantidad de números repetidos por fila:");
        for (int i = 0; i < FILAS; i++) {
            System.out.println("Fila " + (i + 1) + ": " + repetidosPorFila[i]);
        }

        System.out.println("\nCantidad de números repetidos por columna:");
        for (int j = 0; j < COLUMNAS; j++) {
            System.out.println("Columna " + (j + 1) + ": " + repetidosPorColumna[j]);
        }
    }
}

}
