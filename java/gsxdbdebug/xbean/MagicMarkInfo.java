package xbean;

import xdb.Bean;

public abstract interface MagicMarkInfo
  extends Bean
{
  public abstract MagicMarkInfo copy();
  
  public abstract MagicMarkInfo toData();
  
  public abstract MagicMarkInfo toBean();
  
  public abstract MagicMarkInfo toDataIf();
  
  public abstract MagicMarkInfo toBeanIf();
  
  public abstract long getExpiredtime();
  
  public abstract void setExpiredtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MagicMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */