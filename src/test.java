public class test {
	static public void main(String[] args) {
		int[] data = { 3, 1, 2, 0, 6, 5, 4 };

		quicksort qs = new quicksort(data);
		qs.Sort(0, 6);
		System.out.println(qs.toString());
	}
}
