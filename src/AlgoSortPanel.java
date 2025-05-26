import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AlgoSortPanel extends JPanel {
	private int arraySize = 100;
	private int[] array = new int[arraySize];
	private int hMultiplier = -6;
	private int wWidth = 1200;
	
	AlgoSortPanel(){
		//this.setPreferredSize(new Dimension(1200, 600));
		for (int i = 0; i < arraySize; i ++) {
			array[i] = i + 1;
		}
		
		shuffle();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			
		for (int i = 0; i < arraySize; i ++) {
			g.setColor(Color.red);
			g.fillRect(0 + (wWidth * i / 100), 610, wWidth / 100, array[i] * hMultiplier);
		}
		
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
}
