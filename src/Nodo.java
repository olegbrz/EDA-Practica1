
public class Nodo<E> {
	private E element;
	private Nodo<E> next;
	
	public Nodo(Nodo<E> next)
	{
		this.next = next;
	}
	
	public Nodo(E element, Nodo<E> next)
	{
		this.element = element;
		this.next = next;
	}
	
	public Nodo<E> getNext() 
	{
		return next;
	}
	public Nodo<E> setNext(Nodo<E> next)
	{
		return this.next = next;
	}
	
	public E getElement()
	{
		return element;
	}
	public void setElement(E element)
	{
		this.element = element;
	}

}
