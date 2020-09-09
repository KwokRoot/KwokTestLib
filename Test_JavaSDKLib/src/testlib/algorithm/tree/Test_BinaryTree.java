package testlib.algorithm.tree;

public class Test_BinaryTree {

	public static void main(String[] args) {
		
		BinaryTree<KeyValue> binaryTree = new BinaryTree<KeyValue>();
		binaryTree.insertNode(new KeyValue("6", "666"));
		binaryTree.insertNode(new KeyValue("1", "111"));
		binaryTree.insertNode(new KeyValue("8", "888"));
		binaryTree.insertNode(new KeyValue("3", "333"));
		binaryTree.insertNode(new KeyValue("2", "222"));
		binaryTree.insertNode(new KeyValue("9", "999"));
		binaryTree.insertNode(new KeyValue("5", "555"));
		binaryTree.insertNode(new KeyValue("7", "777"));
		
		System.out.println("------ 中序遍历 ------");
		binaryTree.LDR(x -> System.out.print(x));

		System.out.println("\n------ 先序遍历 ------");
		binaryTree.DLR(x -> System.out.print(x));
		
		System.out.println("\n------ 后序遍历 ------");
		binaryTree.LRD(x -> System.out.print(x));
		
		System.out.println("\n------ 广度(层次)优先遍历 ------");
		binaryTree.BFS(x -> System.out.print(x));
		
		System.out.println("\n------ 搜索 ------");
		System.out.println(binaryTree.search(new KeyValue("3", null)));
		System.out.println(binaryTree.search(new KeyValue("4", null)));
		
		//复制
		binaryTree.copy().LRD(x -> System.out.print(x));
		System.out.println(binaryTree == binaryTree.copy());
		
	}
	
	public static class KeyValue implements Comparable<KeyValue> {

		private String key;
		private String value;
		
		public KeyValue(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		public String toString() {
			return "KeyValue(" + key + ":" + value + ")";
		}
		
		@Override
		public int compareTo(KeyValue o) {
			return this.key.compareTo(o.getKey());
		}
	}
}
