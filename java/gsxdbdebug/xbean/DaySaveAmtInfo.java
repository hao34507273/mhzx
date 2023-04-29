package xbean;

import xdb.Bean;

public abstract interface DaySaveAmtInfo
  extends Bean
{
  public abstract DaySaveAmtInfo copy();
  
  public abstract DaySaveAmtInfo toData();
  
  public abstract DaySaveAmtInfo toBean();
  
  public abstract DaySaveAmtInfo toDataIf();
  
  public abstract DaySaveAmtInfo toBeanIf();
  
  public abstract long getDay_begin_time();
  
  public abstract long getSave_amt();
  
  public abstract void setDay_begin_time(long paramLong);
  
  public abstract void setSave_amt(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DaySaveAmtInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */