package org.example;

import java.util.Scanner;

public class Cajero {

    private static int saldo = 100000;
    private static int saldo_reiniciado = 100000;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    /**
     * Ejecuta el menú principal del programa y gestiona la interacción con el usuario.
     */
    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            System.out.println("Seleccione una opción:  ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                ejecutarOpcion(opcion);
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida. Por favor ingrese un número. ");
                opcion = -1;
            }
        } while (opcion != 0);
        // TODO: Implementar el código para gestionar la interacción con el usuario.
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private static void mostrarOpciones() {
        System.out.println("---- CAJERO AUTOMÁTICO ----");
        System.out.println("[1] Retiro de dinero ");
        System.out.println("[2] Consultar Saldo");
        System.out.println("[3] Depositar Dinero");
        System.out.println("[0] Salir del programa");
        // TODO: Implementar el código para mostrar las opciones del menú en pantalla.
    }

    /**
     * Ejecuta la acción correspondiente según la opción seleccionada.
     * @param opcion Opción ingresada por el usuario.
     */
    private static void ejecutarOpcion(int opcion) {
        try {
            switch (opcion){
                case 1 -> {
                    System.out.println("Monto a retirar: ");
                    int monto = Integer.parseInt(scanner.nextLine());
                    retirar(monto);
                }

                case 2 -> {
                    System.out.println("Su saldo es de: " + obtenerSaldo());
                }

                case 3 -> {
                    System.out.println("Monto a depositar: ");
                    int monto = Integer.parseInt(scanner.nextLine());
                    depositar(monto);
                }
                case 0 -> System.out.println("Saliendo del programa....");
                default -> System.out.println("Opción inválida");
            }
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un número. ");
        } catch (Exception e) {
            System.out.println("Error inesperado:" + e.getMessage());
        }
        // TODO: Implementar la lógica para ejecutar la opción seleccionada.
    }

    /**
     * Realiza un retiro de dinero si las condiciones son válidas.
     * @param monto Monto a retirar.
     */
    public static void retirar(int monto) {
        if (monto <= 0){
            System.out.println("El monto debe ser mayor que cero.");
            return;
        }

        if (monto % 1000 != 0) {
            System.out.println("El monto debe ser múltiplo de 1000.");
            return;
        }

        if (monto > saldo) {
            System.out.println("Saldo insuficiente. Saldo disponible: $" + saldo);
        }

        saldo -= monto;

        // TODO: Validar monto positivo
        // TODO: Validar múltiplo de 1000

        // TODO: Validar que el saldo sea suficiente
        // TODO: Restar el monto del saldo si todo es válido
    }

    /**
     * Deposita un monto de dinero al saldo, si es válido.
     * @param monto Monto a depositar.
     */
    public static void depositar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return;
        }

        if (monto % 1000 != 0){
            System.out.println("El monto debe ser múltiplo de 1000.");
            return;
        }

        saldo += monto ;
        System.out.println("Depósito realizado. Nuevo saldo: $" + saldo);
        // TODO: Validar monto positivo
        // TODO: Validar múltiplo de 1000
        // TODO: Sumar el monto al saldo si es válido
    }

    /**
     * Retorna el saldo disponible en la cuenta simulada.
     * @return Saldo actual.
     */
    public static int obtenerSaldo() {
        // TODO: Retornar el valor actual del saldo
        return saldo;
    }

    /**
     * Reinicia el saldo a un valor inicial fijo (usado en pruebas).
     */
    public static void reiniciarSaldo() {
        saldo = saldo_reiniciado;
        System.out.println("El saldo ha sido reiniciado a $" + saldo);
        // TODO: Restablecer el valor del saldo a su valor original
    }
}