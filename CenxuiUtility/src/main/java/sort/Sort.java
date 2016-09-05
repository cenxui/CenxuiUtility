package sort;

public class Sort {
	
	public static void seletion(int[] arr) {
		
	}
	
	public static void insert(int[] arr) {
		
	}
	
	public static void bubble(int[] arr) {
		
	}
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
