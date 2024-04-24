package DataStr;

public class MyBST<Ttype> {
	private MyTreeNode root = null;
	private int counter = 0;
	
	//pec noklusejuma jau bus konstruktors
	
	public boolean isEmpty() {
		return( counter == 0);
	}
	public int HowManyElements() {
		return counter;
	}
	
	public void insert(Ttype element) {
		if (isEmpty()) root = new MyTreeNode(element);
		else {
			insertHelpRecursive(root, element);
		}
	}
	
	private void insertHelpRecursive(MyTreeNode tempNode, Ttype element) {
		if (((Comparable)tempNode.getElement()).compareTo(element) == 1) {
			if(tempNode.getLeftCh() == null) {
				MyTreeNode newNode = new MyTreeNode<Ttype>(element);
				tempNode.setLeftCh(newNode);
				tempNode.setParent(newNode);
				counter++;
			}
			else {
				insertHelpRecursive(tempNode.getLeftCh(), element);
			}
		}
		else if(((Comparable)tempNode.getElement()).compareTo(element) == -1){
			//labais berns neeksiste
			if(tempNode.getRightCh() == null) {
				MyTreeNode newNode = new MyTreeNode<Ttype>(element);
				tempNode.setRightCh(newNode);
				tempNode.setParent(newNode);
				counter++;
			}
		}
		//sads elements jau eksistee
		else {
			System.out.println("Šāds elements jau eksistē BST");
		}
	}
}
