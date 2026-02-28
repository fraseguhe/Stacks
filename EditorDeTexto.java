/*Importamos las utilidades con * que son todas las librerias de Java 
para poder usar Scanner para extraer las entradas de la consola, 
Deque para poder modificar ambos extremos de un array o listaindexada, 
ArrayDeque nos va a permitir crear arreglos variables en tamaño que sean 
modificables desde ambos extremos y InputMismatchException aunque no es 
estrictamente necesario me parecio prudente incluirlo ya que vamos a 
trabajar con inputs que pueden dejar inutilizable el programa.*/
import java.util.*;
/*Iniciamos o abrimos el archivo */
public class EditorDeTexto {
    /*creamos el punto de inicio para el programa*/
    public static void main(String[] args) {
        /*aca segun yo estamos creando un objeto scanner denttro de la variable consola que va a 
        almacenar como un valor nuevo toda entrada del sistema que se realize en la consola */
        Scanner consola = new Scanner(System.in);
        /*aca segun yo tambien estamos creando 2 arreglos deque de tipo texto dentro de la variable 
        "texto" con la posibilidad de modificarse por ambos lados porque son deque*/
        Deque<String> texto = new ArrayDeque<String>();
        Deque<String> respaldo = new ArrayDeque<String>();
        /*Aca decidi crear una variable boleana para el ciclo while para usar alguna variable de 
        tipo boleana, ya que me llama la atención aunque perfectamente se podia hacer con la 
        variable menu que veremos a continuación */
        Boolean salir = false;
        /*la dichosa variable menu de tipo entero */
        int menu;
        /*Nuestro oo mas bien mi programa dentro de un bucle while que 
        solo se acaba cuando mi variable boleana salir es verdadera */
        while (salir == false) {
            /*Las intruciones basicas en muchos comandos print, para usar el programa de la forma mas literal posible para 
            que no haya lugar a interpretaciones y un menu netamente visual que no supe conectar
            realmente con alguna variable, entonces toco por logica 
            PD: Desconozco sihay forma de imprimir bloques de texto de seguro si pero ya no quiero seguir optimizando esto */
            System.out.println("Por Favor digite unicamente el digito de alguna");
            System.out.println("de las siguientes opciones y presione Enter");
            System.out.println("==========");
            System.out.println("   Menu");
            System.out.println("==========");
            System.out.println("1. Añadir texto");
            System.out.println("2. Eliminar ultimo texto");
            System.out.println("3. Deshacer ultima accion");
            System.out.println("4. Ver texto completo");
            System.out.println("5. Salir");
            /*aca puse una funcion llamada try que va siempre con una catch porque me di cuenta tarde en las pruebas 
            que al ingresar en la variable menu un valor que no es entero el programa estalla y puede ser un error 
            muy facil de cometer entonces por eso tambien lo vi necesario */
            try {
            /*aca la variable menu va a almacenar lo que el scanner asignado a "consola"
            detecte en la consola como entero */
            menu = consola.nextInt();
            /*aca la consola se limpia de /n que es un salto de linea o un enter que queda en el bufer luego de leer la consola*/
            consola.nextLine();
            /*Bueno y en caso de que el scaner no pueda convertir el input en un entero
            porque el usurario se haya elevado o interpretadp lo que no era
            tenemos esta funcion que es catch y va a actuar cuando el input
            recibido por la variable no coincida con el tipo de dato necesario
            arrojara una excepción para que no estalle esto y ejecutara los siguientes comandos */
            } catch (InputMismatchException exception) {
            /*Se podia poner un System print aca pero no quise porque queria que el caso 5 
            tuviera mas de una forma de ser ejecutado */ 
            consola.nextLine();
            menu=0;
            }
            /*aca la función switch va a saltar al case dependiendo del valor que tenga menu, se puede con cualquier tipo de dato
            y en caso de que no sea igual a ningun caso va a saltar al prederminado*/
                switch (menu) {
                case 1: 
                /*aca prinmero se realiza una copia de "seguridad en el array de respaldo antes de realizar
                cualquier modificación porque asi si queremos podemos reversar al estado anterior" 
                PD: no se puede poner simplemente un = porque resulta que java en lugar de copiar los elemtos
                hace es una referencia al mismo espacio de memoria en el que se encuentran los datos, en lugar de una copia funciona ams como
                una redirección entonces si cambian los datos de texto igual cambian en respaldo porque estan en el mismo espacio en memoria*/            
                respaldo = new ArrayDeque<>(texto);
                /*ya luego se añade lo que la variable consola contenga que recordemos que tiene el objeto scanner asignado 
                y va a recuperar el input ded la consola */
                texto.add(consola.nextLine());
                /*Importante el break ya que es como decirle hasta aca, ya puedes salir del switch */
                break;
                case 2: 
                /*misma logica que cuando realizamos el respaldo en case 1 */
                respaldo = new ArrayDeque<>(texto);
                /*aca removemos el ultimo elemento añadido */
                texto.removeLast();
                break;
                case 3:
                /*aca asignamos a texto los valores que tenga el respaldo realizado antes de la ultima modificación */ 
                texto = new ArrayDeque<>(respaldo);
                break;
                case 4:
                /*aca puse que se imprimiera una texto que separara el menu 
                porque no se apreciaba bien a mi parecer*/
                System.out.println("==========");
                System.out.println("  TEXTO");
                System.out.println("==========");
                /*aca muy importante yo no queria imprimir el array de texto directamente porque no se veia bien 
                lleno de todas esas , y con los [], entonces este ciclo for va a ejecutarse unicamente el numero de elementos 
                de texto que haya dentro del arreglo asignado a la variable texto y va a imprimir cada uno de los elementos seguido de un espacio en blanco*/
                    for (String element:texto) {
                        System.out.print(element+" ");
                    }
                /*estos saltos en consola es para que cuando el ciclo for termine y vuelva a ejecutarse el while no sea en la misma linea que nuestro texto
                y 2 porque me parece que se ve mejor */
                System.out.println();
                System.out.println();
                /*aca tenia un poblema y era que al probar despues de tantos intentos no estallaba nada pero a la hora de ver el texto completo inmediatamente saltaba 
                otra ves el menu y aunque funciona no es comodo tener que volver a subir en la consola porque no lo alcansaste a leer en milesimas de segundo y 
                para lograr esto sin morir en el intento, hay que encapsular la funcion Thread.sleep dentro de un try- catch para que compile, en caso de que el temporizador 
                se vea interrumpido simplemente va a saltar al siguiente bloque de codigo por el break que hay inmediatamente */
                try {
                Thread.sleep(3000);
                } catch (InterruptedException e) {}
                break;
                /*el caso 5 mi favorito es cuando el usuario le da al 5 y aca no hay mucho se establece la variable salir a true y el bucle while finaliza */
                case 5:
                salir = true;
                break;
                default:
                System.out.println("Opcion incorrecta vuelva a intentar");
            }
        }
        /*la verdad no entiendo proque hay que cerrar la variable asociada a scanner pero el editor dice que es una buena practica y pues ajá */
        consola.close(); 
    }
}