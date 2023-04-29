package xbean;

import xdb.Bean;

public abstract interface ServerLevelInfo
  extends Bean
{
  public abstract ServerLevelInfo copy();
  
  public abstract ServerLevelInfo toData();
  
  public abstract ServerLevelInfo toBean();
  
  public abstract ServerLevelInfo toDataIf();
  
  public abstract ServerLevelInfo toBeanIf();
  
  public abstract int getServerlevel();
  
  public abstract long getStarttime();
  
  public abstract long getTime_offset();
  
  public abstract void setServerlevel(int paramInt);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setTime_offset(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ServerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */