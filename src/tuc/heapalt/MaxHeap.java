package tuc.heapalt;

// https://iq.opengenus.org/max-heap-min-heap/ (page states wrong complexity for Extract-Min / Extract-Max which should be O(logn) !!)
// Missing build-heap method

// build-heap: https://iq.opengenus.org/create-heap-from-array/

public class MaxHeap {
    public int capacity;
    public int [] mH;
    public int currentSize;
    public MaxHeap(int capacity){
        this.capacity=capacity;
        mH = new int [capacity+1];
       currentSize =0;
    }
    public void createHeap(int [] arrA){
        if(arrA.length>0){
            for(int i=0;i<arrA.length;i++){
                insert(arrA[i]);
            }
        }
    }
    public void display(){
        for(int i=1;i<mH.length;i++){
            System.out.print(" " + mH[i]);
        }
        System.out.println("");
    }
    public void insert(int x) {
        if(currentSize==capacity){
            System.out.println("heap is full");
            return;
        }
        currentSize++;
        int idx = currentSize;
        mH[idx] = x;
        bubbleUp(idx);
    }

    public void bubbleUp(int pos) {
        int parentIdx = pos/2;
        int currentIdx = pos;
        while (currentIdx > 0 && mH[parentIdx] < mH[currentIdx]) {

            swap(currentIdx,parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx/2;
        }
    }

    public int extractMax() {
        int max = mH[1];
        mH[1] = mH[currentSize];
        mH[currentSize] = 0;
        sinkDown(1);
        currentSize--;
        return max;
    }

    public void sinkDown(int k) {
        int greatest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k+1;
        if (leftChildIdx < heapSize() && mH[greatest] < mH[leftChildIdx]) {
            greatest = leftChildIdx;
        }
        if (rightChildIdx < heapSize() && mH[greatest] < mH[rightChildIdx]) {
            greatest = rightChildIdx;
        }
        if (greatest != k) {

            swap(k, greatest);
            sinkDown(greatest);
        }
    }

    public void swap(int a, int b) {
        int temp = mH[a];
        mH[a] = mH[b];
        mH[b] = temp;
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int heapSize(){
        return currentSize;
    }

    public static void main(String args[]){
        int arrA [] = {3,2,1,7,8,4,10,16,12};
        System.out.print("Original Array : ");
        for(int i=0;i<arrA.length;i++){
            System.out.print("  " + arrA[i]);
        }
        MaxHeap m = new MaxHeap(arrA.length);
        System.out.print("\nMax-Heap : ");
        m.createHeap(arrA);
        m.display();
        System.out.print("Extract Max :");
        for(int i=0;i<arrA.length;i++){
            System.out.print("  " + m.extractMax());
        }
    }
}