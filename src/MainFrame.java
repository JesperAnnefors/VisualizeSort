import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {

		public MainFrame() {
			//create a frame
			JFrame frame = new JFrame();
			
			//set frame specifications
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("VisualizeSort");
			frame.setResizable(false);
			frame.setSize(1200, 720);
			frame.setLayout(new BorderLayout(10, 10));
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			//create a header panel
			JPanel header = new JPanel();
			
			//set header specifications
			header.setBackground(Color.red);
			header.setPreferredSize(new Dimension(50,50));
			
			/* 
				Todo: 
				Add buttons to header: 
					Combobox to choose which algorithm to use.
					Slider for array length.
					Button to randomize the array.
					Button to start the sorting algorithm + animation.
			*/
			
			//add header to frame
			frame.add(header, BorderLayout.NORTH);
			
			//replace the sortPanel with a parent class that extends JPanel.
			//create child classes for each sorting algorithm.
			JPanel sortPanel = new JPanel();
			sortPanel.setBackground(Color.blue);
			frame.add(sortPanel, BorderLayout.CENTER);
		}
}
