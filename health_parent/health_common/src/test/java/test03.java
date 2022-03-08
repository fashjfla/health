import java.util.HashMap;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-10-26 17:03
 **/
public class test03 {

	public static void main(String[] args) {
		int x=123;
		reverse(x);

		HashMap<String, String> map = new HashMap<>();
//		map.resize();
	}

	public static int reverse(int x) {
		int a = x%10;
		int b = x%100;
		int c = b%10;
		int d = x/100;
		return 0;
	}
}
