package xbean;

import xdb.Bean;

public abstract interface LoginSignInfo
  extends Bean
{
  public abstract LoginSignInfo copy();
  
  public abstract LoginSignInfo toData();
  
  public abstract LoginSignInfo toBean();
  
  public abstract LoginSignInfo toDataIf();
  
  public abstract LoginSignInfo toBeanIf();
  
  public abstract long getLast_time();
  
  public abstract int getSortid();
  
  public abstract long getStart_time();
  
  public abstract void setLast_time(long paramLong);
  
  public abstract void setSortid(int paramInt);
  
  public abstract void setStart_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LoginSignInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */