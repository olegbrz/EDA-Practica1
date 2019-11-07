
public class LList<E> implements List<E> {

	private Node<E> head;
	private Node<E> tail;
	private Node<E> curr;
	private int size;

	public LList(int size) {
		this();
	}

	public LList() {
		head = tail = curr = new Node<E>(null);
		size = 0;
	}

	@Override
	public void clear() {
		curr = tail = head = new Node<E>(null);
		size = 0;
	}

	@Override
	public void insert(E item) {
		curr.setNext(new Node<E>(item, curr.getNext()));
		if (tail == curr) {
			tail = curr.getNext();
		} // New tail
		size++;
	}

	@Override
	public void append(E item) {
		tail = tail.setNext(new Node<E>(item, null));
		size++;
	}

	@Override
	public E remove() {
		if (curr.getNext() == null) {
			return null; // Nothing to remove
		}
		E it = curr.getNext().getElement(); // Remember value
		if (tail == curr.getNext()) {
			tail = curr; // Removed last
		}
		curr.setNext(curr.getNext().getNext()); // Remove from list
		size--; // Decrement count
		return it;
	}

	@Override
	public void moveToStart() {
		curr = head;
	}

	@Override
	public void moveToEnd() {
		curr = tail;
	}

	@Override
	public void prev() {
		if (curr != head) {
			Node<E> temp = head;
			// March down list until we find the previous element
			while (temp.getNext() != curr) {
				temp = temp.getNext();
			}
			curr = temp;
		}
	}

	@Override
	public void next() {
		curr = curr.getNext();

	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public int currPos() {
		Node<E> temp = head;
		int i;
		for (i = 0; curr != temp; i++) {
			temp = temp.getNext();
		}
		return i;
	}

	@Override
	public void moveToPos(int pos) {
		assert (pos >= 0) && (pos <= size) : "Position out of range";
		curr = head;
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
	}

	@Override
	public E getValue() {
		if (curr.getNext() == null) {
			return null;
		}
		return curr.getNext().getElement();
	}

	public String toString() {
		String s = "";
		moveToStart();
		for (int i = 0; i < size; i++) {
			s += getValue();
			next();
		}
		return s;
	}
}
