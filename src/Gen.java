// Nombre: Oleg
// DNI: Y4903207N
// Curso: 2�
// Grado: Ingenier�a de la Salud
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
		String operaci�n = st.nextToken();
		
		// Identificaci�n de operaci�n
		if (operaci�n.equals("insert")) {
			int pos = Integer.parseInt(st.nextToken());
			String tipo = st.nextToken();
			String sec = st.nextToken();
			
			this.lista[pos] = new Secuencia(tipo, sec);
		}
		else if (operaci�n.equals("remove")){
			int pos = Integer.parseInt(st.nextToken());
			this.lista[pos] = null;
		} 
		else if (operaci�n.equals("print")){
			Integer pos = null;
			
			try {
				pos = Integer.parseInt(st.nextToken());
			}
			catch (Exception e) {
				pos = null;
			}
			
			if (pos != null) {
				for (int i=0;i<lista.length;i++) {
					if (lista[i] != null) {
						System.out.println(i + " " + lista[i]);
					}
				}
			}
			else {
				System.out.println(pos + " " + lista[pos]);
			}
			
			
		}
		else if (operaci�n.equals("clip")){
			String pos = st.nextToken();
			String start = st.nextToken();
			String end = st.nextToken();
		}
		else if (operaci�n.equals("copy")){
			int pos1 = Integer.parseInt(st.nextToken());
			int pos2 = Integer.parseInt(st.nextToken());
			
			Secuencia aux = lista[pos1];
			lista[pos2] = aux;
			
			
		}
		else if (operaci�n.equals("swap")){
			String pos1 = st.nextToken();
			String start1 = st.nextToken();
			String pos2 = st.nextToken();
			String start2 = st.nextToken();
		}
		else if (operaci�n.equals("transcribe")){
			int pos = Integer.parseInt(st.nextToken());
			
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
