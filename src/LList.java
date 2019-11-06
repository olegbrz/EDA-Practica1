class LList<E> {
	private Link<E> head ;
	private Link<E> tail ;
	private Link<E> curr ;
	private int listSize ;
	
	/** Constructors */
	LList(int size) {
		this ();
	}

	LList(){
		clear();
		}
	
	// Remove all elements
	public void clear () {
		// Create trailer
		curr = tail = new Link <E>(null);
		
		// Create header
		head = new Link<E>(tail);
		listSize = 0;
	}
	
	public boolean append ( E it ) {
		tail = tail.setNext(new Link<E>( null ));
		tail.setElement(it);
		tail = tail.next();
		listSize++;
		return true ;
		}

	public boolean insert ( E it ) {
		curr.setNext(new Link <E>(curr.element(), curr.next ()));
		curr.setElement(it);
		if (tail == curr) {
			tail = curr.next (); // New tail
		}
		listSize++;
		return true;
		}

}
