/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-10-26 16:22
 **/
public class test02 {

	public int lengthOfLongestSubstring(String s) {
		int a = s.length();
		int max = 0;
		char[] temp = s.toCharArray();
		String c = null;
		char[] chars = c.toCharArray();
		for (int i = 0; i < a; i++) {
			for (int j = i + 1; j < a; j++) {
				if (temp[i]!=temp[j]){
                      c = s.substring(i,j);
					for (int k = 0; k < c.length(); k++) {
					}
				}
			}

		}
		return 0;
	}

}
