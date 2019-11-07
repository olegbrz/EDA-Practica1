
public class Node<E> {
	private E element;
	private Node<E> next;

	public Node(Node<E> next) {
		this.next = next;
	}

	public Node(E element, Node<E> next) {
		this.element = element;
		this.next = next;
	}

	public Node<E> getNext() {
		return next;
	}

	public Node<E> setNext(Node<E> next) {
		return this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

}
