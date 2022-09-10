package ABB;

import java.util.Scanner;

/**
 * @since 19 de julio de 2022
 */
public class Main {

	public static void main(String[] args) {

		Arbol arbol = new Arbol();
		Scanner in = new Scanner(System.in);

		int item, flag, codigo, wait;
		Object objeto;
		boolean graficado = false;
		flag = wait = 0;

//MUESTRA EL MENÚ PRINCIPAL
		while (flag == 0) {
			System.out.println("---------------------------------");
			System.out.println("-> Menú                         |");
			System.out.println("| 1. Ingresar                   |");
			System.out.println("| 2. Consultar                  |");
			System.out.println("| 3. Salir                      |");
			System.out.println("---------------------------------");
			System.out.print("Ingresa una opción, por favor: ");
			try {
				item = in.nextInt();
				switch (item) {
					//PIDE DATOS
					case 1: {
						try {
							System.out.print("Ingresa el código: ");
							codigo = in.nextInt();
							System.out.print("Ingresa un dato cualquiera: ");
							objeto = in.next();

							arbol.insertar(codigo, objeto);
						} catch (Exception e) {
							System.out.println("(x) Algo ha ocurrido. Vuelve a intentarlo");
							flag = -1;
						}
						break;
					}
					//MUESTRA MENÚ DE MOSTRADO
					case 2: {
						if (!arbol.esVacio()) {
							//NUEVO ESTADO DEL MENÚ
							flag = 1;
							while (flag == 1) {
								try {
									System.out.println("---------------------------------");
									System.out.println("-> Mostrar                      |");
									System.out.println("| 1. De mayor a menor           |");
									System.out.println("| 2. Subárbol derecho           |");
									System.out.println("| 3. Subárbol izquierdo         |");
									System.out.println("| 4. Consulta individual        |");
									System.out.println("| 5. Graficar                   |");
									System.out.println("| 6. Volver                     |");
									System.out.println("---------------------------------");
									System.out.print("Ingresa una opción, por favor: ");
									item = in.nextInt();
								} catch (Exception e) {
									System.out.println("(x) Ingresa un item: [1-4]");
									flag = -1;
								}

								//OPCIONES DE MOSTRADO
								switch (item) {
									case 1: {
										if (!arbol.esVacio()) {
											arbol.mostraror();
											System.out.println("");
										} else {
											System.out.println("(x) Lo sentimos. El árbol está vacío");
										}
										System.out.print("*Escribe 1 para continuar: ");
										wait = in.nextInt();
										break;
									}
									case 2: {
										if (!arbol.esVacio()) {
											arbol.mostrarDerec();
											System.out.println("");
										} else {
											System.out.println("(x) Lo sentimos. El árbol está vacío");
										}
										System.out.print("*Escribe 1 para continuar: ");
										wait = in.nextInt();
										break;
									}

									case 3: {
										if (!arbol.esVacio()) {
											arbol.mostrarIzq();
											System.out.println("");
										} else {
											System.out.println("(x) Lo sentimos. El árbol está vacío");
										}
										System.out.print("*Escribe 1 para continuar: ");
										wait = in.nextInt();
										break;
									}

									case 4: {
										System.out.print("Ingresa el nodo a consultar: ");
										int x = in.nextInt();
										arbol.consultarPorReferencia(x);
										System.out.println("");
										System.out.print("*Escribe 1 para continuar: ");
										wait = in.nextInt();
										break;
									}
									case 5: {
										if (!arbol.esVacio()) {
											if (arbol.graficado) {
												arbol.visibilizar(false);
											}
											arbol.graficar();
										} else {
											System.out.println("(x) Lo sentimos. El árbol está vacío");
											System.out.print("*Escribe 1 para continuar: ");
											wait = in.nextInt();
										}
									}
									case 6: {
										flag = 0;
										break;
									}
									default: {
										System.out.println("(x) Opción inválida, vuelve a intentarlo");
										System.out.print("\n*Escribe 1 para continuar: ");
										wait = in.nextInt();
									}
								}
							}
						} else {
							System.out.println("(x) Lo sentimos. El árbol está vacío");
							System.out.print("\n*Escribe 1 para continuar: ");
							wait = in.nextInt();
						}
						break;
					}
					//CIERRA EL PROGRAMA

					case 3: {
						System.exit(0);
						break;
					}
					//OPCIÓN INVÁLIDA
					default: {
						System.out.println("(x) Opción inválida, vuelve a intentarlo");
						System.out.print("\n*Escribe 1 para continuar: ");
						wait = in.nextInt();
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("(x) Ingresa un item: [1 - 4]");
				flag = -1;
			}
		}
	}
}
