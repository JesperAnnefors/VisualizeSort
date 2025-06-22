
public class SelectionSort implements AlgoSortPanel.SortingAlgo {
	private AlgoSortPanel panel;
	
	SelectionSort(AlgoSortPanel panel) {
		this.panel = panel;
	}

	@Override
	public void sort(int[] array, int length) {
		int delay = 110 - length;
		
        for (int i = 0; i < length - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;   
            panel.animate(delay);
        }
	}
}
