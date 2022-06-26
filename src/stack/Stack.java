package stack;

public class Stack {
	private int capacity = 50;
	private int vector[] = new int[capacity];
	private int top = -1;

	public void push(int item) {
		if (this.size() < capacity) {
			vector[++top] = item;
		}
	}

	public int pop() {
		if (this.empty() == false) {
			return vector[top--];
		}
		return -1;
	}

	public int size() {
		return top + 1;
	}

	public int top() {
		return vector[top];
	}

	public boolean empty() {
		if (this.size() == 0) {
			return true;
		}
		return false;
	}

	public boolean full() {
		if (this.size() == capacity) {
			return true;
		}
		return false;
	}

	public int getCapacity() {
		return capacity;
	}
}
