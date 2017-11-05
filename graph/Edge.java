package graph;

/**
 * A <b>directed</b> edge.
 * @author olsenp
 *
 */
public class Edge {
	private Vertex source;
	private Vertex destination;
	private char strength; /* Either S (strong), W (weak), or 0 (no label)*/
	
	/**
	 * Creates a directed edge with a vertex at each end.
	 * @param in the edge is from this vertex
	 * @param out the edge goes to this vertex.
	 */
	public Edge(Vertex in, Vertex out) {
		source = in;
		destination = out;
	}
	
	/**
	 * Creates a directed edge with a vertex at each end.
	 * @param in the edge is from this vertex
	 * @param out the edge goes to this vertex
	 * @param strength S or W for strong or weak respectively.
	 */
	public Edge(Vertex in, Vertex out, char strength) {
		source = in;
		destination = out;
		this.strength = strength;
	}

	/** This method allows edges to be stored in hashsets or used as
	 * indices in hashmaps.
	 */
	public int hashCode() {
		return source.hashCode() ^ destination.hashCode();
	}
	
	/**
	 * Returns the vertex this edge came out of.
	 * @return the vertex this edge came out of.
	 */
	public Vertex source() {
		return source;
	}
	
	/**
	 * Returns the vertex this edge is going to.
	 * @return the vertex this edge is going to.
	 */
	public Vertex destination() {
		return destination;
	}
	
	/**
	 * Returns the strength of the edge.
	 * @return the strength of the edge.
	 */
	public char strength() {
		return strength;
	}
	
	public boolean equals(Object o) {
		return source.equals(((Edge)o).source) &&
				destination.equals(((Edge)o).destination);
	}
}