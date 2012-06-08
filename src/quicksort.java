public class quicksort {

	static public void main(String[] args) {
		quicksort qs = new quicksort(7);
		qs.data[0] = 3;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 0;
		qs.data[4] = 6;
		qs.data[5] = 5;
		qs.data[6] = 4;
		qs.Sort(0, 6);
		System.out.println(qs.toString());
	}

	private int[] data;

	int size;

	public quicksort(int len) {
		size = len;
		data = new int[size];
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
