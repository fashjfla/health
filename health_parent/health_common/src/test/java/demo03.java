import java.util.List;
import java.util.Scanner;

public class demo03 {


	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.isEmpty()) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int le = triangle.size();
		int[] a = new int[le];
		a[0] = triangle.get(0).get(0);
		for (int i = 1; i < le; i++) {
			a[i] = a[i - 1] + triangle.get(i).get(i);
			for (int j = i - 1; j > 0; j--) {
				a[j] = Math.min(a[j], a[j - 1]) + triangle.get(i).get(j);
			}
			a[0] = a[0] + triangle.get(i).get(0);
		}
		return min(a);
	}

	public static int min(int[] a) {
		for (int i = 1; i < a.length; i++) {
			a[i] = Math.min(a[i - 1], a[i]);
		}
		return a[a.length - 1];
	}

}