package section3.n5;

import java.util.Arrays;

public class MyArrayList<T> {
	private static final int INIT_CAPACITY = 10;
	private T[] theData;
	private int size;			// 데이터 수
	private int capacity = 0;
	
	public MyArrayList() {
		this.theData = (T[])new Object [INIT_CAPACITY];
		this.size = 0;
		this.capacity = INIT_CAPACITY;
	}
	
	public void add(int index, T anEntry) {
		if(index < 0 || index > size) { // error or exception
			System.out.println("index or size is not good");
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if(size >= capacity) {
			reallocate();
		}
		for(int i = size-1; i >= index; i--) {
			theData[i+1] = theData[i];
		}
		theData[index] = anEntry;
		size++;
	}
	
	private void reallocate() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity); // 원본 배열 복사
	}

	public void add(T anEntry) {
		add(size, anEntry);
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(T anEntry) {
		for(int i = 0; i < size; i++) {
			if(theData[i].equals(anEntry)) {
				return i;
			}
		}
		return -1;
	}
	
	public T get(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}
	
	public T set(int index, T newValue) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		T oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}
	
	public T remove(int index) {
		if(index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		T returnValue = theData[index];
		for(int i = index - 1; i < size; i++) {
			theData[i-1] = theData[i];
		}
		size--;
		return returnValue;
	}
	
}
