import java.util.Scanner;
//Hacer una versión de este programa pero que corra con parámetros únicamente

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
    public static String crearObjeto(Scanner teclado){
        String resultado;
        resultado = crearObjeto1(teclado) + crearObjeto2(teclado);
        return resultado;
    }
    private static String crearObjeto1(Scanner teclado){
        String parte1 = "";
        System.out.print("Tipo de objeto: ");
        String tipo = teclado.nextLine();
        System.out.print("Nombre del objeto: ");
        String nombre = teclado.nextLine();
        parte1 = tipo+" "+nombre+" = new "+tipo;
        return parte1;
    }
    private static String crearObjeto2(Scanner teclado){
        String parte2 = "";
        System.out.print("¿Tiene argumentos el constructor?(S/N): ");
        char a = teclado.next().charAt(0);
        teclado.nextLine();
        String argumentos = "";
        if (a == 'S' || a == 's'){
            System.out.print("(Argumentos): ");
            argumentos += teclado.nextLine();
        }
        parte2 = "("+argumentos+")";
        return parte2;
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
                    teclado.nextLine();
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
                    String cadena = crearObjeto(teclado);
                    System.out.print("¿Mismo nombre o enumerado?(N/E):");
                    char e = teclado.next().charAt(0);
                    System.out.print("Numero de líneas que quiere generar: ");
                    n = teclado.nextInt();
                    if (e == 'E' || e == 'e'){
                        String[] cadenas = cadena.split(" ");
                        for (int i = 0; i <= n; i++) {
                            cadena = cadenas[0]+" "+cadenas[1]+(i+1)+" "+cadenas[2]+" "+cadenas[3]+" "+cadenas[4];
                            System.out.println(cadena);
                        }
                    }else{
                        for (int i = 0; i < n; i++) {
                            System.out.println(cadena);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Operación 3)");
                    System.out.println("Introduzca la línea de código a repetir: ");
                    cadena = teclado.nextLine();
                    System.out.println("Numero de líneas que quiere generar: ");
                    n = teclado.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println(cadena);
                    }
                    break;
                case 4:
                    System.out.println("Operación 4)");
                    System.out.print("Número de case:");
                    n = teclado.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("case "+i+":");
                        System.out.println();
                        System.out.println("\tbreak;");
                    }
                    System.out.println("default: ");
                    System.out.println("\tbreak;");
                    break;
                case 5:
                    System.out.println("Operación 5)");
                    System.out.print("Número de condiciones if:");
                    n = teclado.nextInt();
                    System.out.println("if(){");
                    System.out.println();
                    for (int i = 0; i < n; i++) {
                        System.out.println("}else if(){");
                        System.out.println();
                    }
                    System.out.println("}else{");
                    System.out.println();
                    System.out.println("}");
                    break;
            }
        }while (opcion != 6);
        teclado.close();
    }
}