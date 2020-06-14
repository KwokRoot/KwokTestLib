package testlib.gui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * 该练习是对 ProgressBar-进度条 的练习。
 * @author Kwok
 */
public class Test_ProgressBar extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		//设置 JFrame 属性
		Test_ProgressBar frame = new Test_ProgressBar();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		
		//添加 JPanel，并设置属性
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		//添加 JButton，并设置属性
		JButton button = new JButton("开始");
		button.setFont(new Font("楷体", Font.BOLD, 99));
		contentPane.add(button, BorderLayout.CENTER);
		
		//添加 JProgressBar，并设置属性
		final JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.green);//设置进度条背景色
		progressBar.setForeground(Color.red);//设置进度条前景色
		progressBar.setStringPainted(true);
		progressBar.setString("Load...");
		contentPane.add(progressBar, BorderLayout.SOUTH);

		final Timer timer = new Timer();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				progressBar.setValue(0);
				timer.schedule(new progressBarTimer(progressBar), 0, 50);
			}
		});
		frame.validate();
	}
}

class progressBarTimer extends TimerTask {
	
	JProgressBar progressBar;
	
	public progressBarTimer(JProgressBar progressBar) {
		super();
		this.progressBar = progressBar;
	}
	
	@Override
	public void run() {
		progressBar.setValue(progressBar.getValue()+1);
		System.out.println(progressBar.getValue());
		if(progressBar.getValue() == progressBar.getMaximum()){
			this.cancel();
		}
		progressBar.setString(String.format("%.0f%%", progressBar.getPercentComplete()*100));
	}
}
