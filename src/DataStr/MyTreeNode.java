package DataStr;

public class MyTreeNode<Ttype> {
	private Ttype element;
	private MyTreeNode parent = null;
	private MyTreeNode rightCh = null;
	private MyTreeNode leftCh = null;
	
	public Ttype getElement() {
		return element;
	}
	public void setElement(Ttype element) {
		if(element != null)
			this.element = element;
		else
			this.element = (Ttype) new Object();
	}
	public MyTreeNode getParent() {
		return parent;
	}
	public void setParent(MyTreeNode parent) {
		this.parent = parent;
	}
	public MyTreeNode getRightCh() {
		return rightCh;
	}
	public void setRightCh(MyTreeNode rightCh) {
		this.rightCh = rightCh;
	}
	public MyTreeNode getLeftCh() {
		return leftCh;
	}
	public void setLeftCh(MyTreeNode leftCh) {
		this.leftCh = leftCh;
	}
	
	public MyTreeNode(Ttype element) {
		setElement(element);
	}
	
	public String toString() {
		return "" + element;
	}
}
