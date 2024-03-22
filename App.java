package tv.weshowyou.phone;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * @author Alastair Sagar
 *
 */
public class App extends JFrame {

	private JTextField dialText;
	private JButton dialButton;
	private JList<String> previousCallsList;
	private DefaultListModel<String> previouslyCalledListModel;
	private PhoneLine phoneLine;
	private PreviousCallList calledList;

	public App() {
		phoneLine = new PhoneLine();
		calledList = new PreviousCallList();

		setTitle("Phone App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		dialText = new JTextField(20);
		dialButton = new JButton("Dial");
		dialButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String number = dialText.getText();
				phoneLine.dial(number);
				calledList.addNumber(number);
				updatePreviousCallList();
			}
		});

		previouslyCalledListModel = new DefaultListModel<>();
		previousCallsList = new JList<>(previouslyCalledListModel);

		JScrollPane scrollPane = new JScrollPane(previousCallsList);

		add(dialText, BorderLayout.SOUTH);
		add(dialButton, BorderLayout.CENTER);
		add(scrollPane, BorderLayout.NORTH);

		pack();
		setVisible(true);
	}

	public void updatePreviousCallList() {
		previouslyCalledListModel.clear();
		List<String> numbers = calledList.getNumbers();
		for (String number : numbers) {
			previouslyCalledListModel.addElement(number);
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new App();
			}
		});
	}
}