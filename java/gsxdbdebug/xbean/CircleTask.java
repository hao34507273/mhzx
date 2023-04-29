package xbean;

import xdb.Bean;

public abstract interface CircleTask
  extends Bean
{
  public abstract CircleTask copy();
  
  public abstract CircleTask toData();
  
  public abstract CircleTask toBean();
  
  public abstract CircleTask toDataIf();
  
  public abstract CircleTask toBeanIf();
  
  public abstract long getLegendendtime();
  
  public abstract int getRenxingcounter();
  
  public abstract int getTaskid();
  
  public abstract int getFactioncontribution();
  
  public abstract long getFactioncontributionupdatetime();
  
  public abstract void setLegendendtime(long paramLong);
  
  public abstract void setRenxingcounter(int paramInt);
  
  public abstract void setTaskid(int paramInt);
  
  public abstract void setFactioncontribution(int paramInt);
  
  public abstract void setFactioncontributionupdatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CircleTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */