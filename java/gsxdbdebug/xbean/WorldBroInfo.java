package xbean;

import xdb.Bean;

public abstract interface WorldBroInfo
  extends Bean
{
  public abstract WorldBroInfo copy();
  
  public abstract WorldBroInfo toData();
  
  public abstract WorldBroInfo toBean();
  
  public abstract WorldBroInfo toDataIf();
  
  public abstract WorldBroInfo toBeanIf();
  
  public abstract long getLastbrotime();
  
  public abstract void setLastbrotime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WorldBroInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */