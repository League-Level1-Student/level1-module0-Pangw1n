package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffectsMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	JButton Sound1 = new JButton();
	JButton Sound2 = new JButton();
	JButton Sound3 = new JButton();
	JButton Sound4 = new JButton();
	
	public void SoundBoard()
	{
		frame.setVisible(true);
		frame.add(panel);
		
		Sound1.setText("Sawing Wood");
		Sound1.addActionListener(this);
		panel.add(Sound1);

		Sound2.setText("Synth Lead");
		Sound2.addActionListener(this);
		panel.add(Sound2);

		Sound3.setText("Dog Bark");
		Sound3.addActionListener(this);
		panel.add(Sound3);
		
		Sound4.setText("Cat Meow");
		Sound4.addActionListener(this);
		panel.add(Sound4);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		
		if (buttonPressed == Sound1)
		{
			playSound("sawing-wood-daniel_simon.wav");
		}
		else if (buttonPressed == Sound2)
		{
			playSound("18121__daven__bold-lead-f1.wav");
		}
		else if (buttonPressed == Sound3)
		{
			playSound("327666__juan-merie-venter__dog-bark.wav");
		}
		else if (buttonPressed == Sound4)
		{
			playSound("412016__skymary__cat-purring-and-meow.wav");
		}
	}
	
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
	}
}
