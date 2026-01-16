// ---------------- STATIC ARRAY CLASS ----------------
class hi {
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

// ---------------- DYNAMIC ARRAY CLASS ----------------
class DynamicArray {
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
            System.out.println("Array resized to " + items.length);
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
