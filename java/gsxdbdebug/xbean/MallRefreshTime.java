package xbean;

import xdb.Bean;

public abstract interface MallRefreshTime
  extends Bean
{
  public abstract MallRefreshTime copy();
  
  public abstract MallRefreshTime toData();
  
  public abstract MallRefreshTime toBean();
  
  public abstract MallRefreshTime toDataIf();
  
  public abstract MallRefreshTime toBeanIf();
  
  public abstract long getRefreshtime();
  
  public abstract void setRefreshtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MallRefreshTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */