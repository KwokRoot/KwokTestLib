package testlib.gui.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * 该练习是对 javax.swing.JTable 使用的练习。
 * @author Kwok
 */
public class Test_JTable2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	String oldValue = "";
	String newValue = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_JTable2 frame = new Test_JTable2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test_JTable2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.NORTH);
		table = new JTable();
		table.setRowHeight(30);
		scrollPane.setViewportView(table);

		final DefaultTableModel tableModel = new DefaultTableModel(
				new Object[][] { { 1, 2, 3, 4, 5, 666 }, { 21, 22, 23, 24, 25, 666 } },
				new Object[] { "A", "B", "C", "D", "E", "F" });
		tableModel.addRow(new Object[] { 31, 32, 33, 34, 35, 666 });
		tableModel.setValueAt("123321", 1, 2);
		table.setModel(tableModel);
		
		//设置第 4 列为选择框
		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(3).setCellEditor(new DefaultCellEditor(new JCheckBox("男")));
		
		//设置第 5 列为列表框，列表框项目为 String 类型。
		tableColumnModel.getColumn(4)
				.setCellEditor(new DefaultCellEditor(
						new JComboBox<String>(
								new String[] { "选项1", "选项2", "选项3" }
								)
						));
		
		//设置第 6 列为列表框，列表框项目为 User 类型。
		User u1 = new User("001", "111");
		User u2 = new User("002", "222");
		User u3 = new User("003", "333");
		User u6 = new User("006", "666");
		
		JComboBox<User> jComboBox = new JComboBox<User>(new User[]{u1,u2,u3,u6});
		jComboBox.setSelectedItem(u6);
		DefaultCellEditor defaultCellEditor = new DefaultCellEditor(jComboBox);
		tableColumnModel.getColumn(5).setCellEditor(defaultCellEditor);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedColumn() < 3) {
					oldValue = table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
					System.out.println("原值：" + oldValue);
				}
			
			}
		});
		
		
		tableModel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent paramTableModelEvent) {
				newValue = tableModel.getValueAt(paramTableModelEvent.getLastRow(), paramTableModelEvent.getColumn()).toString();
				System.out.println("新值：" + newValue);
			}
		});
		
	}

}


class User {

	private String no;
	private String name;

	public User(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}