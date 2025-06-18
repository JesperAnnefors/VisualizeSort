
public class BubbleSort implements AlgoSortPanel.SortingAlgo {

	private AlgoSortPanel panel;
	private int delay;
	
	BubbleSort(AlgoSortPanel panel){
		this.panel = panel;
	}
	
	@Override
	public void sort(int[] array, int length) {
		int i, j, temp;
        boolean swapped;
        delay = 110 - length;
        
        for (i = 0; i < length - 1; i++) {
            swapped = false;
            for (j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    
                	if (panel.threadInterrupted()) return;
                	
                    // Swap array[j] and array[j+1]
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    panel.animate(delay);
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        panel.stopSort();
	}
}
