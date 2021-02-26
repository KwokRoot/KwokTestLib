package testlib.radix;

/**
 * 该练习是字节数组转化为 16进制 字符串的练习。
 * @author Kwok
 */
public class Test_ByteArrayToHexString {

	public static String byteArrayToHexString1(byte[] bytes) {

		if (bytes == null || bytes.length <= 0) {
			return null;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			
			/* byteToHexString */
			int v = bytes[i] & 0xFF;
			String hv = Integer.toHexString(v);					//小写英文字母
			//String hv = Integer.toHexString(v).toUpperCase();	//大写英文字母
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			/* byteToHexString END */
			
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
	
	
	
	private final static String[] hexDigits_LOWER = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	//private final static String[] hexDigits__UPPER = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
	public static String byteArrayToHexString2(byte[] bytes) {

		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			
			/* byteToHexString */
			int n = b;
			if (n < 0) {
				n = 256 + n;
			}
			int d1 = n / 16;
			int d2 = n % 16;
			String byteStr = hexDigits_LOWER[d1] + hexDigits_LOWER[d2];
			/* byteToHexString END */
			
			stringBuilder.append(byteStr);
		}
		return stringBuilder.toString();
	}
	
	
	
	/**
	 * commons-codec 实现方式。
	 */
	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	//private static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	public static String byteArrayToHexString3(byte[] bytes) {
		
		int l = bytes.length;
		char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
		
			/* byteToHexString */
			out[(j++)] = DIGITS_LOWER[((0xF0 & bytes[i]) >>> 4)];
			out[(j++)] = DIGITS_LOWER[(0xF & bytes[i])];
			/* byteToHexString END */
		
		}
		return new String(out);
	}
	
	
	
	public static String byteArrayToHexString4(byte[] bytes) {

		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
		
			/* byteToHexString */
			stringBuilder.append(String.format("%02x", b));		//小写英文字母
			// stringBuilder.append(String.format("%02X", b));	//大写英文字母
			/* byteToHexString END */
		
		}
		return stringBuilder.toString();
	}
	
	
	
	public static String byteArrayToHexString5(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			int x = b & 0xff;
			sb.append(Integer.toString(x >> 4, 16)).append(Integer.toString(x & 0xf, 16));
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
		
		byte[] bytes = "A".getBytes(); //A 的二进制 ： 0100 0001
		System.out.println(bytes[0]);
		System.out.println(byteArrayToHexString1(bytes));
		System.out.println(byteArrayToHexString2(bytes));
		System.out.println(byteArrayToHexString3(bytes));
		System.out.println(byteArrayToHexString4(bytes));
		System.out.println(byteArrayToHexString5(bytes));
		
	}

}
