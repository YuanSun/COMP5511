package item42.prefer.lambdas.to.anonymous.classes;

/**
 * Payroll by enum, to implement strategy pattern enum also good for singleton
 * 
 * @author ysun
 *
 */
public enum Payroll {
  MONDAY(PayType.WeekDay),
  TUESDAY(PayType.WeekDay),
  WENDSDAY(PayType.WeekDay),
  THURSDAY(PayType.WeekDay),
  FRIDAY(PayType.WeekDay),
  SATURDAY(PayType.WeekEnd),
  SUNDAY(PayType.WeekEnd);
  
  private PayType payType;
  private Payroll (PayType payType) {
    this.payType = payType;
  }
  
  public double pay(double workHours, double payPerHour) {
    return payType.pay(workHours, payPerHour);
  }
  
  private enum PayType {    
    WeekDay {
      @Override
      double overTimePay(double workHours, double payPerHour) {
        double overTimePay = workHours <= FIXED_WORK_HOUR_PER_DAY ? 
            0 : (workHours - FIXED_WORK_HOUR_PER_DAY) * payPerHour * OVER_TIME_PAY_RATE;
        return overTimePay;
      }
    },
    WeekEnd {
      @Override
      double overTimePay(double workHours, double payPerHour) {
        double overTimePay = workHours * payPerHour * OVER_TIME_PAY_RATE;
        return overTimePay;
      }
    };
    
    private static final int FIXED_WORK_HOUR_PER_DAY = 8; 
    private static final double OVER_TIME_PAY_RATE = 1/2;
    
    abstract double overTimePay(double workHours, double payPerHour);
    public double pay(double workHours, double payPerHour) {
      double basePay = workHours * payPerHour;
      
      double overTimePay = overTimePay(workHours, payPerHour);
      return basePay + overTimePay;
    }
  }
}
