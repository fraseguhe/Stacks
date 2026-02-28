//Importamos la libreria scanner para que el usuario pueda introducir las notas en la consola
import java.util.Scanner; 
public class EjerciciosPractica1 {
    public static void main(String[] args) {
    // Se crean los 3 arreglos de tipo entero con 7 posiciones cada uno
    int []array1 = new int [7], array2 = new int [7], array3 = new int [7];
    // Se crea un scanner para extraer los numeros en la consola
    Scanner leer = new Scanner(System.in);
    // Se pone un bucle para que el usuario pueda llenar el arreglo1 con los numeros
    for (int i = 0; i < array1.length; i++) {
                System.out.println("(Introduce un numero entero) array1 Valor" + (i+1) + ":");
        array1 [i] = leer.nextInt();   
    }
    // Se pone un bucle para que el usuario pueda llenar el arreglo2 con los numeros
     for (int i = 0; i < array2.length; i++) {
                System.out.println("(Introduce un numero entero) array2 Valor" + (i+1) + ":");
        array2 [i] = leer.nextInt();   
        }
    // Se pone un bucle para que el sistema pueda llenar el arreglo3 con la diferencia de los primeros 2 arreglos
    for (int i = 0; i <array3.length; i++) {
        array3 [i] = (array1 [i] - array2 [i]);
        System.out.println("[" + array3[i] + "]");
    }
        // Se crea una variable double del array3 para mostar el promedio de este arreglo
    double promedioarray3 = java.util.Arrays.stream(array3).average().orElse(0.0);
        System.out.println("El promedio del array3 es:" + promedioarray3);
    leer.close();
    }
    }