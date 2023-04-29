package xbean;

import xdb.Bean;

public abstract interface ShiTuTimeInfo
  extends Bean
{
  public abstract ShiTuTimeInfo copy();
  
  public abstract ShiTuTimeInfo toData();
  
  public abstract ShiTuTimeInfo toBean();
  
  public abstract ShiTuTimeInfo toDataIf();
  
  public abstract ShiTuTimeInfo toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract long getEndtime();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setEndtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShiTuTimeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */