package tuc.heap;

import tuc.Elem;

// Max-heap class
public class MaxHeap implements Heap {
	private Elem[] Heap; // Pointer to the heap array
	private int size; // Maximum size of the heap
	private int n; // # of elements now in the heap

	public MaxHeap(Elem[] h, int num, int max) // Constructor
	{
		Heap = h;
		n = num;
		size = max;
		buildHeap();
	}

	public int heapsize() // Return current size
	{
		return n;
	}

	public boolean isLeaf(int pos) // TRUE if pos a leaf
	{
		return (pos >= n / 2) && (pos < n);
	}

	public int leftchild(int pos) // Return leftchild pos
	{
		return 2 * pos + 1;
	}

	public int rightchild(int pos) // Return rightchild pos
	{
		return 2 * pos + 2;
	}

	public int parent(int pos) // Return parent position
	{
		return (pos - 1) / 2;
	}

	public void buildHeap() // Heapify contents
	{
		for (int i = n / 2 - 1; i >= 0; i--)
			siftdown(i);
	}
	
	// Swap two objects in an array
	private void swap(int p1, int p2) {
		Elem temp = Heap[p1];
		Heap[p1] = Heap[p2];
		Heap[p2] = temp;
	}
	
	private void siftdown(int pos) { // Put element in correct place
		Assert.notFalse((pos >= 0) && (pos < n), "Illegal heap position");
		while (!isLeaf(pos)) { // Stop if pos is a leaf
			int j = leftchild(pos);
			if ((j < (n - 1)) && (Heap[j].key() < Heap[j + 1].key()))
				j++; // Set j to greater child's value
			if (Heap[pos].key() >= Heap[j].key())
				return; // Done
			swap(pos, j);
			pos = j; // Move down
		}
	}

	public boolean insert(Elem val) { // Insert value into heap
		Assert.notFalse(n < size, "Heap is full");
		int curr = n++;
		Heap[curr] = val; // Start at end of heap
		// Now sift up until curr’s parent > curr
		while ((curr != 0) && (Heap[curr].key() > Heap[parent(curr)].key())) {
			swap(curr, parent(curr));
			curr = parent(curr);
		}
		return true;
	}

	public Elem remove() { // Remove maximum value
		Assert.notFalse(n > 0, "Heap is empty");
		swap(0, --n); // Swap min with last value
		if (n != 0)
			siftdown(0); // Siftdown new root val
		return Heap[n]; // Return deleted value
	}

	public Elem remove(int pos) {// Remove value at specified position
		Assert.notFalse((pos >= 0) && (pos < n), "Illegal heap position");
		swap(pos, --n); // Swap with last value
		while ((pos != 0) && (Heap[pos].key() > Heap[parent(pos)].key())) {
			swap(pos, parent(pos)); // Push up if small key
			pos = parent(pos);
		}
		if (n != 0)
			siftdown(pos); // Push down if large key
		return Heap[n]; // Return deleted value
	}
} // maxheap class