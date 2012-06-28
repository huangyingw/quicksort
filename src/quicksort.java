public class quicksort {
	int[] data;
	int size;

	public quicksort(int len) {
		size = len;
		data = new int[size];
	}

	public quicksort(int[] data, int size) {
		super();
		this.data = data;
		this.size = size;
	}

	public quicksort(int[] data2) {
		// TODO Auto-generated constructor stub
		this.data = data2;
	}

	int Partition(int i, int j) {
		int pivot = data[i];
		int p = i, q = j;
		while (i < j) {
			while (data[j] > pivot)
				j--;

			while (data[i] < pivot)
				i++;
			if (i < j) {
				swap(i, j);
				if (data[i] == pivot) {
					swap(i, ++p);
				}
			}
			// if (data[j] == pivot) {
			// swap(j, --q);
			// }
		}
		return i;
	}

	void Sort(int low, int high) {
		if (low < high) {
			int pivot;
			pivot = Partition(low, high);
			Sort(low, pivot - 1);
			Sort(pivot + 1, high);
		}
	}

	void swap(int i, int j) {
		data[i] ^= data[j];
		data[j] ^= data[i];
		data[i] ^= data[j];
	}

	public String toString() {
		String result = new String();
		for (int i = 0; i < data.length; i++) {
			result += Integer.toString(data[i]) + ",";
		}
		return result;
	}
}
