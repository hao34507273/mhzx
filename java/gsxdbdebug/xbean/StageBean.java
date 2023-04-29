package xbean;

import xdb.Bean;

public abstract interface StageBean
  extends Bean
{
  public abstract StageBean copy();
  
  public abstract StageBean toData();
  
  public abstract StageBean toBean();
  
  public abstract StageBean toDataIf();
  
  public abstract StageBean toBeanIf();
  
  public abstract int getDuration();
  
  public abstract long getTriggertime();
  
  public abstract void setDuration(int paramInt);
  
  public abstract void setTriggertime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\StageBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */