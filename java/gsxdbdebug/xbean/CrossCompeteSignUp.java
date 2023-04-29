package xbean;

import xdb.Bean;

public abstract interface CrossCompeteSignUp
  extends Bean
{
  public abstract CrossCompeteSignUp copy();
  
  public abstract CrossCompeteSignUp toData();
  
  public abstract CrossCompeteSignUp toBean();
  
  public abstract CrossCompeteSignUp toDataIf();
  
  public abstract CrossCompeteSignUp toBeanIf();
  
  public abstract long getTime();
  
  public abstract void setTime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossCompeteSignUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */