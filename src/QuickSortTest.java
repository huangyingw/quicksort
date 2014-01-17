import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class QuickSortTest {
	private static final Logger logger = Logger.getAnonymousLogger();
	protected String testName;
	private int[] test;
	private int[] expect;

	public QuickSortTest(String testName, int[] test, int[] expect) {
		this.testName = testName;
		this.test = test;
		this.expect = expect;
	}

	@Test
	public void testRun() throws Exception {
		logger.info("Starting Test: " + testName);
		QuickSort quickSort = new QuickSort(test);
		quickSort.Sort();
		logger.info("Actual output: \n" + Arrays.toString(quickSort.getData()));
		logger.info("Expected output: \n" + Arrays.toString(expect));
		Assert.assertTrue(Arrays.equals(quickSort.getData(), expect));
		logger.info("Completed Test: " + testName);
	}

	@Parameters
	public static List<Object[]> getTestCases() throws Exception {
		List<Object[]> testCases = new ArrayList<Object[]>();

		testCases.add(new Object[] { "Test case #1: ",
				new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4, 5 } });
		testCases.add(new Object[] { "Test case #2: ",
				new int[] { 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4 } });
		testCases.add(new Object[] { "Test case #3: ", new int[] { 3, 2, 1 },
				new int[] { 1, 2, 3 } });
		testCases.add(new Object[] { "Test case #4: ", new int[] { 2, 1 },
				new int[] { 1, 2 } });
		testCases.add(new Object[] { "Test case #5: ", new int[] { 1 },
				new int[] { 1 } });
		testCases.add(new Object[] { "Test case #6: ",
				new int[] { 5, 4, 3, 3, 4, 2, 1 },
				new int[] { 1, 2, 3, 3, 4, 4, 5 } });
		testCases.add(new Object[] { "Test case #7: ",
				new int[] { 3, 4, 3, 5, 4, 2, 1 },
				new int[] { 1, 2, 3, 3, 4, 4, 5 } });
		return testCases;
	}
}
