package mzm.gsp.timer.main;

public abstract interface TimerObserver
{
  public abstract boolean update();
  
  public abstract boolean needToStop();
  
  public abstract long getIntervalMilliSeconds();
  
  public abstract long getTimeoutTimestamp();
  
  public abstract void setTimeoutTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timer\main\TimerObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */