package DataManagment;

public class MapEntry<K, V> {
	private K key;
	private V value;
	
	public MapEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
}
