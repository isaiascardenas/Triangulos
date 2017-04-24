import java.util.Scanner; 
import java.io.*;

class Taller1 {

	public static void main(String[] args) {

		// File read

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File ("./triangle.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			Triangle triangle = new Triangle();
			String linea;
			int n = Integer.parseInt(br.readLine());
			triangle.setHigh(n);
			triangle.setLines();

			for (int i=0; i < n; i++) {
				triangle.setLine(i, br.readLine());
			}
			fr.close();

			System.out.println("maxArea: " + triangle.getMaxArea());
			
			// test
			// int maxArea = 1;
			// for (int i=0; i<triangle.getHigh(); i++) {
			// 	for (int j=0; j<triangle.getLines()[i].length(); j++) {
			// 		if (triangle.getLines()[i].charAt(j) == '-' && j%2 ==1) {
			// 			triangle.setPivot(j);
			// 			System.out.println("i: " + i);
			// 			System.out.println("j: " + j);
			// 			System.out.println("pivot: " + triangle.getPivot());
			// 			System.out.println("area: " + maxArea);	
			// 		}
			// 	}
			// }

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
