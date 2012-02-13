public class quicksort {
	static public void main(String[] args) {
		quicksort qs = new quicksort(7);
		qs.data[0] = 0;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 6;
		qs.data[4] = 4;
		qs.data[5] = 5;
		qs.data[6] = 3;
		qs.Sort(0, 6);
		System.out.println(qs.toString());

		qs.data[0] = 6;
		qs.data[1] = 5;
		qs.data[2] = 4;
		qs.data[3] = 3;
		qs.data[4] = 2;
		qs.data[5] = 1;
		qs.data[6] = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());

		qs.data[0] = 0;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 3;
		qs.data[4] = 4;
		qs.data[5] = 5;
		qs.data[6] = 6;
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
		while (i < j) {
			while (i < j && data[j] > pivot)
				j--;
			while (i < j && data[i] < pivot)
				i++;
			if (i < j) {
				data[i] ^= data[j];
				data[j] ^= data[i];
				data[i] ^= data[j];
			}
		}
		data[i] = pivot;
		return i;
	}

	void Print(int left, int right) {
		for (int i = left; i <= right; i++)
			System.out.print(data[i]);
		System.out.println();
	}

	void Sort(int low, int high) {
		if (low < high) {
			int pivot;
			pivot = Partition(low, high);
			System.out.print("current->");
			Print(low, high);
			System.out.println("pivot->" + pivot);

			System.out.print("left->");
			Print(low, pivot - 1);
			Sort(low, pivot - 1);
			System.out.print("right->");
			Print(pivot + 1, high);
			System.out.println();
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
