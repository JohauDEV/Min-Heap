import java.util.ArrayList;

public class GFG {

    public static void insert(ArrayList<Integer> heap, int value) {
        heap.add(value);


        int index = heap.size() - 1;
        while (index > 0 && heap.get((index - 1) / 2) > heap.get(index)) {
            int temp = heap.get(index);
            heap.set(index, heap.get((index - 1) / 2));
            heap.set((index - 1) / 2, temp);
            index = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] values = {10, 3, 2, 4, 5, 1};
        int n = values.length;
        for (int i = 0; i < n; i++) {
            insert(arr, values[i]);
            System.out.print("Inserido " + values[i] + " no min-heap: ");
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(arr.get(j) + " ");
            }
            System.out.println();
        }
    }
}