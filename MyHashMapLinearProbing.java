package leetcode;

public class MyHashMapLinearProbing {

	private int size;
	private String[] keys;
	private String[] values;

	public MyHashMapLinearProbing(int capacity) {
		this.size = capacity * 3;
		this.keys = new String[size];
		this.values = new String[size];
	}

	public void put(String key, String value) {
		int location = getLocation(key);

		while (location < keys.length && keys[location] != null) {
			location++;
		}

		keys[location] = key;
		values[location] = value; // assign the new value when no more nodes found
	}

	public String get(String key) {
		int location = getLocation(key);

		while (location < keys.length && keys[location] != null) {
			if (key.equals(keys[location])) {
				return values[location];
			} else {
				return null;
			}
		}
		return null;
	}

	public boolean containsKey(String key) {
		return get(key) != null;
	}

	private int getLocation(String key) {
		return (key.hashCode() & 0x7fffffff) % size;
	}

	public static void main(String[] args) {
		MyHashMapLinearProbing myMap = new MyHashMapLinearProbing(31);

		myMap.put("venkat", "venkat");
		myMap.put("chanti", "chanti");
		myMap.put("banti", "banti");

		System.out.println(myMap.get("banti"));
		System.out.println(myMap.get("venkat"));
		System.out.println(myMap.get("chanti"));
	}

}
