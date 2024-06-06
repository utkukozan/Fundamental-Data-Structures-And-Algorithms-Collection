import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueue {
    private int[] heap;
    private int size;

    public PriorityQueue(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void offer(int value) {
        if (size == heap.length) {
            // Resize the heap if it's full
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChild;
        int rightChild;
        int maxChild;

        while (index < size / 2) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;

            if (rightChild < size && heap[rightChild] > heap[leftChild]) {
                maxChild = rightChild;
            } else {
                maxChild = leftChild;
            }

            if (heap[index] >= heap[maxChild]) {
                break;
            }

            swap(index, maxChild);
            index = maxChild;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);

        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);

        System.out.println("Peek: " + pq.peek()); // Should print 5

        while (!pq.isEmpty()) {
            int value = pq.poll();
            System.out.println("Polled: " + value);
        }

        // Trying to poll when the priority queue is empty
        // This will throw a NoSuchElementException
        // System.out.println(pq.poll());
    }
}
