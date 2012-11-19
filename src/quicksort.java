public class quicksort {
	int[] data;

	public quicksort(int[] data) {
		this.data = data;
	}

	int Partition(int low, int high) {
		int pivot = data[low];
		int i = low;
		int j = high;
		while (i < j && data[j] >= pivot)
			j--;
		while (i < j && data[i] <= pivot)
			i++;
		if (i < j) {
			swap(i, j);
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

}
