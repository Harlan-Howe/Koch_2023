import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class KochFrameAndRunner extends JFrame {

	private final SnowPanel myPanel;
	private final JSlider mySlider;
	
	/**
	 * @param args - not used.
	 */
	public static void main(String[] args) 
	{
		KochFrameAndRunner app = new KochFrameAndRunner();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public KochFrameAndRunner()
	{
		super("Koch Snowflake");
		this.getContentPane().setLayout(new BorderLayout());
		JPanel sliderPanel = new JPanel(new FlowLayout());
		sliderPanel.add(new JLabel("Recursion Depth"));
		mySlider = new JSlider(0,10,0);
		mySlider.setMajorTickSpacing(1);
		mySlider.setPaintTicks(true);
		sliderPanel.add(mySlider);
		mySlider.addChangeListener(new SliderListener());
		this.getContentPane().add(sliderPanel,BorderLayout.SOUTH);
		myPanel = new SnowPanel();
		myPanel.setPreferredSize(new Dimension(800,800));
		this.getContentPane().add(myPanel,BorderLayout.CENTER);
		setSize(800,900);
		setResizable(false);
		setVisible(true);
		
	}
	
	public class SliderListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent ce)
		{
			if (mySlider.getValueIsAdjusting())
				return;
			myPanel.setDepth(mySlider.getValue());
		}
	}
}
