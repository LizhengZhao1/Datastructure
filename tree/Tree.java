package tree;
import java.util.Collection;
public interface Tree<E>  extends Collection<E>{
	
	public boolean search(E e);
	
	public boolean insert(E e);
	
	public boolean delete(E e);
	
	public boolean add(E e);
	
	public int getSize();
	
	public default void inorder() {}

    public default void postorder() {}

    public default void preorder() {}
}
