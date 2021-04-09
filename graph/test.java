package tree;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<String> tree = new BST<String>();
		tree.insert("1");
		tree.insert("2");
		tree.insert("3");
		System.out.println("inorder:");
		tree.inorder();
	}

}
