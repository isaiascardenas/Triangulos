import java.util.Scanner; 
import java.io.*;

class Taller1 {

	public static void main(String[] args) {

		// File read

		try {
			File archivo = new File ("./triangle.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);

			Recursivo triangle = new Recursivo();
			int n =Integer.parseInt(br.readLine());
			triangle.setHigh(n);
			triangle.setLines();

			for (int i=0; i < n; i++) {
				triangle.setLine(i, br.readLine());
			}
			fr.close();

			System.out.println("maxArea: " + triangle.getMaxArea());

		} catch(Exception e){
			e.printStackTrace();
		}

		// Input

		// Scanner reader = new Scanner(System.in);
		// System.out.println("ingrese la cantidad de filas del triangulo: ");
		// int n = reader.nextInt();
		// for (int i = 0; i < n ; i++ ) {
		// 	reader = new Scanner(System.in);
		// 	System.out.println("ingrese linea a linea el triangulo");
		// 	String line = reader.next();
		// }
	}
}
