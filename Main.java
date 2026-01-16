public class Main {

    // -------- STATIC ARRAY CLASS --------
    static class hi {
        private int[] items;
        private int count;

        public hi(int length) {
            items = new int[length];
        }

        public void insert(int value) {
            if (count == items.length) {
                System.out.println("Array is full! Cannot insert " + value);
                return;
            }
            items[count++] = value;
        }

        public void print() {
            for (int i = 0; i < count; i++)
                System.out.print(items[i] + " ");
            System.out.println();
        }
    }

    // -------- DYNAMIC ARRAY CLASS --------
    static class DynamicArray {
        private int[] items;
        private int count;

        public DynamicArray(int length) {
            items = new int[length];
        }

        public void insert(int value) {
            if (count == items.length) {
                int[] newItems = new int[count * 2];
                for (int i = 0; i < count; i++)
                    newItems[i] = items[i];
                items = newItems;
            }
            items[count++] = value;
        }

        public void removeAt(int index) {
            if (index < 0 || index >= count)
                throw new IllegalArgumentException("Invalid index");

            for (int i = index; i < count - 1; i++)
                items[i] = items[i + 1];
            count--;
        }

        public int indexOf(int value) {
            for (int i = 0; i < count; i++)
                if (items[i] == value)
                    return i;
            return -1;
        }

        public void print() {
            for (int i = 0; i < count; i++)
                System.out.print(items[i] + " ");
            System.out.println();
        }
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        // O(1)
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(arr[0]);

        // O(n)
        for (int i = 0; i < 5; i++)
            System.out.println("linear " + i);

        // O(n^2)
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                System.out.println("nested " + i + "," + j);

        // Static Array
        hi no = new hi(3);
        no.insert(10);
        no.insert(20);
        no.insert(30);
        no.print();

        // Dynamic Array
        DynamicArray da = new DynamicArray(2);
        da.insert(5);
        da.insert(15);
        da.insert(25);
        da.print();

        // Matrix
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Diagonal:");
        for (int i = 0; i < mat.length; i++)
            System.out.print(mat[i][i] + " ");
    }
}
