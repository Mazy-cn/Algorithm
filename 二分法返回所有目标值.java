import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyTest {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 5, 6, 6, 6, 7, 8, 8, 8, 8, 8, 8, 8, 10, 12 };
		// ASC，目标值可重复
		myFunction(arr, 8);

	}

	static int binarySearch(int[] arr, int num, int start, int end) {
		while (end > start) {
			int temp = (end - start) / 2 + start;
			if (num == arr[temp]) {
				return temp;
			}

			if (arr[temp] > num) {
				int i = binarySearch(arr, num, 0, temp - 1);
				return i;
			}
			if (arr[temp] < num) {
				int i = binarySearch(arr, num, temp + 1, end);
				return i;
			}
		}
		return -1;
	}

	static void myFunction(int[] arr, int num) {
		int i = binarySearch(arr, num, 0, arr.length - 1);
		if (i != -1) {
			int min = i, max = i;
			while (min > -1 && arr[min] == arr[min - 1]) {
				min--;
			}
			while (max < arr.length && arr[max] == arr[max + 1]) {
				max++;
			}
			for (int j = min; j <= max; j++) {
				System.out.print(j + " ");
			}
		} else {
			System.out.println(-1);
		}

	}

}