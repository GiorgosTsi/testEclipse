package tuc.heap;

import tuc.Elem;

public interface Heap {
	public int heapsize();

	public boolean isLeaf(int pos);

	public int leftchild(int pos);

	public int rightchild(int pos);

	public int parent(int pos);

	public void buildHeap();
	
	public boolean insert(Elem val);

	public Elem remove(); // max / min

	public Elem remove(int pos);
}
