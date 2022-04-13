package tuc.bst;

import java.io.*;
import tuc.IElem;

// Driver class for BST tests
public class BSTmain {

// Main routine for BST tests
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		BST tree = new BST();

		System.out.println("IsEmpty: " + tree.isEmpty());
		tree.insert(new IElem(10));
		tree.print();
		System.out.println("IsEmpty: " + tree.isEmpty());
		tree.remove(10);
		tree.print();
		System.out.println("IsEmpty: " + tree.isEmpty());
		tree.clear();
		System.out.println("IsEmpty: " + tree.isEmpty());
		tree.insert(new IElem(15));
		System.out.println("IsEmpty: " + tree.isEmpty());
		tree.find(15);
		tree.print();
		tree.remove(20);
		System.out.println("Now, insert 20");
		tree.insert(new IElem(20));
		tree.print();
		tree.remove(20);
		tree.print();
		tree.insert(new IElem(70));
		System.out.println("IsEmpty: " + tree.isEmpty());
		tree.insert(new IElem(35));
		tree.insert(new IElem(20));
		tree.insert(new IElem(17));
		tree.insert(new IElem(15));
		tree.insert(new IElem(19));
		tree.insert(new IElem(100));
		tree.insert(new IElem(90));
		tree.insert(new IElem(95));
		tree.insert(new IElem(1));
		tree.print();
		System.out.println("Find 100: " + tree.find(100));
		System.out.println("Find 99: " + tree.find(99));
		System.out.println("Find 20: " + tree.find(20));
		System.out.println("Need to do some delete tests.");
		System.out.println("Delete: 15");
		tree.remove(15);
		tree.print();
		System.out.println("Delete: 15");
		tree.remove(15);
		tree.print();
		System.out.println("Delete: 70");
		tree.remove(70);
		tree.print();

		System.out.print("Do Preorder: \t");
		tree.preorder();
		System.out.print("Do Postoder: \t");
		tree.postorder();
		System.out.print("Do Inorder: \t");
		tree.inorder();

		System.out.println("Total number of tree nodes: " + tree.count());

		tree.printRange(1, 200);
		tree.printRange(16, 95);
		tree.printRange(20, 85);

		tree.clear();
		tree.print();
		System.out.println("IsEmpty: " + tree.isEmpty());
		System.out.println("That is all.");
		System.in.read();
	}
}
