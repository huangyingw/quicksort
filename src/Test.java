import java.io.IOException;

public class Test {
	static public void main(String[] args) throws IOException {
		int[] data = { 3, 1, 2, 0, 6, 2, 5, 4 };
		Quicksort qs = new Quicksort(data, "log.txt");
		qs.Sort();
		// System.out.println(qs.toString());
	}
}
