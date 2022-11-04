package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	public void showButton() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		JButton button = new JButton();
		frame.add(button);
		frame.pack();
		
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int rand = new Random().nextInt(5);
		
		if (rand == 0)
		{
			JOptionPane.showMessageDialog(null, "A faithful friend is a strong defense.");
		}
		else if (rand == 1)
		{
			JOptionPane.showMessageDialog(null, "A hunch is creativity trying to tell you something.");
		}
		else if (rand == 2)
		{
			JOptionPane.showMessageDialog(null, "Accept something that you cannot change, and you will feel better.");
		}
		else if (rand == 3)
		{
			JOptionPane.showMessageDialog(null, "All will go well with your new project.");
		}
		else if (rand == 4)
		{
			JOptionPane.showMessageDialog(null, "Curiosity kills boredom. Nothing can kill curiosity.");
		}
	}
}
