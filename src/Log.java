import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Log {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true));
		String newStr = "新的内容\n";
		bw.write(newStr, 0, newStr.length());
		bw.flush();
		bw.close();
	}
}
