package testlib.gui.component;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * 该练习是对 javax.swing.JFileChooser 类的常用功能的练习。
 * @author Kwok
 */
public class Test_JFileChooser {

	public static void main(String[] args) {

		JFileChooser fileChooser = new JFileChooser("D:\\java");
		fileChooser.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				
				return "文本文件";
			}
			@Override
			public boolean accept(File paramFile) {
				if(paramFile.getAbsolutePath().endsWith(".txt")){
					return true;
				}else{
					return false;
				}
			}
		});
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setSelectedFiles(new File[]{new File("T1.txt"), new File("T2.txt")});
		
		
		int state = fileChooser.showOpenDialog(null);
		switch (state) {
		case JFileChooser.APPROVE_OPTION :
			File[] files = fileChooser.getSelectedFiles();
			for (File file : files){
				System.out.println(file.getAbsolutePath());
			}
			break;
		case JFileChooser.CANCEL_OPTION :
			System.out.println("取消");
			break;
		case JFileChooser.ERROR_OPTION:
			System.out.println("错误");
			break;
		}
		
		
		state = fileChooser.showSaveDialog(null);
		switch (state) {
		case JFileChooser.APPROVE_OPTION :
			File[] files = fileChooser.getSelectedFiles();
			for (File file : files){
				System.out.println(file.getAbsolutePath());
			}
			break;
		case JFileChooser.CANCEL_OPTION :
			System.out.println("取消");
			break;
		case JFileChooser.ERROR_OPTION:
			System.out.println("错误");
			break;
		}
		
		
		state = fileChooser.showDialog(null, "运行");
		switch (state) {
		case JFileChooser.APPROVE_OPTION :
			File[] files = fileChooser.getSelectedFiles();
			for (File file : files){
				System.out.println(file.getAbsolutePath());
			}
			break;
		case JFileChooser.CANCEL_OPTION :
			System.out.println("取消");
			break;
		case JFileChooser.ERROR_OPTION:
			System.out.println("错误");
			break;
		}
		
	}
}
