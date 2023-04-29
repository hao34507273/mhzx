package xbean;

import xdb.Bean;

public abstract interface RoleCrossBattleBetTimesInfo
  extends Bean
{
  public abstract RoleCrossBattleBetTimesInfo copy();
  
  public abstract RoleCrossBattleBetTimesInfo toData();
  
  public abstract RoleCrossBattleBetTimesInfo toBean();
  
  public abstract RoleCrossBattleBetTimesInfo toDataIf();
  
  public abstract RoleCrossBattleBetTimesInfo toBeanIf();
  
  public abstract int getTimes();
  
  public abstract long getTimestamp();
  
  public abstract void setTimes(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossBattleBetTimesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */