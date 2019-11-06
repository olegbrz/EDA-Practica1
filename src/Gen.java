// Nombre: Oleg
// DNI: Y4903207N
// Curso: 2º
// Grado: Ingeniería de la Salud
// Grupo: A

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

// Esqueleto basico para el ejercicio "Secuencias Geneticas con listas"
public class Gen {
	Secuencia[] lista;
	
	public Gen(int n) {
		lista = new Secuencia[n];
	}
	
	protected void procesar(String linea) {
		// Troceo de linea
		StringTokenizer st = new StringTokenizer(linea);
		String operación = st.nextToken();
		
		// Identificación de operación
		if (operación.equals("insert")) {
			int pos = Integer.parseInt(st.nextToken());
			String tipo = st.nextToken();
			String sec = st.nextToken();
			
			this.lista[pos] = new Secuencia(tipo, sec);
		}
		else if (operación.equals("remove")){
			int pos = Integer.parseInt(st.nextToken());
			this.lista[pos] = null;
		} 
		else if (operación.equals("print")){
			String pos = st.nextToken();	
				}
		else if (operación.equals("clip")){
			String pos = st.nextToken();
			String start = st.nextToken();
			String end = st.nextToken();
		}
		else if (operación.equals("copy")){
			String pos1 = st.nextToken();
			String pos2 = st.nextToken();
		}
		else if (operación.equals("swap")){
			String pos1 = st.nextToken();
			String start1 = st.nextToken();
			String pos2 = st.nextToken();
			String start2 = st.nextToken();
		}
		else if (operación.equals("transcribe")){
			String pos = st.nextToken();
		}
	} 
	
	public void leerFichero(String nombreFichero) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			while ((linea = br.readLine()) != null)   {
				  procesar(linea);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Gen gen = new Gen(Integer.parseInt(args[0]));
		gen.leerFichero(args[1]);	
	}
	
	

}
