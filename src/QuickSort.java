
public class QuickSort implements AlgoSortPanel.SortingAlgo {

	private AlgoSortPanel panel;
	private int delay;
	
	QuickSort(AlgoSortPanel panel){
		this.panel = panel;
	}
	
	@Override
	public void sort(int[] array, int length) {
		delay = 110 - length;
		quickSort(array, 0, length - 1);

	}
	
	// Partition function
    private int partition(int[] arr, int low, int high) {
        
        // Choose the pivot
        int pivot = arr[high];
        
        // Index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);  
        return i + 1;
    }

    // Swap function
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        panel.animate(delay);
    }

    // The QuickSort function implementation
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
