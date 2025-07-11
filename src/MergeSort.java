
public class MergeSort implements AlgoSortPanel.SortingAlgo {

	private AlgoSortPanel panel;
	private int delay;
	
	MergeSort(AlgoSortPanel panel){
		this.panel = panel;
	}
	
	@Override
	public void sort(int[] array, int length) {
		delay = 110 - length;
		sortList(array, 0, length - 1);	
	}
	
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                panel.animate(delay);
            }
            else {
                arr[k] = R[j];
                j++;
                panel.animate(delay);
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            panel.animate(delay);
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            panel.animate(delay);
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void sortList(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sortList(arr, l, m);
            sortList(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }


}
