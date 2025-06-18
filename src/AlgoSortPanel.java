import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AlgoSortPanel extends JPanel {
	private int arraySize = 100;
	private int visible = 50;
	private int[] array = new int[arraySize];
	private int hMultiplier = 6;
	private int wWidth = 1200;
	private BasicStroke lineWidth = new BasicStroke(1f);
	private Thread sortThread;
	private SortingAlgo sortAlgo;
	private MainFrame frame;
	
	
	AlgoSortPanel(MainFrame frame){
		for (int i = 0; i < arraySize; i ++) {
			array[i] = i + 1;
		}
		
		shuffle();
		this.frame = frame;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(lineWidth);
		g2D.setColor(Color.red);
		for (int i = 0; i < arraySize; i ++) {
			g2D.fillRect(0 + (wWidth * i / visible), 602 - array[i] * hMultiplier  , wWidth / visible, array[i] * hMultiplier);
		}
		
		g2D.setColor(Color.black);	
		for (int i = 0; i < arraySize; i ++) {		
			g2D.drawRect(0 + (wWidth * i / visible), 602 - array[i] * hMultiplier  , wWidth / visible, array[i] * hMultiplier);
		}
		
	}
	
	public void animate(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		repaint();
	}
	
	public Boolean threadInterrupted() {
		Thread.currentThread();
		return Thread.interrupted();
	}
	
	public void shuffle() {
		
		//Fisher-yates shuffle
		Random r = new Random();
        
        
        for (int i = arraySize - 1; i > 0; i--) {
            
            // Pick a random index from 0 to i
            int j = r.nextInt( i + 1 );
            
            // Swap array[i] with the element at random index
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
	}
	
	public void setVisible(int v) {
		visible = v;
	}
	
	public interface SortingAlgo {
		void sort(int[] array, int length);
	}
	
	public void startSort() {
		sortThread = new Thread(() -> {
            sortAlgo.sort(array, visible);
            frame.setEnabledHeader(true);
        });
        sortThread.start();
	}
	
	public void stopSort() {
		sortThread.interrupt();
	}
	
	public void setSortAlgorithm(String algo) {
		switch (algo) {
			case "Bubble sort":
				sortAlgo = new BubbleSort(this);
				break;
			case "Merge sort":
				break;
		}
	}
}
