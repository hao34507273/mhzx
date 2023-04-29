package xbean;

import xdb.Bean;

public abstract interface HangStockingHistoryInfo
  extends Bean
{
  public abstract HangStockingHistoryInfo copy();
  
  public abstract HangStockingHistoryInfo toData();
  
  public abstract HangStockingHistoryInfo toBean();
  
  public abstract HangStockingHistoryInfo toDataIf();
  
  public abstract HangStockingHistoryInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getHangtime();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setHangtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HangStockingHistoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */