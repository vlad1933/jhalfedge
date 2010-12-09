package model;

/**
 * User: itamar
 * Date: Nov 27, 2010
 * Time: 7:53:51 PM
 */
public class HalfEdge {
    private Vertex vertex;
    private HalfEdge next;
    private HalfEdge prev;
    private HalfEdge opp;

    public Vertex getVertex() {
        return vertex;
    }

    public HalfEdge getNext() {
        return next;
    }

    public HalfEdge getPrev() {
        return prev;
    }

    public HalfEdge getOpp() {
        return opp;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    private Face face;

    public HalfEdge(Vertex vertex) {
        try {
            this.vertex = vertex;
//            vertex.halfEdge = this;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public void setNext(HalfEdge next, boolean override) {
        if (this.next == null || override)
            this.next = next;
    }

    public void setPrev(HalfEdge prev) {
        this.prev = prev;
    }

    public void setOpp(HalfEdge opp) {
        this.opp = opp;
    }

    public void initialize(HalfEdge otherEdge) {
        this.next = otherEdge;
        this.prev = otherEdge;
        this.opp  = otherEdge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HalfEdge edge = (HalfEdge) o;

        if (!this.getVertex().equals(edge.getVertex())) return false;
        if (!this.getNext().getVertex().equals(edge.getNext().getVertex())) return false;

        return true;
    }
}
