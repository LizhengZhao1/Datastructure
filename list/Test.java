package list;

public class Test {
	public static void main(String[] args) {

//		LinkStack<String> ls = new LinkStack<String>();
//		ls.push("123");
//		ls.push("567");
//		
//		System.out.println(ls);
//		System.out.println(ls.size());
//		System.out.println(ls.pop());
//		System.out.println(ls.size());
//		
//		LinkQueue<String> queue = new LinkQueue<String>();
//		queue.enQueue("123");
//		queue.enQueue("567");
//		
//		System.out.println(queue);
//		System.out.println(queue.size());
//		System.out.println(queue.deQueue());
//		System.out.println(queue.size());
		
		MySingleLinkedList<String> msl = new MySingleLinkedList<String>();
		msl.add("123");
		System.out.println(msl);
		System.out.println(msl.size());
		msl.add(0, "456");
		System.out.println(msl);
		System.out.println(msl.size());
		msl.add(msl.size-1,"789");
		System.out.println(msl);
		System.out.println(msl.size());
		msl.remove(2);
		System.out.println(msl);
		System.out.println(msl.size());
		msl.remove(0);
		System.out.println(msl);
		System.out.println(msl.size());
	}
}
