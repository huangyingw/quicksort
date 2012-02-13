public class quicksort {
	private static int count = 0;

	static public void main(String[] args) {
		quicksort qs = new quicksort(7);
		qs.data[0] = 3;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 6;
		qs.data[4] = 4;
		qs.data[5] = 5;
		qs.data[6] = 0;
		quicksort.count = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());
		System.out.println(quicksort.count);

		qs.data[0] = 6;
		qs.data[1] = 5;
		qs.data[2] = 4;
		qs.data[3] = 3;
		qs.data[4] = 2;
		qs.data[5] = 1;
		qs.data[6] = 0;
		quicksort.count = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());
		System.out.println(quicksort.count);

		qs.data[0] = 0;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 3;
		qs.data[4] = 4;
		qs.data[5] = 5;
		qs.data[6] = 6;
		quicksort.count = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());
		System.out.println(quicksort.count);
	}
	private int[] data;

	int size;

	public quicksort(int len) {
		size = len;
		data = new int[size];
	}

	int Partition(int i, int j) {
		int pivot = data[i];
		while (i < j) {
			while (data[j] > pivot)
				j--;
			while (data[i] < pivot)
				i++;
			if (i < j) {
				data[i] ^= data[j];
				data[j] ^= data[i];
				data[i] ^= data[j];
				count++;
			}
		}
		data[i] = pivot;
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

	public String toString() {
		String result = new String();
		for (int i = 0; i < data.length; i++) {
			result += Integer.toString(data[i]) + ",";
		}
		return result;
	}
}
