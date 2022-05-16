package testlib.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * java.awt.datatransfer.Clipboard 类获取到剪贴板信息。
 * @author Kwok
 * 2022-05-15
 */
public class Test_Clipboard {
	
	public static void main(String[] args) throws Exception {
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable transferable = clipboard.getContents(null);
		if(null != transferable && transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			// 处理剪贴板文本类型信息
			
			System.out.println((String)transferable.getTransferData(DataFlavor.stringFlavor));
		
		}else if(null != transferable && transferable.isDataFlavorSupported(DataFlavor.imageFlavor)){
			// 处理剪贴板图片类型信息

			 // BufferedImage image = (BufferedImage)transferable.getTransferData(DataFlavor.imageFlavor);
			 // ImageIO.write(image, "jpg", new File("D://opt/copy.jpg"));
			
		}else {
			
		}
		
	}
	
}
