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
		if (isEmpty()) 
		{
			root = new MyTreeNode<Ttype>(element);
			counter++;
		}
		else {
			insertHelpRecursive(root, element);
		}
	}
	//remove
	
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
	
	public void print() throws Exception {
		if(isEmpty()) throw new Exception("Koks ir tukss");
		
		printRecursivePreOrder(root);
		System.out.println();
	}
	
	private void printRecursivePreOrder(MyTreeNode tempNode) {
		//root - left - right
		//root
		System.out.print(tempNode.getElement());
		
		//left
		if(tempNode.getLeftCh() != null) {
			System.out.print(" ->LC: " + tempNode.getLeftCh().getElement() + " [ " + tempNode.getElement() + "] ");
			printRecursivePreOrder(tempNode.getLeftCh());
		}
		//right
		//ja eksistē labais berns
		if(tempNode.getRightCh() != null) {
			System.out.print(" ->RC: " + tempNode.getRightCh().getElement() + " [" + tempNode.getElement() + "] ");
			printRecursivePreOrder(tempNode.getRightCh());
		}
	}
	
	//TODO
	//1. izveidot search
	//2. parbaude vai nav tukss
	//3. ja nav tukss, tad vajag izsaukt helper funkcija
	//4. uzstaisit helper funkciju prieks meklesanas
	
	public boolean search(Ttype element) throws Exception {
		if (isEmpty()) throw new Exception("Koks tukss");
		
		
		return helpSearch(root, element);
	}
	
	private boolean helpSearch(MyTreeNode tempNode, Ttype element) {
		if (tempNode.getElement().equals(element))
			return true;
		// apakškoka sakne ir lielāks par elementu
		if (
	((Comparable) tempNode.getElement()).compareTo(element) == 1) {
			//ja kreisais bērns eksistē
			if (tempNode.getLeftCh() != null) 
			{
				return helpSearch(tempNode.getLeftCh(), element);
			}
		}
		// saknes elements ir mazaks par element
		else if (
	((Comparable) tempNode.getElement()).compareTo(element) == -1) {
			//ja labais bērns eksistē
			if (tempNode.getRightCh() != null) 
			{
				return helpSearch(tempNode.getRightCh(), element);
			}
		}
		
		return false;	
		}
	
	public void delete(Ttype element) throws Exception {
		if(isEmpty()) throw new Exception("Koks tukss");
		
		deleteHelp(root, element);
	}
	
	public void deleteHelp (MyTreeNode tempNode, Ttype element) {
		if (tempNode.getElement().equals(element)) {
			if(tempNode.getLeftCh() == null && tempNode.getRightCh() == null) {
				MyTreeNode parent = tempNode.getParent();
				
				if(parent.getLeftCh().getElement().equals(element)) {
					parent.setLeftCh(null);
				}
				else if(parent.getRightCh().getElement().equals(element)) {
					parent.setRightCh(null);
				}
			}
		}
		if (((Comparable) tempNode.getElement()).compareTo(element) == 1) {
			//ja kreisais bērns eksistē
			if (tempNode.getLeftCh() != null) 
			{
				deleteHelp(tempNode.getLeftCh(), element);
			}
		}	
		if (((Comparable) tempNode.getElement()).compareTo(element) == -1) {
			//ja kreisais bērns eksistē
			if (tempNode.getRightCh() != null) 
			{
				helpSearch(tempNode.getRightCh(), element);
			}
		}
		else if(tempNode.getLeftCh() == null && tempNode.getRightCh() != null) {
			MyTreeNode parent = tempNode.getParent();
			MyTreeNode leftChild = tempNode.getLeftCh();
			parent.setLeftCh(leftChild);
			leftChild.setParent(parent);
		}
		else if(tempNode.getLeftCh() != null && tempNode.getRightCh() == null) {
			MyTreeNode parent = tempNode.getParent();
			MyTreeNode rightChild = tempNode.getRightCh();
			parent.setRightCh(rightChild);
			rightChild.setParent(parent);
		}
		else if(tempNode.getLeftCh() != null && tempNode.getRightCh() != null) {
			
		}
	}
}
