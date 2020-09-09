package testlib.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {

	TreeNode<T> root;
	
	public void insertNode(T data) {
		TreeNode<T> node = TreeNode.newTreeNode(data);
		if(root == null) {
			root = node;
		}else {
			insertNode(root, node);
		}
	}
	
	private void insertNode(TreeNode<T> parentNode, TreeNode<T> childNode){
		
		if(childNode.data.compareTo(parentNode.data) <= 0) {
			if(parentNode.leftChild == null) {
				parentNode.leftChild = childNode;
			}else {
				insertNode(parentNode.leftChild, childNode);
			}
		}else {
			if(parentNode.rightChild == null) {
				parentNode.rightChild = childNode;
			}else {
				insertNode(parentNode.rightChild, childNode);
			}
		}
	}
	
	
	/**
	 * 中序遍历(有序)
	 * @param callback
	 */
	public void LDR(Consumer<T> callback) {
		
		if(root == null) {
			System.err.println("NULL");
		}else {
			LDR(root, callback);
		}
		
	}
	
	private void LDR(TreeNode<T> node, Consumer<T> callback) {
		if(node.leftChild != null) {
			LDR(node.leftChild, callback);
		}
		
		callback.accept(node.data);
		
		if(node.rightChild != null) {
			LDR(node.rightChild, callback);
		}
	}
	
	
	/**
	 * 先序遍历
	 * @param callback
	 */
	public void DLR(Consumer<T> callback) {
		if(root == null) {
			System.err.println("NULL");
		}else {
			DLR(root, callback);
		}
	}
	
	private void DLR(TreeNode<T> node, Consumer<T> callback) {
		callback.accept(node.data);

		if(node.leftChild != null) {
			DLR(node.leftChild, callback);
		}
		
		
		if(node.rightChild != null) {
			DLR(node.rightChild, callback);
		}
	}
	
	/**
	 * 后序遍历
	 * @param callback
	 */
	public void LRD(Consumer<T> callback) {
		if(root == null) {
			System.err.println("NULL");
		}else {
			LRD(root, callback);
		}
	}
	
	private void LRD(TreeNode<T> node, Consumer<T> callback) {
		if(node.leftChild != null) {
			LRD(node.leftChild, callback);
		}
		
		if(node.rightChild != null) {
			LRD(node.rightChild, callback);
		}

		callback.accept(node.data);
	}
	
	
	/**
	 * 广度(层次)优先遍历
	 * @param callback
	 */
	public void BFS(Consumer<T> callback) {
		if(root == null) {
			System.err.println("NULL");
		}else {
			Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
			TreeNode<T> currentNode = null;
		    queue.offer(root);
		    while (!queue.isEmpty()) {
		      currentNode = queue.poll();
		      callback.accept(currentNode.data);
		      if (currentNode.leftChild != null)
		        queue.offer(currentNode.leftChild);
		      if (currentNode.rightChild != null)
		        queue.offer(currentNode.rightChild);
		    }
		}
	}
	
	
	public T search(T data) {
		return search(root, data);
	}
	
	private T search(TreeNode<T> node, T data) {
		if(node == null) {
			return null;
		}
		if(data.compareTo(node.data) == 0) {
			return node.data;
		}else if(data.compareTo(node.data) < 0) {
			return search(node.leftChild, data);
		}else {
			return search(node.rightChild, data);
		}
	}
	
	public BinaryTree<T> copy(){
		BinaryTree<T> binaryTree = new BinaryTree<T>();
		binaryTree.root = root;
		copy(root, binaryTree.root);
		return binaryTree;
	}
	
	private void copy(TreeNode<T> srcNode, TreeNode<T> tarNode){
		if (srcNode == null) {
			return;
		}
		tarNode.data = srcNode.data;
		copy(srcNode.leftChild, tarNode.leftChild);
		copy(srcNode.rightChild, tarNode.rightChild);
	}
	
}
