package item42.prefer.lambdas.to.anonymous.classes;

public class App {

  public static void main(String[] args) {
    System.out.println(Payroll.SATURDAY.pay(40, 25));

    System.out.println(LambdaOperation.MINUS.apply(5.0, 3.0));

    System.out.println(Operation.TIMES.apply(3.0, 4.0));
  }

}
