package xbean;

import xdb.Bean;

public abstract interface MonthCardActivityInfo
  extends Bean
{
  public abstract MonthCardActivityInfo copy();
  
  public abstract MonthCardActivityInfo toData();
  
  public abstract MonthCardActivityInfo toBean();
  
  public abstract MonthCardActivityInfo toDataIf();
  
  public abstract MonthCardActivityInfo toBeanIf();
  
  public abstract long getBuy_time();
  
  public abstract long getStart_time();
  
  public abstract long getLast_award_time();
  
  public abstract int getPhase();
  
  public abstract boolean getIs_present_award();
  
  public abstract boolean getIs_fix_same_serviceid_bug();
  
  public abstract long getTss_end_time();
  
  public abstract void setBuy_time(long paramLong);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setLast_award_time(long paramLong);
  
  public abstract void setPhase(int paramInt);
  
  public abstract void setIs_present_award(boolean paramBoolean);
  
  public abstract void setIs_fix_same_serviceid_bug(boolean paramBoolean);
  
  public abstract void setTss_end_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MonthCardActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */