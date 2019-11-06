
public class Secuencia {
	private LList<Nucleotido> lista;
	private String tipo;
	
	public Secuencia() {
		lista = new LList<Nucleotido>();
	}
	
	public Secuencia(String tipo, String cadena) {
		this.tipo = tipo;
		lista = new LList<Nucleotido>();
		for(char c: cadena.toCharArray()) {
			lista.append(new Nucleotido(c));
		}
	}
	
	public void insert(Nucleotido n) {
		lista.insert(n);
	}
	
	public void remove() {
	}
	
	public void print() {
		
	}
	
	public void clip() {
		
	}
	public void copy() {
		
	}
	
	public void swap() {
		
	}
	
	public void transcribe() {
		
	}

}
