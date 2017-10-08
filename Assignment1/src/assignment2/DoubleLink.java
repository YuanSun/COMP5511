package assignment2;

public class DoubleLink<T> implements Link<T>{
  public T data;
  public Link<T> next;
  public Link<T> previous;

  public DoubleLink(T data) {
    this.data = data;
  }

  public void displayLink() {
    System.out.print(data.toString() + " ");
  }

}
