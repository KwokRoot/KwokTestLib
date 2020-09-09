package testlib.algorithm.tree;

public class TreeNode<T extends Comparable<T>> {
	
	public T data;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
	
	public static <K extends Comparable<K>> TreeNode<K> newTreeNode(K data) {
		TreeNode<K> treeNode = new TreeNode<K>();
		treeNode.data = data;
		return treeNode;
	}

}

