import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
			frame.setLayout(new BorderLayout());
			frame.setLocationRelativeTo(null);
			
			//create a header panel
			JPanel header = new JPanel();
			
			//set header specifications
			header.setBackground(Color.red);
			header.setPreferredSize(new Dimension(50,50));
			header.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 12));
			
			//create header components
			JButton randomize = new JButton("Randomize");
			
			JButton sort = new JButton("Sort!");
			
			String[] algorithms = {"Bubble sort", "Merge sort"};
			JComboBox<String> algorithm = new JComboBox<String>(algorithms);
			
			
			/* 
				Todo: 
				Add buttons to header: 
					Combobox to choose which algorithm to use.
					Slider for array length.
					Button to randomize the array.
					Button to start the sorting algorithm + animation.
			*/
			
			//add components to header
			header.add(randomize);
			header.add(algorithm);
			header.add(sort);
			
			//add header to frame
			frame.add(header, BorderLayout.NORTH);
			
			//replace the sortPanel with a parent class that extends JPanel.
			//create child classes for each sorting algorithm.
			JPanel sortPanel = new JPanel();
			sortPanel.setBackground(Color.blue);
			frame.add(sortPanel, BorderLayout.CENTER);
			
			frame.setVisible(true);
		}
}
