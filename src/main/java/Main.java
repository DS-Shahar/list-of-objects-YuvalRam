package yuval;

public class testQ_node {

	public static void main(String[] args) {
		Task[] a = {new Task("a1", 2, 100),new Task("a2", 2, 100),new Task("a3", 2, 100),new Task("a4", 4, 100),new Task("a5", 4, 100)};
		Node<Task> L = q1_buildList(a);
		System.out.println(L);
		System.out.println(insert(L,new Task("b1", 1, 100)));

	}
	
	public static Node<Task> q1_buildList(Task[] arr) {
		Node<Task> p1 = new Node<Task>(arr[0]);
		Node<Task> p2 = new Node<Task>(arr[1]);
		p1.setNext(p2);
		for (int i = 2; i < arr.length; i++) {
			Node<Task> p = new Node<Task>(arr[i]);
			p2.setNext(p);
			p2 = p;
		}
		return p1;
	}
	
	public static Node<Task> insert(Node<Task> L, Task t) {
		Node<Task> p = L;
		Node<Task> task = new Node<Task>(t);
		boolean x = false;
		if(p.getValue().getPriority()>task.getValue().getPriority()) {
			task.setNext(p);
			L = task;
			x = true;
		}
		while(p.getNext()!=null&&x==false) {
			if(p.getNext().getValue().getPriority()>task.getValue().getPriority()) {
				task.setNext(p.getNext());
				p.setNext(task);
				x = true;
			}
			else
				p = p.getNext();
		}
		if(x==false) 
			p.setNext(task);
		return L;
	}
	
	public static void update(Node<Task> L, boolean b, int c) {
		if(b==true)
			L = L.getNext();
		else {
			Task t = L.getValue();
			L = L.getNext();
			t.subCredit(c);
			if(t.getCredit()<10) {
				t.addCredit(100);
				t.decPriority();
			}
			insert(L,t);
		}
	}

}
