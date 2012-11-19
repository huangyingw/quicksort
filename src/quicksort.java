public class quicksort {
	int[] data;

	public quicksort(int[] data) {
		this.data = data;
	}

	int Partition(int i, int j) {
		int pivot = data[i];
		while (i < j) {
			while (data[j] > pivot)
				j--;

			while (data[i] < pivot)
				i++;
			if (i < j) {
				swap(i, j);
			}
		}
		return i;
	}

	void Sort() {
		Sort(0, data.length - 1);
	}

	void ThreeSort() {
		ThreeSort(0, data.length - 1);
	}

	void ThreeSort(int low, int high) {
		if (high <= low)
			return;
		int lt = low, gt = high;
		int pivot = data[low];
		int nav = low;
		while (nav <= gt) {
			if (data[nav] < pivot)
				swap(lt++, nav++);
			else if (data[nav] > pivot)
				swap(nav, gt--);
			else
				nav++;
		}
		ThreeSort(low, lt - 1);
		ThreeSort(gt + 1, high);
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

	public static void main(String[] args) {
		int[] data = { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		quicksort q3 = new quicksort(data);

		data = new int[] { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());

		data = new int[] { 3, 1, 7, 0, 6, 2, 5, 4 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
	}
}
