import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class memorytest3 implements ActionListener {
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	HashMap<Integer, Integer> colors = new HashMap<Integer, Integer>();
	HashMap<Integer, Boolean> black = new HashMap<Integer, Boolean>();
	boolean active = true;
	boolean duplicate = false;
	int pressed = 0;
	int button1 = 0;
	int button2 = 0;
	int points = 0;
	int guesses = 0;
	boolean first = true;

	public static void main(String[] args) {
		new memorytest3().run();
	}

	private void run() {
		// TODO Auto-generated method stub
		f.setVisible(true);
		f.add(p);
		f.requestFocus();
		createButtons();
		f.setSize(330, 230);
		f.setTitle("Memory Test");
		colors();
	}

	private void colors() {
		HashMap<Integer, Integer> colorCounters = new HashMap<Integer, Integer>();
		ArrayList<Integer> values = new ArrayList<Integer>();
		createColorCounters(colorCounters);
		int numOfColors = 0;
		int i = 0;
		while (numOfColors < 36) {
			int r = new Random().nextInt(18);
			if (colorCounters.get(r) > 0) {
				colors.put(i, r);
				i++;
				numOfColors++;
				colorCounters.replace(r, colorCounters.get(r),
						colorCounters.get(r) - 1);
			}
		}
	}

	private void createColorCounters(HashMap<Integer, Integer> colorCounters) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 18; i++) {
			colorCounters.put(i, 2);
		}
	}

	private void createButtons() {
		for (int i = 0; i < 36; i++) {
			black.put(i, false);
			JButton b = new JButton();
			b.setText("    ");
			b.addActionListener(this);
			b.setBackground(Color.WHITE);
			buttons.add(b);
		}
		for (JButton b : buttons) {
			p.add(b);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (active == true) {
			for (int i = 0; i < 36; i++) {
				if (e.getSource() == buttons.get(i) && black.get(i) == false) {
					setColor(i);
					if (pressed == 0) {
						if (black.get(button1) == false && first == false) {
							buttons.get(button1).setBackground(Color.WHITE);
							buttons.get(button2).setBackground(Color.WHITE);
						}
						if (colors.get(button1) == colors.get(button2) && first == false) {
							black.replace(button1, false, true);
							black.replace(button2, false, true);
							buttons.get(button1).setBackground(Color.BLACK);
							buttons.get(button2).setBackground(Color.BLACK);
							points++;
						}
						button1 = i;
						pressed++;
					} else if (pressed == 1) {
						if (points == 17) {
							black.replace(button1, false, true);
							black.replace(button2, false, true);
							for(JButton b : buttons)
							{
								b.setBackground(Color.BLACK);
							}
							points++;
						}
						guesses++;
						first = false;
						button2 = i;
						pressed = 0;
					}
					//System.out.println(button1 + " " + button2);
					break;
				}
			}
		}
		if (points == 18) {
			JOptionPane.showMessageDialog(null, "You won!\nGuesses: " + guesses);
		}
		guesses++;
		System.out.println(points);
	}

	private void setColor(int i) {
		if (colors.get(i) == 0) {
			buttons.get(i).setBackground(Color.YELLOW);
		} else if (colors.get(i) == 1) {
			buttons.get(i).setBackground(Color.BLUE);
		} else if (colors.get(i) == 2) {
			buttons.get(i).setBackground(Color.CYAN);
		} else if (colors.get(i) == 3) {
			buttons.get(i).setBackground(Color.DARK_GRAY);
		} else if (colors.get(i) == 4) {
			buttons.get(i).setBackground(Color.RED);
		} else if (colors.get(i) == 5) {
			buttons.get(i).setBackground(Color.GREEN);
		} else if (colors.get(i) == 6) {
			buttons.get(i).setBackground(Color.LIGHT_GRAY);
		} else if (colors.get(i) == 7) {
			buttons.get(i).setBackground(Color.MAGENTA);
		} else if (colors.get(i) == 8) {
			buttons.get(i).setBackground(Color.ORANGE);
		} else if (colors.get(i) == 9) {
			buttons.get(i).setBackground(Color.PINK);
		} else if (colors.get(i) == 10) {
			buttons.get(i).setBackground(new java.awt.Color(104, 95, 235));
		} else if (colors.get(i) == 11) {
			buttons.get(i).setBackground(new java.awt.Color(67, 0, 65));
		} else if (colors.get(i) == 12) {
			buttons.get(i).setBackground(new java.awt.Color(200, 100, 0));
		} else if (colors.get(i) == 13) {
			buttons.get(i).setBackground(new java.awt.Color(158, 0, 248));
		} else if (colors.get(i) == 14) {
			buttons.get(i).setBackground(new java.awt.Color(200, 200, 100));
		} else if (colors.get(i) == 15) {
			buttons.get(i).setBackground(new java.awt.Color(17, 98, 1));
		} else if (colors.get(i) == 16) {
			buttons.get(i).setBackground(new java.awt.Color(77, 78, 79));
		} else if (colors.get(i) == 17) {
			buttons.get(i).setBackground(new java.awt.Color(218, 18, 8));
		}
	}
}
