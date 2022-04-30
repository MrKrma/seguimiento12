package model;

public class NodeDL {
	private int value;
	private int turns;
	private NodeDL prev;
	private NodeDL next;
	
	public int getTurns() {
		return turns;
	}
	public void setTurns(int turns) {
		this.turns = turns;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public NodeDL getPrev() {
		return prev;
	}
	public void setPrev(NodeDL prev) {
		this.prev = prev;
	}
	public NodeDL getNext() {
		return next;
	}
	public void setNext(NodeDL next) {
		this.next = next;
	}
	
	public NodeDL(int value) {
		this.value = value;
		this.turns = 0;
	}

}
