package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JButton Video1 = new JButton();
	JButton Video2 = new JButton();
	JButton Video3 = new JButton();
	
	public void Videos()
	{
		frame.setVisible(true);
		frame.add(panel);
		
		panel.add(Video1);
		Video1.setText("Ducks");
		Video1.addActionListener(this);
		panel.add(Video2);
		Video2.setText("Frog");
		Video2.addActionListener(this);
		panel.add(Video3);
		Video3.setText("Unicorns");
		Video3.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ButtonPressed = (JButton) e.getSource();
		
		if (ButtonPressed == Video1)
		{
			showDucks();
		}
		else if (ButtonPressed == Video2)
		{
			showFrog();
		}
		else if (ButtonPressed == Video3)
		{
			showFluffyUnicorns();
		}
	}
	
	void showDucks() {
	     playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
	     playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
	     playVideo("https://www.youtube.com/watch?v=a-xWhG4UU_Y");
	}

	void playVideo(String videoID) {
	     
	     // Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
	     //work on some Linux implementations
	     try {
	     if (System.getProperty("os.name").toLowerCase().contains("linux")) {
	     if (Runtime.getRuntime().exec(new String[] {
	      "which", "xdg- open" }).getInputStream().read() != -1) {
	     Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
	     }
	     } else {
	          URI uri = new URI(videoID);
	          java.awt.Desktop.getDesktop().browse(uri);
	     }      } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
}
