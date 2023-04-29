package xbean;

import xdb.Bean;

public abstract interface DailyGiftInfo
  extends Bean
{
  public abstract DailyGiftInfo copy();
  
  public abstract DailyGiftInfo toData();
  
  public abstract DailyGiftInfo toBean();
  
  public abstract DailyGiftInfo toDataIf();
  
  public abstract DailyGiftInfo toBeanIf();
  
  public abstract long getReceive_time();
  
  public abstract void setReceive_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DailyGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */