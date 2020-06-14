package testlib.gui.component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 该练习是对 JTable 表格填充和修改的练习。
 * @author Kwok
 */
public class Test_JTable1 {
	
	static Object oldValue;
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("表格视图");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final TableModel model = new DefaultTableModel(new Object[][] {{11,12,13},{21,22,23}}, new String[] { "第一列", "第二列", "第三列" });
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JButton button = new JButton("获取数据");
		panel.add(button, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		final JTable table = new JTable();
		scrollPane.setViewportView(table);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(model);
				System.out.println("行数：" + table.getRowCount());
				System.out.println("列数：" + table.getColumnCount());
			}
		});

		final MouseAdapter mouseAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent paramMouseEvent) {
				int clickRow = table.getSelectedRow();
				int clickColumn = table.getSelectedColumn();
				System.out.println("点击的行：" + clickRow);
				System.out.println("点击的列：" + clickColumn);
				oldValue = table.getValueAt(clickRow, clickColumn);
				System.out.println(oldValue);
			}
		};
		
		table.addMouseListener(mouseAdapter);
		
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
				//table.removeMouseListener(mouseAdapter);
				
				Object newValue = table.getValueAt(e.getLastRow(), e.getColumn());
				if(oldValue.toString().equals(newValue.toString())){
					System.out.println("未修改");
				}else{
					System.out.println("已修改");
				}
				
				//table.addMouseListener(mouseAdapter);
			}
		});
		
		frame.validate();	//验证此容器及其所有子组件，再次布置其子组件。
		//frame.pack();	//调整此窗口的大小，以适合其子组件的首选大小和布局。
		
	}

}
