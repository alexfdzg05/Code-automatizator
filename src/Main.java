import java.util.Scanner;

public class Main {
    public static void mensajeBienvenida(){
        System.out.println("----Automatizador de Código----");
    }
    public static int menu(Scanner teclado){
        int opcion;
        do {
            System.out.print("Seleccione la operación que desea realizar: " +
                    "\n" + "1) Repetir 'System.out.println()' " +
                    "\n" + "2) Crear objetos " +
                    "\n" + "3) Repetir una línea de código específica" +
                    "\n" + "4) Repetir esctructura del 'case'"+
                    "\n" + "5) Repetir estructura de 'else if'"+
                    "\n" + "6) Salir\n");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // No borrar, es para que se consuma el salto de línea;
            if (opcion < 0 || opcion > 6){
                System.out.println("\nOpción inexistente");
            }
        }while (opcion < 0 || opcion > 6);
        return opcion;
    }

    public static void main(String[] args) {
        mensajeBienvenida();
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 1:
                    System.out.println("Operación 1)");
                    System.out.print("¿Ejecutar un sout con contenido o sin él?(S/N):");
                    char eleccion = teclado.next().charAt(0);
                    boolean contenido = (eleccion == 'S' || eleccion == 's');
                    System.out.print("Número de líneas 'sout' que quiere generar: ");
                    int n = teclado.nextInt();
                    if (contenido) {
                        System.out.print("Introduzca el contenido: ");
                        String mensaje = teclado.nextLine();
                        System.out.println();
                        for (int i = 0; i < n; i++) {
                            System.out.println("System.out.println(" + mensaje + ")");
                        }
                    } else if (eleccion == 'N' || eleccion == 'n') {
                        for (int i = 0; i < n; i++) {
                            System.out.println("System.out.println()");
                        }
                    }
                    System.out.println("\nSaliendo de la Operación 1)");
                    break;
                case 2:
                    System.out.println("Operación 2)");

                    break;
                case 3:
                    System.out.println("Operación 3)");

                    break;
                case 4:
                    System.out.println("Operación 4)");

                    break;
                case 5:
                    System.out.println("Operación 5)");

                    break;
            }
        }while (opcion != 6);
    }
}