/*************************************************************************
 * Compilation: javac Quick3wayBars.java Execution: java Quick3wayBars N M
 * Dependencies: StdDraw.java
 * 
 * Sort N random integers between 1 and M using quicksort with 3-way
 * partitioning, visualizing the results by ploting bars with heights
 * proportional to the values.
 * 
 * % java Quick3wayBars 20
 * 
 *************************************************************************/

public class Quick3wayBars {
	private static int N, M;
	private static int frame = 0;

	public static void sort(double[] a) {
		// StdRandom.shuffle(a);
		show(a, 0, 0, -1, a.length - 1);
		frame++;
		sort(a, 0, a.length - 1);
		show(a, 0, 0, -1, a.length - 1);
		frame++;
	}

	private static void sort(double[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo, gt = hi;
		double v = a[lo];
		int i = lo;
		while (i <= gt)
			if (less(v, a[i]))
				exch(a, i, gt--);
			else if (less(a[i], v))
				exch(a, lt++, i++);
			else
				i++;
		show(a, lo, lt, gt, hi);
		frame++;
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}

	private static boolean less(double v, double w) {
		return v < w;
	}

	private static void exch(double[] a, int i, int j) {
		double t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(double[] a, int lo, int lt, int gt, int hi) {
		StdDraw.setYscale(-(M + 1) * (M + 1 - frame), (M + 1) * frame + (M + 1)
				/ 2);
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		for (int k = 0; k < lo; k++)
			StdDraw.line(k, 0, k, a[k] * .7);
		for (int k = hi + 1; k < a.length; k++)
			StdDraw.line(k, 0, k, a[k] * .7);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int k = lo; k <= hi; k++)
			StdDraw.line(k, 0, k, a[k] * .7);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		for (int k = lt; k <= gt; k++)
			StdDraw.line(k, 0, k, a[k] * .7);
	}

	public static void main(String[] args) {
		// N = Integer.parseInt(args[0]);
		// M = Integer.parseInt(args[1]);
		N = 50;
		M = 80;
		StdDraw.setCanvasSize(800, M * 70);
		StdDraw.show(0);
		StdDraw.setXscale(-1, N + 1);
		StdDraw.setPenRadius(.006);
		StdDraw.show(0);
		double[] a = new double[N];
		for (int i = 0; i < N; i++)
			a[i] = 1 + (int) (Math.random() * M);
		sort(a);
		StdDraw.show(0);
	}
}
