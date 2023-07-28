package in.verma.app8.mergesort;
import java.util.Arrays;

public class Main {

        public static void main(String[] args) {

            String[] animals = {"cat", "orange", "elephant", "bird"};

            mergeSort(animals);
            System.out.println(Arrays.toString(animals));
        }

        public static void mergeSort(String[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }

            int mid = arr.length / 2; String[] left_half = Arrays.copyOfRange(arr, 0, mid);
            String[] right_half = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left_half);
            mergeSort(right_half);

            merge(arr, left_half, right_half);
        }

        public static void merge(String[] arr, String[] left, String[] right) {
            int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

            while (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex].length() < right[rightIndex].length()) {
                    arr[mergedIndex] = left[leftIndex];
                    leftIndex++;
                } else {
                    arr[mergedIndex] = right[rightIndex];
                    rightIndex++;
                }
                mergedIndex++;
            }

            while (leftIndex < left.length) {
                arr[mergedIndex] = left[leftIndex];
                leftIndex++;
                mergedIndex++;
            }

            while (rightIndex < right.length) {
                arr[mergedIndex] = right[rightIndex];
                rightIndex++;
                mergedIndex++;
            }
        }
    }