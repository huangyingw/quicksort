import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		int[] data = { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		quicksort q3 = new quicksort(data);

		data = new int[] { 7, 6, 5, 5, 4, 4, 3, 2, 2, 1 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
		q3.Sort();
		System.out.println(q3.toString());

		data = new int[] { 3, 1, 7, 0, 6, 2, 5, 4 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
		q3.Sort();
		System.out.println(q3.toString());

		data = new int[] { 7 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
		q3.Sort();
		System.out.println(q3.toString());

		data = new int[] { 3, 3, 3, 3, 3 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
		q3.Sort();
		System.out.println(q3.toString());

		data = new int[] { 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
		q3.Sort();
		System.out.println(q3.toString());

		data = new int[] { 3, 1, 7, 0, 6, 2, 5, 4 };
		q3 = new quicksort(data);
		q3.ThreeSort();
		System.out.println(q3.toString());
		q3.Sort();
		System.out.println(q3.toString());
	}
}
