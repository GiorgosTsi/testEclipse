package tuc.heap;

import java.io.*;

import tuc.Elem;
import tuc.IElem;

// Driver class for MaxHeap and MinHeap tests
public class HeapMain {

	// Main routine for Heap tests
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		int heapMaxSize = 20;
		int initialNumberOfElements = 7;
		Elem[] heap_array = new Elem[heapMaxSize];
		for (int i = 0; i < initialNumberOfElements; i++)
			heap_array[i] = new IElem(i + 1);

		System.out.print("Initial array:");
		for (int i = 0; i < initialNumberOfElements; i++)
			System.out.print(" " + heap_array[i].key());

		Heap myMaxHeap = new MaxHeap(heap_array, initialNumberOfElements, heapMaxSize); // Create a MaxHeap
		myMaxHeap.insert(new IElem(8));

		System.out.print("\nMax Heap array:");
		for (int i = 0; i < myMaxHeap.heapsize(); i++)
			System.out.print(" " + heap_array[i].key());
		System.out.println("\nNumber of elements: " + myMaxHeap.heapsize());

		int currentNumberOfElements = myMaxHeap.heapsize();
		// Sort elements using remove() on myMaxHeap
		for (int i = 0; i < currentNumberOfElements; i++) {
			myMaxHeap.remove();
		}
		System.out.print("Heap Sort:");
		for (int i = 0; i < currentNumberOfElements; i++)
			System.out.print(" " + heap_array[i].key());

		Heap myMinHeap = new MinHeap(heap_array, currentNumberOfElements, heapMaxSize); // Create a MinHeap

		System.out.print("\n\nMin Heap array:");
		for (int i = 0; i < myMinHeap.heapsize(); i++)
			System.out.print(" " + heap_array[i].key());
		System.out.println("\nNumber of elements: " + myMinHeap.heapsize());

		currentNumberOfElements = myMinHeap.heapsize();
		// Sort elements using remove() on myMinHeap
		for (int i = 0; i < currentNumberOfElements; i++) {
			myMinHeap.remove();
		}
		System.out.print("Heap Sort (reverse):");
		for (int i = 0; i < currentNumberOfElements; i++)
			System.out.print(" " + heap_array[i].key());

	}
}