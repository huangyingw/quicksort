import java.util.Random;

public class quicksort {
	int[] data;
	int size;

	public quicksort(int[] data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}

	void Partition(int low, int high, Integer leftP, Integer rightP) {
		Random random = new Random();
		// int s = random.nextInt(j) % (j - i + 1) + i;
		// int pivot = data[s];
		int pivot = data[low];
		int p = low, q = high;
		while (low < high) {
			while (data[high] > pivot)
				high--;
			if (data[high] == pivot) {
				swap(high--, p++);
				continue;
			}
			while (data[low] < pivot)
				low++;
			if (data[low] == pivot) {
				swap(low++, p++);
				continue;
			}
			if (low < high) {
				swap(low, high);
			}
		}
		while (p > 0) {
			swap(--p, --low);
		}
		leftP = low - 1;
		rightP = high + 1;
	}

	void Sort() {
		Sort(0, data.length - 1);
	}

	void Sort(int low, int high) {
		if (low < high) {
			int pivot;
			Integer leftP = 0;
			Integer rightP = 0;
			Partition(low, high, leftP, rightP);
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
