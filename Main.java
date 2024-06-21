import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Menu y Parqueadero
        Menu menu = new Menu();
        Parqueadero parqueadero = new Parqueadero(1.0);  // Valor inicial para la tarifa

        // Crear un objeto Scanner para leer la entrada desde el teclado
        Scanner sc = new Scanner(System.in);

        // Solicitar al usuario que ingrese la hora y minutos de ingreso
        System.out.println("Ingrese la hora de ingreso al parqueadero");
        int horaing = sc.nextInt();
        System.out.println("Ingrese los minutos");
        int minutosing = sc.nextInt();

        // Verificar que la hora y minutos de ingreso están en el rango permitido
        if (horaing >= 6 && horaing < 21 && minutosing >= 0 && minutosing <= 59) {
            // Solicitar al usuario que ingrese la tarifa del parqueadero
            System.out.println("Ingrese la tarifa del parqueadero");
            double tarifa = sc.nextDouble();
            parqueadero.setTarifa(tarifa);  // Usar el método setTarifa para establecer la tarifa

            // Imprimir la tarifa y esperar 2 segundos antes de mostrar el menú
            System.out.println("La tarifa inicial ingresada es de: " + parqueadero.getTarifa());
            try {
                Thread.sleep(2000);  // Espera de 2 segundos (2000 milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int respuesta;
            do {
                menu.MostrarMenu();
                respuesta = sc.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("Seleccionó: Ingresar un auto al parqueadero");

                        // Verificar si hay espacio disponible antes de ingresar un auto
                        if (parqueadero.puestosDisponibles() > 0) {
                            System.out.println("Ingrese la placa del auto a ingresar:");
                            String placaIngreso = sc.next();
                            if (parqueadero.ingresarAuto(placaIngreso)) {
                                System.out.println("Auto ingresado al parqueadero correctamente.");
                            }
                        } else {
                            System.out.println("No hay espacio disponible en el parqueadero.");
                        }
                        break;

                    case 2:
                        System.out.println("Seleccionó: Sacar un auto del parqueadero");

                        // Simular la salida de un auto
                        System.out.println("Ingrese la placa del auto a sacar:");
                        String placaSalida = sc.next();
                        if (parqueadero.autoEstaEnParqueadero(placaSalida)) {
                            parqueadero.sacarAuto(placaSalida);
                            System.out.println("Auto retirado del parqueadero correctamente.");
                        } else {
                            System.out.println("El auto no está actualmente en el parqueadero.");
                        }
                        break;

                    case 3:
                        System.out.println("Seleccionó: Informar los ingresos del parqueadero");

                        // Simular la presentación de los ingresos acumulados del parqueadero
                        // En este ejemplo, solo se cuenta la cantidad de autos ingresados
                        int ingresosTotales = parqueadero.getAutosIngresados().size();
                        System.out.println("Ingresos totales del parqueadero: " + ingresosTotales);
                        break;

                    case 4:
                        System.out.println("Seleccionó: Consultar los puestos disponibles");

                        // Simular la consulta de puestos disponibles
                        int puestosDisponibles = parqueadero.puestosDisponibles();
                        System.out.println("Puestos disponibles en el parqueadero: " + puestosDisponibles);
                        break;

                    case 5:
                        System.out.println("Seleccionó: Cambiar la tarifa del parqueadero");

                        // Solicitar al usuario la nueva tarifa y actualizarla
                        System.out.println("Ingrese la nueva tarifa del parqueadero");
                        double nuevaTarifa = sc.nextDouble();
                        parqueadero.setTarifa(nuevaTarifa);
                        System.out.println("La tarifa ha sido actualizada a: " + parqueadero.getTarifa());
                        break;

                    case 6:
                        System.out.println("Seleccionó: Avanzar el reloj");

                        // Simular el avance del reloj o del tiempo en el parqueadero
                        System.out.println("El tiempo ha avanzado en el parqueadero.");
                        break;

                    case 7:
                        System.out.println("Seleccionó: Calcular las horas del auto en el parqueadero");

                        // Simular el cálculo de las horas que ha estado un auto en el parqueadero
                        System.out.println("Ingrese la placa del auto para calcular las horas:");
                        String placaCalculo = sc.next();
                        // Lógica para calcular el tiempo transcurrido
                        System.out.println("Horas calculadas para el auto con placa " + placaCalculo);
                        break;

                    case 8:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }
            } while (respuesta != 8);  // Asegúrate de que el valor 8 es la opción de salida
        } else {
            System.out.println("La hora ingresada no es correcta. El parqueadero se encuentra cerrado.");
        }

        // Cerrar el objeto Scanner
        sc.close();
    }
}
