package edge;

import java.util.Set;

import vertex.Vertex;

public class CommentTie extends DirectedEdge{
	// Abstraction function:
    // AF(Edge) = {edge|label != null && source ！= null && target ！= null && weight >= 0 && type of source, target = person}.
	//
    // Representation invariant:
	// label cannot be null
    // Neither source nor target can be null
	// weight is more than or equals 0
	// type of two vertices is person
	//
    // Safety from rep exposure:
    // All fileds are private
	// the get methods can prevent sharing data with clients.
	public CommentTie(String label, double weight) {
		super(label, weight);
		checkRep();
	}
	public CommentTie(Vertex src,Vertex arg, double weight) {
		super(src,arg, weight);
		checkRep();
	}
	public CommentTie(String label, Vertex src,Vertex arg, double weight) {
		super(label,src,arg, weight);
		checkRep();
	}
	private void checkRep() {
		assert !super.getsource().equals(super.gettarget());
		assert this.getsource().tellclass().equals("Person");
		assert this.gettarget().tellclass().equals("Person");
	}
	@Override
	public String tellclass() {
		return "CommentTie";
	}
	@Override
	public boolean equals(Object e) { 
		Edge edge = (Edge) e;
		if(edge.tellclass().equals(this.tellclass())) {
			if(edge.getsource().equals(this.getsource()) && edge.gettarget().equals(this.gettarget())
					) {
				return true;
			}else {
				return false;
			}
		}else{
			return false;
		}
	}
}