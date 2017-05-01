import java.util.Scanner; 
import java.io.*;

class Entrega1 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int n = 0;
		int i = 0;
		boolean opcionInvalida = true;
		char metodo;
		char entrada;

		while (opcionInvalida) {
			System.out.println("Ingrese una opción válida para escoger un método de resolución:");
			System.out.println("1) Método iterativo");
			System.out.println("2) Método recursivo");
			System.out.print("-> ");
			metodo = reader.next().charAt(0);

			if (metodo == '1' || metodo == '2') {

				System.out.println("Ingrese la opción de entrada:");
				System.out.println("1) Tipeo linea a linea");
				System.out.println("2) Lectura de archivo");
				System.out.print("-> ");
				entrada = reader.next().charAt(0);

				switch (entrada) {
					case '1':
						System.out.println("Ingrese la cantidad de filas del triángulo: ");
						System.out.print("-> ");
						n = reader.nextInt();

						if (metodo == '1') {
								Iterativo triangle = new Iterativo();
								triangle.setHigh(n);
								triangle.setLines();

								for (i=0; i < n; i++) {
									System.out.println("Ingrese la linea número "+(i+1)+" (debe tener "+(2*(n-(i+1))+1)+" carácteres):");
									System.out.print("-> ");
									String line = reader.next();
									triangle.setLine(i, line);
								}

								System.out.println("El triángulo más grande posee un área de: " + triangle.getMaxArea());
							} else {
								Recursivo triangle = new Recursivo();
								triangle.setHigh(n);
								triangle.setLines();

								for (i=0; i < n; i++) {
									System.out.println("Ingrese la linea número "+(i+1)+" (debe tener "+(2*(n-(i+1))+1)+" carácteres):");
									System.out.print("-> ");
									String line = reader.next();
									triangle.setLine(i, line);
								}

								System.out.println("El triángulo más grande posee un área de: " + triangle.getMaxArea());
							}

						opcionInvalida = false;
						break;

					case '2':

						System.out.println("Ingrese el nombre del archivo (debe estar en ésta carpeta):");
						System.out.print("-> ");
						String file = reader.next();

						System.out.println("Ingrese la ubicación del archivo:");
						System.out.print("-> ");
						String path = reader.next();
						try {
							File archivo = new File (path+"/"+file+".txt");
							FileReader fr = new FileReader (archivo);
							BufferedReader br = new BufferedReader(fr);
							if (metodo == '1') {
								Iterativo triangle = new Iterativo();
								n = Integer.parseInt(br.readLine());
								triangle.setHigh(n);
								triangle.setLines();

								for (i=0; i < n; i++) {
									triangle.setLine(i, br.readLine());
								}
								fr.close();

								System.out.println("El triángulo más grande posee un área de: " + triangle.getMaxArea());
								opcionInvalida = false;
							} else {
								Recursivo triangle = new Recursivo();
								n = Integer.parseInt(br.readLine());
								triangle.setHigh(n);
								triangle.setLines();

								for (i=0; i < n; i++) {
									triangle.setLine(i, br.readLine());
								}
								fr.close();

								System.out.println("El triángulo más grande posee un área de: " + triangle.getMaxArea());
								opcionInvalida = false;
							}
						} catch(Exception e){
							e.printStackTrace();
						}
						break;

					default:
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
						System.out.println("Ingrese una opción válida.");
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}		
			} else {
				System.out.println("input: "+metodo);
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Ingrese una opción válida.");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
}
