public class HeapSortUtils {

    // просеивание вверх
    private static void siftUp(int[] array, int size, int pos) {
        while (2 * pos + 1 < size) {
            int t = 2 * pos + 1;
            if (2 * pos + 2 < size && array[2 * pos + 1] < array[2 * pos + 2]) {
                t = 2 * pos + 2;
            }
            if (array[pos] < array[t]) {
                swap(array, pos, t);
                pos = t;
            } else {
                break;
            }
        }
    }
    // создание кучи из массива
    private static int[] makeHeap(int[] array) {
        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            siftUp(array, n, i);
        }
        return array;
    }

    // сортировка путем просеивания вниз
    public static void heapSort(int[] array) {
        int n = array.length;
        makeHeap(array);
        while (n > 0) {
            swap(array, 0, n - 1);
            n--;
            siftUp(array, n, 0);
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
