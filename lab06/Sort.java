package lab06;

public class Sort {
    public static void main(String[] args) {
        int[] arr1 = { 7, 4, 5, 1, 3 };
        printArr(arr1);
        bubbleSort(arr1, arr1.length);
        printArr(arr1);

        int[] arr2 = { 9, 2, 2, 5, 4, 3, 1, 6, 7, 3, 8, 0, 3 };
        printArr(arr2);
        System.out.println("simple bubble sort");
        bubbleSort(arr2, arr2.length);
        printArr(arr2);
    }

    public static void bubbleSort(int arr[], int n) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        bubbleSort(arr, n - 1);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
