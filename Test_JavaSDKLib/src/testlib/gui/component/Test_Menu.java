package testlib.gui.component;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 * 该练习是 JavaGUI 创建菜单（顶部菜单栏、右键菜单、系统菜单）的练习。
 * @author Kwok
 */
public class Test_Menu extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		final Test_Menu frame = new Test_Menu();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		
		
		System.out.println("------------------------------ 操作 1:创建普通菜单 ------------------------------");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("菜单");
		menuBar.add(menu);
		
		JMenuItem jMenuItem = new JMenuItem("文件");
		menu.add(jMenuItem);
		
		
		System.out.println("------------------------------ 操作 2:创建弹出菜单 ------------------------------");
		
		final JPopupMenu popupMenu = new JPopupMenu("右键菜单");
		popupMenu.add(new JMenuItem("复制"));
		popupMenu.add(new JMenuItem("修改"));
		popupMenu.addSeparator();
		popupMenu.add(new JMenuItem("删除"));
		
		
		//frame.add(popupMenu); //当使用 PopupMenu 生成弹出菜单时，缺少此语句会抛异常（NullPointerException）。
		
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3){
					popupMenu.show(frame, e.getX(), e.getY());
				}
			}
		});
		
		
		System.out.println("------------------------------ 操作 3:创建系统托盘 ------------------------------");
		
		if (SystemTray.isSupported()) {
			Image image = null;
			try {
				image = ImageIO.read(Test_Menu.class.getResource("Test_Menu.png"));
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			TrayIcon trayIcon = new TrayIcon(image);

			// 为托盘图标加弹出菜弹
			PopupMenu popMenu = new PopupMenu();
			popMenu.add(new MenuItem("open"));
			popMenu.add(new MenuItem("close"));
			popMenu.addSeparator();
			popMenu.add(new MenuItem("status"));
			trayIcon.setPopupMenu(popMenu);

			// 添加工具提示文本
			trayIcon.setToolTip("系统托盘\r\n连接正常");

			// 获得系统托盘对象
			SystemTray systemTray = SystemTray.getSystemTray();

			// 为系统托盘加托盘图标
			try {
				systemTray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(frame, "not support SystemTray");
		}

	}
}
