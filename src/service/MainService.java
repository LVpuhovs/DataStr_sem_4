package service;

import DataStr.MyBST;

public class MainService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBST<Integer> bstWithIntegers = new MyBST<Integer>();
		
		bstWithIntegers.insert(5);
		bstWithIntegers.insert(8);
		bstWithIntegers.insert(3);
		bstWithIntegers.insert(4);
		try {
			bstWithIntegers.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
