public class Quick3way {
	int[] data;

	public Quick3way(int[] data) {
		this.data = data;
	}

	public void sort() {
		sort(0, data.length - 1);
	}

	private void sort(int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, gt = hi;
		int v = data[lo];
		int i = lo;
		while (i <= gt) {
			if (data[i] < v)
				exch(lt++, i++);
			else if (data[i] > v)
				exch(i, gt--);
			else
				i++;
		}
		sort(lo, lt - 1);
		sort(gt + 1, hi);
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
