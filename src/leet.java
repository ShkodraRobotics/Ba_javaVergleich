public class leet {
    public int[] twoSum(int[] nums, int target) {
        int count =0;
        int count2 = 0;
        for(int num :nums ){
            int hellp = target - num;
            count++;
            for(int i = 0; i < nums.length;i++){
                if(nums[i+count] == hellp){
                    int er [] = {i+count};
                    return er;
                }
            }
            count2++;

        }

        return null;


    }
}
