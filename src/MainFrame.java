import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame implements ActionListener, ChangeListener{
	private int frameWidth = 1200;
	private int frameHeight = 720;
	private int sliderValue = 50;
	
	//Header components
	private JButton randomize = new JButton("Randomize");
	private JButton sort = new JButton("Sort!");
	private JSlider slider = new JSlider(10, 100, sliderValue);
	private JLabel label = new JLabel(" Array Length: " + sliderValue + " ");
	private String[] algorithms = {"Bubble sort", "Merge sort", "Quick sort", "Selection sort"};
	private JComboBox<String> algorithm = new JComboBox<String>(algorithms);
	
	private AlgoSortPanel sortPanel = new AlgoSortPanel(this);
	

	public MainFrame() {
		//create a frame
		JFrame frame = new JFrame();
		
		//set frame specifications
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("VisualizeSort");
		frame.setResizable(false);
		frame.setSize(frameWidth, frameHeight);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		
		//create a header panel
		JPanel header = new JPanel();
		
		//set header specifications
		header.setPreferredSize(new Dimension(1200, 81));
		header.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
		//setup header components
		
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(10);
		slider.setPaintLabels(true);
		
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//add components to header
		header.add(randomize);
		header.add(algorithm);
		header.add(sort);
		header.add(slider);
		header.add(label);
		
		//add actionListeners
		randomize.addActionListener(this);
		slider.addChangeListener(this);
		sort.addActionListener(this);
		
		//Setup AlgoSortPanel
		
		sortPanel.setBackground(Color.blue);
		
		//add panels to frame
		frame.add(header, BorderLayout.NORTH);
		frame.add(sortPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == randomize) {
			sortPanel.shuffle();
			sortPanel.repaint();
		}
		else if (e.getSource() == sort) {
			if (sort.getText().equals("Sort!")) {
				sortPanel.setSortAlgorithm(algorithm.getSelectedItem().toString());
				sortPanel.startSort();
				setEnabledHeader(false);
			}
			else {
				sortPanel.stopSort();
				setEnabledHeader(true);
			}
		}		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		sliderValue = slider.getValue();
		label.setText(" Array Length: " + String.valueOf(sliderValue) + " ");
		sortPanel.setVisible(sliderValue);
		sortPanel.repaint();			
	}
	
	public void setEnabledHeader(Boolean b) {
		
		if (b) {
			sort.setText("Sort!");
		}
		else {
			sort.setText("Stop");
		}
		
		slider.setEnabled(b);
		randomize.setEnabled(b);
		algorithm.setEnabled(b);
	}
}
