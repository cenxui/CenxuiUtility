package sort;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Sort {
	
	/**
	 * selection sort
	 * @param arr
	 */
	
	public static void seletion(int[] arr) {
		int temp = 0;
		int index = 0;

		for (int left = 0; left<arr.length-1 ; left++) {
			index = left;
			for (int right = left+1; right < arr.length ; right++ ) {
				if (arr[right] < arr[index]) {
					index = right;
				}
			}
			if (index != left) {
				temp = arr[index];
				arr[index] = arr[left];
				arr[left] = temp;
			}		
		}
	}
	/**
	 * insert sort
	 * @param arr
	 */
	
	public static void insert(int[] arr) {
		int left = 0 , right = 0, newVal = 0;
		
		for (right = 1 ; right <arr.length ; right++) {			
			newVal = arr[right];
		
			if (newVal< arr[right-1]) {
				left = right;
				while (left >0 && arr[left-1] > newVal) {
					arr[left--] = arr[left];
				}
				arr[left] = newVal;
			}		
		}
	} 
	
	/**
	 * bubble sorting  
	 * @param arr
	 */
	
	public static void bubble(int[] arr) {
		boolean sorted = false;
		int temp = 0;
		int right = 1;
		int len = arr.length;
		
		while (sorted == false) {
			sorted = true;
			for (int left = 0; left < len - right; left++) {
				if (arr[left] > arr[left+1]) {
					sorted = false;
					temp = arr[left];
					arr[left] = arr[left+1];
					arr[left+1] = temp;
				}
			}
			right++;
		}
	}
	
	
	
	/**
	 * merge sort 
	 * @param arr
	 */
	
	public static void merge (int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		sort(arr, result, 0,len-1);
	}
	
	static void sort(int[] arr, int[] result, int start, int end) {		
		if (start >= end) return ;
		
		int len = end - start, mid = (len >> 1) + start;
		int leftStart = start, leftEnd = mid;
		int rightStart = mid + 1, rightEnd = end;
		sort(arr, result, leftStart, leftEnd); 
		sort(arr, result, rightStart, rightEnd);
		
		int index = start;
		int leftIndex = leftStart, rightIndex = rightStart;
		while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
			if (arr[leftIndex] > arr[rightIndex]) {
				result[index++] = arr[rightIndex++];
			}else {
				result[index++] = arr[leftIndex++];	
			}			
		}
		while (leftIndex <= leftEnd) {
			result[index++] = arr[leftIndex++];
		}
		while (rightIndex <= rightEnd) {
			result[index++] =  arr[rightIndex++];
		}
		System.arraycopy(result, start, arr, start,len+1);
	}
	
	/**
	 * open the array.txt file 
	 * @param fileName 
	 * @param length array length
	 * @return the array from array.txt. file
	 */
	
	static int[] getArray(String fileName ,int length) {
		File file = new File(fileName);

		BufferedReader bufferedReader = null;
		int[] result = null;
		try {
			FileInputStream  fileInputStream = new FileInputStream(file);
			bufferedReader =
					new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));	
			String text = null;
			result = new int[length];
			int index = 0;
			for (;;) {
				text = bufferedReader.readLine();
				if (text == null) {
					break;
				}
				result[index++] = Integer.valueOf(text);
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	enum Pivot {
		First,
		Final,
		MedianOfThree
	}
	
	public static void quick(int[] arr) {
		quick(arr, 0, arr.length - 1, Pivot.MedianOfThree);
	}
	
	static void quick(int[] arr, int from, int end, Pivot piv) {
		if (from >= end) {
			return;
		}
		
		if (end - from != 1) {
			switch (piv) {
			case First:
				break;
			case Final:
				swap(arr, from, end);;
				break;
			case MedianOfThree:
				if (arr[from] < arr[(from + end)/2] ) {
					if (arr[(from + end)/2] < arr[end]) {
						swap(arr, from, (from + end)/2);
					}else {
						if (arr[from] < arr[end]) {
							swap(arr, from, end);
						}
					}
				}else {
					if (arr[(from + end)/2] > arr[end]) {
						swap(arr, from, (from + end)/2);
					}else {
						if (arr[from] > arr[end]) {
							swap(arr, from, end);
						}
					}
				}					
				break;
			}
		}
		
		int left = from + 1;
	
		for (int i = from + 1 ; i <= end; i++) {
			if (arr[i] < arr[from]) {
				swap(arr, left, i);
				left++;
			}
		}
		left--;
		swap(arr, from, left);

		quick(arr, from, left-1, piv);
		quick(arr, left+1, end, piv);
	}
	
	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	/**
	 * print array
	 * @param arr the array we want to print
	 */
	public static void printArrays(int[] arr) {
		StringBuilder stringBuilder = new StringBuilder("{");
		int i = 0;
		for ( ; i< arr.length-1; i++) {
			stringBuilder.append(arr[i]).append(" ,");
		}
		stringBuilder.append(arr[i]).append("}");
		out.println(stringBuilder);
	}
	
	/**
	 * shell sort
	 * @param arr
	 */
	
	public static void shell(int[] arr) {
		int gap = arr.length;
		
		while (gap > 0) {
			if (gap == 2) {
				gap = 1;
			}else {
				gap = gap/2;
			}
			
			for (int i = 0; i < arr.length - gap; i++) {
				if (arr[i] > arr[i + gap]) {
					swap(arr, i, i + gap);
					
					for ( int j = i; j>0 && j>gap; ) {
						if (arr[j] > arr[j-gap]) {
							break;
						}
						swap(arr,j - gap, j);
						j = j - gap;
					}
				}
			}		
		}	
	}
	
	/**
	 * 
	 * @param arr
	 * @return true if is sorted, false if there is an element not sorted
	 */
	
	public static boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] > arr[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = getArray("c:\\text\\100.txt", 100);
		printArrays(arr);
		shell(arr);
		printArrays(arr);
		out.print(isSorted(arr));
		
		

	}
}
