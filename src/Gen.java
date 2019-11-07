import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Gen {
	Sequence[] secuencesList;

	public Gen(int n) {
		secuencesList = new Sequence[n];
	}

	protected void process(String linea) {
		StringTokenizer st = new StringTokenizer(linea);
		String operation = st.nextToken();

		if (operation.equals("insert")) {
			String sequence = null;
			try {
				int position = Integer.parseInt(st.nextToken());
				String type = st.nextToken();
				try {
					sequence = st.nextToken();
				} catch (Exception e) {
				}

				if (sequence == null) {
					this.secuencesList[position] = new Sequence();
					this.secuencesList[position].setType(type);
					return;
				}

				if (type == "ADN") {
					for (char nucleotide : sequence.toCharArray()) {
						if (nucleotide != 'A' && nucleotide != 'C' && nucleotide != 'G' && nucleotide != 'T') {
							return;
						}
					}
				} else if (type == "ARN") {
					for (char nucleotide : sequence.toCharArray()) {
						if (nucleotide != 'A' && nucleotide != 'C' && nucleotide != 'G' && nucleotide != 'U') {
							return;
						}
					}
				}

				else {
					this.secuencesList[position] = new Sequence(type, sequence);
				}
			} catch (Exception e) {
				return;
			}
		}

		else if (operation.equals("remove")) {
			try {
				int position = Integer.parseInt(st.nextToken());
				this.secuencesList[position] = null;
			} catch (Exception e) {
				return;
			}
		}

		else if (operation.equals("print")) {
			Integer position = null;

			try {
				position = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				position = null;
			}

			if (position == null) {
				for (int i = 0; i < secuencesList.length; i++) {
					if (secuencesList[i] != null) {
						System.out.println(i + " " + secuencesList[i]);
					}
				}
			} else {
				System.out.println(position + " " + secuencesList[position]);
			}
		}

		else if (operation.equals("clip")) {
			try {
				int position = Integer.parseInt(st.nextToken());
				int start = Integer.parseInt(st.nextToken());
				Integer end = null;
				try {
					end = Integer.parseInt(st.nextToken());
				} catch (Exception e) {
				}

				if (end == null) {
					end = secuencesList[position].length() - 1;
				}

				LList<Nucleotide> sequence = secuencesList[position].getSequence();
				LList<Nucleotide> auxSequence = new LList<Nucleotide>();

				sequence.moveToPos(start);
				for (int i = start; i <= end; i++) {
					auxSequence.append(sequence.getValue());
					sequence.next();
				}

				secuencesList[position].setSequence(auxSequence);
			} catch (Exception e) {
				return;
			}
		}

		else if (operation.equals("copy")) {
			int position1 = Integer.parseInt(st.nextToken());
			int position2 = Integer.parseInt(st.nextToken());

			Sequence sec1 = secuencesList[position1];
			String type = sec1.getType();

			LList<Nucleotide> auxSequence = new LList<Nucleotide>();

			LList<Nucleotide> sequence = sec1.getSequence();
			sequence.moveToPos(0);
			for (int i = 0; i < sec1.length(); i++) {
				auxSequence.append(new Nucleotide(sequence.getValue().getNucleotido()));
				sequence.next();
			}

			Sequence aux = new Sequence(type, auxSequence);

			secuencesList[position2] = aux;
		}

		else if (operation.equals("swap")) {
			int position1 = Integer.parseInt(st.nextToken());
			int start1 = Integer.parseInt(st.nextToken());
			int position2 = Integer.parseInt(st.nextToken());
			int start2 = Integer.parseInt(st.nextToken());

			LList<Nucleotide> sequence1 = secuencesList[position1].getSequence();
			LList<Nucleotide> sequence2 = secuencesList[position2].getSequence();

			LList<Nucleotide> auxSequence1 = new LList<Nucleotide>();
			LList<Nucleotide> auxSequence2 = new LList<Nucleotide>();

			sequence1.moveToPos(start1);
			int a = sequence1.length() - start1;
			for (int i = 0; i <= a - 1; i++) {
				auxSequence1.append(sequence1.getValue());
				sequence1.remove();
			}

			sequence2.moveToPos(start2);
			int b = sequence2.length() - start2;
			for (int i = 0; i <= b - 1; i++) {
				auxSequence2.append(sequence2.getValue());
				sequence2.remove();
			}

			auxSequence1.moveToPos(0);
			for (int i = 0; i <= auxSequence1.length() - 1; i++) {
				sequence2.append(auxSequence1.getValue());
				auxSequence1.next();
			}

			auxSequence2.moveToPos(0);
			for (int i = 0; i <= auxSequence2.length() - 1; i++) {
				sequence1.append(auxSequence2.getValue());
				auxSequence2.next();
			}
		}

		else if (operation.equals("transcribe")) {
			int position = Integer.parseInt(st.nextToken());
			Sequence sequence = secuencesList[position];
			LList<Nucleotide> cad = sequence.getSequence();
			LList<Nucleotide> cadAux = new LList<Nucleotide>();

			cad.moveToEnd();
			cad.prev();
			for (int i = 1; i <= cad.length(); i++) {
				char nucleotide = cad.getValue().getNucleotido();

				if (nucleotide == 'A') {
					nucleotide = 'U';
				} else if (nucleotide == 'T') {
					nucleotide = 'A';
				} else if (nucleotide == 'C') {
					nucleotide = 'G';
				} else if (nucleotide == 'G') {
					nucleotide = 'C';
				}

				cadAux.append(new Nucleotide(nucleotide));
				cad.prev();
				nucleotide = cad.getValue().getNucleotido();
				sequence.setType("ARN");
				sequence.setSequence(cadAux);
			}
		}
	}

	public void readFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				process(line);
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
		gen.readFile(args[1]);
	}
}
