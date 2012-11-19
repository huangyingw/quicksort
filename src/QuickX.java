/*************************************************************************
 * Compilation: javac QuickX.java Execution: java QuickX N
 * 
 * Uses the Bentley-McIlroy 3-way partitioning scheme, chooses the partitioning
 * element using Tukey's ninther, and cuts off to insertion sort.
 * 
 * Reference: Engineering a Sort Function by Jon L. Bentley and M. Douglas
 * McIlroy. Softwae-Practice and Experience, Vol. 23 (11), 1249-1265 (November
 * 1993).
 * 
 *************************************************************************/

public class QuickX {
	private static final int CUTOFF = 8; // cutoff to insertion sort, must be >=
											// 1

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		int N = hi - lo + 1;

		// cutoff to insertion sort
		if (N <= CUTOFF) {
			insertionSort(a, lo, hi);
			return;
		}

		// use median-of-3 as partitioning element
		else if (N <= 40) {
			int m = median3(a, lo, lo + N / 2, hi);
			exch(a, m, lo);
		}

		// use Tukey ninther as partitioning element
		else {
			int eps = N / 8;
			int mid = lo + N / 2;
			int m1 = median3(a, lo, lo + eps, lo + eps + eps);
			int m2 = median3(a, mid - eps, mid, mid + eps);
			int m3 = median3(a, hi - eps - eps, hi - eps, hi);
			int ninther = median3(a, m1, m2, m3);
			exch(a, ninther, lo);
		}

		// Bentley-McIlroy 3-way partitioning
		int i = lo, j = hi + 1;
		int p = lo, q = hi + 1;
		while (true) {
			Comparable v = a[lo];
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
			if (eq(a[i], v))
				exch(a, ++p, i);
			if (eq(a[j], v))
				exch(a, --q, j);
		}
		exch(a, lo, j);

		i = j + 1;
		j = j - 1;
		for (int k = lo + 1; k <= p; k++)
			exch(a, k, j--);
		for (int k = hi; k >= q; k--)
			exch(a, k, i++);

		sort(a, lo, j);
		sort(a, i, hi);
	}

	// sort from a[lo] to a[hi] using insertion sort
	private static void insertionSort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
	}

	// return the index of the median element among a[i], a[j], and a[k]
	private static int median3(Comparable[] a, int i, int j, int k) {
		return (less(a[i], a[j]) ? (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k
				: i) : (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
	}

	/***********************************************************************
	 * Helper sorting functions
	 ***********************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	// does v == w ?
	private static boolean eq(Comparable v, Comparable w) {
		return (v.compareTo(w) == 0);
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***********************************************************************
	 * Check if array is sorted - useful for debugging
	 ***********************************************************************/
	private static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	// test client
	public static void main(String[] args) {

		// generate array of N random reals between 0 and 1
		// int N = Integer.parseInt(args[0]);
		int N = 55;
		Double[] a = new Double[N];
		for (int i = 0; i < N; i++) {
			a[i] = Math.random();
		}

		// sort the array
		sort(a);

		// display results
		for (int i = 0; i < N; i++) {
			System.out.println(a[i]);
			;
		}
		System.out.println("isSorted = " + isSorted(a));

	}
}
