package assignment2;

public class SingleLink<T> implements Link<T>{
  public T data;
  public SingleLink<T> next;

  // constructor
  public SingleLink(T data) {
    this.data = data;
  }

  public void displayLink() {
    System.out.print(data.toString() + " ");
  }
}
