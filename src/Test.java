import java.io.IOException;

public class Test {
	static public void main(String[] args) throws IOException {
		int[] data = { 3, 1, 7, 0, 6, 2, 5, 4 };
		quicksort qs = new quicksort(data);
		// qs.Sort();
		qs.ThreeSort();
		System.out.println(qs.toString());
	}
}
