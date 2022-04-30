package model;

public class BankLine {
	
	NodeDL head;
	NodeDL turn;
	
	public NodeDL getHead() {
		return head;
	}
	public void setHead(NodeDL head) {
		this.head = head;
	}
	public NodeDL getTurn() {
		return turn;
	}
	public void setTurn(NodeDL turn) {
		this.turn = turn;
	}
	
	public BankLine() {
	}
	
	public void addNode(int value) {
		if(head == null) {
			head = new NodeDL(value);
			head.setNext(head);
			head.setPrev(head);
			turn = head;
		}else {
			NodeDL node = new NodeDL(value);
			NodeDL tail = head.getPrev();
			
			tail.setNext(node);
			node.setPrev(tail);
			node.setNext(head);
			head.setPrev(node);
		}
	}
	
	public boolean deleteTurn(int value) {
		boolean delete = false;
		delete = deleteTurn(head, value);
		return delete;
	}
	
	private boolean deleteTurn(NodeDL current, int value) {
		if(current.getValue() == value) {
			current.getNext().setPrev(current.getPrev());
			current.getPrev().setNext(current.getNext());
			
			if(current == turn) {
				nextTurn();
			}
			if(current == head) {
				NodeDL node = current.getNext();
				head = node;
			}
			return true;
		}
		if(current.getNext() == head) {
			return false;
		}
		
		return deleteTurn(current.getNext(), value);
	}
	
	public int lastTurn() {
		int turn = 0;
		if(head != null) {
			turn = head.getPrev().getValue();
		}
		return turn;
	}
	
	public String print() {
		return print(head, "");
	}
	
	private String print(NodeDL node, String theList) {
		if(node.getNext().equals(head)) {
			return theList+"["+node.getValue()+"]";
		}
		return theList += "["+node.getValue()+"]" +print(node.getNext(), theList);
	}
	
	public int theTurn() {
		return turn.getValue();
	}
	
	public void nextTurn() {
		NodeDL node = turn.getNext();
		int num = turn.getTurns();
		if(num > 3) {
			deleteTurn(head, turn.getValue());
		}else {
			turn.setTurns(num+1);
		}
		turn = node;
	}
}
