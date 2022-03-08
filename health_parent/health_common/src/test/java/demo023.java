import java.util.Scanner;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-10-25 16:06
 **/
public class demo023 {
	public static void main(String[] args) {
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
 		maxSubArray(nums);
		System.out.println(maxSubArray(nums));
		System.out.println(-1);

		for (int i = 1; i < 0; i++) {
			System.out.println(13131313);
		}
	}
	public static int maxSubArray(int[] nums) {

		int len = nums.length;

		if (len == 0) {

			return 0;
		}

		int[] dp = new int[len];

		dp[0] = nums[0];

		for (int i = 1; i < len; i++) {

			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

		}

		// 最后这一步，是求一个全局的最优值
		int res = dp[0];

		for (int i = 1; i < len; i++) {

			res = Math.max(res,dp[i]); } return res;

	}
}