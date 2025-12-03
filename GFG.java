import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap {
    private List<Integer> heap;
    public MinHeap() {
        heap = new ArrayList<>();
    }
    private int getParentIndex(int i) {
        if (i == 0) return -1;
        return (i - 1) / 2;
    }
    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }
    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public void insert(int item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }
    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        while (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }
    public int peekMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap está vazio.");
        }
        return heap.get(0);
    }
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap está vazio.");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);

        return min;
    }
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallest)) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallest)) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    public int size() {
        return heap.size();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        System.out.println("Inserindo elementos: 10, 5, 15, 2, 20");
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(2);
        minHeap.insert(20);

        System.out.println("Tamanho atual do Heap: " + minHeap.size());
        System.out.println("Menor elemento (peek): " + minHeap.peekMin());
        System.out.println("Extraindo o menor elemento: " + minHeap.extractMin());
        System.out.println("Menor elemento após extração: " + minHeap.peekMin());
        System.out.println("Extraindo o menor elemento: " + minHeap.extractMin());
        System.out.println("Tamanho final do Heap: " + minHeap.size()); 
    }
}
