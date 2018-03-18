package conditionVariable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@ThreadSafe
public class ConditionBoundedBuffer {
  protected final Lock lock = new ReentrantLock();
  // CONDITION PREDICATE: notFull (count < items.length)
  private final Condition notFull = lock.newCondition();
  // CONDITION PREDICATE: notEmpty (count > 0)
  private final Condition notEmpty = lock.newCondition();
  
  @GuardedBy("lock")
  private final T[] items = (T[]) new Object[BUFFER_SIZE];
  @GuardedBy("lock") private int tail, head, count;
}
