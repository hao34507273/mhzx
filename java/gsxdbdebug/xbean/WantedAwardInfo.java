package xbean;

import xdb.Bean;

public abstract interface WantedAwardInfo
  extends Bean
{
  public abstract WantedAwardInfo copy();
  
  public abstract WantedAwardInfo toData();
  
  public abstract WantedAwardInfo toBean();
  
  public abstract WantedAwardInfo toDataIf();
  
  public abstract WantedAwardInfo toBeanIf();
  
  public abstract int getCount();
  
  public abstract long getTimestamp();
  
  public abstract void setCount(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WantedAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */