package xbean;

import xdb.Bean;

public abstract interface GatherMapItemInfo
  extends Bean
{
  public abstract GatherMapItemInfo copy();
  
  public abstract GatherMapItemInfo toData();
  
  public abstract GatherMapItemInfo toBean();
  
  public abstract GatherMapItemInfo toDataIf();
  
  public abstract GatherMapItemInfo toBeanIf();
  
  public abstract long getRequest_gather_timestamp();
  
  public abstract long getGather_success_timestamp();
  
  public abstract int getGather_success_times();
  
  public abstract void setRequest_gather_timestamp(long paramLong);
  
  public abstract void setGather_success_timestamp(long paramLong);
  
  public abstract void setGather_success_times(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GatherMapItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */