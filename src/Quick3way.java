/*************************************************************************
 * Compilation: javac Quick3way.java Execution: java Quick3way < input.txt
 * Dependencies: StdOut.java StdIn.java Data files:
 * http://algs4.cs.princeton.edu/23quicksort/tiny.txt
 * http://algs4.cs.princeton.edu/23quicksort/words3.txt
 * 
 * Sorts a sequence of strings from standard input using 3-way quicksort.
 * 
 * % more tiny.txt S O R T E X A M P L E
 * 
 * % java Quick3way < tiny.txt A E E L M O P R S T X [ one string per line ]
 * 
 * % more words3.txt bed bug dad yes zoo ... all bad yet
 * 
 * % java Quick3way < words3.txt all bad bed bug dad ... yes yet zoo [ one
 * string per line ]
 * 
 *************************************************************************/

public class Quick3way {

	// quicksort the array a[] using 3-way partitioning
	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	// quicksort the subarray a[lo .. hi] using 3-way partitioning
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

		// a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
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
	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***********************************************************************
	 * Check if array is sorted - useful for debugging
	 ***********************************************************************/
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	// print array to standard output
	private static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

	// Read strings from standard input, sort them, and print.
	public static void main(String[] args) {
		int[] a = { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		Quick3way.sort(a);
		show(a);
	}

}
