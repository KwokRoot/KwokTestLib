package testlib.radix;

/**
 * 该练习是 16进制 字符串转化为字节数组的 4种 方式的练习。
 * @author Kwok
 */
public class Test_HexStringToByteArray {

	public static byte[] HexStringTobyteArray1(String HexStr) {
		
		if (HexStr == null || "".equals(HexStr)) {
	        return null;
	    }
		if ((HexStr.length() & 0x1) != 0) {
			return "EROR : Odd number of characters.".getBytes();
		}
		
		int len = HexStr.length() >> 1;
		
		byte[] bytes = new byte[len];
		
		/* HexStringTobyte */
		for (int i = 0; i < len; i++) {
			//bytes[i] = Integer.valueOf((Integer.valueOf(HexStr.substring(2 * i, 2 * i + 1), 16) * 16 + Integer.valueOf(HexStr.substring(2 * i + 1, 2 * i + 2), 16))).byteValue();
			bytes[i] = Integer.valueOf(HexStr.substring(2 * i, 2 * i + 2), 16).byteValue();
		}
		/* HexStringTobyte END */
		
		return bytes;
	}
	
	
	
	private static String hexChars = "0123456789ABCDEF";
	public static byte[] HexStringTobyteArray2(String HexStr) {
		
		if (HexStr == null || "".equals(HexStr)) {
			return null;
		}
		if ((HexStr.length() & 0x1) != 0) {
			return "EROR : Odd number of characters.".getBytes();
		}
		HexStr = HexStr.toUpperCase();

		int len = HexStr.length() / 2;
		char[] hexStrChars = HexStr.toCharArray();
		byte[] bytes = new byte[len];

		for (int i = 0; i < len; i++) {
			
			/* HexStringTobyte */
			int pos = i * 2;
			bytes[i] = (byte) (hexChars.indexOf((hexStrChars[pos])) << 4 | hexChars.indexOf(hexStrChars[pos + 1]));
			/* HexStringTobyte END */
			
		}
		return bytes;
	}
	
	
	
	/**
	 * commons-codec 实现方式。
	 */
	public static byte[] HexStringTobyteArray3(String HexStr) {
		
		if (HexStr == null || "".equals(HexStr)) {
	        return null;
	    }
		if ((HexStr.length() & 0x1) != 0) {
			return "EROR : Odd number of characters.".getBytes();
		}

		char[] data = HexStr.toCharArray();
		int len = data.length;
		byte[] out = new byte[len >> 1]; // 相当于除以 2
		
		/* HexStringTobyte */
		for (int i = 0, j = 0; j < len; i++) {
			int f = Character.digit((data[j++]), 16) << 4; // 相当于乘以 16
			f |= Character.digit((data[j++]), 16); //按位逻辑与运算
			out[i] = ((byte) (f & 0xFF));
		}
		/* HexStringTobyte END */
		
		return out;
	}
	
	
	
	public static byte[] HexStringTobyteArray4(String HexStr) {
		
		if (HexStr == null || "".equals(HexStr)) {
			return null;
		}
		if ((HexStr.length() & 0x1) != 0) {
			return "EROR : Odd number of characters.".getBytes();
		}
		int len = HexStr.length();
		byte[] bytes = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			
			/* HexStringTobyte */
			bytes[i / 2] = (byte) ((Character.digit(HexStr.charAt(i), 16) << 4)	+ Character.digit(HexStr.charAt(i + 1), 16));
			/* HexStringTobyte END */
			
		}
		return bytes;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(new String(("e4bda0e5a5bd".getBytes()))); // 区别于普通字符串转字节数组
		System.out.println(new String(HexStringTobyteArray1("e4bda0e5a5bd")));
		System.out.println(new String(HexStringTobyteArray2("e4bda0e5a5bd")));
		System.out.println(new String(HexStringTobyteArray3("e4bda0e5a5bd")));
		System.out.println(new String(HexStringTobyteArray4("e4bda0e5a5bd")));
		
		System.out.println(Integer.toBinaryString(-1)); // -1 的 2 进制位(补码)。int类型 占 4byte，即 32(4*8)bit。 
		System.out.println(Integer.toBinaryString(0xff & (byte)-1));	//	byte类型的 -1 二进制位。
		
	}

}
