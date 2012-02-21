import java.lang.reflect.Array;

public class quicksort<T extends Comparable<T>> {
	private static int count = 0;

	static public void main(String[] args) {
		quicksort<Integer> qs = new quicksort<Integer>(7);
		qs.data[0] = 3;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 0;
		qs.data[4] = 6;
		qs.data[5] = 5;
		qs.data[6] = 4;
		quicksort.count = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());

		qs.data[0] = 6;
		qs.data[1] = 5;
		qs.data[2] = 4;
		qs.data[3] = 3;
		qs.data[4] = 2;
		qs.data[5] = 1;
		qs.data[6] = 0;
		quicksort.count = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());

		qs.data[0] = 0;
		qs.data[1] = 1;
		qs.data[2] = 2;
		qs.data[3] = 3;
		qs.data[4] = 4;
		qs.data[5] = 5;
		qs.data[6] = 6;
		quicksort.count = 0;
		qs.Sort(0, 6);
		System.out.println(qs.toString());
	}

	private T[] data;

	int size;

	public quicksort(int len) {
		size = len;
		//data = new T[size];
		data=(T[]) Array.newInstance(componentType, length)
	}

	int Partition(int i, int j) {
		T pivot = data[i];
		while (i < j) {
			while (data[j].compareTo(pivot) > 0)
				j--;
			while (data[i].compareTo(pivot) < 0)
				i++;
			if (i < j) {
				T temp = data[j];
				data[j] = data[i];
				data[i] = temp;
				count++;
			}
		}
		return i;
	}

	void Sort(int low, int high) {
		if (low < high) {
			int pivot;
			pivot = Partition(low, high);
			Sort(low, pivot - 1);
			Sort(pivot + 1, high);
		}
	}

	public String toString() {
		String result = new String();
		for (int i = 0; i < data.length; i++) {
			result += data[i].toString() + ",";
		}
		return result;
	}
}
