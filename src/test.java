public class test {
	static public void main(String[] args) {
		quicksort qs = new quicksort(7);
		qs.data[0] = 3;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 0;
		qs.data[4] = 6;
		qs.data[5] = 5;
		qs.data[6] = 4;
		qs.Sort(0, 6);
		System.out.println(qs.toString());
	}
}
