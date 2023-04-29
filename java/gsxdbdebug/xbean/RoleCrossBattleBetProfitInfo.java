package xbean;

import xdb.Bean;

public abstract interface RoleCrossBattleBetProfitInfo
  extends Bean
{
  public abstract RoleCrossBattleBetProfitInfo copy();
  
  public abstract RoleCrossBattleBetProfitInfo toData();
  
  public abstract RoleCrossBattleBetProfitInfo toBean();
  
  public abstract RoleCrossBattleBetProfitInfo toDataIf();
  
  public abstract RoleCrossBattleBetProfitInfo toBeanIf();
  
  public abstract long getProfit();
  
  public abstract long getTimestamp();
  
  public abstract void setProfit(long paramLong);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleCrossBattleBetProfitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */