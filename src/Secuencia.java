
public class Secuencia {
	private LList<Nucleotido> cadena;
	private String tipo;
	
	public Secuencia() {
		cadena = new LList<Nucleotido>();
	}
	
	public Secuencia(String tipo, String cadena) {
		this.tipo = tipo;
		this.cadena = new LList<Nucleotido>();
		for(char c: cadena.toCharArray()) {
			this.cadena.append(new Nucleotido(c));
		}
	}
	
	public LList<Nucleotido> getCadena() {
		return cadena;
	}

	public void setCadena(LList<Nucleotido> cadena) {
		this.cadena = cadena;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int length() {
		return cadena.length();
	}
	
	public String toString() {
		String tipo = this.tipo;
		String cadena = "";
		this.cadena.moveToStart();
		for(int i =0 ; i<this.cadena.length(); i++) {
			cadena += this.cadena.getValue().getNucleotido();
			this.cadena.next();
			}
		String datos = tipo + " " + cadena;
		return datos;
	}
	
}
