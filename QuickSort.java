public class QuickSort{

    static void quickSort(String a[], int start, int end) {
        int partition = partition(a, start, end);
        if (partition - 1 > start)
            quickSort(a, start, partition - 1);
        if (partition + 1 < end)
            quickSort(a, partition + 1, end);
    }
    static int partition(String a[], int start, int end) {
        String pivot = a[end];
        for (int i = start; i < end-1; i++) {
            if (a[i].compareTo(pivot)<0) {
                swap(a, start, i);
                start++;
            }
        }
        swap(a, start, end);
        return start;
    }
    static void swap(String a[], int index1, int index2) {
        String tmp = Task34Main.data1[index1];
        Task34Main.data1[index1] = Task34Main.data1[index2];
        Task34Main.data1[index2] = tmp;
        String temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}