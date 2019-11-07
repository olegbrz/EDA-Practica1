
public class Sequence {
	private LList<Nucleotide> sequence;
	private String type;

	public Sequence() {
		sequence = new LList<Nucleotide>();
	}

	public Sequence(String type, String sequence) {
		this.type = type;
		this.sequence = new LList<Nucleotide>();
		for (char c : sequence.toCharArray()) {
			this.sequence.append(new Nucleotide(c));
		}
	}

	public Sequence(String type, LList<Nucleotide> sequence) {
		this.type = type;
		this.sequence = sequence;
	}

	public LList<Nucleotide> getSequence() {
		return sequence;
	}

	public void setSequence(LList<Nucleotide> sequence) {
		this.sequence = sequence;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int length() {
		return sequence.length();
	}

	public String toString() {
		String type = this.type;
		String sequence = "";
		this.sequence.moveToStart();
		for (int i = 0; i < this.sequence.length(); i++) {
			sequence += this.sequence.getValue().getNucleotido();
			this.sequence.next();
		}
		String info = type + " " + sequence;
		return info;
	}

}
