package testlib.robot;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 使用 java.awt.Robot 类，间隔一段时间对屏幕进行截屏，可后台运行。
 * @author Kwok
 * 2021-06-06
 */
public class Test_RobotScreenCapture {

	private static final String baseDir = "/opt/java/";
	
	static {
		File baseFile = new File(baseDir);
		if(!baseFile.exists()) {
			baseFile.mkdirs();
		}
	}
	
    public static void main(String[] args) throws AWTException, IOException {

        Robot robot = new Robot();
        
        //获取屏幕大小
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = Double.valueOf(size.getWidth()).intValue();
        int height = Double.valueOf(size.getHeight()).intValue();

        while (true){
        	
        	String timeSuffix = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
            
        	BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(width, height));
            File outputfile = new File(baseDir + "image" + "_" + timeSuffix + ".jpg");
            ImageIO.write(bufferedImage, "jpg", outputfile);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
