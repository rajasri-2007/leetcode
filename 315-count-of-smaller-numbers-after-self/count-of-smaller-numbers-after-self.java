class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        int[] count = new int[n];

        mergeSort(arr, 0, n - 1, count);

        List<Integer> ans = new ArrayList<>();

        for (int x : count) {
            ans.add(x);
        }

        return ans;
    }

    void mergeSort(int[][] arr, int left, int right, int[] count) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, count);
        mergeSort(arr, mid + 1, right, count);

        merge(arr, left, mid, right, count);
    }

    void merge(int[][] arr, int left, int mid, int right, int[] count) {

        int[][] temp = new int[right - left + 1][2];

        int i = left;
        int j = mid + 1;
        int k = 0;

        int smaller = 0;

        while (i <= mid && j <= right) {

            if (arr[j][0] < arr[i][0]) {

                temp[k++] = arr[j++];
                smaller++;

            } else {

                count[arr[i][1]] += smaller;

                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            count[arr[i][1]] += smaller;
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}