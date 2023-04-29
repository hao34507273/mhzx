package xbean;

import xdb.Bean;

public abstract interface AxeActivityInfo
  extends Bean
{
  public abstract AxeActivityInfo copy();
  
  public abstract AxeActivityInfo toData();
  
  public abstract AxeActivityInfo toBean();
  
  public abstract AxeActivityInfo toDataIf();
  
  public abstract AxeActivityInfo toBeanIf();
  
  public abstract int getContinuous_not_gold_times();
  
  public abstract long getStart_timestamp();
  
  public abstract void setContinuous_not_gold_times(int paramInt);
  
  public abstract void setStart_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AxeActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */