package ch7Test;

public class Test {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 3, 1, 4, 8 };
        // reverse(arr);
        bubble(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println(erfen(arr, 77));
    }

    public static void reverse(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public static void bubble(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int erfen(int[] arr, int target) {
        int max = arr.length - 1;
        int min = 0;
        int mid = 0;
        boolean flag = false;
        while (min <= max) {
            mid = (min + max) / 2;
            if (arr[mid] < target) {
                max = mid - 1;
            } else if (arr[mid] > target) {
                min = mid + 1;
            } else {
                flag = true;
                break;
            }
        }
        return (flag ? mid : -1);
    }

}
