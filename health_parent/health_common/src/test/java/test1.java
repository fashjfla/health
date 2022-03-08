import org.junit.Test;

/**
 * @author 唐晋
 * @version 1.0
 * @date 2021-10-26 14:53
 **/

public class test1 {

	public static void main(String[] args) {
		int []nums1 = {1,3,5,2,4};
		int [] nums2 = {6,5,4,3,2,1,7};

        nextGreaterElement(nums1, nums2);
		int[] a=nextGreaterElement(nums1,nums2);
		System.out.println(a);

	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		for (int i = 0; i < nums1.length; ++i)
		{
			int j = 0; while (j < nums2.length && nums2[j] != nums1[i])
			{ ++j; }
			int k = j + 1;
			while (k < nums2.length && nums2[k] < nums2[j])
			{ ++k; }
			nums1[i] = k < nums2.length ? nums2[k] : -1; }



	    return nums1;

		/*for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i]==nums2[j]){
					int k = j+1;
					if (k<nums2.length){
						for (k = j + 1; k < nums2.length; k++) {
							while (nums2[k]>nums1[i]){
								nums1[i] = nums2[k];
							}
						}
						nums1[i]=-1;
					}
				}else {
					nums1[i]=-1;
				}
				break;
			}
		}*/
}

}

