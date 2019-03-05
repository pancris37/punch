package punch.day3.task3;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-05 13:51
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *  1. quick sort
 *  2.insert sort
 *  3.bubble sort
 *  4. select sort
 *  5. heap sort
 *  6. 归并排序
 *  7. 第 K 大元素 heap sort
 * <br>
 */
public class GroupSort {

    /**
     * important
     * @param nums
     */
    public static void quickSort(int [] nums){
        quickSort(nums,0,nums.length - 1);
    }
    private  static void  quickSort(int [] nums,int left,int right){
        if(left >= right) return;
        int i = left,j =right;
        int cmp = nums[j];
        while (i < j){
            while (i < j && cmp > nums[i]){
                i ++;
            }
            // 这里 要么 i == j or nums[i] >= nums[j]
            nums[j] = nums[i];
            if (i > j) j--;
            // 换方向
            while (i < j && cmp <= nums[j]){
                j --;
            }
            nums[i] = nums[j];
            if(i > j) i++;
        }
        nums[i] = cmp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    /**
     *  cur
     *  for i = cur swap (i,i-1) until [i-1] < [i]
     * @param nums
     */
    public static void insertSort(int [] nums){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j > 0  ; j--) {
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                }
            }
        }
    }

    public static void bubbleSort(int [] nums){
        for (int i = nums.length -1; i > 0  ; i--) {
            for (int j = 0; j <i ; j++) {
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    /**
     *  每次找出 剩余数组中最小值的索引j 进行 swap(i,j) i++
     * @param nums
     */
    public static void selectSort(int [] nums) {
        for (int i = 0; i < nums.length ; i++) {
            int index = i;
            for (int j = i; j < nums.length ; j++) {
                index = nums[j] < nums[index]? j:index;
            }
            swap(nums,i,index);
        }
    }

    public static void heapSort(){

    }

    /**
     *  important
     *  分治思想
     */
    public static void mergeSort(int [] nums){
        mergeSort(nums,0,nums.length - 1);
    }

    private static void mergeSort(int [] nums,int left,int right){
        if(left == right) return;
        if(right - left == 1){
            if(nums[left] > nums[right]){
                swap(nums,left,right);
            }
            return;
        }
        // divide
        int mid = (left + right) >> 1;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        //combin [left,right]
        combinArraySortedPart(nums,left,mid,right);
    }

    private static void combinArraySortedPart(int [] nums,int left,int mid,int right){
        int [] tmp = new int [right - left +1];
        int k = 0,i = left,j = mid+1;
        for (;i <= mid && j <= right ;k++) {
            if(nums[i] > nums[j]){
                tmp[k] = nums[j];
                j++;
            }else {
                tmp[k] = nums[i];
                i++;
            }
        }
        // remain copy
        System.arraycopy(nums,i > mid?j:i ,tmp,k,tmp.length - k );
        System.arraycopy(tmp,0,nums,left,tmp.length);
    }

    private  static  void swap(int [] nums,int i ,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String [] args){
        int [] nums  = {3,1,5,7,2,3,4,8,0,3,7,1,4,24,9,11};
        //bubbleSort(nums);
        //insertSort(nums);
        //selectSort(nums);
        //quickSort(nums);
        mergeSort(nums);


        for (int n : nums){
            System.out.print(n+ "->" );
        }
    }
}
