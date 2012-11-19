public class Quick3way {
	int[] data;

	public Quick3way(int[] data) {
		this.data = data;
	}

	public void sort() {
		sort(0, data.length - 1);
	}

	private void sort(int low, int high) {
		if (high <= low)
			return;
		int lt = low, gt = high;
		int v = data[low];
		int nav = low;
		while (nav <= gt) {
			if (data[nav] < v)
				exch(lt++, nav++);
			else if (data[nav] > v)
				exch(nav, gt--);
			else
				nav++;
		}
		sort(low, lt - 1);
		sort(gt + 1, high);
	}

	private void exch(int i, int j) {
		int swap = data[i];
		data[i] = data[j];
		data[j] = swap;
	}

	private void show() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ",");
		}
	}

	public static void main(String[] args) {
		int[] data = { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		Quick3way q3 = new Quick3way(data);
		q3.sort();
		q3.show();
	}
}
