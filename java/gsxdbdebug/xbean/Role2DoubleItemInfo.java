package xbean;

import xdb.Bean;

public abstract interface Role2DoubleItemInfo
  extends Bean
{
  public abstract Role2DoubleItemInfo copy();
  
  public abstract Role2DoubleItemInfo toData();
  
  public abstract Role2DoubleItemInfo toBean();
  
  public abstract Role2DoubleItemInfo toDataIf();
  
  public abstract Role2DoubleItemInfo toBeanIf();
  
  public abstract int getToday_guarantee_times();
  
  public abstract long getToday_guarantee_refresh_time();
  
  public abstract int getToday_trigger_times();
  
  public abstract long getToday_trigger_refresh_time();
  
  public abstract int getGuarantee_not_trigger_times();
  
  public abstract void setToday_guarantee_times(int paramInt);
  
  public abstract void setToday_guarantee_refresh_time(long paramLong);
  
  public abstract void setToday_trigger_times(int paramInt);
  
  public abstract void setToday_trigger_refresh_time(long paramLong);
  
  public abstract void setGuarantee_not_trigger_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2DoubleItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */