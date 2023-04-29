package xbean;

import xdb.Bean;

public abstract interface WeekPerfectRingCout
  extends Bean
{
  public abstract WeekPerfectRingCout copy();
  
  public abstract WeekPerfectRingCout toData();
  
  public abstract WeekPerfectRingCout toBean();
  
  public abstract WeekPerfectRingCout toDataIf();
  
  public abstract WeekPerfectRingCout toBeanIf();
  
  public abstract int getWeekperfectringcount();
  
  public abstract long getCleantime();
  
  public abstract void setWeekperfectringcount(int paramInt);
  
  public abstract void setCleantime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WeekPerfectRingCout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */