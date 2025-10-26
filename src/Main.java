import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ============================================================

        // 🧩 EJERCICIO: SIMULADOR DEL PROBLEMA DE LAS TRES PUERTAS (SIN FUNCIONES)

        // ============================================================

        //

        // 🎯 OBJETIVO:

        // Simular N partidas (por ejemplo, 100) del juego de las 3 puertas (Monty Hall)

        // para comparar dos estrategias:

        //   A) Mantener la puerta elegida inicialmente.

        //   B) Cambiar a la otra puerta disponible después de que el presentador abra una.

        //

        // ------------------------------------------------------------

        // 🧠 RESTRICCIÓN:

        // - TODO el código debe ir en este main. NO usar funciones auxiliares.

        //

        // ------------------------------------------------------------

        // 🏗️ PASOS A IMPLEMENTAR (TODO en main):

        //

        // 1) Declarar variables de control:

        //    - int partidas = 100;  // o el número que quieras

        //    - int victoriasManteniendo = 0;

        //    - int victoriasCambiando = 0;

        //

        // 2) Bucle for que repita 'partidas' veces la simulación:

        //    En cada iteración:

        //    - Generar aleatoriamente la puerta con premio: int premio = (int)(Math.random()*3); // 0,1,2

        //    - Generar la elección inicial del concursante: int eleccion = (int)(Math.random()*3);

        //

        //    - Determinar qué puerta abre el presentador:

        //        * Debe ser una puerta distinta de 'eleccion' y que NO tenga el premio.

        //        * Elegir una de las válidas (si hay dos, puedes escoger una al azar).

        //        * Guardar en: int abierta = ...;

        //

        //    - Determinar la otra puerta cerrada distinta de 'eleccion' y de 'abierta':

        //        * Guardar en: int otraCerrada = ...;

        //

        //    - Estrategia A (mantener):

        //        * Si 'eleccion' == 'premio', sumar 1 a victoriasManteniendo.

        //

        //    - Estrategia B (cambiar):

        //        * Si 'otraCerrada' == 'premio', sumar 1 a victoriasCambiando.

        //

        // 3) Al terminar el bucle:

        //    - Imprimir:

        //        "Partidas: X"

        //        "Victorias manteniendo: X (Y%)"

        //        "Victorias cambiando:   X (Y%)"

        //

        //    - Comentar brevemente cuál estrategia resulta mejor en la simulación.

        //      (Debería salir ~33% manteniendo y ~66% cambiando).

        //

        // ------------------------------------------------------------

        // 💡 PISTAS:

        // - Representa las puertas como 0, 1 y 2.

        // - Para hallar 'abierta', puedes usar un pequeño bucle while que pruebe valores

        //   hasta encontrar una puerta válida (≠ eleccion y ≠ premio).

        // - 'otraCerrada' es la única puerta que no es 'eleccion' ni 'abierta'.

        //

        // ------------------------------------------------------------

        // 🔁 OPCIONALES:

        // - Permitir cambiar el número de partidas (leer de args o Scanner).

        // - Mostrar resultados parciales cada 10 partidas.

        // - Añadir una estrategia "aleatoria" (a veces cambia, a veces no) y contar sus victorias.

        //

        // ============================================================

        Scanner sc = new Scanner(System.in);

        int partidas = 0;
        int victorias_manteniendo = 0;
        int victorias_cambiando = 0;

        System.out.println("Bienvenido a Monty Hall! Dinos tu nombre concursante: ");
        String concursante = sc.nextLine();
        System.out.println("Perfecto " + concursante + "! Pues vamos a jugar...\n");

        int opcion_menu = 0;

        do {
            System.out.println(" ");
            System.out.println("==========🚪 Menu Monty Hall 🚪=========\n");
            System.out.println("1. Jugar una partida\n");
            System.out.println("2. Mostrar estadisticas de la sesión\n");
            System.out.println("3. Salir\n");
            System.out.println("=======================================\n");
            System.out.println(" ");
            System.out.print("Ingresa la opcion que desees: ");
            int opcion = sc.nextInt();

            while (opcion != 1 && opcion != 2 && opcion != 3) {
                System.out.println("Opcion incorrecta, ingrese una opcion valida: ");
                opcion = sc.nextInt();
            }

            opcion_menu = opcion;

            switch (opcion) {
                case 1:
                    partidas++;

                    int[] puertas = new int[3];
                    puertas[0] = 1;
                    puertas[1] = 2;
                    puertas[2] = 3;
                    int premio = (int) (Math.random() * 3)+1;
                    System.out.println("(DEBUG) La puerta con premio es: " + premio); // puedes borrar esto si quieres



                    int i = 3;
                    int puertaElegida = 0;

                    int abierta;
                    do {
                        abierta = (int) (Math.random() * 3)+1;
                    } while (abierta == puertaElegida || abierta == premio);
                    System.out.println("(DEBUG) La puerta abieta por el presentador es: " + abierta);

                    // Determinar la otra puerta cerrada
                    int cerrada = 0;
                    for (int j = 1; j <= 3; j++) {
                        if (j != premio && j != abierta) {
                            cerrada = j;
                            System.out.println("(DEBUG) La puerta cerrada es: " + cerrada);
                            break;
                        }
                    }

                    boolean cambiando = false;
                    while (i > 1 || puertaElegida == premio) {
                        int eleccionCambio = 0;
                        while (eleccionCambio != 1) {
                            System.out.println(concursante + " Elige una de las puertas (1, 2, 3): ");
                            int puerta_elegida1 = sc.nextInt();
                            puertaElegida = puerta_elegida1;
                            System.out.println(concursante + " has elegido la puerta " + puerta_elegida1 + ". Quieres mantener tu elección (1) o prefieres cambiarla? (2)");
                            int eleccion = sc.nextInt();
                            eleccionCambio = eleccion;
                            if (eleccion == 2) {
                                cambiando = true;
                            }
                        }
                        if (eleccionCambio == 1) {
                            if (puertaElegida == premio) {
                                System.out.println("Enhorabuena! Has escogido la puerta correcta, te llevas el premio felicidades!\n");
                                if (cambiando) {
                                    victorias_cambiando++;
                                } else {
                                    victorias_manteniendo++;
                                }
                                break;
                            } else {
                                i--;
                                int[] puertasRestantes = new int[2];
                                if (puertaElegida == 1) {
                                    puertasRestantes[0] = 2;
                                    puertasRestantes[1] = 3;
                                } else if (puertaElegida == 2) {
                                    puertasRestantes[0] = 1;
                                    puertasRestantes[1] = 3;
                                } else if (puertaElegida == 3) {
                                    puertasRestantes[0] = 1;
                                    puertasRestantes[1] = 2;
                                }
                                System.out.println("La puerta escogida es incorrecta. Elige una de las puertas restantes, puerta " + puertasRestantes[0] + ", o puerta " + puertasRestantes[1] + ": ");
                                int puerta_elegida2 =  sc.nextInt();
                                while (eleccionCambio != 1) {
                                    puertaElegida = puerta_elegida2;
                                    System.out.println(concursante + " has elegido la puerta " + puerta_elegida2 + ". Quieres mantener tu elección (1) o prefieres cambiarla? (2)");
                                    int eleccion = sc.nextInt();
                                    eleccionCambio = eleccion;
                                    if (eleccion == 2) {
                                        cambiando = true;
                                    }
                                }
                                if (eleccionCambio == 1) {
                                    if (puerta_elegida2 == premio) {
                                        System.out.println("Enhorabuena! Has escogido la puerta correcta, te llevas el premio felicidades!\n");
                                        if (cambiando) {
                                            victorias_cambiando++;
                                        } else {
                                            victorias_manteniendo++;
                                        }
                                        break;
                                    } else {
                                        int puertaRestante = 0;
                                        if (puertaElegida == 1 && puerta_elegida2 == puertasRestantes[0]) {
                                            puertaRestante = 3;
                                            System.out.println("Has perdido! La puerta que contenía el premio era la puerta " + puertaRestante + ".\n");
                                        } else if (puertaElegida == 2 && puerta_elegida2 == puertasRestantes[0]) {
                                            puertaRestante = 3;
                                            System.out.println("Has perdido! La puerta que contenía el premio era la puerta " + puertaRestante + ".\n");
                                        } else if (puertaElegida == 3 && puerta_elegida2 == puertasRestantes[0]) {
                                            puertaRestante = 2;
                                            System.out.println("Has perdido! La puerta que contenía el premio era la puerta " + puertaRestante + ".\n");
                                        }
                                        i--;
                                    }

                                }
                            }
                        }
                    }

                case 2:
                    // 🔧 Mostrar estadísticas con porcentajes
                    System.out.println("\n===== 📊 ESTADÍSTICAS DE LA SESIÓN =====");
                    System.out.println("Partidas jugadas: " + partidas);
                    System.out.println("Victorias manteniendo: " + victorias_manteniendo +
                            " (" + (partidas > 0 ? (100.0 * victorias_manteniendo / partidas) : 0) + "%)");
                    System.out.println("Victorias cambiando:   " + victorias_cambiando +
                            " (" + (partidas > 0 ? (100.0 * victorias_cambiando / partidas) : 0) + "%)");
                    System.out.println("=========================================\n");
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("La opcion introducida no es válida, introduce un valor válido: ");


            }
        } while (opcion_menu != 3);


    }
}