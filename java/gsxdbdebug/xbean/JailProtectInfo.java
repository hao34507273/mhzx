package xbean;

import xdb.Bean;

public abstract interface JailProtectInfo
  extends Bean
{
  public abstract JailProtectInfo copy();
  
  public abstract JailProtectInfo toData();
  
  public abstract JailProtectInfo toBean();
  
  public abstract JailProtectInfo toDataIf();
  
  public abstract JailProtectInfo toBeanIf();
  
  public abstract long getSessionid();
  
  public abstract long getLeavejailtimestamp();
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setLeavejailtimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JailProtectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */