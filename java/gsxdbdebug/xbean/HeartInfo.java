package xbean;

import xdb.Bean;

public abstract interface HeartInfo
  extends Bean
{
  public abstract HeartInfo copy();
  
  public abstract HeartInfo toData();
  
  public abstract HeartInfo toBean();
  
  public abstract HeartInfo toDataIf();
  
  public abstract HeartInfo toBeanIf();
  
  public abstract int getTriggertime();
  
  public abstract long getLastchecktime();
  
  public abstract long getOtherroleid();
  
  public abstract void setTriggertime(int paramInt);
  
  public abstract void setLastchecktime(long paramLong);
  
  public abstract void setOtherroleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HeartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */