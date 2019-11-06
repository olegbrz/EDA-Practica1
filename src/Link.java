
class Link <E > {
	private E element ; // valor del nodo
	private Link <E> next ; // ref . siguiente nodo
	
	// Constructores
	Link(E it, Link<E> nextval) {
		element = it;
		next = nextval;
		}
	
	Link(Link<E> nextval){
		element = null;
		next = nextval;
		}
	
	// Gestion de enlaces
	Link<E> next() {
		return next;
		}
	
	Link<E> setNext(Link<E> nextval){
		return next = nextval;
		}
	
	// Acceso
	E element () {
		return element;
		}
	E setElement (E it) {
		return element = it;
		}
}