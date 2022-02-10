import java.util.Scanner;

public class LList<T>
{
	Node head;
	
	private class Node
	{
		T item;
		Node next;
		
		public Node(T item, Node next)
		{
			this.item = item;
			this.next = next;
		}
	}
	
	public  LList()
	{
		
	}
	
	public LList(LList other)
	{
		
	}
	
	public LList(T[] other)
	{
		
	}
	
	public void add(T item)
	{
		head = new Node(item, head);
	}
	
	public void addToEnd(T item)
	{
		
	}
	
	public T removeFromFront()
	{
		if (head == null)
			return null;
		
		T result = head.item;
		head = head.next;
		
		return result;
	}
	
	public int getIndex()
	{
		return -1;
	}
	
	private Node getPredecessor(T item)
	{
		Node previousNode = null;
		for (Node ptr = head; ptr != null; ptr = ptr.next)
		{
			if (ptr.item.equals(item))
				return previousNode;	
			else
				previousNode = ptr;
		}

		return null;
	}
	
	public int size()
	{
		return -1;
	}
	
	public int count(T item)
	{
		return -1;
	}
	
	public T delete(T item)
	{
		if (head == null)
			return null;
		Node previousNode = getPredecessor(item);		
		if (previousNode == null)
			if (head.item.equals(item))
				return removeFromFront();
			else 
				return null;		
		
		previousNode.next = previousNode.next.next;
		return null;
	}

	public void insertAt(int index, T item)
	{
		
	}

	public T[] toArray()
	{
		int count = 0;
		for (Node ptr = head; ptr != null; ptr = ptr.next)
			++count;
			
		T[] array = (T[]) new Object[count];
		int index = 0;
		
		for (Node ptr = head; ptr != null; ptr = ptr.next)
			array[index++]  = ptr.item;
		return array;
	}
	
	public boolean replace(T oldItem, T newItem)
	{
		return false;
	}

	public boolean replaceAll(T oldItem, T newItem)
	{
		return false;
	}
	
	public LList reverse()
	{
		return null;
	}

	public String toString()
	{
		String result = "";
		
		for (Node ptr=head; ptr!=null; ptr=ptr.next)
			result += ptr.item + " ";
		
		return result;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		LList<Integer>  lList = new LList<>(); 
		
		while (true)
		{
			System.out.println("1. add");
			System.out.println("2. remove from front");
			System.out.println("9. toString");
			
			switch(in.nextInt())
			{
			case 1:
				System.out.println("Enter item");
				lList.add(in.nextInt());
				break;
			case 2:
				System.out.println("Item removed: " + lList.removeFromFront());
				break;
			case 9:
				System.out.println(lList);
				break;
			}
		}
	}

}
