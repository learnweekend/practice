package leetcode;

public class MyHashMapChaining {
	private int size;
	private Node[] array;

	public MyHashMapChaining(int capacity) {
		this.size = capacity;
		this.array = new Node[capacity];
	}

	public void put(String key, String value) {
		int location = getLocation(key);

		Node node = array[location];
		while (node != null) {
			if (key.equals(node.key)) { // replace the existing value
				node.value = value;
				return;
			}
			node = node.next; // move to next node
		}
		array[location] = new Node(key, value, array[location]); // assign the new value when no more nodes found
	}

	public String get(String key) {
		int location = getLocation(key);
		Node node = array[location];

		while (node != null) {
			if (key.equals(node.key))
				return node.value;

			node = node.next;
		}
		return null;
	}

	public boolean containsKey(String key) {
		return get(key) != null;
	}

	private int getLocation(String key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}

	private static class Node {
		private String key;
		private String value;
		private Node next;

		public Node(String key, String value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		MyHashMapChaining myMap = new MyHashMapChaining(31);

		myMap.put("venkat", "venkat");
		myMap.put("chanti", "chanti");
		myMap.put("banti", "banti");

		System.out.println(myMap.get("banti"));
		System.out.println(myMap.get("venkat"));
		System.out.println(myMap.get("chanti"));
	}
}
