// Nombre: Oleg
// DNI: Y4903207N
// Curso: 2
// Grado: Ingenieria de la Salud
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
			String sec = null;
			try {
				int pos = Integer.parseInt(st.nextToken());
				String tipo = st.nextToken();
				try {
					sec = st.nextToken();
				}
				catch (Exception e) {}
					
				if (sec == null) {
					this.lista[pos] = new Secuencia();
					this.lista[pos].setTipo(tipo);
					return;
				}
				
				if (tipo == "ADN") {
					for (char nuc: sec.toCharArray()) {
						if (nuc != 'A' && nuc != 'C' && nuc != 'G' && nuc != 'T') {
							return;
						}
					}
				}
				else if (tipo=="ARN") {
					for (char nuc: sec.toCharArray()) {
						if (nuc != 'A' && nuc != 'C' && nuc != 'G' && nuc != 'U') {
							return;
						}
					}
				}
				
				else {
					this.lista[pos] = new Secuencia(tipo, sec);
				}
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
			
			Secuencia sec1 = lista[pos1];
			String type = sec1.getTipo();
			
			LList<Nucleotido> cadena = new LList<Nucleotido>();
			
			LList<Nucleotido> cad = sec1.getCadena();
			cad.moveToPos(0);
			for (int i=0; i<sec1.length();i++) {
				cadena.append(new Nucleotido(cad.getValue().getNucleotido()));
				cad.next();
			}
			
			Secuencia aux = new Secuencia(type, cadena);
			
			lista[pos2] = aux;
		}
		
		else if (operación.equals("swap")){
			int pos1 = Integer.parseInt(st.nextToken());
			int start1 = Integer.parseInt(st.nextToken());
			int pos2 = Integer.parseInt(st.nextToken());
			int start2 = Integer.parseInt(st.nextToken());
			
			LList<Nucleotido> cadena1 = lista[pos1].getCadena();
			LList<Nucleotido> cadena2 = lista[pos2].getCadena();
			
			LList<Nucleotido> cadenaAux1 = new LList<Nucleotido>();
			LList<Nucleotido> cadenaAux2 = new LList<Nucleotido>();
			
			cadena1.moveToPos(start1);
			int a =cadena1.length() - start1;
			for(int i=0;i<=a-1;i++) {
				cadenaAux1.append(cadena1.getValue());
				cadena1.remove();
			}
			
			cadena2.moveToPos(start2);
			int b =cadena2.length() - start2;
			for(int i=0;i<=b-1;i++) {
				cadenaAux2.append(cadena2.getValue());
				cadena2.remove();
			}
			
			cadenaAux1.moveToPos(0);
			for(int i=0;i<=cadenaAux1.length()-1;i++) {
				cadena2.append(cadenaAux1.getValue());
				cadenaAux1.next();
			}
			
			cadenaAux2.moveToPos(0);
			for(int u=0;u<=cadenaAux2.length()-1;u++) {
				cadena1.append(cadenaAux2.getValue());
				cadenaAux2.next();
			}
		}
		
		else if (operación.equals("transcribe")){
			int pos = Integer.parseInt(st.nextToken());
			Secuencia sec = lista[pos];
			LList<Nucleotido> cad = sec.getCadena();
			LList<Nucleotido> cadAux = new LList<Nucleotido>();
			
			cad.moveToEnd();
			cad.prev();
			for (int i=1;i<=cad.length();i++) {
				char nuc = cad.getValue().getNucleotido();
				
				if (nuc == 'A') {
					nuc = 'U';
				}
				else if (nuc == 'T') {
					nuc = 'A';
				}
				else if (nuc == 'C') {
					nuc = 'G';				
				}
				else if (nuc == 'G') {
					nuc = 'C';
				}
				cadAux.append(new Nucleotido(nuc));
				cad.prev();
				nuc = cad.getValue().getNucleotido();
			sec.setTipo("ARN");
			sec.setCadena(cadAux);
			}
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
