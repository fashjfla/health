import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-10-19 10:54
 **/
public class demo {


	public static void main(String[] args) {
		int i= 10;

		String str = "adv";
		demo.Testone(i);
		demo.Testtow(str);
		System.out.println(i);
		System.out.println(str);
		System.out.println(demo.Testtow(str));

		String[] array =new String[]{"zhangsan","lisi"};
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList(array));
		arr.add("wangwu");
		System.out.println(arr);
	}

	private static String Testtow(String str) {
		str = str.substring(1);
		return str;
	}


	public static int Testone(int i){
        i=i+1;
		return i;
	}




}

