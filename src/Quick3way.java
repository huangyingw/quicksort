
public class Quick3way {

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, gt = hi;
		int v = a[lo];
		int i = lo;
		while (i <= gt) {
			if (a[i] < v)
				exch(a, lt++, i++);
			else if (a[i] > v)
				exch(a, i, gt--);
			else
				i++;
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	public static void main(String[] args) {
		int[] a = { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		Quick3way.sort(a);
		show(a);
	}
}
