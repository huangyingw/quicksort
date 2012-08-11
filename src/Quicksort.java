import java.util.Random;

public class Quicksort {
	int[] data;
	private int leftP;
	private int rightP;
	int size;

	public Quicksort(int[] data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}

	void Partition(int low, int high) {
		// Random random = new Random();
		// int s = random.nextInt(j) % (j - i + 1) + i;
		// int pivot = data[s];
		System.out.print("the original data->");
		Print(low, high);
		int pivot = data[low];
		int left = low, right = high, leftStore = left, rightStore = right;
		while (left < right) {
			while (left < right && data[right] > pivot)
				right--;
			while (left < right && right < rightStore && data[right] == pivot) {
				swap(right--, rightStore--);
        System.out.println("After swap1");
        Print(low,high);
			}
			while (left < right && data[left] < pivot)
				left++;
			while (left < right && leftStore < left && data[left] == pivot) {
				swap(left++, leftStore++);
        System.out.println("After swap2");
        Print(low,high);
			}
			if (left < right) {
				swap(left++, right--);
        System.out.println("After swap3");
        Print(low,high);
			}
		}
		while (leftStore > low) {
			swap(leftStore--, left--);
      System.out.println("After swap4");
      Print(low,high);
		}
		while (rightStore < high) {
			swap(rightStore++, right++);
      System.out.println("After swap5");
      Print(low,high);
		}
		leftP = left - 1;
		rightP = right + 1;
	}

	public void Print() {
		Print(0, data.length - 1);
	}

	public void Print(int l, int r) {
		for (int i = l; i <= r; i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
	}

	void Sort() {
		Sort(0, data.length - 1);
	}

	void Sort(int low, int high) {
		if (low < high) {
			int pivot;
			Partition(low, high);
			Sort(low, leftP);
			Sort(rightP, high);
		}
	}

	void swap(int i, int j) {
		if (i != j) {
			System.out.println("swap " + data[i] + " and " + data[j]);
			data[i] ^= data[j];
			data[j] ^= data[i];
			data[i] ^= data[j];
		}
	}

	public String toString() {
		String result = new String();
		for (int i = 0; i < data.length; i++) {
			result += Integer.toString(data[i]) + ",";
		}
		return result;
	}
}
