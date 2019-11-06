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
			try {
				int pos = Integer.parseInt(st.nextToken());
				String tipo = st.nextToken();
				String sec = st.nextToken();
				this.lista[pos] = new Secuencia(tipo, sec);
			}
			catch (Exception e) {
				return;
			}
			
		}
		else if (operación.equals("remove")){
			try {
				int pos = Integer.parseInt(st.nextToken());
				this.lista[pos] = null;
			}
			catch (Exception e){
				return;
			}
			
		} 
		else if (operación.equals("print")){
			Integer pos = null;
			
			try {
				pos = Integer.parseInt(st.nextToken());
			}
			catch (Exception e) {
				pos = null;
			}
			
			if (pos == null) {
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
		else if (operación.equals("clip")){
			try {
				int pos1 = Integer.parseInt(st.nextToken());
				int start = Integer.parseInt(st.nextToken());
				Integer end = null;
				try {
					end = Integer.parseInt(st.nextToken());
				}
				catch (Exception e) {}
				
				if (end == null) {
					end = lista[pos1].length() - 1;
				}
				
				LList<Nucleotido> cadena = lista[pos1].getCadena();
				LList<Nucleotido> cadenaAux = new LList<Nucleotido>();
				
				cadena.moveToPos(start);
				for(int i=start;i<=end;i++) {
					cadenaAux.append(cadena.getValue());
					cadena.next();
				}
				
				lista[pos1].setCadena(cadenaAux);
				
			}
			catch (Exception e) {
				return;
			}
		}
		else if (operación.equals("copy")){
			int pos1 = Integer.parseInt(st.nextToken());
			int pos2 = Integer.parseInt(st.nextToken());
			
			Secuencia aux = lista[pos1];
			lista[pos2] = aux;
		}
		else if (operación.equals("swap")){
			int pos1 = Integer.parseInt(st.nextToken());
			int start1 = Integer.parseInt(st.nextToken());
			int pos2 = Integer.parseInt(st.nextToken());
			int start2 = Integer.parseInt(st.nextToken());
		}
		else if (operación.equals("transcribe")){
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
