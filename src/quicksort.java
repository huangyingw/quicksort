import java.util.Random;

public class quicksort {
	int[] data;
	private int leftP;
	private int rightP;
	int size;

	public quicksort(int[] data) {
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
		int left = low, right = high, store = left;
		while (left < right) {
			while (data[right] > pivot)
				right--;
			while (data[right] == pivot) {
				swap(right--, store++);
			}
			while (data[left] < pivot)
				left++;
			while (data[left] == pivot)
				swap(left++, store++);
			if (left < right) {
				swap(left, right);
			}
			Print(low, high);
		}
		while (store > 0) {
			swap(store--, left--);
		}
		leftP = left - 1;
		rightP = right + 1;
		System.out.print("the left Partitioned data->");
		Print(low, leftP);
		System.out.print("the right Partitioned data->");
		Print(rightP, high);
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
