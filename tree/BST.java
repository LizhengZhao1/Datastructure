package tree;

import java.util.Collection;
import java.util.Iterator;


public class BST<E extends Comparable<E>> implements Tree<E> {
	
	TreeNode<E> root ;
	int size;
	
	public BST() {
		size = 0;
		root = new TreeNode<E>(null);
	}
	public  void inorder() {
		inorder(root);
	}
	public  void inorder(TreeNode<E> root) {
		if(root == null) {
			return ;
		}
		else {
			inorder(root.left);
			System.out.println(root.element + " ");
			inorder(root.right);
		}
	}

    public  void postorder() {
    	postorder(root);
    }
    public  void postorder(TreeNode<E> root) {
		if(root == null) {
			return ;
		}
		else {
			inorder(root.left);
			inorder(root.right);
			System.out.println(root.element + " ");
		}
	}

    public  void preorder() {
    	preorder(root);
    }
    
    public  void preorder(TreeNode<E> root) {
		if(root == null) {
			return ;
		}
		else {
			System.out.println(root.element + " ");
			inorder(root.left);
			inorder(root.right);
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		root = null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return getSize();
	}
  
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean search(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> curr = root;
		
		while (curr != null) {
			if(e.compareTo( curr.element) < 0) {
				curr = curr.left;
			}
			else if(e.compareTo(curr.element)  > 0) {
				curr = curr.right;
			}
			else {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		return add(e);
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> parent = null;
		TreeNode<E> curr = root;
		
		while(curr != null) {
			if(e.compareTo( curr.element) < 0) {
				parent = curr;
				curr = curr.left;
			}
			else if(e.compareTo(curr.element)  > 0) {
				parent = curr;
				curr = curr.right;
			}
			else {
				break; 
			}
		}
		
		if(curr == null) {
			return false; // this element was not found.
		}
		
		if(curr.left == null) {
			 if(parent == null) {
				 root = curr.right;
			 }
			 else {
				 if(e .compareTo(parent.element) < 0) {
					 parent.left = curr.right;
				 }
				 else {
					 parent.right = curr.right;
				 }
			 }
		}
		else {
			TreeNode<E> parentOfRightMost = curr;
			TreeNode<E> rightMost = curr.left;
			
			while(rightMost.right != null) {
				rightMost = rightMost.right;
			}
			
			curr.element = rightMost.element;
			
			if(parentOfRightMost == curr) {
				parentOfRightMost.left = rightMost.left;
			}
			else {
				parentOfRightMost.right = rightMost.left;
			}
		}
		size--;
		return true;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> newNode = new TreeNode(e);
		TreeNode<E> parent = null;
		TreeNode<E> curr = root;
		while(curr != null) {
			if(e.compareTo( curr.element) < 0) {
				parent = curr;
				curr = curr.left;
			}
			else if(e.compareTo(curr.element)  > 0) {
				parent = curr;
				curr = curr.right;
			}
			else {
				return false; // this element is already there.
			}
		}
		
		if(e.compareTo(parent.element) < 0) {
			parent.left = newNode;
		}
		else if (e.compareTo(parent.element) > 0){
			parent.right = newNode;
		}
		size++;
		return true;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}

class TreeNode<E>{
	E element;
	TreeNode<E> left;
	TreeNode<E> right;
	
	public TreeNode(E e) {
		element = e;
		left = null;
		right = null;
	}
}
