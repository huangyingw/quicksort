import java.io.IOException;

public class Quicksort {
	int[] data;
	private int leftP;
	private int rightP;
	int size;
	private Log log;

	public Quicksort(int[] data, String name) throws IOException {
		// TODO Auto-generated constructor stub
		this.data = data;
		log = new Log(name);
	}

	void Partition(int low, int high) throws IOException {
		// Random random = new Random();
		// int s = random.nextInt(j) % (j - i + 1) + i;
		// int pivot = data[s];
		log.Appendln("the original data->");
		Print(low, high);
		int pivot = data[low];
		int left = low, right = high, leftStore = left, rightStore = right;
		while (left < right) {
			while (left < right && data[right] > pivot)
				right--;
			while (left < right && right < rightStore && data[right] == pivot) {
				swap(right--, rightStore--);
				log.Appendln("After swap1");
				Print(low, high);
			}
			while (left < right && data[left] < pivot)
				left++;
			while (left < right && leftStore < left && data[left] == pivot) {
				swap(left++, leftStore++);
				log.Appendln("After swap2");
				Print(low, high);
			}
			if (left < right) {
				swap(left++, right--);
				log.Appendln("After swap3");
				Print(low, high);
			}
		}
		while (leftStore > low) {
			swap(leftStore--, left--);
			log.Appendln("After swap4");
			Print(low, high);
		}
		while (rightStore < high) {
			swap(rightStore++, right++);
			log.Appendln("After swap5");
			Print(low, high);
		}
		leftP = left - 1;
		rightP = right + 1;
	}

	public void Print() throws IOException {
		Print(0, data.length - 1);
	}

	public void Print(int l, int r) throws IOException {
		for (int i = l; i <= r; i++) {
			System.out.print(data[i] + ",");
		}
		log.Appendln();
	}

	void Sort() throws IOException {
		Sort(0, data.length - 1);
	}

	void Sort(int low, int high) throws IOException {
		if (low < high) {
			int pivot;
			Partition(low, high);
			Sort(low, leftP);
			Sort(rightP, high);
		}
	}

	void swap(int i, int j) throws IOException {
		if (i != j) {
			log.Appendln("swap " + data[i] + " and " + data[j]);
			data[i] ^= data[j];
			data[j] ^= data[i];
			data[i] ^= data[j];
		}
	}

	public String toString() {
		String result = new String();
		for (int i = 0; i < data.length; i++) {
			result += Integer.toString(data[i]) + ",";
		}
		return result;
	}
}
