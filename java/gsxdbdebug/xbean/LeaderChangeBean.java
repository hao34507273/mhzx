package xbean;

import xdb.Bean;

public abstract interface LeaderChangeBean
  extends Bean
{
  public abstract LeaderChangeBean copy();
  
  public abstract LeaderChangeBean toData();
  
  public abstract LeaderChangeBean toBean();
  
  public abstract LeaderChangeBean toDataIf();
  
  public abstract LeaderChangeBean toBeanIf();
  
  public abstract long getSessionid();
  
  public abstract void setSessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LeaderChangeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */